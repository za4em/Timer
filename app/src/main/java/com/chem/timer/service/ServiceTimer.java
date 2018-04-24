package com.chem.timer.service;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

import com.chem.timer.domain.interactor.TimerInteractor;
import com.chem.timer.presentation.base.BaseService;

import javax.inject.Inject;

/**
 * Created by user on 23.04.2018.
 */

public class ServiceTimer extends BaseService {

    public static final String MESSAGE_TIMER_SECONDS = "message_timer_seconds";
    public static final String INTENT_TIMER_SECONDS = "intent_timer_seconds";
    public static final String INTENT_TIMER_ADD_SECONDS = "intent_timer_add_seconds";

    private int seconds;
    private boolean isTimerRunning;
    private Handler handler;

    @Inject
    TimerInteractor timerInteractor;

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        super.onStartCommand(intent, startId, startId);
        if (handler == null) {
            timerInteractor
                    .getSeconds()
                    .subscribe(seconds -> this.seconds = seconds, Throwable::printStackTrace);
        }
        if (intent != null) {
            this.seconds += intent.getIntExtra(INTENT_TIMER_ADD_SECONDS, 0);
        }
        if (!isTimerRunning) {
            initTimer();
        }
        return START_NOT_STICKY;
    }

    private void initTimer() {
        isTimerRunning = true;
        sendIntent(seconds);

        handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (seconds > 0) {
                    seconds--;
                }
                sendIntent(seconds);
                isTimerRunning = seconds != 0;
                if (isTimerRunning)
                    handler.postDelayed(this, 1000);
            }
        });
    }

    private void sendIntent(int seconds) {
        Intent intent = new Intent(MESSAGE_TIMER_SECONDS);
        intent.putExtra(INTENT_TIMER_SECONDS, seconds);
        LocalBroadcastManager.getInstance(ServiceTimer.this).sendBroadcast(intent);
    }


    @Override
    public void onDestroy() {
        timerInteractor
                .setSeconds(seconds)
                .subscribe(super::onDestroy, Throwable::printStackTrace);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
