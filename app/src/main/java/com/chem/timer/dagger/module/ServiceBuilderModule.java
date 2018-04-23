package com.chem.timer.dagger.module;

import com.chem.timer.dagger.scope.ServiceScope;
import com.chem.timer.service.ServiceTimer;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by mi on 20.11.2017.
 */
@Module(includes = {
        AndroidSupportInjectionModule.class
})
public interface ServiceBuilderModule {

    @ServiceScope
    @ContributesAndroidInjector
    ServiceTimer serviceTimerInjector();


}
