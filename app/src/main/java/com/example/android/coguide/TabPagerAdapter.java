package com.example.android.coguide;

/**
 * Created by amarnath on 4/2/18.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter {

    int tabCount;

    public TabPagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.tabCount = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                camera tab1 = new camera();
                return tab1;
            case 1:
                sights tab2 = new sights();
                return tab2;
            case 2:
                places tab3 = new places();
                return tab3;
            case 3:
                shops tab4 = new shops();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }


}