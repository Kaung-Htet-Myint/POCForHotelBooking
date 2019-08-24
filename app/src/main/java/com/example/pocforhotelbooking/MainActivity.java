package com.example.pocforhotelbooking;

import android.os.Bundle;

import com.example.pocforhotelbooking.adapters.TabPagerAdapter;
import com.example.pocforhotelbooking.fragments.NearByFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private NearByFragment nearByFragment;
    private ViewPager vpBottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        /*vpBottomNav = findViewById(R.id.vp_bottom_nav);
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.item_home:
                    vpBottomNav.setCurrentItem(0);

                    case R.id.item_search:
                        vpBottomNav.setCurrentItem(1);
                }
                return false;
            }
        });*/

        vpBottomNav = findViewById(R.id.vp_bottom_nav);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(vpBottomNav);


        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        vpBottomNav.setAdapter(tabPagerAdapter);
    }

   /* private void setupWithViewPager(ViewPager viewPager){
        TabPagerAdapter bottomNavPagerAdapter  = new TabPagerAdapter(getSupportFragmentManager());
        nearByFragment = new NearByFragment();
        vpBottomNav.setAdapter(bottomNavPagerAdapter);
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
