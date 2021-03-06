package com.leo.test.di;


import com.leo.test.business.task.TaskActivity;
import com.leo.test.business.task.di.TaskModule;
import com.leo.test.business.user.UserActivity;
import com.leo.test.business.user.UserFragment;
import com.leo.test.business.user.di.UserModule;
import com.leo.test.scoped.ActivityScoped;
import com.leo.test.scoped.FragmentScoped;
import com.leo.test.third.di.ThirdModules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * We want Dagger.Android to create a Subcomponent which has a parent Component of whichever module ActivityBindingModule is on,
 * in our case that will be AppComponent. The beautiful part about this setup is that you never need to tell AppComponent that it is going to have all these subcomponents
 * nor do you need to tell these subcomponents that AppComponent exists.
 * We are also telling Dagger.Android that this generated SubComponent needs to include the specified modules and be aware of a scope annotation @ActivityScoped
 * When Dagger.Android annotation processor runs it will create 4 subcomponents for us.
 */
@Module
public abstract class BusinessBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = {TaskModule.class, ThirdModules.class})
    abstract TaskActivity tasksActivity();

    @FragmentScoped
    @ContributesAndroidInjector(modules = {UserModule.class})
    abstract UserFragment userFragment();
}
