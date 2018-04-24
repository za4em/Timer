package com.chem.timer.presentation.timer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.chem.timer.R;
import com.chem.timer.presentation.base.BaseFragment;
import com.chem.timer.service.ServiceTimer;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by user on 23.04.2018.
 */

public class TimerFragment extends BaseFragment implements TimerView {

    @Inject
    @InjectPresenter
    TimerPresenter presenter;

    @BindView(R.id.timer_text_view)
    TextView timerView;
    @BindView(R.id.timer_counter_text)
    TextView counterText;

    private LocalBroadcastManager localBroadcastManager;

    @ProvidePresenter
    TimerPresenter providePresenter() {
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

    @OnClick(R.id.timer_five_second_button)
    public void onViewClicked() {
        presenter.onButtonFiveSecondClick();
    }

    @Override
    public void onInitView() {
        registerReceiver();
    }

    private void registerReceiver() {
        localBroadcastManager = LocalBroadcastManager.getInstance(getContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ServiceTimer.MESSAGE_TIMER_SECONDS);
        localBroadcastManager.registerReceiver(broadcastReceiver, intentFilter);
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction()==null)
                return;
            if (intent.getAction().equals(ServiceTimer.MESSAGE_TIMER_SECONDS)) {
                int timerSeconds = intent.getIntExtra(ServiceTimer.INTENT_TIMER_SECONDS,
                        0);
                presenter.onTimerSecondsUpdated(timerSeconds);
            }
        }
    };

    @Override
    public void updateTimerText(String timeText) {
        timerView.setText(timeText);
    }

    @Override
    public void updateClickCounter(String countText) {
        counterText.setText(countText);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(broadcastReceiver);
    }
}
