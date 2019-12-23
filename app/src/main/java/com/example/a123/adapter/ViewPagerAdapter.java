package com.example.a123.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.a123.UI.ui.Base.BaseFragment;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<String> titles;
    private List<BaseFragment> fragments;
    public ViewPagerAdapter(FragmentManager fm, List<String> titles, List<BaseFragment>fragments){
        super(fm);
        this.titles =titles;
        this.fragments =fragments;
    }




    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return titles.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}

