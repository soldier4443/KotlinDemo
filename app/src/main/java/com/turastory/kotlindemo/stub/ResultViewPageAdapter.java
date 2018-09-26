package com.turastory.kotlindemo.stub;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by tura on 2018-09-26.
 */
public class ResultViewPageAdapter extends FragmentStatePagerAdapter {
    public ResultViewPageAdapter(FragmentManager fm) {
        super(fm);
    }
    
    @Override
    public Fragment getItem(int i) {
        return null;
    }
    
    @Override
    public int getCount() {
        return 0;
    }
}
