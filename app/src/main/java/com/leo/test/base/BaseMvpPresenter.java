package com.leo.test.base;

/**
 * @author leo, ZhangWei
 * @date 2018/5/30
 */
public class BaseMvpPresenter<V extends BaseView> implements BasePresenter<V> {

    protected V view;

    @Override
    public void takeView(V v) {
        this.view = view;
    }

    @Override
    public void dropView() {
        view = null;
    }
}
