package com.chem.timer.data.storage;

import com.chem.timer.data.Provider;
import com.orhanobut.hawk.Hawk;

import javax.inject.Inject;


public class TimerStorage implements Provider.TimerStorage {

    private static final String TIMER_SECONDS = "seconds";
    private static final int DEFAULT_SECONDS = 20;

    private static final String TIMER_CLICKS = "clicks";


    @Inject
    public TimerStorage() {
    }

    @Override
    public int getTimerSeconds() {
        return Hawk.get(TIMER_SECONDS, DEFAULT_SECONDS);
    }

    @Override
    public void setTimerSeconds(int seconds) {
        Hawk.put(TIMER_SECONDS, seconds);
    }

    @Override
    public void addClickCount() {
        int clickCount = getClickCount() + 1;
        Hawk.put(TIMER_CLICKS, clickCount);
    }

    @Override
    public int getClickCount() {
        return Hawk.get(TIMER_CLICKS, 0);
    }
}
