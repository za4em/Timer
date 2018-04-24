package com.chem.timer.dagger.module;


import com.chem.timer.data.repository.TimerRepository;
import com.chem.timer.domain.repository.ITimerRepository;

import dagger.Binds;
import dagger.Module;

@Module(includes = {
        StorageModule.class
})
public interface RepositoryModule {

    @Binds
    ITimerRepository bindUserDataRepository(TimerRepository timerRepository);
}
