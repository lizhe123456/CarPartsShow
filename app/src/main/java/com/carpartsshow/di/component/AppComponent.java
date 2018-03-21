package com.carpartsshow.di.component;


import com.carpartsshow.app.App;
import com.carpartsshow.di.module.AppModule;
import com.carpartsshow.di.module.HttpModule;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.db.RealmHelperImpl;
import com.carpartsshow.model.http.HttpHelperImpl;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by lizhe on 2017/12/11 0011.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
@Singleton
@Component(modules = {AppModule.class,HttpModule.class})
public interface AppComponent {

    App getContext(); //提供App的Context

    DataManager getDataManager(); //数据中心

    HttpHelperImpl getHttpHelper(); //提供http的帮助类

    RealmHelperImpl getDbHelper(); //提供数据库帮助类

}
