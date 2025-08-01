package com.example.parcial_numero_2;

/*
Aquí se muestra la lista con todos los relojes :P
 */

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class TodosLosRelojesFragment extends Fragment {
    RecyclerView rv;
    RelojesAdapter adapter;
    DatabaseHelper myDB;

    @Override
    public View onCreateView(LayoutInflater i, ViewGroup c,
                             Bundle b) {
        View v = i.inflate(R.layout.fragment_watches, c, false);

        rv = v.findViewById(R.id.rv_watches);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        // -----INVESTIGAR POR QUE BORRA ERRONEAMENTE EL BTNBORRAR-----
        // AHORA sí rellenas el campo:
        myDB = new DatabaseHelper(requireContext());
        List<ClaseReloj> items = myDB.getAll();
        adapter = new RelojesAdapter(items, myDB);
        rv.setAdapter(adapter);

        return v;
    }
    // -----INVESTIGAR POR QUE BORRA ERRONEAMENTE EL BTNBORRAR-----
    @Override
    public void onResume() {
        super.onResume(); //Borrar comentarios
        // myDB ya está inicializado
        List<ClaseReloj> nuevos = myDB.getAll();
        adapter.updateData(nuevos);          // o adapter.list = nuevos
        adapter.notifyDataSetChanged();
    }

}