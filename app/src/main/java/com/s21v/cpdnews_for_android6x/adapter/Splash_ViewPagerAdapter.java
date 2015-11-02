package com.s21v.cpdnews_for_android6x.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.s21v.cpdnews_for_android6x.fragment.SingleViewFragment;
import com.s21v.cpdnews_for_android6x.utils.Constant;

/**
 * Created by 弈 on 2015/11/2.
 */
public class Splash_ViewPagerAdapter extends FragmentStatePagerAdapter {
    private int[] imgIDs;

    public Splash_ViewPagerAdapter(FragmentManager fm, int[] ids) {
        super(fm);
        imgIDs = ids;
    }

    @Override
    public Fragment getItem(int position) {
        SingleViewFragment singleViewFragment = SingleViewFragment.getInstance(imgIDs[position]);
        return singleViewFragment;
    }

    @Override
    public int getCount() {
        return Constant.DOT_SIZE;
    }
}
