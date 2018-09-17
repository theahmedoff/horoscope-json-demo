package com.example.aslan.horoscope;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentMonthly extends Fragment {
    View view;

    public FragmentMonthly() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.monthly_fragment, container, false);
        TextView monthly_text =(TextView) view.findViewById(R.id.monthly_zodic);

        Bundle bundle = getArguments();
        String monthlydesc = bundle.getString("monthly_key");
        monthly_text.setText(monthlydesc);
        return view;
    }
}
