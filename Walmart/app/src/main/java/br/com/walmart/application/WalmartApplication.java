package br.com.walmart.application;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by amandalacanna on 1/9/17.
 */

public class WalmartApplication extends Application {

    @Override public void onCreate() {
        super.onCreate();

        RealmConfiguration realmConfiguration =
                new RealmConfiguration.Builder(this).schemaVersion(0)
                        .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }
}

