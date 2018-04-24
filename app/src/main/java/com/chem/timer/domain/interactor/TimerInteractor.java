package com.chem.timer.domain.interactor;

import com.chem.timer.domain.repository.ITimerRepository;
import com.chem.timer.domain.service.IServiceManager;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by user on 16.03.2018.
 */

public class TimerInteractor {

    private ITimerRepository timerRepository;
    private IServiceManager serviceManager;

    @Inject
    public TimerInteractor(ITimerRepository timerRepository, IServiceManager serviceManager) {
        this.timerRepository = timerRepository;
        this.serviceManager = serviceManager;
    }

    public Single<Integer> getSeconds(){
        return timerRepository.getTimerSeconds();
    }

    public Completable setSeconds(int seconds){
        return timerRepository.setTimerSeconds(seconds);
    }

    public void startService(){
        serviceManager.startService();
    }

    public void addSeconds(int additionalSeconds){
        serviceManager.startService(additionalSeconds);
    }

}
