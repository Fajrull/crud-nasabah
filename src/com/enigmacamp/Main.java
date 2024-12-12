package com.enigmacamp;

public class Main {
    public static void main(String[] args) {
        Nasabah nasabah1 = new Nasabah(1, "Nasabah 1", "123", "123", "123");
        Nasabah nasabah2 = new Nasabah(2, "Nasabah 2", "1234", "12343", "14323");
        Nasabah nasabah3 = new Nasabah(3, "Nasabah 3", "123", "1213", "1223");


        NasabahService nasabahService = new NasabahService();

        nasabahService.create(nasabah1);
        nasabahService.create(nasabah2);
        nasabahService.create(nasabah3);


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
        nasabahService.update(1, "", "", "", "2020-01-01");
        Nasabah nasabahById2 = nasabahService.readById(1);
        System.out.println(nasabahById2);

        System.out.println();
        System.out.println("===================");
        System.out.println();
        System.out.println("Delete Nasabah");

        // delete nasabah
        nasabahService.delete(5);
        System.out.println();
        System.out.println("Read All Data Nasabah");
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