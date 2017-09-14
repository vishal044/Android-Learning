package com.example.vs00481543.fragmentdifferent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

/**
 * Created by VS00481543 on 31-07-2017.
 */

public class FragmentClass extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        final View view= inflater.inflate(R.layout.fragment_top,container,false);

        return view;

    }
}
