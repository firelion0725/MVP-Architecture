package com.leo.test.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function
 */
public abstract class BaseFragment<P extends BasePresenter<BaseView>> extends SupportFragment implements BaseFragmentView {

    protected P presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResID(), container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupPresenter(getupPresenter());
        presenter.takeView(this);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
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

    /**
     * 初始化Presenter
     */
    protected abstract BasePresenter getupPresenter();

    private void setupPresenter(BasePresenter basePresenter) {
        presenter = (P) basePresenter;
    }

}
