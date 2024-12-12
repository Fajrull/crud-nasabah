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

    // Read by id
    public Nasabah readById(int id) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId() == id) {
                return items[i];
            }
        }
        return null;
    }

    // Update nasabah by id , name, nik, phone number, birthdate
    public void update(int id, String fullName, String nik, String phoneNumber, String birthDate) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId() == id) {
                items[i].setFullName(fullName);
                items[i].setNik(nik);
                items[i].setPhoneNumber(phoneNumber);
                items[i].setBirthDate(birthDate);
                System.out.println("Nasabah berhasil diupdate");
                return;
            }
        }
        System.out.println("Nasabah tidak ditemukan");
    }
}