package com.example.android.shtiptourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class ShtipFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public ShtipFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0)
            return new RestaurantsFragment();
        else if(position==1)
            return new LandmarksFragment();
        else if(position==2)
            return new NightclubsFragment();
        else
            return new SchoolsFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.restaurants);
        } else if (position == 1) {
            return mContext.getString(R.string.landmarks);
        } else if (position == 2) {
            return mContext.getString(R.string.nightclubs);
        } else {
            return mContext.getString(R.string.schools);
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}