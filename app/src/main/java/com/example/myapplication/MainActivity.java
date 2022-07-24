package com.example.myapplication;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;


public class MainActivity extends AppCompatActivity {

    private TextView tvName, tvEmail, tvPassword, tvAmt_cigarette, tvPrice_cigarette;
    RequestQueue queue;
    String URL = "http://192.168.1.106/stopsmoking/user.php?email=Tommy@gmail.com";
    
    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvName = findViewById(R.id.name);
        tvEmail = findViewById(R.id.email);
        tvPassword = findViewById(R.id.password);
        tvAmt_cigarette = findViewById(R.id.amt_cigarette);
        tvPrice_cigarette = findViewById(R.id.price_cigarette);
        queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                name.setText(response.toString());
//                email.setText(response.toString());
//                password.setText(response.toString());
//                amt_cigarette.setText(response.toString());
//                price_cigarette.setText(response.toString());
                JSONArray arr = null;
                try {
                    arr = new JSONArray(response);
                    JSONObject jObj = arr.getJSONObject(0);
                    tvName.setText(jObj.getString("name"));
                    tvEmail.setText(jObj.getString("email"));
                    tvPassword.setText(jObj.getString("password"));
                    tvAmt_cigarette.setText(jObj.getString("amt_cigarette"));
                    tvPrice_cigarette.setText(jObj.getString("price_cigarette"));

                    Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvName.setText(error.toString());
                tvEmail.setText(error.toString());
                tvPassword.setText(error.toString());
                tvAmt_cigarette.setText(error.toString());
                tvPrice_cigarette.setText(error.toString());
                Log.d("error",error.toString());
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
    }
    public void btnGetClicked(View view) {


    }
}