package com.chem.timer.service;

import android.content.Intent;
import android.support.annotation.Nullable;

import com.chem.timer.presentation.base.BaseService;

/**
 * Created by user on 23.04.2018.
 */

public class ServiceTimer extends BaseService {

    public ServiceTimer() {
        super("Timer Service");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
