package com.example.aslan.horoscope;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentDaily extends Fragment {
    View view;
    public FragmentDaily() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.daily_fragment, container, false);
        TextView daily_text =(TextView) view.findViewById(R.id.daily_zodic);

        Bundle bundle = getArguments();
        String dailydesc = bundle.getString("daily_key");

        daily_text.setText(dailydesc);
        return view;

    }
}
