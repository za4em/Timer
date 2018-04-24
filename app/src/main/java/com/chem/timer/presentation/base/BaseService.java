package com.chem.timer.presentation.base;

import android.app.Service;

import dagger.android.AndroidInjection;

/**
 * Created by mi on 20.11.2017.
 */

public abstract class BaseService extends Service {


    @Override
    public void onCreate() {
        AndroidInjection.inject(this);
        super.onCreate();
    }

}
