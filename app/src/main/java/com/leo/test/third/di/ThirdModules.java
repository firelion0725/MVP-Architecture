package com.leo.test.third.di;

import com.leo.test.scoped.ActivityScoped;
import com.leo.test.third.ThirdObject;

import dagger.Module;
import dagger.Provides;

/**
 * @author leo, ZhangWei
 * @date 2018/5/28
 */
@Module
public class ThirdModules {

    @ActivityScoped
    @Provides
    public ThirdObject getThirdObject() {
        return new ThirdObject("test", "just a message");
    }
}
