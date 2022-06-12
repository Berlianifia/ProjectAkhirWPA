package com.example.fragment.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.fragment.LoginActivity;
import com.example.fragment.R;
import com.example.fragment.model.Trans;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AkunActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;
    SharedPreferences sharedPreferences;
    EditText name,phone;
    RelativeLayout rl1;
    TextView txtDate,txtTotal,txtStatus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name=findViewById(R.id.settings_phone_number);
        phone=findViewById(R.id.settings_full_name);
        txtDate=findViewById(R.id.txtDate);
        txtTotal=findViewById(R.id.txtTotal);
        txtStatus=findViewById(R.id.txtStatus);

        sharedPreferences = getApplication().getSharedPreferences("remember", Context.MODE_PRIVATE);

        name.setText(sharedPreferences.getString("nama_pelanggan","User"));
        Log.d("GA",sharedPreferences.getString("nama_pelanggan","User"));
        phone.setText(sharedPreferences.getString("telepon_pelanggan","User"));
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setSelectedItemId(R.id.akun);
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
                        startActivity(new Intent(getApplicationContext(), ChartActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.akun:
                        return true;
                }
                return false;
            }
        });

        getData(sharedPreferences.getString("id_pelanggan","User"));


    }

    public  void getData(String id){
        String url="http://192.168.1.3:8058/FamilyCollection/api/checkout/get.php?id="+id;
        StringRequest stringRequest=new StringRequest(
                Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Trans", response);
                        try{

                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray getHasil= jsonObject.getJSONArray("hasil");

                            JSONObject getData=getHasil.getJSONObject(0);
                            txtDate.setText(getData.getString("created_at"));
                            txtTotal.setText("Rp. "+getData.getString("total"));
                            txtStatus.setText(getData.getString("status"));


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
                        Toast.makeText(getApplicationContext(), "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
    public void logout(View view) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
        finish();
    }
}
