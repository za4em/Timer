package com.chem.timer.dagger.module;

import com.chem.timer.dagger.scope.ActivityScope;
import com.chem.timer.dagger.scope.FragmentScope;
import com.chem.timer.presentation.main.MainPresenter;
import com.chem.timer.presentation.timer.TimerPresenter;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Router;

@Module
public class PresenterModule {

    @ActivityScope
    @Provides
    MainPresenter provideMainPresenter(Router router) {
        return new MainPresenter(router);
    }

    @FragmentScope
    @Provides
    TimerPresenter provideTimerPresenter(Router router){
        return new TimerPresenter(router);
    }

}