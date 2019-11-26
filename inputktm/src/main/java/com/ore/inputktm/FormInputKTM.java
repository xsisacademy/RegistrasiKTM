package com.ore.inputktm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ore.inputktm.utils.FormInput;
import com.ore.inputktm.utils.KTMModel;

public class FormInputKTM extends AppCompatActivity {
    private Context context = this;

    private EditText inputNamaMahasiswa, inputAlamatMahasiswa, inputUsiaMahasiswa;
    private Button buttonDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_input_ktm);

        //init
        inputNamaMahasiswa = findViewById(R.id.inputNamaMahasiswa);
        inputAlamatMahasiswa = findViewById(R.id.inputAlamatMahasiswa);
        inputUsiaMahasiswa = findViewById(R.id.inputUsiaMahasiswa);

        buttonDaftar = findViewById(R.id.buttonDaftar);
        buttonDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validasiInput();
            }
        });

        emptyData();
    }

    void validasiInput(){
        String nama = inputNamaMahasiswa.getText().toString().trim();
        String alamat = inputAlamatMahasiswa.getText().toString().trim();
        String usia = inputUsiaMahasiswa.getText().toString().trim();

        if(nama.isEmpty() || alamat.isEmpty() || usia.isEmpty()){
            Toast.makeText(context, "Nama, Alamat, Usia harus diisi!", Toast.LENGTH_SHORT).show();
        }
        else{
            KTMModel model = new KTMModel();
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setUsia(Integer.parseInt(usia));

            FormInput.setDataModel(model);

            //kembalikan result
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);

            //tutup activity
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        emptyData();
    }

    void emptyData(){
        KTMModel model = new KTMModel();
        FormInput.setDataModel(model);
    }
}
