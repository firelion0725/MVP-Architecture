package com.leo.test.order.rider;

import android.util.Log;

import com.leo.test.R;
import com.leo.test.base.BaseRxLifecycleActivity;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function 任务类
 */
public class RiderActivity extends BaseRxLifecycleActivity<RiderPresenterImpl> implements RiderContract.RiderView {

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_rider;
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
        Log.i("RiderActivity", "show Data:" + string);
    }

    @Override
    public void showData(String str) {
        show(str);
//        presenter.showOther();
    }
}
