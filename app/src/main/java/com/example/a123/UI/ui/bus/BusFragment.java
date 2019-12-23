package com.example.a123.UI.ui.bus;

import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.a123.R;
import com.example.a123.UI.ui.Base.BaseFragment;
import com.example.a123.adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class BusFragment extends BaseFragment {
    private TabLayout tab;
    private ViewPager pager;
    private List<String> titles;
    private List<BaseFragment> fragments;
    private ViewPagerAdapter adapter;

    protected int setLayoutId(){
        return R.layout.bus_fragment;
    }
    protected void initView(){
        tab =mView.findViewById(R.id.tab);
        pager =mView.findViewById(R.id.pager);
    }

    @Override
    protected void initData() {
      titles =new ArrayList<>();
      titles.add("1号站台");
      titles.add("2号站台");
      fragments =new ArrayList<BaseFragment>();
      fragments.add(new BusStationOneFragment());
      fragments.add(new BusStationTwoFragment());

        FragmentManager fm =getChildFragmentManager();
        adapter =new ViewPagerAdapter(fm,titles,fragments);
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);

    }
}
