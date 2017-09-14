package com.example.vs00481543.myapplication;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onStart() {
        super.onStart();

        final Button but = (Button) findViewById(R.id.button_logIn);
        final EditText et = (EditText) findViewById(R.id.editText_user);

        but.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Log.w(">>>>>>>>>>>>>>>>", "button clicked :" + et.getText().toString());
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);


                Snackbar.make((LinearLayout) findViewById(R.id.main_layout), et.getText().toString(), Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}

