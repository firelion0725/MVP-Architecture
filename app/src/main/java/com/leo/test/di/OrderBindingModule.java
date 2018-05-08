package com.leo.test.di;

import com.leo.test.order.list.ListActivity;
import com.leo.test.order.list.di.ListModule;
import com.leo.test.order.rider.RiderActivity;
import com.leo.test.order.rider.di.RiderModule;
import com.leo.test.scoped.ActivityScoped;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function
 */
@Module
public abstract class OrderBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = {ListModule.class})
    abstract ListActivity listActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {RiderModule.class})
    abstract RiderActivity riderActivity();
}
