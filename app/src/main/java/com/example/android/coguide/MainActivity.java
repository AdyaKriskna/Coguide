package com.example.android.coguide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout =
                (TabLayout) findViewById(R.id.tab_layout);
  //      tabLayout.setupWithViewPager(viewPager);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.camera));
        tabLayout.addTab(tabLayout.newTab().setText("sights"));
        tabLayout.addTab(tabLayout.newTab().setText("places"));
        tabLayout.addTab(tabLayout.newTab().setText("shops"));

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new TabPagerAdapter
                (getSupportFragmentManager(),
                        tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new
                                                   TabLayout.OnTabSelectedListener() {
                                                       @Override
                                                       public void onTabSelected(TabLayout.Tab tab) {
                                                           viewPager.setCurrentItem(tab.getPosition());
                                                       }

                                                       @Override
                                                       public void onTabUnselected(TabLayout.Tab tab) {

                                                       }

                                                       @Override
                                                       public void onTabReselected(TabLayout.Tab tab) {

                                                       }

                                                   });
//        FragmentManager fm = getSupportFragmentManager();
//        @SuppressLint("ResourceType")
//        Fragment fragment = fm.findFragmentById(R.layout.activity_main);





    }



}
