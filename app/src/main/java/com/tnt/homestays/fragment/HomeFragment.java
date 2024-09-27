package com.tnt.homestays.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tnt.homestays.R;
import com.tnt.homestays.activities.DetailHomeActivity;
import com.tnt.homestays.adapter.HomestaysAdapter;
import com.tnt.homestays.model.Homestays;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements HomestaysAdapter.OnItemClickListener{
    RecyclerView rcViewHome;

    //Firebase
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<Homestays> homestaysArrayList;
    HomestaysAdapter homestaysAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //init Firebase
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Homestays");

        //Show list homestays
        rcViewHome = view.findViewById(R.id.rcViewHome);
        rcViewHome.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (databaseReference != null){
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    homestaysArrayList = new ArrayList<Homestays>();
                    for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                        Homestays homestays = dataSnapshot1.getValue(Homestays.class);
                        homestaysArrayList.add(homestays);
                    }
                    homestaysAdapter = new HomestaysAdapter(getContext(),homestaysArrayList);
                    rcViewHome.setAdapter(homestaysAdapter);
                    homestaysAdapter.setOnItemClickListener(HomeFragment.this);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(getActivity(), "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public void onItemClick(int position) {
        Homestays homestays = homestaysArrayList.get(position);
        Intent intent = new Intent(getContext(), DetailHomeActivity.class);
        intent.putExtra("img", homestays.getImages());
        intent.putExtra("title", homestays.getTitle());
        intent.putExtra("address", homestays.getAddress());
        intent.putExtra("area", homestays.getArearoom());
        intent.putExtra("phone", homestays.getPhone());
        intent.putExtra("des", homestays.getDescription());
        intent.putExtra("price", homestays.getPrice());
        startActivity(intent);
        Toast.makeText(getActivity(), "Normal click at position: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onWhatEverClick(int position) {
        Toast.makeText(getActivity(), "Whatever click at position: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDeleteClick(int position) {

    }
}
