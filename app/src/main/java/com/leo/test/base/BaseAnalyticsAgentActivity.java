package com.leo.test.base;

/**
 * @author leo, ZhangWei
 * @date 2018/6/13
 */
public abstract class BaseAnalyticsAgentActivity extends BaseButterKnifeActivity {

    @Override
    protected void onResume() {
        super.onResume();
        // 友盟或其他统计方法
//        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        // 友盟或其他统计方法
//        MobclickAgent.onPause(this);
        super.onPause();
    }

}
