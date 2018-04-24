package com.chem.timer.dagger.module;


import com.chem.timer.domain.interactor.TimerInteractor;
import com.chem.timer.domain.repository.ITimerRepository;
import com.chem.timer.domain.service.IServiceManager;

import dagger.Module;
import dagger.Provides;

@Module(includes = {
        RepositoryModule.class,
        ServiceModule.class
})
public class InteractorModule {

    @Provides
    TimerInteractor provideTimerInteractor(
            ITimerRepository timerRepository,
            IServiceManager serviceManager
    ) {
        return new TimerInteractor(
                timerRepository,
                serviceManager
        );
    }

}
