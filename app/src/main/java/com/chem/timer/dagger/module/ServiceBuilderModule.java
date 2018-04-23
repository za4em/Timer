package com.chem.timer.dagger.module;

import dagger.Module;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by mi on 20.11.2017.
 */
@Module(includes = {
        AndroidSupportInjectionModule.class
})
public interface ServiceBuilderModule {

//    @ServiceScope
//    @ContributesAndroidInjector
//    ServiceDownloadAudio serviceDownloadAudioInjector();


}
