package com.tnt.homestays.adapter;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tnt.homestays.R;
import com.tnt.homestays.model.Homestays;

import java.util.ArrayList;

public class HomestaysAdapter extends RecyclerView.Adapter<HomestaysAdapter.HomestaysHolder> {
    Context context;
    ArrayList<Homestays> homestaysArrayList;
    private OnItemClickListener mListener;

    public HomestaysAdapter(Context context, ArrayList<Homestays> homestaysArrayList) {
        this.context = context;
        this.homestaysArrayList = homestaysArrayList;
    }


    @NonNull
    @Override
    public HomestaysHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false);
        return new HomestaysHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomestaysHolder holder, int position) {
        Homestays homestays = homestaysArrayList.get(position);
        holder.tvTitle.setText(homestays.getTitle());
        holder.tvAddress.setText(homestays.getAddress());
        holder.tvArea.setText(homestays.getArearoom());
        holder.tvPrice.setText(homestays.getPrice());
        Glide.with(context).load(homestays.getImages()).into(holder.imgAvatar);
    }

    @Override
    public int getItemCount() {
        return homestaysArrayList.size();
    }

    public class HomestaysHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener{
        public ImageView imgAvatar;
        public TextView tvPrice;
        public TextView tvAddress;
        public TextView tvArea;
        public TextView tvTitle;

        public HomestaysHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = (ImageView) itemView.findViewById(R.id.imgAvatar);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
            tvAddress = (TextView) itemView.findViewById(R.id.tvAddress);
            tvArea = (TextView) itemView.findViewById(R.id.tvArea);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);

            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {

                    switch (menuItem.getItemId()) {
                        case 1:
                            mListener.onWhatEverClick(position);
                            return true;
                        case 2:
                            mListener.onDeleteClick(position);
                            return true;
                    }
                }
            }
            return false;
        }


        @Override
        public void onClick(View view) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(position);
                }
            }
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.setHeaderTitle("Select Action");
            MenuItem doWhatever = contextMenu.add(Menu.NONE, 1, 1, "Do whatever");
            MenuItem delete = contextMenu.add(Menu.NONE, 2, 2, "Delete");

            doWhatever.setOnMenuItemClickListener(this);
            delete.setOnMenuItemClickListener(this);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onWhatEverClick(int position);

        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
}
