package com.example.vs00481543.fragmentexample2;

import android.os.Bundle;
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

public class FragmentClass extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        final View view=inflater.inflate(R.layout.fragment_ex,container,false);
        Button but=(Button) view.findViewById(R.id.buttonfrag);

        but.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(getActivity(),"Fragment Click",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
