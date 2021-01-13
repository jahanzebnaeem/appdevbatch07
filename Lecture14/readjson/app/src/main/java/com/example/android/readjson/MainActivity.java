package com.example.android.readjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String jsonData = "{" +
            "  'info':" +
            "  {" +
            "    'name':'Jahanzeb'," +
            "    'age': 38" +
            "  }," +
            "  'jobs':[" +
            "    {" +
            "      'id': 1," +
            "      'title': 'Associate Developer'," +
            "      'desc': 'Help out in development tasks.'" +
            "    }," +
            "    {" +
            "      'id': 2," +
            "      'title': 'Developer'," +
            "      'desc': 'Develop new applications.'" +
            "    }," +
            "    {" +
            "      'id': 3," +
            "      'title': 'Senior Developer'," +
            "      'desc': 'Develop new applications and help associate developers.'" +
            "    }" +
            "  ]" +
            "}";

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONObject info = jsonObject.getJSONObject("info");
            String name = info.getString("name");
            int age = info.getInt("age");

//            Toast.makeText(this, "Name is " + name + ", and your age is " + age, Toast.LENGTH_LONG).show();

            JSONArray jobs = jsonObject.getJSONArray("jobs");
            for (int i = 0; i < jobs.length(); i++) {
                JSONObject job = jobs.getJSONObject(i);
                int id = job.getInt("id");
                String title = job.getString("title");
                String desc = job.getString("desc");

                Toast.makeText(this, "Job id: " + id + ", job title: " + title + ", and description is " + desc, Toast.LENGTH_LONG).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}