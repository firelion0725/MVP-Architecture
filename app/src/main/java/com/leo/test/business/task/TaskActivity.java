package com.leo.test.business.task;

import android.util.Log;
import android.widget.Button;

import com.leo.test.R;
import com.leo.test.base.BaseActivity;
import com.leo.test.base.BaseRxLifecycleActivity;
import com.leo.test.third.ThirdObject;

import javax.inject.Inject;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function 任务类
 */
public class TaskActivity extends BaseActivity<TaskPresenterImpl> implements TaskContract.TaskView {

    Button button;

    @Inject
    ThirdObject thirdObject;

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
        button = findViewById(R.id.button);
        show(thirdObject.toString());
    }

    @Override
    public void show(String string) {
        Log.i("TaskActivity", "show Data:" + string);
        presenter.showOther();
    }

    @Override
    public void showData(String str) {
        show(str);
    }
}
