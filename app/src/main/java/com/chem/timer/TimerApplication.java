package com.chem.timer;

import android.app.Activity;
import android.app.Application;
import android.app.Service;

import com.chem.timer.dagger.component.DaggerApplicationComponent;
import com.orhanobut.hawk.Hawk;
import com.squareup.leakcanary.LeakCanary;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasServiceInjector;

/**
 * Created by user on 23.04.2018.
 */

public class TimerApplication extends Application implements HasActivityInjector, HasServiceInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<Service> dispatchingAndroidInjectorService;


    @Override
    public void onCreate() {
        super.onCreate();

        Hawk.init(this)
                .build();

        DaggerApplicationComponent
                .builder()
                .context(this)
                .build()
                .inject(this);

        if (BuildConfig.DEBUG) {

            if (LeakCanary.isInAnalyzerProcess(this)) {
                // This process is dedicated to LeakCanary for heap analysis.
                // You should not init your app in this process.
                return;
            }
            LeakCanary.install(this);
        }
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Service> serviceInjector() {
        return dispatchingAndroidInjectorService;
    }
}
