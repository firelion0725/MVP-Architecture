package com.leo.test.order.list.di;

import com.leo.test.order.list.ListActivity;
import com.leo.test.order.list.ListContract;
import com.leo.test.order.list.ListPresenterImpl;
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
public abstract class ListModule {

    @ContributesAndroidInjector
    abstract ListActivity ListsActivity();

    @ActivityScoped
    @Binds
    abstract ListContract.ListView ListView(ListActivity activity);

    @ActivityScoped
    @Binds
    abstract ListContract.ListPresenter ListPresenter(ListPresenterImpl presenter);

}
