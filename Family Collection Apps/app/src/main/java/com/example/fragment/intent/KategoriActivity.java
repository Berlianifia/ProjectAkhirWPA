package com.example.fragment.intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
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
import com.example.fragment.activity.SearchActivity;
import com.example.fragment.adapter.DataAdapter;
import com.example.fragment.adapter.KategoriAdapter;
import com.example.fragment.adapter.ProductAdapter;
import com.example.fragment.model.Category;
import com.example.fragment.model.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class KategoriActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager linearLayoutManager;
    String URL_JSON = "http://192.168.1.3:8058/FamilyCollection/api/category.php";

    List<Category> categoryList;
    private DividerItemDecoration dividerItemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_layout);
        categoryList=new ArrayList<>();
        adapter=new KategoriAdapter(categoryList,getApplicationContext());
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);
        getCategory();

    }

    public void getCategory(){
        StringRequest stringRequest=new StringRequest(
                Request.Method.POST, URL_JSON,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Retrofit", response);
                        try{
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray getHasil= jsonObject.getJSONArray("hasil");

                            ArrayList arrayList = new ArrayList();
                            for (int i=0; i<getHasil.length(); i++){
                                Category category=new Category();

                                JSONObject getData=getHasil.getJSONObject(i);
                                category.setKategori(getData.getString("kategori"));
                                categoryList.add(category);

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
//                        Toast.makeText(SearchActivity.this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }



}
