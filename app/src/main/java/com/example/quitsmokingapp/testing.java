package com.example.quitsmokingapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class testing extends AppCompatActivity {
    private TextView tv1;
    RequestQueue queue;
    String URL = "http://192.168.0.9/coordinateAPI.php?location=jelutong";
    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);

        tv1 = findViewById(R.id.textview1);
    }

    public void btnGetClicked(View view) {
        queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                tv1.setText(response.toString());
                Toast.makeText(testing.this,response.toString(),Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tv1.setText(error.toString());
                Log.d("error",error.toString());
            }
        });
        queue.add(request);
    }

    public void btnPostClicked(View view) {
        queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                tv1.setText(response.toString());
                Toast.makeText(testing.this,response.toString(),Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tv1.setText(error.toString());
                Log.d("error",error.toString());
            }
        })
        {
            protected Map<String, String> getParams() throws com.android.volley.AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", "Mickey");
                params.put("age", "666");
                return params;
            };
        };
        queue.add(request);
    }
}