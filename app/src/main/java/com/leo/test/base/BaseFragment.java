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
public abstract class BaseFragment<P extends BasePresenter> extends BaseAnalyticsAgentFragment implements BaseFragmentView {

    @Inject
    protected P presenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("BaseFragment", "presenter:" + presenter);
        if (presenter != null) {
            presenter.takeView(this);
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
            presenter.dropView();
        }
        super.onDestroy();
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
