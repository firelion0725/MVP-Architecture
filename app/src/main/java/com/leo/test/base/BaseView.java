package com.leo.test.base;

import android.content.Context;
import android.support.annotation.NonNull;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function
 */
public interface BaseView {

    <T> LifecycleTransformer<T> bindToLifecycle();

    void show(String string);

    Context getViewContext();

    Context getViewApplicationContext();
}
