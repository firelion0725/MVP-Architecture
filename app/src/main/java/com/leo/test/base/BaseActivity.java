package com.leo.test.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import javax.inject.Inject;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function
 */
public abstract class BaseActivity<P extends BasePresenter> extends BaseAnalyticsAgentActivity implements BaseActivityView {

    @Inject
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("BaseActivity", "presenter:" + presenter);
        if (presenter != null) {
            presenter.takeView(this);
        }
        initData();
        setupView();
    }

    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.dropView();
        }
        super.onDestroy();
    }

    @Override
    public Context getViewContext() {
        return this;
    }

    @Override
    public Context getViewApplicationContext() {
        return this.getApplicationContext();
    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化视图数据
     */
    protected abstract void setupView();
}
