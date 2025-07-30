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

    DatabaseHelper myDB;

    public RelojesAdapter(List<ClaseReloj> list, DatabaseHelper myDB) {
        this.list = list;
        this.myDB = myDB;
    }

    public static class VH extends RecyclerView.ViewHolder {
        TextView modelo, marca, descripcion, precio;
        Button btnBorrar;

        public VH(View v) {
            super(v);
            modelo      = v.findViewById(R.id.wt_modelo);
            marca       = v.findViewById(R.id.wt_marca);
            descripcion = v.findViewById(R.id.wt_descripcion);
            precio      = v.findViewById(R.id.wt_precio);
            btnBorrar = v.findViewById(R.id.wt_btnBorrar);
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

        // -----INVESTIGAR POR QUE BORRA ERRONEAMENTE EL BTNBORRAR-----

        h.btnBorrar.setOnClickListener(v -> {
            if (myDB.deleteById(w.getId())) {
                list.remove(p);
                notifyItemRemoved(p);
            } else {
                Toast.makeText(v.getContext(), "Error borrando", Toast.LENGTH_SHORT).show();
            }
        });


//        h.btnAdd.setOnClickListener(v -> {
//            Data.addToCart(w);
//            Toast.makeText(v.getContext(),
//                    w.name + " agregado", Toast.LENGTH_SHORT).show();
//        });
    }

    /**
     * Reemplaza la lista interna y notifica al RecyclerView.
     */
    public void updateData(List<ClaseReloj> nuevos) {
        this.list = nuevos;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
