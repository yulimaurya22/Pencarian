package com.virnanda.candiindonesia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewCandiAdapter extends RecyclerView.Adapter<CardViewCandiAdapter.CardViewHolder> {


    private ArrayList<Candi> listCandi;
    private OnItemClickCallback onItemClickCallback;

    public CardViewCandiAdapter(ArrayList<Candi> list){
        this.listCandi = list;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    //menghubungkan mainactivity dengan cardview
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_candi, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    //menghubungkan id ke data
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Candi candi = listCandi.get(position);
        Glide.with(holder.itemView.getContext())
                .load(candi.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.tvNama.setText(candi.getNama());
        holder.tvDetail.setText(candi.getDetail());
        holder.btnBaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listCandi.get(holder.getAdapterPosition()));
                Toast.makeText(holder.itemView.getContext(), listCandi.get(holder.getAdapterPosition()).getNama(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listCandi.get(holder.getAdapterPosition()));
                Toast.makeText(holder.itemView.getContext(), listCandi.get(holder.getAdapterPosition()).getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // mengembalikan jumlah item data yang tersedia untuk ditampilkan
    @Override
    public int getItemCount() {
        return listCandi.size();
    }

    //membuat variabel di viewholder
    public class CardViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPhoto;
        TextView tvNama, tvDetail;
        Button btnBaca;

        //menghubungkan id di layout ke viewholder
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.iv_item_photo);
            tvNama = itemView.findViewById(R.id.tvTitle);
            tvDetail = itemView.findViewById(R.id.tvDesc);
            btnBaca = itemView.findViewById(R.id.btnBaca);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Candi candi);

    }
}
