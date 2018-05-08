package com.leo.test.order.list;

import android.util.Log;

import com.leo.test.R;
import com.leo.test.base.BaseRxLifecycleActivity;
import com.leo.test.order.rider.RiderActivity;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function 任务类
 */
public class ListActivity extends BaseRxLifecycleActivity<ListPresenterImpl> implements ListContract.ListView {

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_list;
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
        Log.i("ListActivity", "show Data:" + string);
        goActivity(RiderActivity.class);
    }

    @Override
    public void showData(String str) {
        show(str);
//        presenter.showOther();
    }
}
