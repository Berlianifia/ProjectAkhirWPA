package com.example.fragment.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragment.R;
import com.example.fragment.model.Product;
import com.example.fragment.model.Promo;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;


public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.MyViewHolder>{

        List<Promo> mPromoList;
        Context context;
        SharedPreferences sharedPreferences;

        public PromoAdapter(List<Promo> mPromoList, Context context) {
            this.mPromoList = mPromoList;
            this.context = context;
        }

        @NonNull
        @Override
        public PromoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_promo, parent, false);
            PromoAdapter.MyViewHolder mViewHolder = new PromoAdapter.MyViewHolder(mView);
            return mViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull PromoAdapter.MyViewHolder holder, final int position) {
            String URL = "http://192.168.1.3:8058/FamilyCollection/foto_produk/";
            sharedPreferences = context.getSharedPreferences("remember", Context.MODE_PRIVATE);

            Locale localeID = new Locale("in", "ID");
            NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
            final String urlGambarBerita = URL+mPromoList.get(position).getFoto_produk();
            Picasso.with(context).load(urlGambarBerita).into(holder.imgProduk);
            holder.txtNama.setText(mPromoList.get(position).getNama_produk());
            holder.txtHarga.setText(mPromoList.get(position).getHarga_produk());
            holder.txtHarga.setPaintFlags(holder.txtHarga.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.txtPromo.setText(mPromoList.get(position).getHarga_promo());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });

        }

        @Override
        public int getItemCount() {
            return (mPromoList == null) ? 0 :  mPromoList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView txtNama,imgFoto,txtHarga,txtPromo;
            ImageView imgProduk;
            ImageButton imgCart;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                txtNama=itemView.findViewById(R.id.txtNama);
                txtHarga=itemView.findViewById(R.id.txtHarga);
                txtPromo=itemView.findViewById(R.id.txtPromo);
//            txtStokHabis=itemView.findViewById(R.id.txtStokHabis);
                imgProduk=itemView.findViewById(R.id.imgProduk);
//            imgCart=itemView.findViewById(R.id.imgCart);
            }
        }
}
