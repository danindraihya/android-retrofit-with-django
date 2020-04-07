package com.example.appmahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.appmahasiswa.Model.Mahasiswa;
import com.example.appmahasiswa.Retrofit.ApiClient;
import com.example.appmahasiswa.Retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    EditText editNama, editAlamat;
    Button btnUpdate, btnDelete;
    ApiInterface mApiInterface;
    Integer id;
    String nama, alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        editNama = (EditText) findViewById(R.id.editNama);
        editAlamat = (EditText) findViewById(R.id.editAlamat);
        btnUpdate = (Button) findViewById(R.id.Update);
        btnDelete = (Button) findViewById(R.id.Delete);

        Bundle bundle = getIntent().getExtras();
        id = Integer.parseInt(bundle.getString("id"));

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        getMahasiswa();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama = editNama.getText().toString();
                alamat = editAlamat.getText().toString();
                updateMahasiswa();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteMahasiswa();
            }
        });

    }

    private void getMahasiswa() {
        Call<Mahasiswa> mahasiswa = mApiInterface.getMahasiswa(id);
        mahasiswa.enqueue(new Callback<Mahasiswa>() {
            @Override
            public void onResponse(Call<Mahasiswa> call, Response<Mahasiswa> response) {

                Mahasiswa mahasiswa = response.body();

                editNama.setText(mahasiswa.getNama());
                editAlamat.setText(mahasiswa.getAlamat());
            }

            @Override
            public void onFailure(Call<Mahasiswa> call, Throwable t) {

            }
        });
    }

    private void updateMahasiswa() {
        Call<Mahasiswa> mahasiswa = mApiInterface.updateMahasiswa(id, nama, alamat);
        mahasiswa.enqueue(new Callback<Mahasiswa>() {
            @Override
            public void onResponse(Call<Mahasiswa> call, Response<Mahasiswa> response) {
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Mahasiswa> call, Throwable t) {

            }
        });
    }

    private void deleteMahasiswa() {
        Call<Void> mahasiswa = mApiInterface.deleteMahasiswa(id);
        mahasiswa.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
