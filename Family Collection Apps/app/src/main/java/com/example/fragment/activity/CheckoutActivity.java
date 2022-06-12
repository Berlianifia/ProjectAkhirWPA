package com.example.fragment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.fragment.LoginActivity;
import com.example.fragment.R;

import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CheckoutActivity extends AppCompatActivity {
    private String URL = "http://192.168.1.3:8058/FamilyCollection/api/checkout/post.php";
    TextView total;
    Intent mIntent;
    SharedPreferences sharedPreferences;
    Date c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        total=findViewById(R.id.txtTotal);
        mIntent = getIntent();
        total.setText(mIntent.getStringExtra("total"));
        sharedPreferences = getApplication().getSharedPreferences("remember", Context.MODE_PRIVATE);
    }

    public void checkout(View view){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Checkout",response);
                if (!response.equals("failure")) {
                    Toast.makeText(getApplicationContext(), "Chekout Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), AkunActivity.class);
                    startActivity(intent);
                    finish();
                } else if (response.equals("failure")) {
                    Toast.makeText(getApplicationContext(), "Invalid Login Id/Password", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> data = new HashMap<>();
                data.put("id_pelanggan", sharedPreferences.getString("id_pelanggan","User"));
                data.put("status", "Pending");
                data.put("created_at", String.valueOf(Calendar.getInstance().getTime()));
                data.put("total", mIntent.getStringExtra("total"));
                return data;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}