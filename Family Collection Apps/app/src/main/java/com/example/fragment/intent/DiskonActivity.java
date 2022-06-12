package com.example.fragment.intent;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.fragment.R;
import com.example.fragment.adapter.PromoAdapter;
import com.example.fragment.model.Promo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DiskonActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager linearLayoutManager;
    EditText cari;
    List<Promo> promoList;
    private DividerItemDecoration dividerItemDecoration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diskon);
        recyclerView=findViewById(R.id.recyclerview_layout);
        cari=findViewById(R.id.search_product_name);

        promoList = new ArrayList<>();
        adapter=new PromoAdapter(promoList,getApplicationContext());

        linearLayoutManager =  new GridLayoutManager(getApplicationContext(), 2, GridLayoutManager.VERTICAL, false);
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);

        getPromo();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void getPromo(){
        String url="http://192.168.1.3:8058/FamilyCollection/api/diskon.php";
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
                                Promo promo=new Promo();

                                JSONObject getData=getHasil.getJSONObject(i);
                                promo.setNama_produk(getData.getString("nama_produk"));
                                promo.setHarga_produk("Rp. "+getData.getString("harga_produk"));
                                promo.setHarga_promo("Rp. "+(Integer.parseInt(getData.getString("harga_produk"))-Integer.parseInt(getData.getString("harga_diskon"))));
                                promo.setFoto_produk(getData.getString("foto_produk"));
                                promoList.add(promo);

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
                        Toast.makeText(DiskonActivity.this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
