package com.leo.test;

import com.leo.test.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function
 */
public class MyApp extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
//        RealmUtils.initRealm(getApplicationContext());
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
