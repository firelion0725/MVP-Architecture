package com.leo.test.di;

import android.app.Application;

import com.leo.test.MyApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {ApplicationModule.class
        , AndroidSupportInjectionModule.class
        , BusinessBindingModule.class
        , OrderBindingModule.class
})
public interface AppComponent extends AndroidInjector<MyApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
