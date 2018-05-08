package com.leo.test.business.task;

import android.util.Log;

import com.leo.test.R;
import com.leo.test.base.BaseRxLifecycleActivity;
import com.leo.test.business.user.UserActivity;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function 任务类
 */
public class TaskActivity extends BaseRxLifecycleActivity<TaskPresenterImpl> implements TaskContract.TaskView {

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_task;
    }

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected void setupView() {

    }

    @Override
    public void show(String string) {
        presenter.showOther();
        Log.i("TaskActivity", "show Data:" + string);
//        goActivity(UserActivity.class);
    }

    @Override
    public void showData(String str) {
        show(str);
//        presenter.showOther();
    }
}
