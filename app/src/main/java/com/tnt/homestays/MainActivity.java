package com.tnt.homestays;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;
import com.tnt.homestays.fragment.FavoriteFragment;
import com.tnt.homestays.fragment.FindFragment;
import com.tnt.homestays.fragment.HomeFragment;
import com.tnt.homestays.fragment.UserFragment;


public class MainActivity extends AppCompatActivity {


    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home) {
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                }else if (tabId == R.id.tab_find){
                    fragment = new FindFragment();
                    loadFragment(fragment);
                }else if (tabId == R.id.tab_favorites){
                    fragment = new FavoriteFragment();
                    loadFragment(fragment);
                }else if (tabId == R.id.tab_user){
                    fragment = new UserFragment();
                    loadFragment(fragment);
                }
            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
            }
        });

    }



    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }


}
