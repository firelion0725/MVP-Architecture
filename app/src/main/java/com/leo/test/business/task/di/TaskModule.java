package com.leo.test.business.task.di;

import com.leo.test.business.task.TaskActivity;
import com.leo.test.business.task.TaskContract;
import com.leo.test.business.task.TaskPresenterImpl;
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
public abstract class TaskModule {

    @ContributesAndroidInjector
    abstract TaskActivity tasksActivity();

    @ActivityScoped
    @Binds
    abstract TaskContract.TaskView taskView(TaskActivity activity);

    @ActivityScoped
    @Binds
    abstract TaskContract.TaskPresenter taskPresenter(TaskPresenterImpl presenter);

}
