package com.tnt.homestays;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tnt.homestays.fragment.FavoriteFragment;
import com.tnt.homestays.fragment.FindFragment;
import com.tnt.homestays.fragment.HomeFragment;
import com.tnt.homestays.fragment.UserFragment;


public class MainActivity extends AppCompatActivity {

    //    private ActionBar toolbar;
    BottomNavigationView navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        toolbar = getSupportActionBar();
//        assert toolbar != null;
//        toolbar.setTitle(R.string.home);

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(new HomeFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.nav_home:
//                    toolbar.setTitle(R.string.home);
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_search:
//                    toolbar.setTitle(R.string.search);
                    fragment = new FindFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_favorite:
//                    toolbar.setTitle(R.string.favorite);
                    fragment = new FavoriteFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_user:
//                    toolbar.setTitle(R.string.user);
                    fragment = new UserFragment();
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }


}
