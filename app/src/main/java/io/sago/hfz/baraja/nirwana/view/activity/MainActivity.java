package io.sago.hfz.baraja.nirwana.view.activity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import android.os.Bundle;
import android.view.MenuItem;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import io.sago.hfz.baraja.nirwana.NirwanaApplication;
import io.sago.hfz.baraja.nirwana.R;
import io.sago.hfz.baraja.nirwana.di.component.ApplicationComponent;
import io.sago.hfz.baraja.nirwana.di.component.ActivityComponent;
import io.sago.hfz.baraja.nirwana.di.component.DaggerActivityComponent;
import io.sago.hfz.baraja.nirwana.di.modules.ActivityModule;
import io.sago.hfz.baraja.nirwana.services.TmdbApiService;
import io.sago.hfz.baraja.nirwana.view.adapter.SectionsPagerAdapter;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemReselectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    public static final String API_KEY_TAG = "api_key";

    public static final String API_KEY = "3f8171028d2be22d2cea4508627a837b";

    public static final String BASE_URL = "https://api.themoviedb.org/3/";

    public static final String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500/";

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @BindView(R.id.nav_view)
    BottomNavigationView bottomNavigationView;

    @Inject
    TmdbApiService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this,
            getSupportFragmentManager());


        viewPager.setAdapter(sectionsPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void initViews() {
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_movies:
                return true;
            case R.id.navigation_tv:
                return true;
            default:
                return false;
        }
    }
}
