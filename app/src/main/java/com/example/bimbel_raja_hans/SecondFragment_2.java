package com.example.bimbel_raja_hans;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondFragment_2 extends Fragment {
    EditText et_alas;
    EditText et_tinggi;
    TextView tv_hasil;
    Button btn_hitung;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et_alas = view.findViewById(R.id.alasSegitiga);
        et_tinggi = view.findViewById(R.id.tinggiSegitiga);
        tv_hasil = view.findViewById(R.id.hasilSegitiga);
        btn_hitung = view.findViewById(R.id.hitungSegitiga);

        btn_hitung.setOnClickListener(view1 -> {
            if (TextUtils.isEmpty(et_alas.getText().toString()) || TextUtils.isEmpty(et_tinggi.getText().toString())) {
                tv_hasil.setText("0");
            } else {
                double alas = parseDouble(et_alas.getText().toString());
                double tinggi = parseDouble(et_tinggi.getText().toString());
                double luas = alas * tinggi / 2;
                tv_hasil.setText(String.valueOf(luas));
            }
        });
    }
}