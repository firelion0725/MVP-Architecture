package com.leo.test.business.user.di;

import com.leo.test.business.user.UserContract;
import com.leo.test.business.user.UserFragment;
import com.leo.test.business.user.UserPresenterImpl;
import com.leo.test.scoped.ActivityScoped;
import com.leo.test.scoped.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function
 */
@Module
public abstract class UserModule {

//    @ContributesAndroidInjector
//    abstract UserFragment userFragment();
//
//    @FragmentScoped
//    @Binds
//    abstract UserContract.UserView userView(UserFragment fragment);
//
//    @ActivityScoped
//    @Binds
//    abstract UserContract.UserPresenter userPresenter(UserPresenterImpl presenter);

//    @FragmentScoped
    @ContributesAndroidInjector
    abstract UserFragment userFragment();

    @ActivityScoped
    @Binds
    abstract UserContract.UserPresenter userPresenter(UserPresenterImpl presenter);

}
