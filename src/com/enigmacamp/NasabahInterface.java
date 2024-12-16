package com.enigmacamp;

import java.util.ArrayList;

public interface NasabahInterface {
    public void create(int id, String fullName, String nik, String phoneNumber, String birthDate);
    public ArrayList<Nasabah> dataNasabah();
    public ArrayList<Nasabah> dataById(int id);
    public ArrayList<Nasabah> updateData(int id, String fullName, String nik, String phoneNumber, String birthDate);
    public void deleteNasabah(int id);
}
