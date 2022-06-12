package com.example.fragment.model;

public class Product {
    private String id_produk;
    private String nama_produk;
    private String harga_produk;
    private String berat_produk;
    private String foto_produk;
    private String deskripsi_produk;


    public Product() {
    }

    public Product(String id_produk, String nama_produk, String harga_produk, String berat_produk, String foto_produk, String deskripsi_produk) {
        this.id_produk = id_produk;
        this.nama_produk = nama_produk;
        this.harga_produk = harga_produk;
        this.berat_produk = berat_produk;
        this.foto_produk = foto_produk;
        this.deskripsi_produk = deskripsi_produk;
    }
    public String getId_produk() {
        return id_produk;
    }

    public void setId_produk(String id_produk) {
        this.id_produk = id_produk;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public String getHarga_produk() {
        return harga_produk;
    }

    public void setHarga_produk(String harga_produk) {
        this.harga_produk = harga_produk;
    }

    public String getBerat_produk() {
        return berat_produk;
    }

    public void setBerat_produk(String berat_produk) {
        this.berat_produk = berat_produk;
    }

    public String getFoto_produk() {
        return foto_produk;
    }

    public void setFoto_produk(String foto_produk) {
        this.foto_produk = foto_produk;
    }

    public String getDeskripsi_produk() {
        return deskripsi_produk;
    }

    public void setDeskripsi_produk(String deskripsi_produk) {
        this.deskripsi_produk = deskripsi_produk;
    }
}

