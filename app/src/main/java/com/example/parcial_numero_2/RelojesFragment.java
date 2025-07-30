package com.example.parcial_numero_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RelojesFragment extends Fragment {

    EditText modeloEdit, marcaEdit, descrEdit, precioEdit;
    Button añadirButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        DatabaseHelper myDB = new DatabaseHelper(requireContext());

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_relojes, container, false);

        modeloEdit = v.findViewById(R.id.modeloEdit);
        marcaEdit = v.findViewById(R.id.marcaEdit);
        descrEdit = v.findViewById(R.id.descrEdit);
        precioEdit = v.findViewById(R.id.precioEdit);

        añadirButton = v.findViewById(R.id.button);


            añadirButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = myDB.insertValues(modeloEdit.getText().toString(), marcaEdit.getText().toString());

                    if (isInserted) {
                        Toast.makeText(getActivity(), "Data is inserted", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getActivity(), "Smth went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        return v;
    }


}