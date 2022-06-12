package com.example.fragment.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragment.R;
import com.example.fragment.model.Product;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder>{

    List<Product> mProdukList;
    Context context;
    SharedPreferences sharedPreferences;

    public ProductAdapter(List<Product> mProdukList, Context context) {
        this.mProdukList = mProdukList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_product, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.MyViewHolder holder, final int position) {
        String URL = "http://192.168.1.3:8058/FamilyCollection/foto_produk/";
        sharedPreferences = context.getSharedPreferences("remember", Context.MODE_PRIVATE);

        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        final String urlGambarBerita = URL+mProdukList.get(position).getFoto_produk();
        Picasso.with(context).load(urlGambarBerita).into(holder.imgProduk);
        holder.txtNama.setText(mProdukList.get(position).getNama_produk());
        holder.txtHarga.setText(mProdukList.get(position).getHarga_produk());
//        holder.imgCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mApiInterface= ApiClient.getClient().create(ApiInterface.class);
//                Call<PostPutDelCart> postKeranjang=mApiInterface.postCart(sharedPreferences.getString("id_user","5"),mProdukList.get(position).getId_product(),mProdukList.get(position).getProduct_price());
//                postKeranjang.enqueue(new Callback<PostPutDelCart>() {
//                    @Override
//                    public void onResponse(Call<PostPutDelCart> call, Response<PostPutDelCart> response) {
//                        if(response.body().getStatus()){
//                            Toast.makeText(context, "Barang ditambahkan", Toast.LENGTH_SHORT).show();
//                            Intent intent=new Intent(context, CartActivity.class);
//                            context.startActivity(intent);
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<PostPutDelCart> call, Throwable t) {
//
//                    }
//                });
//            }
//        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent mIntent = new Intent(view.getContext(), DetailActivity.class);
//                mIntent.putExtra("id_product",mProdukList.get(position).getId_product());
//                mIntent.putExtra("product_name",mProdukList.get(position).getProduct_name());
//                mIntent.putExtra("product_price",String.valueOf(formatRupiah.format(mProdukList.get(position).getProduct_price())));
//                mIntent.putExtra("product_description",mProdukList.get(position).getProduct_description());
//                mIntent.putExtra("product_rating",mProdukList.get(position).getProduct_rating());
//                mIntent.putExtra("product_image",mProdukList.get(position).getProduct_image());
//                view.getContext().startActivity(mIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (mProdukList == null) ? 0 :  mProdukList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtNama,imgFoto,txtHarga,txtStokHabis;
        ImageView imgProduk;
        ImageButton imgCart;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNama=itemView.findViewById(R.id.txtNama);
            txtHarga=itemView.findViewById(R.id.txtHarga);
//            txtStokHabis=itemView.findViewById(R.id.txtStokHabis);
            imgProduk=itemView.findViewById(R.id.imgProduk);
//            imgCart=itemView.findViewById(R.id.imgCart);
        }
    }


}
