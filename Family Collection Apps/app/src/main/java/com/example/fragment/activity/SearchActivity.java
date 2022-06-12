package com.example.fragment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.fragment.R;
import com.example.fragment.adapter.DataAdapter;
import com.example.fragment.adapter.FeedAdapter;
import com.example.fragment.adapter.ProductAdapter;
import com.example.fragment.model.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;
    RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager linearLayoutManager;
    EditText cari;
    List<Product> productList;
    private DividerItemDecoration dividerItemDecoration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        recyclerView=findViewById(R.id.search_list);
        cari=findViewById(R.id.search_product_name);

        productList = new ArrayList<>();
        adapter=new ProductAdapter(productList,getApplicationContext());

        linearLayoutManager =  new GridLayoutManager(getApplicationContext(), 2, GridLayoutManager.VERTICAL, false);
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);

        cari_data("");
        cari.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cari_data(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setSelectedItemId(R.id.search);
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.search:
                        return true;
                    case R.id.chart:
                        startActivity(new Intent(getApplicationContext(), ChartActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.akun:
                        startActivity(new Intent(getApplicationContext(), AkunActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
    void cari_data(String data_cari){
        productList.clear();
        String url="http://192.168.1.3:8058/FamilyCollection/api/search.php?data="+ data_cari;
        StringRequest stringRequest=new StringRequest(
                Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Retrofit", response);



                        try{
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray getHasil= jsonObject.getJSONArray("hasil");

                            ArrayList arrayList = new ArrayList();
                            for (int i=0; i<getHasil.length(); i++){
                                Product product=new Product();

                                JSONObject getData=getHasil.getJSONObject(i);
                                product.setNama_produk(getData.getString("nama_produk"));
                                product.setHarga_produk("Rp. "+getData.getString("harga_produk"));
                                product.setFoto_produk(getData.getString("foto_produk"));
                                productList.add(product);

                            }

                            adapter.notifyDataSetChanged();

//                            final Adapter adapter = new Adapter(jsonObject.getJSONArray("hasil"), model);
//                            recyclerView.setAdapter(adapter);
                        }catch (JSONException e){

                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SearchActivity.this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
