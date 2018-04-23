package com.chem.timer.presentation.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.chem.timer.R;
import com.chem.timer.presentation.base.BaseActivity;
import com.chem.timer.presentation.timer.TimerFragment;
import com.chem.timer.utils.ScreensKeyUtils;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainView {

    @Inject
    @InjectPresenter
    MainPresenter presenter;

    @ProvidePresenter
    MainPresenter providePresenter(){
        return presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected Fragment createFragment(String screenKey, Object data) {
        Fragment fragment = null;
        switch (screenKey) {
            case ScreensKeyUtils.FRAGMENT_TIMER_SCREEN:
                fragment = TimerFragment.newInstance();
                break;

        }

        return fragment;
    }

    @Override
    protected int setFragmentContainer() {
        return R.id.main_container;
    }
}
