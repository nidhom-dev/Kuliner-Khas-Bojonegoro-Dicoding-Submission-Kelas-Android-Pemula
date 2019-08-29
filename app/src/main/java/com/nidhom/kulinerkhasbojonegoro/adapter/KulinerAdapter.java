package com.nidhom.kulinerkhasbojonegoro.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.nidhom.kulinerkhasbojonegoro.DetailActivity;
import com.nidhom.kulinerkhasbojonegoro.R;
import com.nidhom.kulinerkhasbojonegoro.model.Kuliner;

import java.util.ArrayList;

public class KulinerAdapter extends RecyclerView.Adapter<KulinerAdapter.ListViewHolder> {
    private ArrayList<Kuliner> listKuliner;
    private OnItemClickCallback onItemClickCallback;

    public KulinerAdapter (ArrayList<Kuliner> list) {
        this.listKuliner = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_kuliner,viewGroup , false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, final int position) {
        Kuliner kuliner = listKuliner.get(position);

        Glide.with(holder.itemView.getContext())
                .load(kuliner.getFoto())
                .apply(new RequestOptions().override(70,70))
                .into(holder.imgKuliner);

        holder.namaKuliner.setText(kuliner.getNama());
        holder.asalKuliner.setText(kuliner.getAsal());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listKuliner.get(holder.getAdapterPosition()));
                Intent intent = new Intent(v.getContext() , DetailActivity.class);
                intent.putExtra("Nama" , listKuliner.get(position).getNama());
                intent.putExtra("Asal" , listKuliner.get(position).getAsal());
                intent.putExtra("Foto" , listKuliner.get(position).getFoto());
                v.getContext().startActivity(intent);


            }
        });

    }


    @Override
    public int getItemCount() {
        return listKuliner.size();
    }



    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgKuliner ;
        TextView namaKuliner , asalKuliner;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgKuliner = itemView.findViewById(R.id.imgKuliner);
            namaKuliner = itemView.findViewById(R.id.namaKuliner);
            asalKuliner = itemView.findViewById(R.id.asalKuliner);
        }
    }
    public  interface OnItemClickCallback {
        void onItemClicked (Kuliner data);
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

}
