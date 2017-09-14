package com.example.vs00481543.fragmentexample;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by VS00481543 on 24-07-2017.
 */

public class FirstFragment extends Fragment {

    View view;
    Button firstbutton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        view=inflater.inflate(R.layout.first_fragment,container,false);

        firstbutton=(Button) view.findViewById(R.id.firstbutton);
        firstbutton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Snackbar.make((LinearLayout) view.findViewById(R.id.firstid),"First fragment",Snackbar.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
