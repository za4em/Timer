package com.chem.timer.presentation.timer;

import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.chem.timer.R;
import com.chem.timer.presentation.base.BaseFragment;

import javax.inject.Inject;

/**
 * Created by user on 23.04.2018.
 */

public class TimerFragment extends BaseFragment implements TimerView {

    @Inject
    @InjectPresenter
    TimerPresenter presenter;

    @ProvidePresenter
    TimerPresenter providePresenter(){
        return presenter;
    }

    public static TimerFragment newInstance() {
        TimerFragment fragment = new TimerFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.fragment_timer;
    }
}
