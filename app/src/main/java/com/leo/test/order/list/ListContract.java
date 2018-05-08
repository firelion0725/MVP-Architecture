package com.leo.test.order.list;

import com.leo.test.base.BaseView;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function
 */
public interface ListContract {

    interface ListView extends BaseView{
        void showData(String str);
    }

    interface ListPresenter {
        void getData();
    }
}
