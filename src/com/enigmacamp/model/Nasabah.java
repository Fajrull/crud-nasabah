package com.enigmacamp.model;

public class Nasabah {
    private int id;
    private String fullName;
    private String nik;
    private String phoneNumber;
    private String birthDate;

    public Nasabah(int id, String fullName, String nik, String phoneNumber, String birthDate) {
        this.id = id;
        this.fullName = fullName;
        this.nik = nik;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Nasabah{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", nik='" + nik + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}