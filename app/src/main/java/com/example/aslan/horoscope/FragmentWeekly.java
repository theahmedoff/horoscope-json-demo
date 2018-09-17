package com.example.aslan.horoscope;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentWeekly extends Fragment {
    View view;

    public FragmentWeekly() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.weekly_fragment, container, false);
        TextView weekly_text = (TextView) view.findViewById(R.id.weekly_zodic);

        Bundle bundle = getArguments();
        String weeklydesc = bundle.getString("weekly_key");
        weekly_text.setText(weeklydesc);
        return view;
    }
}
