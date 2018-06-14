package com.leo.test.di.component;


import com.leo.test.di.scoped.ActivityScoped;
import com.leo.test.task.TaskActivity;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@ActivityScoped
@Component
public interface ActivityComponent {

    void inject(TaskActivity activity);
//    void inject(RegisterActivity activity);


}
