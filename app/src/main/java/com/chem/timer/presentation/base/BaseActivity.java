package com.chem.timer.presentation.base;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.MvpView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.SupportAppNavigator;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;
import ru.terrakok.cicerone.commands.Replace;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public abstract class BaseActivity extends MvpAppCompatActivity implements MvpView,
        HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Inject
    NavigatorHolder navigatorHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        navigatorHolder.setNavigator(navigator);
        super.onResume();
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }


    private Navigator navigator = new SupportAppNavigator(this, setFragmentContainer()) {

        @Override
        public void applyCommand(Command command) {
            if (!BaseActivity.this.applyCommand(command))
                super.applyCommand(command);
        }

        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            return BaseActivity.this.createFragment(screenKey, data);
        }

        @Override
        protected Intent createActivityIntent(String screenKey, Object data) {
            return BaseActivity.this.createActivityIntent(screenKey, data);
        }

        @Override
        protected void setupFragmentTransactionAnimation(Command command,
                                                         Fragment currentFragment,
                                                         Fragment nextFragment,
                                                         FragmentTransaction fragmentTransaction) {
            BaseActivity.this.setupFragmentTransactionAnimation(command,
                    currentFragment,
                    nextFragment,
                    fragmentTransaction);
        }

        @Override
        protected Bundle createStartActivityOptions(Command command, Intent activityIntent) {
            return BaseActivity.this.createStartActivityOptions(command, activityIntent);
        }
    };

    /**
     * override this method if you need in activity navigation
     *
     * @param screenKey activity key, stored in ScreensKeyUtils
     * @param data      data for activity
     * @return intent for activity creating
     */
    protected Intent createActivityIntent(String screenKey, Object data) {
        return null;
    }

    /**
     * override this method if you need in fragment navigation
     *
     * @param screenKey fragment key, stored in ScreensKeyUtils
     * @param data      data for fragment
     * @return fragment instance
     */
    protected Fragment createFragment(String screenKey, Object data) {
        return null;
    }

    /**
     * override this method if you need in fragment navigation
     *
     * @return id of the fragments container layout
     */
    protected int setFragmentContainer() {
        return -1;
    }

    /**
     * override this method if you need in fragment animations
     *
     * @param command             current navigation command. Will be only {@link Forward} or {@link Replace}
     * @param currentFragment     current fragment in container
     *                            (for {@link Replace} command it will be screen previous in new chain, NOT replaced screen)
     * @param nextFragment        next screen fragment
     * @param fragmentTransaction fragment transaction
     */
    protected void setupFragmentTransactionAnimation(Command command,
                                                     Fragment currentFragment,
                                                     Fragment nextFragment,
                                                     FragmentTransaction fragmentTransaction) {
    }

    /**
     * override this method if you need in applyCommand different from applyCommand SupportAppNavigator
     *
     * @param command current navigation command
     * @return true if your override this method and changed behavior command, other false
     */
    protected boolean applyCommand(Command command) {
        return false;
    }

    /**
     * override this method if you need in activity options
     *
     * @param command        current navigation command
     * @param activityIntent current navigation intent
     * @return bundle activity options
     */
    protected Bundle createStartActivityOptions(Command command, Intent activityIntent) {
        return null;
    }
}
