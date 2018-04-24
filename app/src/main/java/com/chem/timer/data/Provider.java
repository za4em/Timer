package com.chem.timer.data;

public interface Provider {

    interface TimerStorage {

        int getTimerSeconds();

        void setTimerSeconds(int seconds);

        void setClickCount(int clickCount);

        void getClickCount();
    }


}
