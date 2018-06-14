package com.leo.test.di;

import com.leo.test.MyApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {ApplicationModule.class
        , AndroidSupportInjectionModule.class
        , BusinessBindingModule.class
})
public interface AppComponent extends AndroidInjector<MyApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(DaggerApplication application);

        AppComponent build();
    }
}
