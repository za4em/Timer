package com.chem.timer.presentation.base;

import android.app.IntentService;

import dagger.android.AndroidInjection;

/**
 * Created by mi on 20.11.2017.
 */

public abstract class BaseService extends IntentService {


    public BaseService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        AndroidInjection.inject(this);
        super.onCreate();
    }

}
