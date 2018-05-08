package com.leo.test.business.user.di;

import com.leo.test.business.user.UserActivity;
import com.leo.test.business.user.UserContract;
import com.leo.test.business.user.UserPresenterImpl;
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
public abstract class UserModule {

    @ContributesAndroidInjector
    abstract UserActivity usersActivity();

    @ActivityScoped
    @Binds
    abstract UserContract.UserView userView(UserActivity activity);

    @ActivityScoped
    @Binds
    abstract UserContract.UserPresenter userPresenter(UserPresenterImpl presenter);

}
