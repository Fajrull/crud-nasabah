package com.enigmacamp.service;

import com.enigmacamp.utils.InvalidExecption;
import com.enigmacamp.model.Nasabah;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

// Kelas untuk memanipulasi data nasabah seperti (create, read, update, delete)
public class NasabahService implements NasabahInterface {
    private static ArrayList<Nasabah> items = new ArrayList<>();

    public NasabahService() {
    }

    // Menambahkan data
    public void create(int id, String fullName, String nik, String phoneNumber, String birthDate){
        try {
            validateUniqueNasabah(nik, phoneNumber);
            validateIdUnique(id);
            Nasabah nasabah = new Nasabah(id,fullName,nik,phoneNumber,birthDate);
            items.add(nasabah);
        } catch (InvalidExecption e) {
            System.out.println(e.getMessage());
        }

    }

    // Read all data
    public ArrayList<Nasabah> dataNasabah(){
        return items;
    }

    // Read data by id
    public ArrayList<Nasabah> dataById(int id){
        ArrayList<Nasabah> result = new ArrayList<>();
        for (Nasabah nasabah : items) {
            if (nasabah.getId() == id) {
                result.add(nasabah);
            }
        }
        return result;
    }

    //     Update nasabah
    public ArrayList<Nasabah> updateData(int id, String fullName, String nik, String phoneNumber, String birthDate){
        try {
            validateUpdateNasabah(fullName, nik, phoneNumber, birthDate);
            validateUniqueNasabah(nik,phoneNumber);
            ArrayList<Nasabah> result = new ArrayList<>();
            for(Nasabah nasabah : items){
                if (nasabah.getId() == id) {
                    nasabah.setFullName(fullName);
                    nasabah.setNik(nik);
                    nasabah.setPhoneNumber(phoneNumber);
                    nasabah.setBirthDate(birthDate);
                    result.add(nasabah);
                    System.out.println("data berhasil di update");
                }
            }
            return result;
        } catch (InvalidExecption e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    // Delete nasabah by id
    public void deleteNasabah(int id) {
        try {
            validateDayaEmpty(id);
            for (Nasabah nasabah : items) {
                if (nasabah.getId() == id) {
                    items.remove(nasabah);
                    System.out.println("data berhasil di hapus");
                    break;
                }
            }
        } catch (InvalidExecption e) {
            System.out.println(e.getMessage());
        }
    }

    //validasi agar nik,phone number unik dan id,nik,phone number tidak boleh sama
    public void validateUniqueNasabah(String nik, String phoneNumber) throws InvalidExecption {
        for (Nasabah nasabah : items) {
            if (nasabah.getNik() == nik) {
                throw new InvalidExecption("NIK sudah terdaftar");
            }
            if (nasabah.getPhoneNumber() == phoneNumber) {
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
    public void validateDayaEmpty(int id) throws InvalidExecption{
        for (Nasabah nasabah : items) {
            if (nasabah.getId() == id) {
                return;
            }
        }
        throw new InvalidExecption("Data nasabah tidak ditemukan");
    }

}
