package com.example.aslan.horoscope;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Horoscope> mData;

    public RecyclerViewAdapter(Context mContext, List<Horoscope> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.cardview_item, parent, false);
        final HoroscopeJsonAPI jsonAPI = new HoroscopeJsonAPI();
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.cv_cardviewID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, HoroscopeActivity.class);
                intent.putExtra("Title", mData.get(viewHolder.getAdapterPosition()).getTitle());
                intent.putExtra("daily_horoscope", mData.get(viewHolder.getAdapterPosition()).getDailyDesc());
                intent.putExtra("weekly_horoscope", mData.get(viewHolder.getAdapterPosition()).getWeeklyDesc());
                intent.putExtra("monthly_horoscope", mData.get(viewHolder.getAdapterPosition()).getMonthlyDesc());
                intent.putExtra("yearly_horoscope", mData.get(viewHolder.getAdapterPosition()).getYeaerlyDesc());
                intent.putExtra("date_horoscope", mData.get(viewHolder.getAdapterPosition()).getDate());
                intent.putExtra("Thumbnail", mData.get(viewHolder.getAdapterPosition()).getThumbnail());
                //viewHolder.tabLayout.setOnTabSelectedListener();
                mContext.startActivity(intent);
            }
        });

        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv_hTitle.setText(mData.get(position).getTitle());
        holder.img_hThumbnail.setImageResource(mData.get(position).getThumbnail());
//        holder.cv_cardviewID.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, HoroscopeActivity.class);
//                intent.putExtra("Title", mData.get(position).getTitle());
//                intent.putExtra("daily_horoscope", mData.get(position).getDailyDesc());
//                intent.putExtra("date_horoscope", mData.get(position).getDate());
//                intent.putExtra("Thumbnail", mData.get(position).getThumbnail());
//                mContext.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_hTitle;
        TextView tv_hDailyDesc;
        TextView tv_hMonthlyDesc;
        TextView tv_hWeeklyDesc;
        TextView tv_hYearlyDesc;
        TextView tv_hDate;
        ImageView img_hThumbnail;
        CardView cv_cardviewID;
        ViewPager viewPager;
        TabLayout tabLayout;
        HoroscopeJsonAPI jsonAPI;

        public MyViewHolder(View itemView) {
            super(itemView);
            jsonAPI = new HoroscopeJsonAPI();
            tv_hTitle = (TextView) itemView.findViewById(R.id.horoscope_title_id);
            tv_hDate = (TextView) itemView.findViewById(R.id.date_hid);
            tv_hDailyDesc = (TextView) itemView.findViewById(R.id.daily_zodic);
            tv_hWeeklyDesc = (TextView) itemView.findViewById(R.id.weekly_zodic);
            tv_hMonthlyDesc = (TextView) itemView.findViewById(R.id.monthly_zodic);
            tv_hYearlyDesc = (TextView) itemView.findViewById(R.id.yearly_zodic);
            img_hThumbnail = (ImageView) itemView.findViewById(R.id.horoscope_img_id);
            cv_cardviewID = (CardView) itemView.findViewById(R.id.cardview_id);
            tabLayout = (TabLayout) itemView.findViewById(R.id.tablayout_id);

        }
    }


}
