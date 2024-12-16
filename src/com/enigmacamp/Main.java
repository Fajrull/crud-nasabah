package com.enigmacamp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NasabahService nasabah = new NasabahService();

//        System.out.println("=".repeat(30));
//        System.out.println("Create Data Nasabah");
        nasabah.create(1,"fajrul","3402","0882","23-32-33");
        nasabah.create(2,"luluk","3405","0881","23-32-33");
//
//        System.out.println("=".repeat(30));
//        System.out.println("Read All Data Nasabah");
//        System.out.println(nasabah.dataNasabah());
//        System.out.println("=".repeat(30));
//
//        System.out.println("Read Data By ID");
//        System.out.println(nasabah.dataById(5));
//        System.out.println("=".repeat(30));
//
//        System.out.println("Update Data Nasabah");
//        nasabah.updateData(1,"sc","123","1293","20-20-22");
//        System.out.println(nasabah.dataById(1));
//
//
//        System.out.println("=".repeat(30));
//        System.out.println("Delete Data Nasabah");
//        nasabah.deleteNasabah(9);
//        System.out.println(nasabah.dataNasabah());

        // memanggil Scanner dari file inputHandler
        InputHandler input = new InputHandler();
        input.inputHandler(new Scanner(System.in));
        while (true) {
            System.out.println("=".repeat(30));
            System.out.println("1. Create Data Nasabah");
            System.out.println("2. Read All Data Nasabah");
            System.out.println("3. Read Data By ID");
            System.out.println("4. Update Data Nasabah");
            System.out.println("5. Delete Data Nasabah");
            System.out.println("6. Exit");
            System.out.println("=".repeat(30));
            System.out.print("Pilih Menu : ");
            int menu = input.GetInt("");
            switch (menu) {
                case 1:
                    System.out.println("=".repeat(30));
                    System.out.println("Create Data Nasabah");
                    System.out.println("=".repeat(30));
                    System.out.print("ID : ");
                    int id = input.GetInt("");
                    System.out.print("Full Name : ");
                    String fullName = input.getString("");
                    System.out.print("NIK : ");
                    String nik = input.getString("");
                    System.out.print("Phone Number : ");
                    String phoneNumber = input.getString("");
                    System.out.print("Birth Date : ");
                    String birthDate = input.getString("");
                    nasabah.create(id, fullName, nik, phoneNumber, birthDate);
                    break;
                case 2:
                    System.out.println("=".repeat(30));
                    System.out.println("Read All Data Nasabah");
                    System.out.println(nasabah.dataNasabah());
                    System.out.println("=".repeat(30));
                    break;
                case 3:
                    System.out.println("=".repeat(30));
                    System.out.println("Read Data By ID");
                    System.out.println("=".repeat(30));
                    System.out.print("Masukkan ID : ");
                    id = input.GetInt("");
                    System.out.println(nasabah.dataById(id));
                    System.out.println("=".repeat(30));
                    break;
                case 4:
                    System.out.println("=".repeat(30));
                    System.out.println("Update Data Nasabah");
                    System.out.println("=".repeat(30));
                    System.out.print("ID : ");
                    id = input.GetInt("");
                    System.out.print("Full Name : ");
                    fullName = input.getString("");
                    System.out.print("NIK : ");
                    nik = input.getString("");
                    System.out.print("Phone Number : ");
                    phoneNumber = input.getString("");
                    System.out.print("Birth Date : ");
                    birthDate = input.getString("");
                    nasabah.updateData(id, fullName, nik, phoneNumber, birthDate);
                    break;
                case 5:
                    System.out.println("=".repeat(30));
                    System.out.println("Delete Data Nasabah");
                    System.out.println("=".repeat(30));
                    System.out.print("ID : ");
                    id = input.GetInt("");
                    nasabah.deleteNasabah(id);
                    System.out.println(nasabah.dataNasabah());
                    break;
                case 6:
                    System.out.println("=".repeat(30));
                    System.out.println("Exit");
                    System.out.println("=".repeat(30));
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan Tidak ada");
            }
        }
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

//Lanjutkan studi kasus CRUD Nasabah
// 1. Refactor code agar menggunakan Collection ArrayList untuk CRUDnya
// 2. Buatkanlah Bash Console untuk proses management CRUD datanya
// 3. Buat branch baru :
//    03-with-arraylist (Branch untuk penerapan collection)
//    04-bash-console (Branch untuk penerapan input console user)