package com.whmnrc.carpartsshow.util;

import com.whmnrc.carpartsshow.exception.SysException;
import com.whmnrc.carpartsshow.model.http.response.CPSResponse;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/8/19 0019.
 * Rx帮助类，统一返回结果集
 */

public class RxUtil {

    /**
     * 统一线程处理
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> rxSchedulerHelper(){
        return new FlowableTransformer<T,T>(){

            @Override
            public Flowable<T> apply(Flowable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    //有返回
    public static <T> FlowableTransformer<CPSResponse<T>,T> handle(){
        return new FlowableTransformer<CPSResponse<T>, T>() {
            @Override
            public Flowable<T> apply(Flowable<CPSResponse<T>> upstream) {
                return upstream.flatMap(new Function<CPSResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(@NonNull CPSResponse<T> tWeatherResponse) throws Exception {
                        if (tWeatherResponse.getType() == 1){
                            if (tWeatherResponse.getResultdata() == null){
                                return Flowable.error(new SysException(tWeatherResponse));
                            }else {
                                return createData(tWeatherResponse.getResultdata());
                            }
                        }else {
                            return Flowable.error(new SysException(tWeatherResponse));
                        }
                    }
                });
            }
        };
    }
    //无返回
    public static FlowableTransformer<CPSResponse,CPSResponse> handleState(){
        return new FlowableTransformer<CPSResponse, CPSResponse>() {
            @Override
            public Flowable apply(Flowable<CPSResponse> upstream) {
                return upstream.flatMap(new Function<CPSResponse, Flowable<CPSResponse>>() {
                    @Override
                    public Flowable<CPSResponse> apply(@NonNull final CPSResponse zlResponse) throws Exception {
                        if (zlResponse.getType() == 1){
                            return createData(zlResponse);
                        }else {
                            return Flowable.error(new SysException(zlResponse));
                        }
                    }
                });
            }
        };

    }


    /**
     * 生成Flowable
     * @param <T>
     * @return
     */
    public static <T> Flowable<T> createData(final T t) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }
}
