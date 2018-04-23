package com.chem.timer.dagger.module;



import com.chem.timer.dagger.scope.FragmentScope;
import com.chem.timer.presentation.timer.TimerFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface FragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = PresenterModule.class)
    TimerFragment timerFragmentInjector();
}
