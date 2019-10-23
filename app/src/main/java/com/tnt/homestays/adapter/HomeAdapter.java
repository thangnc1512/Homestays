//package com.tnt.homestays.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.tnt.homestays.R;
//import com.tnt.homestays.model.Homestays;
//
//import java.util.List;
//
//public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
//
//    private Context context;
//    private List<Homestays> list;
//
//    public HomeAdapter(Context context, List<Homestays> list) {
//        this.context = context;
//        this.list = list;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home,parent,false);
//        return new ViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Glide.with(context).load(list.get(position).getUrl()).into(holder.img);
//        holder.tvName.setText(list.get(position).getName());
//        holder.tvAddress.setText(list.get(position).getAddress());
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        private ImageView imgAvatar;
//        private TextView tvPrice;
//        private TextView tvAddress;
//        private TextView tvArea;
//        private TextView tvTitle;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            imgAvatar = (ImageView) itemView.findViewById(R.id.imgAvatar);
//            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
//            tvAddress = (TextView) itemView.findViewById(R.id.tvAddress);
//            tvArea = (TextView) itemView.findViewById(R.id.tvArea);
//            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
//        }
//    }
//}
