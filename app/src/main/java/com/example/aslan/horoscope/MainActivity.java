package com.example.aslan.horoscope;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static List<Horoscope> mData;
    RecyclerView recyclerView;
    private CardView cardView;
    //Navigation
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle barDrawerToggle;
    //Volley Json Horoscope
    private RequestQueue queue;

    //Navigation
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mData = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_id);
        addHoroscope(mData, recyclerView);
        //jsonParse();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_id);
        barDrawerToggle =new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(barDrawerToggle);
        barDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Volley
        queue = Volley.newRequestQueue(this);
        DailyDesc();
        WeeklyDesc();
        MonthlyDesc();
        YearlyDesc();

        //Navigation view
        navigationView = (NavigationView) findViewById(R.id.nav_id);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (barDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();
        Fragment fragment = null;

        if (id == R.id.horo_main_menu) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else if (id == R.id.age_calculator_id) {
            fragment = new AgeCalculator();
        } else if (id == R.id.nav_share) {
            fragment = new Shared();
        }

        if (fragment != null){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.screen_area, fragment);
            fragmentTransaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_id);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_id);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    public void addHoroscope(List<Horoscope> mData, RecyclerView recyclerView){
        mData.add(new Horoscope("Aries", "AriesDaily", "AriesWeekly", "AriesMonthly", "AriesYearly", "March 21 - April 19", R.drawable.aries));
        mData.add(new Horoscope("Cancer", "Cancerdaily", "", "", "", "June 21 - July 22", R.drawable.cancer));
        mData.add(new Horoscope("Capricorn", "Capriorndaily", "", "", "", "December 22 - January 19", R.drawable.capricorn));
        mData.add(new Horoscope("Gemini", "Geminidaly", "", "", "", "May 21 - June 20", R.drawable.gemini));
        mData.add(new Horoscope("Libra", "Libradaly", "", "", "", "September 23 - October 22", R.drawable.libra));
        mData.add(new Horoscope("Aquarius", "Aquariusdaly", "", "", "", "January 20 - February 18", R.drawable.aquarius));
        mData.add(new Horoscope("Leo", "Leodaily", "", "", "", "July 23 - August 22", R.drawable.leo));
        mData.add(new Horoscope("Sagittarius", "Saggiatrusdaily", "", "", "", "November 22 - December 21", R.drawable.sagiattrus));
        mData.add(new Horoscope("Scorpio", "Scorpiodaily", "", "", "", "October 23 - November 21", R.drawable.scorpio));
        mData.add(new Horoscope("Taurus", "Taurusdaily", "", "", "", "April 20 - May 20", R.drawable.taurus));
        mData.add(new Horoscope("Virgo", "Virgodaily", "", "", "", "August 23 - September 22", R.drawable.virgo));
        mData.add(new Horoscope("Pisces", "Piscesdaily", "", "", "", "February 19 - March 20", R.drawable.piscas));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mData);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(adapter);

    }

    public void DailyDesc() {
        for (final Horoscope item : mData) {
            String url = "http://sandipbgt.com/theastrologer/api/horoscope/" + item.getTitle().toLowerCase() + "/today/";
            JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                String d = response.getString("horoscope");
                                String[] arr = d.split("Kelli Fox");
                                item.setDailyDesc(arr[0] + "Aslan Ahmedov");

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
            queue.add(objectRequest);
        }
    }

    public void WeeklyDesc() {
        for (final Horoscope item : mData) {
            String url = "http://sandipbgt.com/theastrologer/api/horoscope/" + item.getTitle().toLowerCase() + "/tomorrow/";
            JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                String d = response.getString("horoscope");
                                String[] arr = d.split("Kelli Fox");
                                item.setWeeklyDesc(arr[0] + "Aslan Ahmedov");

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
            queue.add(objectRequest);
        }
    }

    public void MonthlyDesc() {
        for (final Horoscope item : mData) {
            String url = "http://sandipbgt.com/theastrologer/api/horoscope/" + item.getTitle().toLowerCase() + "/yesterday/";
            JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                String d = response.getString("horoscope");
                                String[] arr = d.split("Kelli Fox");
                                item.setMonthlyDesc(arr[0] + "Aslan Ahmedov");

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
            queue.add(objectRequest);
        }
    }

    public void YearlyDesc() {
        for (final Horoscope item : mData) {
            String url = "http://sandipbgt.com/theastrologer/api/horoscope/" + item.getTitle().toLowerCase() + "/tomorrow/";
            JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                String d = response.getString("horoscope");
                                String[] arr = d.split("Kelli Fox");
                                item.setYeaerlyDesc(arr[0] + "Aslan Ahmedov");

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
            queue.add(objectRequest);
        }
    }



}
