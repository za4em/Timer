package com.chem.timer.data.service;

import android.content.Context;
import android.content.Intent;

import com.chem.timer.domain.service.IServiceManager;
import com.chem.timer.service.ServiceTimer;

import javax.inject.Inject;

/**
 * Created by user on 24.04.2018.
 */

public class ServiceManager implements IServiceManager {

    private Context context;

    @Inject
    public ServiceManager(
            Context context
    ) {
        this.context = context;
    }

    @Override
    public void startService(int additionalSeconds) {
        Intent serviceIntent = new Intent(context, ServiceTimer.class);
        serviceIntent.putExtra(ServiceTimer.INTENT_TIMER_ADD_SECONDS, additionalSeconds);
        context.startService(serviceIntent);
    }

    @Override
    public void startService() {
        Intent serviceIntent = new Intent(context, ServiceTimer.class);
        context.startService(serviceIntent);
    }
}
