package com.leo.test.business.user;

import android.util.Log;

import com.leo.data.dao.load.TaskModel;
import com.leo.data.dao.upload.PostTaskModel;
import com.leo.data.rx.AbstractSingleHttp;
import com.leo.data.task.TaskClouds;
import com.leo.test.base.BaseMvpPresenter;

import javax.inject.Inject;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function
 */
public class UserPresenterImpl extends BaseMvpPresenter<UserContract.UserView> implements UserContract.UserPresenter {

    private UserContract.UserView view;

    @Inject
    public UserPresenterImpl(UserContract.UserView view) {
        this.view = view;
    }

    @Override
    public void getData() {
        PostTaskModel body = new PostTaskModel("18302278175", "abcd0987");
        TaskClouds.getTaskData(body)
                .compose(view.<TaskModel>bindToLifecycle())
                .subscribe(new AbstractSingleHttp<TaskModel>() {

                    @Override
                    public void onSuccess(TaskModel taskModel) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });

        String msg = "this is get data";
        view.showData(msg);

    }

    void showOther() {
        Log.i("UserPresenterImpl", "show other msg");
    }
}
