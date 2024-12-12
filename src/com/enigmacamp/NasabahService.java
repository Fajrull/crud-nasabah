package com.enigmacamp;

// Kelas untuk memanipulasi data nasabah seperti (create, read, update, delete)
public class NasabahService implements NasabahInterface{
    private static Nasabah[] items = new Nasabah[4];
    private int nasabahCount = 0;


    public NasabahService() {
    }

    //    Registrasi Nasabah
    public void create(Nasabah nasabah) {
        try {
            validateUniqueNasabah(nasabah.getNik(), nasabah.getPhoneNumber());
            validateAddNasabah(nasabahCount);
            items[nasabahCount++] = nasabah;
            System.out.println("Nasabah berhasil ditambahkan");
        } catch (InvalidAddNasabah e){
            System.out.println(e.getMessage());
        }

    }

    // Read all nasabah
    public Nasabah[] getAllItems() {
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
       try {
           validateIdNasabah(readById(id));
           validateUpdateNasabah(fullName, nik, phoneNumber, birthDate);
           for (int i = 0; i < items.length; i++) {
               if (items[i] != null && items[i].getId() == id) {
                   items[i].setFullName(fullName);
                   items[i].setNik(nik);
                   items[i].setPhoneNumber(phoneNumber);
                   items[i].setBirthDate(birthDate);
                   System.out.println("Nasabah dengan id " + id + " berhasil diupdate");
                   return;
               }
           }
       } catch (invalidNasabahId e){
           System.out.println(e.getMessage());
       }

//        System.out.println("Nasabah tidak ditemukan");
    }

    // Delete by id
    public void delete(int id) {
        try {
            validateIdNasabah(readById(id));
            for (int i = 0; i < items.length; i++) {
                if (items[i] != null && items[i].getId() == id) {
                    items[i] = null;
                    System.out.println("Nasabah dengan id " + id + " berhasil dihapus");
                    return;
                }
            }
        } catch (invalidNasabahId e){
            System.out.println(e.getMessage());
        }

//        System.out.println("Nasabah tidak ditemukan");
    }

    // Custom exception validate add nasabah
    public  int validateAddNasabah(int nasabahCount) throws InvalidAddNasabah{
        if (nasabahCount == getAllItems().length) {
            throw new InvalidAddNasabah("Jumlah nasabah sudah penuh");
        } else {
            return(nasabahCount);
        }
    }

    // Custom exception validasi jika data tidak ada ketika melakukan update, delete dan get by id
    public static void validateIdNasabah(Nasabah items) throws InvalidAddNasabah{
        if (items == null) {
            throw new invalidNasabahId("Nasabah tidak ditemukan, coba periksa kembali id");
        }
    }

    // custom update agar data tidak kosong
    public static void validateUpdateNasabah(String fullName, String nik, String phoneNumber, String birthDate) throws InvalidUpdateNasabah{
        if (fullName.isEmpty() || nik.isEmpty() || phoneNumber.isEmpty() || birthDate.isEmpty()) {
            throw new invalidNasabahId("Data nasabah tidak boleh kosong");
        }
    }

    // membuat agar id,nik,phone number unik dan id,nik,phone number tidak boleh sama
    public void validateUniqueNasabah(String nik, String phoneNumber) throws InvalidAddNasabah{
        Nasabah[] nasabahList = getAllItems();

        for (Nasabah nasabah : nasabahList) {
            if (nasabah != null) {
                if (nasabah.getNik() == nik) {
                    throw new InvalidAddNasabah("NIK sudah terdaftar");
                }
                if (nasabah.getPhoneNumber() == phoneNumber) {
                    throw new InvalidAddNasabah("Nomor hp sudah terdaftar");
                }
            }

        }
    }





}
