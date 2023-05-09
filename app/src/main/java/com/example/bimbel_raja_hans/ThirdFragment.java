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

public class ThirdFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    PagerAdaptor pagerAdaptor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager2 = view.findViewById(R.id.viewPager3);
        tabLayout = view.findViewById(R.id.tabLayout3);
        setViewPager2(viewPager2);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> tab.setText(pagerAdaptor.getFragmentTitle(position))).attach();
    }

    public void setViewPager2(ViewPager2 viewPager2) {
        if (pagerAdaptor == null) {
            pagerAdaptor = new PagerAdaptor(this);
            pagerAdaptor.addFragment(new ThirdFragment_1(), "Block");
            pagerAdaptor.addFragment(new ThirdFragment_2(), "Pyramid");
            pagerAdaptor.addFragment(new ThirdFragment_3(), "Cylinder");
            viewPager2.setAdapter(pagerAdaptor);
        }
    }
}