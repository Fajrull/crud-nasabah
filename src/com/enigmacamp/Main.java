package com.enigmacamp;

public class Main {
    public static void main(String[] args) {
        NasabahService nasabah = new NasabahService();

        System.out.println("=".repeat(30));
        System.out.println("Create Data Nasabah");
        nasabah.create(1,"fajrul","123","1233","23-32-33");
        nasabah.create(1,"khaq","1253","1234","23-32-33");

        System.out.println("=".repeat(30));
        System.out.println("Read All Data Nasabah");
        System.out.println(nasabah.dataNasabah());
        System.out.println("=".repeat(30));

        System.out.println("Read Data By ID");
        System.out.println(nasabah.dataById(5));
        System.out.println("=".repeat(30));

        System.out.println("Update Data Nasabah");
        nasabah.updateData(1,"sc","123","1293","20-20-22");
        System.out.println(nasabah.dataById(1));


        System.out.println("=".repeat(30));
        System.out.println("Delete Data Nasabah");
        nasabah.deleteNasabah(9);
        System.out.println(nasabah.dataNasabah());
        }
    }



// Lanjutkanlah hands on dengan ketentuan berikut:
// 1. Lengkapi service CRUD (create, read(all & id), update, delete)
// 2. Implementasikan sebuah exception untuk validasi berikut
//      a. validasi jika data sudah penuh
//      b. validasi jika data tidak ada ketika melakukan update, delete dan get by id
//      c. validasi jika id, nik dan phone number sudah ada (harus unique)
// 3. Buatlah branch baru dengan nama 02-use-interface dan gunakanlah interface/contract untuk CRUD service
// 4. Buatlah commit per feature.
// contoh :
// - feat : create nasabah
// - feat : update nasabah
// - fix : unique attribute validation when create data