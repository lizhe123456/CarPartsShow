package com.whmnrc.carpartsshow.model.db;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/3/14.
 */

public class RealmHelperImpl implements RealmHelper {

    private static final String DB_NAME = "myRealm.realm";


    @Inject
    public RealmHelperImpl() {
//        RealmConfiguration realmConfig = new RealmConfiguration.Builder(this).build();
//        Realm.setDefaultConfiguration(realmConfig);
    }

}
