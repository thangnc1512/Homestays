package com.tnt.homestays.fragment;

import android.content.Context;
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
import com.tnt.homestays.adapter.HomestaysAdapter;
import com.tnt.homestays.model.Homestays;

import java.util.ArrayList;

public class FindFragment extends Fragment {
    RecyclerView rcViewHome;

    //Firebase
//    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<Homestays> homestaysArrayList;
    HomestaysAdapter homestaysAdapter;
    SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        //init Firebase
//        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Homestays");

        searchView = view.findViewById(R.id.searchView);

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
//                    rcViewHome.setAdapter(homestaysAdapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(getContext(), "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
                }
            });
        }if (searchView != null){
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    search(newText);
                    return false;
                }
            });
        }
    }

    private void search(String newText) {
        ArrayList<Homestays> homestays = new ArrayList<>();
        for(Homestays object : homestaysArrayList){
            if (object.getAddress().toLowerCase().contains(newText.toLowerCase())){
                homestays.add(object);
            }
        }
        HomestaysAdapter homestaysAdapter = new HomestaysAdapter(getContext(),homestays);
        rcViewHome.setAdapter(homestaysAdapter);

    }

}
