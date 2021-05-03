package com.example.workingwithjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    public static String cityID="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GetID(View view)
    {
        final EditText editText = (EditText) findViewById(R.id.txtCity);
        final TextView textView = (TextView) findViewById(R.id.lvOutput);


// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://www.metaweather.com/api/location/search/?query="+editText.getText().toString();


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response)
            {

                try {
                    JSONObject cityInfo = response.getJSONObject(0);
                    cityID = cityInfo.getString("woeid");
                }
                catch(Exception e)
                {
                    textView.setText("Error nothing in the Json File"+e.toString());
                }

                textView.setText("City id = "+cityID);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");

            }
        });

        queue.add(request);
//
//// Request a string response from the provided URL.
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        textView.setText("Response is:"+response);
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                textView.setText("That didn't work!"+error.toString());
//            }
//        });

// Add the request to the RequestQueue.

    }

    public void GetTemps(View view)
    {
        final EditText editText = (EditText) findViewById(R.id.txtCity);
        final TextView textView = (TextView) findViewById(R.id.lvWeather);


// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://www.metaweather.com/api/location/"+cityID;






        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response)
                    {
                        String max_temp="";
                        String min_temp="";
                        try {
                            JSONObject WeatherInfo = response.getJSONObject(1);
                            max_temp = WeatherInfo.getString("max_temp");
                        }
                        catch(Exception e)
                        {
                            textView.setText("Error nothing in the Json File"+e.toString());
                        }

                        textView.setText("Min temp = "+min_temp+"\nMax Temp = "+max_temp);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work! \n"+error.toString());
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                Log.d("Weather",error.toString());

            }
        });

        queue.add(request);
//
//// Request a string response from the provided URL.
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        textView.setText("Response is:"+response);
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                textView.setText("That didn't work!"+error.toString());
//            }
//        });

// Add the request to the RequestQueue.

    }
}