package com.chem.timer.data.repository;

import com.chem.timer.data.Provider;
import com.chem.timer.data.storage.TimerStorage;
import com.chem.timer.domain.repository.ITimerRepository;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by user on 24.04.2018.
 */

public class TimerRepository implements ITimerRepository {

    private Provider.TimerStorage timerStorage;

    private Observable<Integer> observable;

    @Inject
    public TimerRepository(TimerStorage timerStorage) {
        this.timerStorage = timerStorage;
    }

    @Override
    public Single<Integer> getTimerSeconds() {
        return Single.fromCallable(()->timerStorage.getTimerSeconds());
    }

    @Override
    public Completable setTimerSeconds(int seconds) {
        return Completable.fromRunnable(()->timerStorage.setTimerSeconds(seconds));
    }

    @Override
    public Single<Integer> getTimerClicks() {
        return Single.fromCallable(()->timerStorage.getClickCount());
    }

    @Override
    public Completable addTimerClick() {
        return Completable.fromRunnable(()->timerStorage.addClickCount());
    }
}
