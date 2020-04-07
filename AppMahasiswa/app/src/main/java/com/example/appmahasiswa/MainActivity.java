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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnDetail, btnCreate, btnUpdate, btnDelete;
    private TextView tvResponse;
    EditText idMahasiswaDetail, idMahasiswaUpdate, idMahasiswaDelete;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDetail = findViewById(R.id.btnDetail);
        btnCreate = findViewById(R.id.btnCreate);
        tvResponse = findViewById(R.id.tvIndexResponse);
        idMahasiswaDetail = findViewById(R.id.idMahasiswaDetail);

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idMahasiswaDetail.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);

//                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//                intent.putExtra("id", id);
//                startActivity(intent);
            }
        });

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                startActivity(intent);
            }
        });

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        getMahasiswas();
    }

    public void getMahasiswas() {
       Call<List<Mahasiswa>> getMahaiswa = mApiInterface.getMahasiswas();
       getMahaiswa.enqueue(new Callback<List<Mahasiswa>>() {
           @Override
           public void onResponse(Call<List<Mahasiswa>> call, Response<List<Mahasiswa>> response) {

               List<Mahasiswa> mahasiswas = response.body();

               for (Mahasiswa mahasiswa : mahasiswas) {
                   String content = "";
                   content += "ID: " + mahasiswa.getPk() + "\n";
                   content += "Nama: " + mahasiswa.getNama() + "\n";
                   content += "Alamat: " + mahasiswa.getAlamat() + "\n\n";

                   tvResponse.append(content);
               }
           }

           @Override
           public void onFailure(Call<List<Mahasiswa>> call, Throwable t) {

           }
       });
    }

}
