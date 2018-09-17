package com.example.aslan.horoscope;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentYearly extends Fragment {
    View view;;

    public FragmentYearly() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.yearly_fragment, container, false);
        TextView yearly_text = (TextView) view.findViewById(R.id.yearly_zodic);

        Bundle bundle = getArguments();
        String yearly_desc = bundle.getString("yearly_key");
        yearly_text.setText(yearly_desc);
        return view;
    }
}
