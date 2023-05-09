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

public class SecondFragment_1 extends Fragment {
    EditText et_sisi;
    TextView tv_hasil;
    Button btn_hitung;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et_sisi = view.findViewById(R.id.sisiPersegi);
        tv_hasil = view.findViewById(R.id.hasilPersegi);
        btn_hitung = view.findViewById(R.id.hitungPersegi);
        btn_hitung.setOnClickListener(view1 -> {
            if (TextUtils.isEmpty(et_sisi.getText().toString())) {
                tv_hasil.setText("0");
            } else {
                double sisi = parseDouble(et_sisi.getText().toString());
                double luas = sisi * sisi;
                tv_hasil.setText(String.valueOf(luas));
            }
        });
    }
}