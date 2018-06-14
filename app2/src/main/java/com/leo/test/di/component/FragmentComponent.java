package com.leo.test.di.component;


import com.leo.test.business.user.UserFragment;
import com.leo.test.di.scoped.FragmentScoped;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@FragmentScoped
@Component
public interface FragmentComponent {
    void inject(UserFragment fragment);
}
