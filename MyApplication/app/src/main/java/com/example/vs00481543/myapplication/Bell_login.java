package com.example.vs00481543.myapplication;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Bell_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bell_login);
    }

    public void gotopage(View v)
    {
        EditText edit_user=(EditText) findViewById(R.id.text_user);
        EditText edit_pass=(EditText) findViewById(R.id.text_pass);
        String us=edit_user.getText().toString();
        String pa=edit_pass.getText().toString();
        if(us.equals("vishal044")&&pa.equals("Vishal@123")) {
            Intent act2 = new Intent(this, MainActivity.class);
            startActivity(act2);
        }
        else
        {
            Snackbar.make((LinearLayout) findViewById(R.id.main_layout_bell),"Wrong Username or Password , Enter again",Snackbar.LENGTH_SHORT).show();
        }
    }

}


