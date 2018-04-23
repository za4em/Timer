package com.chem.timer.presentation.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;

import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;


public abstract class BaseFragment extends MvpAppCompatFragment implements BaseView {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        int layout = getResourceLayout();
        if (layout != 0) {
            return getActivity().getLayoutInflater().inflate(layout, container, false);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (view != null) {
            ButterKnife.bind(this, view);
            onInitView();
        }
        super.onViewCreated(view, savedInstanceState);
    }

    public void onInitView() {
        //empty
    }

    @LayoutRes
    protected abstract int getResourceLayout();
}
