package com.leo.test.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function
 */
public abstract class BaseActivity<P extends BasePresenter> extends SupportActivity implements BaseActivityView {

    @Inject
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        presenter.takeView(this);
        initData();
        setupView();
    }

    @Override
    protected void onDestroy() {
        presenter.dropView();
        super.onDestroy();
    }

    @Override
    public Context getViewContext() {
        return this;
    }

    /**
     * 通过模板方法加入layout id
     *
     * @return layout id
     */
    protected abstract int getLayoutResID();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化视图数据
     */
    protected abstract void setupView();

    protected void goActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

}
