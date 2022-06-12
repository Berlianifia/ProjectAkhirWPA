package com.example.fragment.model;

public class Trans {
    private String nama_produk;
    private String harga_produk;
    private String foto_produk;
    private String jumlah;
    private String total;

    public Trans() {
    }

    public Trans(String nama_produk, String harga_produk, String foto_produk, String jumlah, String total) {
        this.nama_produk = nama_produk;
        this.harga_produk = harga_produk;
        this.foto_produk = foto_produk;
        this.jumlah = jumlah;
        this.total = total;
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

    public String getFoto_produk() {
        return foto_produk;
    }

    public void setFoto_produk(String foto_produk) {
        this.foto_produk = foto_produk;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
