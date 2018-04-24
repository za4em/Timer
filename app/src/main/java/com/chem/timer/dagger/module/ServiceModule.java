package com.chem.timer.dagger.module;

import com.chem.timer.data.service.ServiceManager;
import com.chem.timer.domain.service.IServiceManager;

import dagger.Binds;
import dagger.Module;

/**
 * Created by mi on 20.11.2017.
 */

@Module
public interface ServiceModule {

    @Binds
    IServiceManager bindServiceManager(ServiceManager serviceManager);

}
