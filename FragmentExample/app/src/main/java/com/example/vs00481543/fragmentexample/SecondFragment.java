package com.example.vs00481543.fragmentexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by VS00481543 on 24-07-2017.
 */

public class SecondFragment extends Fragment {

    View view;
    Button secondbutton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view=inflater.inflate(R.layout.second_fragment,container,false);

        secondbutton=(Button) view.findViewById(R.id.secondbutton);
        secondbutton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(getActivity(),"Second fragment",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
