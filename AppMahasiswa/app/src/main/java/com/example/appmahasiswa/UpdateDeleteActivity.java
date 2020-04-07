package com.example.appmahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.appmahasiswa.Retrofit.ApiInterface;

public class UpdateDeleteActivity extends AppCompatActivity {
    EditText editNama, editAlamat;
    Button btnUpdate, btnDelete;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        editNama = (EditText) findViewById(R.id.editNama);
        editAlamat = (EditText) findViewById(R.id.editAlamat);


    }
}
