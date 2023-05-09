package com.example.bimbel_raja_hans;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class SecondFragment extends Fragment {
    ViewPager2 viewPager2;
    PagerAdaptor pagerAdaptor;
    TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager2 = view.findViewById(R.id.viewPager2);
        tabLayout = view.findViewById(R.id.tabLayout2);
        setViewPager2(viewPager2);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> tab.setText(pagerAdaptor.getFragmentTitle(position))).attach();
    }

    public void setViewPager2(ViewPager2 viewPager2) {
        if (pagerAdaptor == null) {
            pagerAdaptor = new PagerAdaptor(this);
            pagerAdaptor.addFragment(new SecondFragment_1(), "Square");
            pagerAdaptor.addFragment(new SecondFragment_2(), "Triangle");
            pagerAdaptor.addFragment(new SecondFragment_3(), "Circle");
            viewPager2.setAdapter(pagerAdaptor);
        }
    }
}