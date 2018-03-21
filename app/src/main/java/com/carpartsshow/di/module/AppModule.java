package com.carpartsshow.di.module;


import com.carpartsshow.app.App;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.db.RealmHelper;
import com.carpartsshow.model.db.RealmHelperImpl;
import com.carpartsshow.model.http.HttpHelper;
import com.carpartsshow.model.http.HttpHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lizhe on 2017/12/11 0011.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
@Module
public class AppModule {

    private final App application;

    public AppModule(App application){
        this.application = application;
    }

    @Singleton
    @Provides
    App provideApplicationContext(){
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(HttpHelperImpl httpHelper){
        return httpHelper;
    }


    @Provides
    @Singleton
    RealmHelper provideDBHelper(RealmHelperImpl realmHelper){
        return realmHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, RealmHelper DBHelper){
        return new DataManager(httpHelper,DBHelper);
    }

}
