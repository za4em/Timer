package com.chem.timer.dagger.component;

import android.content.Context;

import com.chem.timer.TimerApplication;
import com.chem.timer.dagger.module.ActivityBuilderModule;
import com.chem.timer.dagger.module.NavigationModule;
import com.chem.timer.dagger.module.ServiceBuilderModule;
import com.chem.timer.dagger.module.UtilsModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {
        ActivityBuilderModule.class,
        NavigationModule.class,
        UtilsModule.class,
        ServiceBuilderModule.class

})
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder context(Context context);

        ApplicationComponent build();
    }

    void inject(TimerApplication app);

}
