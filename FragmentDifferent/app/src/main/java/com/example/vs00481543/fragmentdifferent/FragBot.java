package com.example.vs00481543.fragmentdifferent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by VS00481543 on 01-08-2017.
 */

public class FragBot extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        final View view= inflater.inflate(R.layout.fragment_bot,container,false);

      /*  String str=getArguments().getString("textBotNam");

        final TextView txtBot=(TextView) view.findViewById(R.id.botFrag);

        txtBot.setText(str);*/

        return view;

    }
}
