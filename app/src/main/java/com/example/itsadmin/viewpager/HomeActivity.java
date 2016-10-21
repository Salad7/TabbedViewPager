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

    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final ActionBar actionBar = getActionBar();

        //Specify that tabs should be displayed in the action bar
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        PagerAdapter pa = new PagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                 //When swiping between pages,
                //Select the corresponding tab.
                getActionBar().setNavigationMode(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setAdapter(pa);

        //Create a tab listener that is called when the user changes tabs
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                //Show the given tab

                //When the tab is selected, switch
                //To the corresponding page in the viewpager
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
                //Hide the given tab
            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
                //ignore for now
            }
        };

        for(int i = 0; i < 2; i++){
            actionBar.addTab(actionBar.newTab().setText("Tab " + (i+1))
            .setTabListener(tabListener));
        }




    }

    public class PagerAdapter extends FragmentStatePagerAdapter{

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
    }
}
