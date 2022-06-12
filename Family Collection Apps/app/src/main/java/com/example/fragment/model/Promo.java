package com.example.fragment.model;

public class Promo {
    private String nama_produk;
    private String harga_promo;
    private String harga_diskon;
    private String harga_produk;
    private String foto_produk;

    public Promo() {
    }

    public Promo(String nama_produk, String harga_promo, String harga_diskon, String harga_produk, String foto_produk) {
        this.nama_produk = nama_produk;
        this.harga_promo = harga_promo;
        this.harga_diskon = harga_diskon;
        this.harga_produk = harga_produk;
        this.foto_produk = foto_produk;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public String getHarga_promo() {
        return harga_promo;
    }

    public void setHarga_promo(String harga_promo) {
        this.harga_promo = harga_promo;
    }

    public String getHarga_diskon() {
        return harga_diskon;
    }

    public void setHarga_diskon(String harga_diskon) {
        this.harga_diskon = harga_diskon;
    }

    public String getHarga_produk() {
        return harga_produk;
    }

    public void setHarga_produk(String harga_produk) {
        this.harga_produk = harga_produk;
    }

    public String getFoto_produk() {
        return foto_produk;
    }

    public void setFoto_produk(String foto_produk) {
        this.foto_produk = foto_produk;
    }
}
