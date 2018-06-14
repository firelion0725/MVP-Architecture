package com.leo.test.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.leo.test.di.component.ActivityComponent;
import com.leo.test.di.component.DaggerActivityComponent;

import javax.inject.Inject;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function
 */
public abstract class BaseActivity<P extends BasePresenter> extends BaseAnalyticsAgentActivity implements BaseActivityView {

    @Inject
    protected P presenter;

    private ActivityComponent component;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponent();
        initDagger();
        Log.i("BaseActivity", "presenter:" + presenter);
        if (presenter != null) {
            presenter.attachView(this);
        }
        initData();
        setupView();
    }

    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.detachView();
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
     * 初始化Dagger
     */
    protected abstract void initDagger();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化视图数据
     */
    protected abstract void setupView();

    private void initComponent() {
        component = DaggerActivityComponent.create();
    }

    protected ActivityComponent getComponent() {
        return component;
    }

    protected void goActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

}
