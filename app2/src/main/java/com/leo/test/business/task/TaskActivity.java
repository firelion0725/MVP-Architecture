package com.leo.test.business.task;

import android.util.Log;

import com.leo.test.R;
import com.leo.test.base.BaseActivity;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function 任务类
 */
public class TaskActivity extends BaseActivity<TaskPresenterImpl> implements TaskContract.TaskView {



    @Override
    protected int getLayoutResID() {
        return R.layout.activity_task;
    }

    @Override
    protected void initDagger() {
        getComponent().inject(this);
    }

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected void setupView() {

    }

    @Override
    public void showData(String str) {
        Log.i("TaskActivity", "getData");
        Log.i("TaskActivity", "data:" + str);
    }
}
