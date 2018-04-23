package com.chem.timer.presentation.base;


import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import ru.terrakok.cicerone.Router;


public abstract class BasePresenter<View extends MvpView> extends MvpPresenter<View> {

    protected Router router;

    public BasePresenter(Router router) {
        this.router = router;
    }

}


