package com.chem.timer.dagger.module;

import com.chem.timer.dagger.scope.ActivityScope;
import com.chem.timer.presentation.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = {
        AndroidSupportInjectionModule.class
})

public interface ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {
            PresenterModule.class,
            FragmentBuilderModule.class
    })
    MainActivity mainActivityInjector();
}
