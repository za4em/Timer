package com.chem.timer.presentation.main;

import com.arellomobile.mvp.InjectViewState;
import com.chem.timer.presentation.base.BasePresenter;
import com.chem.timer.utils.ScreensKeyUtils;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

/**
 * Created by user on 23.04.2018.
 */
@InjectViewState
public class MainPresenter extends BasePresenter<MainView> {

    @Inject
    public MainPresenter(Router router) {
        super(router);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        router.newRootScreen(ScreensKeyUtils.FRAGMENT_TIMER_SCREEN);
    }
}
