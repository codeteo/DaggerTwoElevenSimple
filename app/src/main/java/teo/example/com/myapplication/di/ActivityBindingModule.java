package teo.example.com.myapplication.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import teo.example.com.myapplication.features.MainActivity;
import teo.example.com.myapplication.features.di.MainActivityModule;

/**
 * We want Dagger.Android to create a Subcomponent which has a parent Component of whichever module
 * ActivityBindingModule is on, in our case that will be AppComponent.
 * The beautiful part about this setup is that you never need to tell AppComponent that it
 * is going to have all these subcomponents nor do you need to tell these subcomponents that AppComponent exists.
 */

@Module
public abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();
}
