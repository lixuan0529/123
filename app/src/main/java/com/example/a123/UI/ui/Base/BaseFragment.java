package com.example.a123.UI.ui.Base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {
    protected Context mContext;
    protected View mView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView =inflater.inflate(setLayoutId(),container,false);
        mContext =mView.getContext();
        initView();
        initData();
        return mView;
    }
    protected abstract int setLayoutId();
    protected abstract void initView();
    protected abstract void initData();
}

