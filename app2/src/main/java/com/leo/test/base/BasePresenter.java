package com.leo.test.base;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function
 */
public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
