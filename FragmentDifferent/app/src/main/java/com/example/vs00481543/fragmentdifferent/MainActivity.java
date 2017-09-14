package com.example.vs00481543.fragmentdifferent;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private List<UserDevices> userDevicesList=new ArrayList<>();
    private RecyclerView recyclerView;
    private UserAdapter uAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        uAdapter= new UserAdapter(userDevicesList, new UserAdapter.onItemClickListener() {
            @Override
            public void onItemCLick(View view, int position) {


            }
        },this);

        RecyclerView.LayoutManager uLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(uLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(uAdapter);

        prepareUserData();
    }

public void prepareUserData()
{
    UserDevices userDevices=new UserDevices("Phone",50,"paid");
    userDevicesList.add(userDevices);

    userDevices=new UserDevices("Phone",50,"paid");
    userDevicesList.add(userDevices);

    userDevices=new UserDevices("Tab",50,"paid",3,5);
    userDevicesList.add(userDevices);

    userDevices=new UserDevices("Phone",50,"paid");
    userDevicesList.add(userDevices);

    userDevices=new UserDevices("Phone",50,"paid");
    userDevicesList.add(userDevices);

    userDevices=new UserDevices("Tab",50,"paid",4,6);
    userDevicesList.add(userDevices);

    userDevices=new UserDevices("Phone",50,"paid");
    userDevicesList.add(userDevices);

    userDevices=new UserDevices("Phone",50,"paid");
    userDevicesList.add(userDevices);
}

}
