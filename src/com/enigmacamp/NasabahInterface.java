package com.enigmacamp;

public interface NasabahInterface {
    public void create(Nasabah nasabah);
    public  Nasabah[] getAllItems();
    public Nasabah readById(int id);
    public void update(int id, String fullName, String nik, String phoneNumber, String birthDate);
    public void delete(int id);
}
