package com.example.appmahasiswa.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mahasiswa {

   @SerializedName("pk")
   Integer pk;

   @SerializedName("nama")
   String nama;

   @SerializedName("alamat")
   String alamat;

    public Mahasiswa(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    public Integer getPk() {
        return pk;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }
}
