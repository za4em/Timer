package com.chem.timer.presentation.timer;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.chem.timer.presentation.base.BaseView;

/**
 * Created by user on 23.04.2018.
 */

public interface TimerView extends BaseView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void updateTimerText(String timeText);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void updateClickCounter(String countText);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showDialog();

}
