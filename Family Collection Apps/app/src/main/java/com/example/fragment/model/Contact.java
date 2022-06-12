package com.example.fragment.model;
public class Contact {
    private int image;
    private String nama;
    private String waktu;
    private String pesan;
    public Contact(int image, String nama, String waktu, String pesan){
        this.image = image;
        this.nama=nama;
        this.waktu=waktu;
        this.pesan=pesan;
    }
    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getWaktu() {
        return waktu;
    }
    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
    public String getPesan() {
        return pesan;
    }
    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
}
