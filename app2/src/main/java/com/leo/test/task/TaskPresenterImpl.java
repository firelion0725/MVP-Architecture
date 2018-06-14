package com.leo.test.task;

import android.util.Log;

import com.leo.test.base.BaseMvpPresenter;

import javax.inject.Inject;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function
 */
public class TaskPresenterImpl extends BaseMvpPresenter<TaskContract.TaskView> implements TaskContract.TaskPresenter {

    @Inject
    public TaskPresenterImpl() {
    }

    @Override
    public void getData() {
        Log.i("TaskPresenterImpl", "getData");
        String msg = "this is get data";
        view.showData(msg);
    }

}
