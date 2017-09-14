package com.example.vs00481543.fragmentexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button but1=(Button) findViewById(R.id.button1);
        final Button but2=(Button) findViewById(R.id.button2);

        but1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                loadFragment(new FirstFragment());
            }
        });

        but2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                loadFragment(new SecondFragment());
            }
        });

    }

    public void loadFragment(Fragment fragment)
    {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction fragtran=fm.beginTransaction();
        fragtran.replace(R.id.frame1,fragment);
        fragtran.commit();
    }
}
