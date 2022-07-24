package com.example.achievement;


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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    RequestQueue queue;
    EditText title, content;
    Button btnsubmit;
    String ReadURL = "http://192.168.1.105/stopsmoking/connectphp.php?action=readOne&setting_type=smoking_tips";
    String UpdateURL = "http://192.168.1.105/stopsmoking/connectphp.php?action=update&setting_type=smoking_tips";

    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.et_title);
        content = findViewById(R.id.et_content);
        btnsubmit = findViewById(R.id.btn_submit);
        showCurrentSetting();
    }
    public void btnOnclick(View view) {
        //update tips title and content in database
        queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, UpdateURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this,"Tips updated successfully",Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                Log.d("error",error.toString());
            }
        })
        {
            protected Map<String, String> getParams() throws com.android.volley.AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put(
                        "setting_content",
                        "{\"title\": \"" + title.getText().toString() + "\", " +
                                "\"content\":\"" + content.getText().toString() + "\"}");
                return params;
            };
        };
        queue.add(request);
    }
    private void showCurrentSetting() {
        // select title and content from database and show
        queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, ReadURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    // get settings row in database in json format
                    JSONArray arrRow = new JSONArray(response);
                    JSONObject jObjRow = arrRow.getJSONObject(0);

                    // get content of tips settings in json format
                    String settingContentStr = jObjRow.getString("setting_content");
                    JSONObject jObjSettingContent = new JSONObject(settingContentStr);
                    title.setText(jObjSettingContent.getString("title"));
                    content.setText(jObjSettingContent.getString("content"));

                } catch (JSONException e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                Log.d("error",error.toString());
            }
        });
        queue.add(request);
    }
}