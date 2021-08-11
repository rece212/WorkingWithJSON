package com.example.workingwithjson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static String cityID="";
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
    }

    public void GetID(View view)
    {
        final EditText editText = (EditText) findViewById(R.id.txtCity);
        final TextView textView = (TextView) findViewById(R.id.txtOutput);


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

    }

    public void GetTemps(View view)
    {
        final EditText editText = (EditText) findViewById(R.id.txtCity);

        final TextView textView = (TextView) findViewById(R.id.txtOutput);
        final ListView lv = (ListView) findViewById(R.id.lvOutput);
// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://www.metaweather.com/api/location/"+cityID;

        Log.i("Test","Button pressed");
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        try
                        {
                            JSONArray weatherList = response.getJSONArray("consolidated_weather");
                            List<WeatherObject> WeatherList= new ArrayList<WeatherObject>();

                            int iSize=0;
                            for ( int i =0;i<6;i++)
                            {
                                WeatherObject OnedayObject = new WeatherObject();
                                JSONObject OneDayJSon = (JSONObject) weatherList.get(i);

                                OnedayObject.setID(OneDayJSon.get("id").toString());
                                OnedayObject.setWeatherStateName(OneDayJSon.get("weather_state_name").toString());
                                OnedayObject.setWeatherStateAbbr(OneDayJSon.get("weather_state_abbr").toString());
                                OnedayObject.setWinddirectioncompass(OneDayJSon.get("wind_direction_compass").toString());
                                OnedayObject.setCreated(OneDayJSon.get("created").toString());
                                OnedayObject.setApplicabledate(OneDayJSon.get("applicable_date").toString());
                                OnedayObject.setMin_temp(OneDayJSon.get("min_temp").toString());
                                OnedayObject.setMax_temp(OneDayJSon.get("max_temp").toString());
                                OnedayObject.setThe_temp(OneDayJSon.get("the_temp").toString());
                                OnedayObject.setWind_speed(OneDayJSon.get("wind_speed").toString());
                                OnedayObject.setWind_direction(OneDayJSon.get("wind_direction").toString());
                                OnedayObject.setAir_pressure(OneDayJSon.get("air_pressure").toString());
                                OnedayObject.setHumidity(OneDayJSon.get("humidity").toString());
                                OnedayObject.setVisibility(OneDayJSon.get("visibility").toString());
                                OnedayObject.setPredictability(OneDayJSon.get("predictability").toString());
                                Log.d("Test",OnedayObject.toString());
                                WeatherList.add(OnedayObject);
                                iSize++;
                            }
                            textView.setText(WeatherList.get(1).toString());
                            String[] strOutput= new String[iSize];
                            for ( int x=0;x<iSize ;x++)
                            {
                                strOutput[x]=WeatherList.get(x).toString();
                            }
                            ArrayAdapter arrayAdapter = new ArrayAdapter(context,R.layout.simple_list_item, R.id.textView, strOutput);

                            lv.setAdapter(arrayAdapter);
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Log.d("Weather","IT worked "+response.toString());
                    }
                }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                        {
                            Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                            Log.d("Weather",error.toString());
                }
        });


        queue.add(request);

    }
}