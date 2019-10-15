package com.tnt.homestays.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tnt.homestays.R;
import com.tnt.homestays.adapter.HomeAdapter;
import com.tnt.homestays.model.Homestays;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    List<Homestays> list;
    HomeAdapter adapter;
    RecyclerView rcViewHome;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        list = new ArrayList<>();
        rcViewHome = view.findViewById(R.id.rcViewHome);
        adapter = new HomeAdapter(getContext(),list);
        for(int i=0;i<=50;i++){
            list.add(new Homestays("https://akm-img-a-in.tosshub.com/indiatoday/images/story/201506/storyimage_647_062215030547.jpg","Homestays "+i,"Việt Nam  "));
        }
        rcViewHome.setLayoutManager(new LinearLayoutManager(getContext()));
        rcViewHome.setAdapter(adapter);
        return view;
    }
}
