package com.chem.timer.presentation.timer;

import com.arellomobile.mvp.InjectViewState;
import com.chem.timer.presentation.base.BasePresenter;

import javax.inject.Inject;

import butterknife.BindView;
import ru.terrakok.cicerone.Router;

/**
 * Created by user on 23.04.2018.
 */

@InjectViewState
public class TimerPresenter extends BasePresenter<TimerView> {

    @Inject
    public TimerPresenter(Router router) {
        super(router);
    }
}
