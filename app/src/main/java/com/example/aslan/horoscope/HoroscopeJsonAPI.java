package com.example.aslan.horoscope;

import android.app.Activity;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class HoroscopeJsonAPI extends Activity{

    public void HoroscopeToday(final TextView desc){
        String url = "http://sandipbgt.com/theastrologer/api/horoscope/aries/today/";
        RequestQueue queue = Volley.newRequestQueue(this);
        //final String[] desc = new String[1];
        //inal String[] desc_str = new String[1];
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String desc_str = response.getString("horoscope");
                            desc.append(desc_str);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(request);
    }

}
