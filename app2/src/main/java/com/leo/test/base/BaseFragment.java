package com.leo.test.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;


import com.leo.test.di.component.DaggerFragmentComponent;
import com.leo.test.di.component.FragmentComponent;

import javax.inject.Inject;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function
 */
public abstract class BaseFragment<P extends BasePresenter> extends BaseAnalyticsAgentFragment implements BaseFragmentView {

    @Inject
    protected P presenter;

    private FragmentComponent component;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initComponent();
        initDagger();
        Log.i("BaseFragment", "presenter:" + presenter);
        if (presenter != null) {
            presenter.attachView(this);
        }
        initData();
        setupView();
    }

    @Override
    public Context getViewContext() {
        return this.getActivity();
    }

    @Override
    public Context getViewApplicationContext() {
        return this.getViewContext().getApplicationContext();
    }

    @Override
    public void onDestroy() {
        if (presenter != null) {
            presenter.detachView();
        }
        super.onDestroy();
    }

    private void initComponent() {
        component = DaggerFragmentComponent.create();
    }

    protected FragmentComponent getComponent() {
        return component;
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

}
