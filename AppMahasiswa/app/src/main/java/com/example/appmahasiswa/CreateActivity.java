package com.example.appmahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appmahasiswa.Model.Mahasiswa;
import com.example.appmahasiswa.Retrofit.ApiClient;
import com.example.appmahasiswa.Retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateActivity extends AppCompatActivity {

    Button btnCreateMahasiswa;
    EditText dataNama, dataAlamat;
    ApiInterface mApiInterface;
    String nama, alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        dataNama = findViewById(R.id.dataNama);
        dataAlamat = findViewById(R.id.dataAlamat);

        btnCreateMahasiswa = findViewById(R.id.btnCreateMahasiswa);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btnCreateMahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama = dataNama.getText().toString();
                alamat = dataAlamat.getText().toString();
                createMahasiswa();
            }
        });


    }

    public void createMahasiswa(){
        Call<Mahasiswa> mahasiswa = mApiInterface.createMahasiswa(nama, alamat);
        mahasiswa.enqueue(new Callback<Mahasiswa>() {
            @Override
            public void onResponse(Call<Mahasiswa> call, Response<Mahasiswa> response) {
                Intent intent = new Intent(CreateActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Mahasiswa> call, Throwable t) {

            }
        });
    }
}
