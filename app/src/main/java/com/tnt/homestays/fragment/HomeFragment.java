package com.tnt.homestays.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tnt.homestays.R;
import com.tnt.homestays.holder.HomestaysHolder;
import com.tnt.homestays.model.Homestays;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    List<Homestays> list;
    RecyclerView rcViewHome;

    //Firebase
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

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
        FirebaseRecyclerOptions<Homestays> options =
                new FirebaseRecyclerOptions.Builder<Homestays>()
                        .setQuery(databaseReference, Homestays.class)
                        .build();

        FirebaseRecyclerAdapter<Homestays, HomestaysHolder> adapter
                = new FirebaseRecyclerAdapter<Homestays, HomestaysHolder>
                (options) {
            @Override
            protected void onBindViewHolder(@NonNull HomestaysHolder holder, int position, @NonNull Homestays model) {
                holder.tvTitle.setText(model.getTitle());
                holder.tvAddress.setText(model.getAddress());
                holder.tvArea.setText(model.getArearoom());
                holder.tvPrice.setText(model.getPrice());
                Glide.with(getContext()).load(model.getImages()).into(holder.imgAvatar);
            }

            @NonNull
            @Override
            public HomestaysHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_home, parent, false);

                return new HomestaysHolder(view);
            }
        };
        rcViewHome.setAdapter(adapter);
        adapter.startListening();
    }
}
