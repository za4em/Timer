package com.chem.timer.dagger.module;

import dagger.Module;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = {
        AndroidSupportInjectionModule.class
})

public interface ActivityBuilderModule {

}
