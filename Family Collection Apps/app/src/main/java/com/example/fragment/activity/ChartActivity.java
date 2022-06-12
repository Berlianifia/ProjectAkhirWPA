package com.example.fragment.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.fragment.R;
import com.example.fragment.adapter.TransAdapter;
import com.example.fragment.model.Trans;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ChartActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;
    RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager linearLayoutManager;
    EditText cari;
    TextView total_price;
    RelativeLayout r111;
    List<Trans> transList;
    private DividerItemDecoration dividerItemDecoration;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        recyclerView=findViewById(R.id.cart_list);
        cari=findViewById(R.id.search_product_name);
        total_price=findViewById(R.id.total_price);
        r111=findViewById(R.id.r111);

        transList = new ArrayList<>();
        adapter=new TransAdapter(transList,getApplicationContext());

        sharedPreferences = getApplication().getSharedPreferences("remember", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);


        getTrans(sharedPreferences.getString("id_pelanggan","User"));
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setSelectedItemId(R.id.chart);
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.search:
                        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.chart:
                        return true;
                    case R.id.akun:
                        startActivity(new Intent(getApplicationContext(), AkunActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        r111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Test1 = new Intent(getApplicationContext(), CheckoutActivity.class);
                Test1.putExtra("total", total_price.getText().toString());
                startActivity(Test1);
            }
        });
    }


    public void getTrans(String id){
        String url="http://192.168.1.3:8058/FamilyCollection/api/transaction.php?id="+id;
        StringRequest stringRequest=new StringRequest(
                Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Trans", response);
                        try{
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray getHasil= jsonObject.getJSONArray("hasil");
                            total_price.setText(jsonObject.getString("total"));

                            ArrayList arrayList = new ArrayList();
                            for (int i=0; i<getHasil.length(); i++){
                                Trans trans=new Trans();

                                JSONObject getData=getHasil.getJSONObject(i);
                                trans.setNama_produk(getData.getString("nama_produk"));
                                trans.setHarga_produk("Rp. "+getData.getString("harga_produk"));
                                trans.setJumlah(getData.getString("jumlah")+" Barang");
                                trans.setFoto_produk(getData.getString("foto_produk"));
                                transList.add(trans);

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
                        Toast.makeText(ChartActivity.this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
