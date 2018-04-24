package com.chem.timer.domain.repository;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by user on 24.04.2018.
 */

public interface ITimerRepository {

    Single<Integer> getTimerSeconds();

    Completable setTimerSeconds(int seconds);

    Single<Integer> getTimerClicks();

    Completable addTimerClick();
}
