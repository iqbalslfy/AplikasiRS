package com.projectrs.aplikasirs;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.projectrs.aplikasirs.Activity.MyAccount;
import com.projectrs.aplikasirs.Adapter.ViewPagerAdapter;
import com.projectrs.aplikasirs.ConfigurationMenu.MenuHome;
import com.projectrs.aplikasirs.Data.DataMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar toolbar;
    private GridLayoutManager layoutMenu;
    private RecyclerView rvMenu;
    MenuHome menuHome;
    private List<DataMain> mainList = new ArrayList<>();
    ViewPager viewPager;
    LinearLayout SliderDots;
    private int dotcounts;
    private ImageView[] dots;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuData();

        rvMenu = findViewById(R.id.rvMenu);
        rvMenu.setHasFixedSize(true);

        layoutMenu = new GridLayoutManager(getApplicationContext(), 3, GridLayoutManager.VERTICAL, false);

        rvMenu.setLayoutManager(layoutMenu);
        menuHome = new MenuHome(mainList, getApplicationContext());
        rvMenu.setAdapter(menuHome);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final NavigationView view = findViewById(R.id.navigationView);

        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_account) {
                    startActivity(new Intent(getApplicationContext(), MyAccount.class));
                }

                if (id == R.id.nav_help) {
                    Toast.makeText(getApplicationContext(), "Clicked!", Toast.LENGTH_SHORT).show();
                }

                if (id == R.id.nav_setting) {
                    Toast.makeText(getApplicationContext(), "Clicked!", Toast.LENGTH_SHORT).show();
                }

                if (id == R.id.nav_logout) {
                    Toast.makeText(getApplicationContext(), "Clicked!", Toast.LENGTH_SHORT).show();
                }


                return true;
            }
        });

        viewPager = findViewById(R.id.viewPagerHome);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        SliderDots = findViewById(R.id.Dots);
        dotcounts = viewPagerAdapter.getCount();

        dots = new ImageView[dotcounts];

        for (int i = 0; i < dotcounts; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.indicator_enable));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);
            SliderDots.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.indicator_unable));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotcounts; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.indicator_unable));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.indicator_enable));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTasks(), 1000, 2000);
    }

    public class TimerTasks extends TimerTask {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    } else {
                        viewPager.setCurrentItem(0);
                    }

                }
            });


        }
    }

    private void menuData() {
        mainList.add(new DataMain(R.drawable.asset, "JADWAL" + "\n" + " & RESERVASI"));
        mainList.add(new DataMain(R.drawable.admumum, "DOKTER" + "\n" + "PRIBADI"));
        mainList.add(new DataMain(R.drawable.rekammedic, "CHECK UP REMINDER"));
        mainList.add(new DataMain(R.drawable.asset, "CHECK UP HISTORY"));
        mainList.add(new DataMain(R.drawable.antrian, "BMI"));
        mainList.add(new DataMain(R.drawable.absendangaji, "BILL" + "\n" + "REMINDER"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
