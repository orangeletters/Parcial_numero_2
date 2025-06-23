package com.example.parcial_numero_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WatchesFragment extends Fragment {
    RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater i, ViewGroup c,
                             Bundle b) {
        // Inflate the layout for this fragment
        View v = i.inflate(R.layout.fragment_watches, c, false);
        rv = v.findViewById(R.id.rv_watches);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new WatchesAdapter(Data.watches));
        return v;
    }
}