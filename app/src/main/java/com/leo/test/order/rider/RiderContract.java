package com.leo.test.order.rider;

import com.leo.test.base.BaseView;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function
 */
public interface RiderContract {

    interface RiderView extends BaseView{
        void showData(String str);
    }

    interface RiderPresenter {
        void getData();
    }
}
