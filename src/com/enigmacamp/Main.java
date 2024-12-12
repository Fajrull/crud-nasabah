package com.enigmacamp;

public class Main {
    public static void main(String[] args) {
        Nasabah nasabah1 = new Nasabah(1, "Nasabah 1", "123", "123", "123");
        Nasabah nasabah2 = new Nasabah(2, "Nasabah 2", "123", "123", "123");
        Nasabah nasabah3 = new Nasabah(3, "Nasabah 3", "123", "123", "123");
        Nasabah nasabah4 = new Nasabah(4, "Nasabah 4", "123", "123", "123");
        Nasabah nasabah5 = new Nasabah(5, "Nasabah 5", "123", "123", "123");
        Nasabah nasabah6 = new Nasabah(6, "Nasabah 6", "123", "123", "123");
        Nasabah nasabah7 = new Nasabah(7, "Nasabah 7", "123", "123", "123");
        Nasabah nasabah8 = new Nasabah(8, "Nasabah 8", "123", "123", "123");
        Nasabah nasabah9 = new Nasabah(9, "Nasabah 9", "123", "123", "123");
        Nasabah nasabah10 = new Nasabah(10, "Nasabah 10", "123", "123", "123");
        Nasabah nasabah11 = new Nasabah(11, "Nasabah 11", "123", "123", "123");
        Nasabah nasabah12 = new Nasabah(12, "Nasabah 12", "123", "123", "123");
        Nasabah nasabah13 = new Nasabah(13, "Nasabah 13", "123", "123", "123");
        Nasabah nasabah14 = new Nasabah(14, "Nasabah 14", "123", "123", "123");
        Nasabah nasabah15 = new Nasabah(15, "Nasabah 15", "123", "123", "123");
        Nasabah nasabah16 = new Nasabah(16, "Nasabah 16", "123", "123", "123");


        NasabahService nasabahService = new NasabahService();

        nasabahService.create(nasabah1);
        nasabahService.create(nasabah2);
        nasabahService.create(nasabah3);
        nasabahService.create(nasabah4);
        nasabahService.create(nasabah5);
        nasabahService.create(nasabah6);
        nasabahService.create(nasabah7);
        nasabahService.create(nasabah8);
        nasabahService.create(nasabah9);
        nasabahService.create(nasabah10);
        nasabahService.create(nasabah11);
        nasabahService.create(nasabah12);
        nasabahService.create(nasabah13);
        nasabahService.create(nasabah14);
        nasabahService.create(nasabah15);
        nasabahService.create(nasabah16);

//        System.out.println("===================");
//        System.out.println("Read all nasabah");
        // read all nasabah
        Nasabah[] nasabahArr = nasabahService.getAllItems();
        System.out.println();
//        for (Nasabah nasabah : nasabahArr) {
//           if (nasabah != null) {
//               System.out.println(nasabah);
//           }
//        }

        System.out.println();
        System.out.println("===================");
        System.out.println("Read by id");

       //  read by id
        Nasabah nasabahById = nasabahService.readById(1);
        System.out.println(nasabahById);

        System.out.println();
        System.out.println("===================");
        System.out.println("Update Nasabah");


        // update nasabah
        nasabahService.update(1, "Fajrul", "3402948474", "089516173839", "2020-01-01");
        Nasabah nasabahById2 = nasabahService.readById(1);
        System.out.println(nasabahById2);

        System.out.println();
        System.out.println("===================");
        System.out.println("Delete Nasabah");

        // delete nasabah
        nasabahService.delete(5);
        for (Nasabah nasabah : nasabahArr) {
            if (nasabah != null) {
                System.out.println(nasabah);
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