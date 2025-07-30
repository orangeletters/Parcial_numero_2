/* package com.example.parcial_numero_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ShopcartFragment extends Fragment {
    RecyclerView rv;
    TextView tvEmpty;

    @Override
    public View onCreateView(LayoutInflater i, ViewGroup c, Bundle b) {
        View v = i.inflate(R.layout.fragment_shopcart, c, false);
        rv = v.findViewById(R.id.rv_cart);
        tvEmpty = v.findViewById(R.id.tv_empty);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        loadData();
        return v;
    }

    private void loadData() {
        if (Data.cart.isEmpty()) {
            tvEmpty.setVisibility(View.VISIBLE);
            rv.setVisibility(View.GONE);
        } else {
            tvEmpty.setVisibility(View.GONE);
            rv.setVisibility(View.VISIBLE);
            rv.setAdapter(new CartAdapter(Data.cart));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }
}
*/