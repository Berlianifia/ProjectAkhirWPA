package com.example.fragment.util;

import com.example.fragment.R;

import java.util.HashMap;
import java.util.Map;


public class Constant {
    public static Map<Integer, String> _gayahidup = new HashMap<Integer, String>() {{
        put(R.drawable.dst1, "Fashion Wanita");
        put(R.drawable.dst2, "Fashion Pria");
        put(R.drawable.dst3, "Fashion Muslim");
        put(R.drawable.dst4, "Fashion Anak");
        put(R.drawable.dst5, "Kecantikan");
        put(R.drawable.dst6, "Rumah Tangga");
        put(R.drawable.dst7, "Kesehatan");
        put(R.drawable.dst8, "Olahraga");
        put(R.drawable.dst9, "Otomotif");
        put(R.drawable.dst10, "Dapur");
    }};
    public static Map<Integer, String> _teknologi = new HashMap<Integer, String>() {{
        put(R.drawable.dst1, "Handphone & Tablet");
        put(R.drawable.dst2, "Laptop & Aksesoris");
        put(R.drawable.dst3, "Komputer & Aksesoris");
        put(R.drawable.dst4, "Elektronik");
        put(R.drawable.dst5, "Kamera");
        put(R.drawable.dst6, "Software");
    }};
    public static Map<Integer, String> _catlain = new HashMap<Integer, String>() {{
        put(R.drawable.dst1, "Mainan & Hobi");
        put(R.drawable.dst2, "Makanan & Minuman");
        put(R.drawable.dst3, "Ibu & Bayi");
        put(R.drawable.dst4, "Souvenir, Kado & Hadiah");
        put(R.drawable.dst5, "Office & Stationery");
        put(R.drawable.dst6, "Buku");
        put(R.drawable.dst7, "Film, Musik & Game");
        put(R.drawable.dst8, "Produk Lainnya");
    }};
    public static Map<Integer, String> _pembayaran = new HashMap<Integer, String>() {{
        put(R.drawable.dst1, "Saldo My Shop");
        put(R.drawable.dst2, "BPJS");
        put(R.drawable.dst3, "Pulsa");
        put(R.drawable.dst4, "Voucher Game");
        put(R.drawable.dst5, "Angsuran Kredit");
        put(R.drawable.dst6, "Donasi");
        put(R.drawable.dst7, "Pascabayar");
        put(R.drawable.dst8, "Tiket Kereta Api");
        put(R.drawable.dst9, "Listrik PLN");
        put(R.drawable.dst10, "Paket Data");
        put(R.drawable.dst10, "Kartu Kredit");
        put(R.drawable.dst10, "Air PDAM");
        put(R.drawable.dst10, "TV Kabel");
        put(R.drawable.dst10

                , "Telepon");
    }};
    public static Map<String, Map<Integer, String>> cards = new HashMap<String, Map<Integer, String>>() {{
        put("Gaya Hidup", _gayahidup);
        put("Teknologi", _teknologi);
        put("Kategori Lain", _catlain);
        put("Pembayatan & Top Up", _pembayaran);
    }};
}
