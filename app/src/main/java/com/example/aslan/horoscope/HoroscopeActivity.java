package com.example.aslan.horoscope;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.aslan.horoscope.FragmentDaily.*;

public class HoroscopeActivity extends AppCompatActivity{

    private TextView title_text;
    private TextView date_text;
    private TextView daily_text;
    private TextView weekly_text;
    private TextView monthly_text;
    private TextView yearly_text;
    private ImageView img_thumbnail;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AppBarLayout appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscope);

        title_text = (TextView) findViewById(R.id.title_hid);
        img_thumbnail = (ImageView) findViewById(R.id.img_view_id);
        date_text = (TextView) findViewById(R.id.date_hid);



        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String daily = intent.getExtras().getString("daily_horoscope");
        String weekly = intent.getExtras().getString("weekly_horoscope");
        String monthly = intent.getExtras().getString("monthly_horoscope");
        String yearly = intent.getExtras().getString("yearly_horoscope");
        String date = intent.getExtras().getString("date_horoscope");
        int image = intent.getExtras().getInt("Thumbnail");

        title_text.setText(Title);
        date_text.setText(date);
        Bundle daily_key = new Bundle();
        daily_key.putString("daily_key",daily);
        Bundle weekly_key = new Bundle();
        weekly_key.putString("weekly_key", weekly);
        Bundle monthly_key = new Bundle();
        monthly_key.putString("monthly_key", monthly);
        Bundle yearly_key = new Bundle();
        yearly_key.putString("yearly_key", yearly);
        img_thumbnail.setImageResource(image);


        //Fragment List
        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        appBarLayout = (AppBarLayout) findViewById(R.id.appBar_id);
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());
        FragmentDaily fragmentDaily =  new FragmentDaily();
        FragmentWeekly fragmentWeekly = new FragmentWeekly();
        FragmentMonthly fragmentMonthly = new FragmentMonthly();
        FragmentYearly fragmentYearly = new FragmentYearly();
        adapter.AddFragment(fragmentDaily, "Daily");
        adapter.AddFragment(fragmentWeekly, "Weekly");
        adapter.AddFragment(fragmentMonthly, "Monthly");
        adapter.AddFragment(fragmentYearly, "Yearly");
        fragmentDaily.setArguments(daily_key);
        fragmentWeekly.setArguments(weekly_key);
        fragmentMonthly.setArguments(monthly_key);
        fragmentYearly.setArguments(yearly_key);
        //adapter Setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

//    public void FragmentList() {
//        //Fragment
//        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
//        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
//        appBarLayout = (AppBarLayout) findViewById(R.id.appBar_id);
//        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());
//        adapter.AddFragment(new FragmentDaily(), "Daily");
//        adapter.AddFragment(new FragmentWeekly(), "Weekly");
//        adapter.AddFragment(new FragmentMonthly(), "Monthly");
//        adapter.AddFragment(new FragmentYearly(), "Yearly");
//        //adapter Setup
//        viewPager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(viewPager);
//    }


}
