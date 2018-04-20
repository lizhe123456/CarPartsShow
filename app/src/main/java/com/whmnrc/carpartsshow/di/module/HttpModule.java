package com.whmnrc.carpartsshow.di.module;

import com.whmnrc.carpartsshow.app.App;
import com.whmnrc.carpartsshow.app.Constants;
import com.whmnrc.carpartsshow.di.qualifiler.CPSUrl;
import com.whmnrc.carpartsshow.model.http.api.CPSApi;
import com.whmnrc.carpartsshow.util.JsonUtil;
import com.whmnrc.carpartsshow.util.LogUtil;
import com.whmnrc.carpartsshow.util.SystemUtil;
import com.whmnrc.carpartsshow.widgets.CPSToast;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lizhe on 2017/12/11 0011.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
@Module
public class HttpModule {

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    @CPSUrl
    Retrofit provideZLRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, Constants.CPS_URL);
    }

    @Singleton
    @Provides
    CPSApi provideZLService(@CPSUrl Retrofit retrofit) {
        return retrofit.create(CPSApi.class);
    }

    @Singleton
    @Provides
    OkHttpClient provideZLClient(OkHttpClient.Builder builder) {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLogger());
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(logInterceptor);
        File cacheFile = new File(Constants.PATH_CACHE);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!SystemUtil.isNetworkConnected(App.getInstance().getmContext())) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (SystemUtil.isNetworkConnected(App.getInstance().getmContext())) {
                    int maxAge = 0;
                    // 有网络时, 不缓存, 最大保存时长为0
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")
                            .build();
                } else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
//                    CPSToast.showText(App.getInstance().getmContext(), "网络已断开，无网络连接");
                }
                return response;
            }
        };

        builder.connectTimeout(15, TimeUnit.SECONDS)
                .addNetworkInterceptor(cacheInterceptor)
                .addInterceptor(cacheInterceptor)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .cache(cache);
        return builder.build();
    }

    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {

        return builder
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    /**
     * http完整日志打印
     */
    private class HttpLogger implements HttpLoggingInterceptor.Logger {

        private StringBuilder mMessage = new StringBuilder();

        @Override
        public void log(String message) {
            // 请求或者响应开始
            if (message.startsWith("--> POST")) {
                mMessage.setLength(0);
            }
            // 以{}或者[]形式的说明是响应结果的json数据，需要进行格式化
            if ((message.startsWith("{") && message.endsWith("}"))
                    || (message.startsWith("[") && message.endsWith("]"))) {
                message = JsonUtil.formatJson(JsonUtil.decodeUnicode(message));
            }
            mMessage.append(message.concat("\n"));
            // 响应结束，打印整条日志
            if (message.startsWith("<-- END HTTP")) {
                LogUtil.d(mMessage.toString());
            }
        }
    }


}
