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

public class ThirdFragment_1 extends Fragment {
    EditText et_panjang;
    EditText et_lebar;
    EditText et_tinggi;
    TextView tv_hasil;
    Button btn_hitung;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et_panjang = view.findViewById(R.id.panjangBalok);
        et_lebar = view.findViewById(R.id.lebarBalok);
        et_tinggi = view.findViewById(R.id.tinggiBalok);
        tv_hasil = view.findViewById(R.id.hasilBalok);
        btn_hitung = view.findViewById(R.id.hitungBalok);
        btn_hitung.setOnClickListener(view1 -> {
            if (TextUtils.isEmpty(et_panjang.getText().toString()) || TextUtils.isEmpty(et_lebar.getText().toString()) ||
                    TextUtils.isEmpty(et_tinggi.getText().toString())) {
                tv_hasil.setText("0");
            } else {
                double panjang = parseDouble(et_panjang.getText().toString());
                double lebar = parseDouble(et_lebar.getText().toString());
                double tinggi = parseDouble(et_tinggi.getText().toString());
                double luas = panjang * lebar * tinggi;
                tv_hasil.setText(String.valueOf(luas));
            }
        });
    }
}