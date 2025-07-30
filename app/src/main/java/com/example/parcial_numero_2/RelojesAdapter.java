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

public class RelojesAdapter extends RecyclerView.Adapter<RelojesAdapter.VH> {

    List<ClaseReloj> list;

    public RelojesAdapter(List<ClaseReloj> list) {
        this.list = list;
    }

    public static class VH extends RecyclerView.ViewHolder {
        TextView modelo, marca, descripcion, precio;

        public VH(View v) {
            super(v);
            modelo      = v.findViewById(R.id.wt_modelo);
            marca       = v.findViewById(R.id.wt_marca);
            descripcion = v.findViewById(R.id.wt_descripcion);
            precio      = v.findViewById(R.id.wt_precio);
        }
    }

    @Override
    public VH onCreateViewHolder(ViewGroup p, int viewType) {
        View v = LayoutInflater.from(p.getContext())
                .inflate(R.layout.item_reloj, p, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(VH h, int p) {
        ClaseReloj w = list.get(p);
        h.modelo.setText(w.getModelo());
        h.marca.setText(w.getMarca());
        h.descripcion.setText(w.getDescripcion());
        h.precio.setText(w.getPrecio());

//        h.btnAdd.setOnClickListener(v -> {
//            Data.addToCart(w);
//            Toast.makeText(v.getContext(),
//                    w.name + " agregado", Toast.LENGTH_SHORT).show();
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
