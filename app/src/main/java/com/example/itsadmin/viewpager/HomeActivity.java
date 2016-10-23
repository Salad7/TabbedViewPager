package com.example.itsadmin.viewpager;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class HomeActivity extends FragmentActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       final ViewPager viewPager;
        final ActionBar actionBar = getActionBar();
        viewPager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter pa = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pa);



    }

    public class PagerAdapter extends FragmentStatePagerAdapter{

        private String[] titles = {"Title 1", "Title 2"};
        public PagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0:
                    Fragment frag = new SampleFragment1();
                    return frag;
                case 1:
                    Fragment frag2 = new SampleFragment2();
                    return frag2;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}

