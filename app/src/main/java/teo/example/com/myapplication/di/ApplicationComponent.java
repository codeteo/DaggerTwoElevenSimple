package teo.example.com.myapplication.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import teo.example.com.myapplication.MyApplication;

/**
 * Dagger component.
 */

@Singleton
@Component(
            modules = {
                AndroidSupportInjectionModule.class,
                ActivityBindingModule.class,
                ApplicationModule.class})
public interface ApplicationComponent extends AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        ApplicationComponent.Builder app(Application application);

        ApplicationComponent build();
    }

}
