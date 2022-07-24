package com.example.adminhomepage;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class achievement extends AppCompatActivity {

    EditText title, hint, reward;
    Button btnsubmit;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);
        title = findViewById(R.id.et_title);
        hint = findViewById(R.id.et_hint);
        reward =  findViewById(R.id.et_reward);
        btnsubmit = findViewById(R.id.btn_submit);
    }

    String URL = "http://192.168.0.108/quitSmoke/connectphp.php";
    @RequiresApi(api = Build.VERSION_CODES.N)

    public void btnOnclick(View view) {
        queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(achievement.this,response.toString(),Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("error",error.toString());
                Toast.makeText(achievement.this,error.toString(),Toast.LENGTH_LONG).show();

            }
        })
        {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("title" , title.getText().toString());
                params.put("hint" , hint.getText().toString());
                params.put("reward" , reward.getText().toString());
                return params;
            };
        };
        queue.add(request);
        request.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });
    }

}