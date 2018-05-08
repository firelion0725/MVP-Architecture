package com.leo.test.order.rider.di;

import com.leo.test.order.rider.RiderActivity;
import com.leo.test.order.rider.RiderContract;
import com.leo.test.order.rider.RiderPresenterImpl;
import com.leo.test.scoped.ActivityScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function
 */
@Module
public abstract class RiderModule {

    @ContributesAndroidInjector
    abstract RiderActivity RidersActivity();

    @ActivityScoped
    @Binds
    abstract RiderContract.RiderView RiderView(RiderActivity activity);

    @ActivityScoped
    @Binds
    abstract RiderContract.RiderPresenter RiderPresenter(RiderPresenterImpl presenter);

}
