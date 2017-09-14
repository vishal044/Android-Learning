package com.example.vs00481543.recyclerfragmentcustom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<UserDetails> userDetailsList=new ArrayList<>();
    private RecyclerView recyclerView;
    private UserAdapter uAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        uAdapter=new UserAdapter(this, userDetailsList, new UserAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
        RecyclerView.LayoutManager uLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(uLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(uAdapter);

        prepareUserData();
    }

    private void prepareUserData()
    {
        UserDetails userDetails=new UserDetails("Vishal",23,"Chandigarh");
        userDetailsList.add(userDetails);

        userDetails=new UserDetails("Sahiba",26,"Pkl");
        userDetailsList.add(userDetails);

        userDetails=new UserDetails("Lovy",27,"Chandigarh");
        userDetailsList.add(userDetails);

        userDetails=new UserDetails("gaurav",30,"Radaur");
        userDetailsList.add(userDetails);

        userDetails=new UserDetails("fdsfs",23,"gdfgd");
        userDetailsList.add(userDetails);

        userDetails=new UserDetails("Vishal",23,"Chandigarh");
        userDetailsList.add(userDetails);

        userDetails=new UserDetails("Vishal",26,"Chandigarh");
        userDetailsList.add(userDetails);

        userDetails=new UserDetails("Vishal",23,"Chandigarh");
        userDetailsList.add(userDetails);

        userDetails=new UserDetails("Vishal",23,"Chandigarh");
        userDetailsList.add(userDetails);

        userDetails=new UserDetails("Vishal",23,"Chandigarh");
        userDetailsList.add(userDetails);

        userDetails=new UserDetails("fdsfs",23,"gdfgd");
        userDetailsList.add(userDetails);

        userDetails=new UserDetails("Vishal",23,"Chandigarh");
        userDetailsList.add(userDetails);

        userDetails=new UserDetails("Vishal",26,"Chandigarh");
        userDetailsList.add(userDetails);

        userDetails=new UserDetails("Vishal",23,"Chandigarh");
        userDetailsList.add(userDetails);

        userDetails=new UserDetails("Vishal",23,"Chandigarh");
        userDetailsList.add(userDetails);

        userDetails=new UserDetails("Vishal",23,"Chandigarh");
        userDetailsList.add(userDetails);

        userDetails=new UserDetails("fdsfs",23,"gdfgd");
        userDetailsList.add(userDetails);

        userDetails=new UserDetails("Vishal",23,"Chandigarh");
        userDetailsList.add(userDetails);

        userDetails=new UserDetails("Vishal",26,"Chandigarh");
        userDetailsList.add(userDetails);

        userDetails=new UserDetails("Vishal",23,"Chandigarh");
        userDetailsList.add(userDetails);

        userDetails=new UserDetails("Vishal",23,"Chandigarh");
        userDetailsList.add(userDetails);

        userDetails=new UserDetails("Vishal",23,"Chandigarh");
        userDetailsList.add(userDetails);

        uAdapter.notifyDataSetChanged();
    }



    public void onStart()
    {
        super.onStart();


    }

}
