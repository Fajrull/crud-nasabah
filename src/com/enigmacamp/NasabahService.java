package com.enigmacamp;

// Kelas untuk memanipulasi data nasabah seperti (create, read, update, delete)
public class NasabahService {
    private Nasabah[] items = new Nasabah[15];
    private int nasabahCount = 0;


    public NasabahService(){}

    //    Registrasi Nasabah
    public void create(Nasabah nasabah){
        items[nasabahCount++] = nasabah;
        System.out.println("Nasabah berhasil ditambahkan");
    }

    // Read all nasabah
    public Nasabah[] getAllItems(){
        return items;
    }

}