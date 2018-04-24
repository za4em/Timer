package com.chem.timer.presentation.timer;

import com.arellomobile.mvp.InjectViewState;
import com.chem.timer.domain.interactor.TimerInteractor;
import com.chem.timer.presentation.base.BasePresenter;

import javax.inject.Inject;

import butterknife.BindView;
import ru.terrakok.cicerone.Router;

/**
 * Created by user on 23.04.2018.
 */

@InjectViewState
public class TimerPresenter extends BasePresenter<TimerView> {

    private static final int DEFAULT_ADDITIONAL_SECONDS = 5;
    private static final int DEFAULT_SECONDS = 20;

    private TimerInteractor timerInteractor;

    @Inject
    public TimerPresenter(Router router, TimerInteractor timerInteractor) {
        super(router);
        this.timerInteractor = timerInteractor;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        timerInteractor.startService();
    }

    public void onButtonFiveSecondClick(){
        timerInteractor.addSeconds(DEFAULT_ADDITIONAL_SECONDS);

    }

    public void onButtonTwentySecondClick(){
        timerInteractor.addSeconds(DEFAULT_SECONDS);
    }

    public void onButtonCancelClick(){
        router.exit();
    }

    public void onTimerSecondsUpdated(int timerSeconds) {
        getViewState().updateTimerText(formatTime(timerSeconds));
    }

    private String formatTime(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        return String.format("%d:%02d:%02d", hours, minutes, secs);
    }
}
