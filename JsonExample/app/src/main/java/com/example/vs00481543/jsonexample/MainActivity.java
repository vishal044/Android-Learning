package com.example.vs00481543.jsonexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String name,sal;
    String JSON_STRING = "{\"employee\":{\"name\":\"Abc\",\"salary\":65000}}";
    TextView empName,empSal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empName=(TextView) findViewById(R.id.name);
        empSal=(TextView) findViewById(R.id.salary);

        try {
            JSONObject obj=new JSONObject(JSON_STRING);
            JSONObject employee=obj.getJSONObject("employee");
            name=employee.getString("name");
            sal=employee.getString("salary");

            empName.setText("Name :  "+name);
            empSal.setText("Salary :  "+sal);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
