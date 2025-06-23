package com.example.parcial_numero_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WatchesAdapter extends RecyclerView.Adapter<WatchesAdapter.VH> {

    List<Watch> list;

    public WatchesAdapter(List<Watch> list) {
        this.list = list;
    }

    public static class VH extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name, price;
        Button btnAdd;

        public VH(View v) {
            super(v);
            img = v.findViewById(R.id.wt_img);
            name = v.findViewById(R.id.wt_name);
            price = v.findViewById(R.id.wt_price);
            btnAdd = v.findViewById(R.id.wt_btnAdd);
        }
    }

    @Override
    public VH onCreateViewHolder(ViewGroup p, int viewType) {
        View v = LayoutInflater.from(p.getContext())
                .inflate(R.layout.item_watch, p, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(VH h, int p) {
        Watch w = list.get(p);
        h.img.setImageResource(w.imageResId);
        h.name.setText(w.name);
        h.price.setText(String.format("$%.2f", w.price));
        h.btnAdd.setOnClickListener(v -> {
            Data.addToCart(w);
            Toast.makeText(v.getContext(),
                    w.name + " agregado", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
