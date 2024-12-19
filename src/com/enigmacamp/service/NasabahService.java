package com.enigmacamp.service;

import com.enigmacamp.utils.InvalidExecption;
import com.enigmacamp.model.Nasabah;

import java.io.*;
import java.util.ArrayList;

// Kelas untuk memanipulasi data nasabah seperti (create, read, update, delete)
public class NasabahService implements NasabahInterface {
    private static ArrayList<Nasabah> items = new ArrayList<>();
    private static File file = new File("nasabah.txt");

    public NasabahService() {
    }

    // Check file and create file
    public static void checkAndCreateFile(File file) {
        if (!checkFileExist(file)){
            createFile(file);
        }else{
            System.out.println("File sudah ada");
        }
    }

    public static Boolean checkFileExist(File file) {
        return file.exists();
    }

    public static void createFile(File file) {
        try{
            if (file.createNewFile()){
                System.out.println("File berhasil dibuat");
            }else {
                System.out.println("File gagal dibuat");
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
            throw new IllegalStateException(e);
        }
    }

    private static void writeFile(ArrayList<Nasabah> items) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Nasabah nasabah : items) {
                bufferedWriter.write(nasabah.getId() + "," + nasabah.getFullName() + "," + nasabah.getNik() + "," + nasabah.getPhoneNumber() + "," + nasabah.getBirthDate() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void justifyData() {
        try{
            ArrayList<Nasabah> dumpItems = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.file));
            String readString;
            while((readString = bufferedReader.readLine()) != null){
                Nasabah nasabah = new Nasabah();
                String[] data = readString.split(",");
                nasabah.setId(Integer.parseInt(data[0]));
                nasabah.setFullName(data[1]);
                nasabah.setNik(data[2]);
                nasabah.setPhoneNumber(data[3]);
                nasabah.setBirthDate(data[4]);
                dumpItems.add(nasabah);
            }
            bufferedReader.close();
//            System.out.println("______________________________");
//            System.out.println(dumpItems);
            items = dumpItems;
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


    // Menambahkan data
    public void create(int id, String fullName, String nik, String phoneNumber, String birthDate){
        try {
            validateIdUnique(id);
            validateUniqueNasabah(nik, phoneNumber);
            validateUpdateNasabah(fullName, nik, phoneNumber, birthDate);
            Nasabah nasabah = new Nasabah(id,fullName,nik,phoneNumber,birthDate);
            items.add(nasabah);
            writeFile(items);
        } catch (InvalidExecption e) {
            System.out.println(e.getMessage());
        }
    }

    // Read all data
    public ArrayList<Nasabah> dataNasabah(){
        if (items.isEmpty()) {
            justifyData();
        }
        return items;
    }

    // Read data by id
    public ArrayList<Nasabah> dataById(int id){
        ArrayList<Nasabah> result = new ArrayList<>();
        try {
            justifyData();
            validateDataEmpty(id);
            for (Nasabah nasabah : items) {
                if (nasabah.getId() == id) {
                    result.add(nasabah);
                }
            }
        } catch (InvalidExecption e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    //   Update nasabah
    public ArrayList<Nasabah> updateData(int id, String fullName, String nik, String phoneNumber, String birthDate){
        try {
            validateDataEmpty(id);
            validateUniqueNasabah(nik,phoneNumber);
            validateUpdateNasabah(fullName, nik, phoneNumber, birthDate);
            justifyData();
            for(Nasabah nasabah : items){
                if (nasabah.getId() == id) {
                    nasabah.setFullName(fullName);
                    nasabah.setNik(nik);
                    nasabah.setPhoneNumber(phoneNumber);
                    nasabah.setBirthDate(birthDate);
//                    items.add(nasabah);
                    writeFile(items);
                    System.out.println("data berhasil di update");
                    break;
                }
            }
        } catch (InvalidExecption e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    // Delete nasabah by id
    public void deleteNasabah(int id) {
        try {
            justifyData();
//            System.out.println(items);
            validateDataEmpty(id);
            for (Nasabah nasabah : items) {
                if (nasabah.getId() == id) {
                    items.remove(nasabah);
                    writeFile(items);
                    System.out.println("data berhasil di hapus");
                    break;
                }
            }
        } catch (InvalidExecption e) {
            System.out.println(e.getMessage());
        }
    }

    //validasi agar nik,phone number unik dan nik,phone number tidak boleh sama
    public void validateUniqueNasabah(String nik, String phoneNumber) throws InvalidExecption {
        for (Nasabah nasabah : items) {
            if (nasabah.getNik().equals(nik)) {
                throw new InvalidExecption("NIK sudah terdaftar");
            }
            if (nasabah.getPhoneNumber().equals(phoneNumber)) {
                throw new InvalidExecption("Nomor hp sudah terdaftar");
            }

        }
    }

    //validasi agar id tidak boleh sama
    public void validateIdUnique(int id) throws InvalidExecption {
        for (Nasabah nasabah : items) {
            if (nasabah.getId() == id) {
                throw new InvalidExecption("Id sudah terdaftar");
            }
        }
    }

    // validasi agar update data tidak kosong
    public void validateUpdateNasabah(String fullName, String nik, String phoneNumber, String birthDate) throws InvalidExecption{
        if (fullName.isEmpty() || nik.isEmpty() || phoneNumber.isEmpty() || birthDate.isEmpty()) {
            throw new InvalidExecption("Data nasabah tidak boleh kosong");
        }
    }

    //validasi jika tidak ada data
    public void validateDataEmpty(int id) throws InvalidExecption{
        System.out.println(items);
        System.out.println(id);
        for (Nasabah nasabah : items) {
            if (nasabah.getId() == id) {
                return;
            }
        }
        throw new InvalidExecption("Data nasabah tidak ditemukan");
    }

}
