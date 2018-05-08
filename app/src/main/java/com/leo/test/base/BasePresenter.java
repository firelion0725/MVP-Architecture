package com.leo.test.base;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function
 */
public abstract class BasePresenter<V extends BaseView> {

    private V view;

    void takeView(V v) {
        view = v;
    }

    void dropView() {
        view = null;
    }
}
