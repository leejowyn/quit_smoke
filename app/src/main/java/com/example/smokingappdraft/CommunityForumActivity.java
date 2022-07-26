package com.example.smokingappdraft;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommunityForumActivity extends AppCompatActivity {
    
    RequestQueue queue;
    final String url_forum_readAll = "http://192.168.0.101/quit_smoking/community_forum.php?action=readAll";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_forum);

        ListView resultsListView = findViewById(R.id.lvForum);

        HashMap<String, String> title_content = new HashMap<>();

        queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, url_forum_readAll, response -> {
            try {
                // get settings row in database in json format
                JSONArray jsonArray = new JSONArray(response);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jObj = jsonArray.getJSONObject(i);
                    title_content.put(jObj.getString("title"), jObj.getString("content"));
                }

                List<HashMap<String, String>> listItems = new ArrayList<>();
                SimpleAdapter adapter = new SimpleAdapter(CommunityForumActivity.this, listItems, R.layout.forum_list_item,
                        new String[]{"First Line", "Second Line"},
                        new int[]{R.id.forumTitle, R.id.forumContent});


                for (Map.Entry<String, String> stringStringEntry : title_content.entrySet()) {
                    HashMap<String, String> resultsMap = new HashMap<>();
                    resultsMap.put("First Line", ((Map.Entry) stringStringEntry).getKey().toString());
                    resultsMap.put("Second Line", ((Map.Entry) stringStringEntry).getValue().toString());
                    listItems.add(resultsMap);
                }

                resultsListView.setAdapter(adapter);

            } catch (JSONException e) {
                Toast.makeText(CommunityForumActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }, error -> {
            Toast.makeText(CommunityForumActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            Log.d("error",error.toString());
        });
        queue.add(request);
    }
}