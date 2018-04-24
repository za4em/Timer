package com.chem.timer.dagger.module;

import com.chem.timer.data.Provider;
import com.chem.timer.data.storage.TimerStorage;

import dagger.Binds;
import dagger.Module;

@Module
public interface StorageModule {

    @Binds
    Provider.TimerStorage bindUserData(TimerStorage timerStorage);
}
