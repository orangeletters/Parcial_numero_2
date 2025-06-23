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

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.VH> {
    List<Watch> list;

    public CartAdapter(List<Watch> list) {
        this.list = list;
    }

    public static class VH extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name, price;
        Button btnRemove;

        public VH(View v) {
            super(v);
            img = v.findViewById(R.id.cart_img);
            name = v.findViewById(R.id.cart_name);
            price = v.findViewById(R.id.cart_price);
            btnRemove = v.findViewById(R.id.cart_btnRemove);
        }
    }

    @Override
    public VH onCreateViewHolder(ViewGroup p, int viewType) {
        View v = LayoutInflater.from(p.getContext())
                .inflate(R.layout.item_cart, p, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(VH h, int p) {
        Watch w = list.get(p);
        h.img.setImageResource(w.imageResId);
        h.name.setText(w.name);
        h.price.setText(String.format("$%.2f", w.price));
        h.btnRemove.setOnClickListener(v -> {
            Data.removeFromCart(w);
            notifyDataSetChanged();
            Toast.makeText(v.getContext(),
                    w.name + " quitado", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

