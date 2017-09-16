package com.example.vs00481543.jsonsharepref;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private static String jsonUrl="https://api.myjson.com/bins/31b8v";
    RecyclerView recyclerView;
    ArrayList<HashMap<String,String>> contactJsonList;
    ProgressDialog progressDialog;
    private static String TAG="JSONSHAREPREF";
    UserAdapter uAdapter;
    private SharedPreferencesHandler sharedPreferencesHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView=(RecyclerView) findViewById(R.id.recycler1);
        contactJsonList=new ArrayList<>();
        new GetContacts().execute();
    }


    private class GetContacts extends AsyncTask<String,String,String>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog=new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {

            HttpHandler httpHandler=new HttpHandler();
            String jsonString=httpHandler.makeServiceCall(jsonUrl);
            Log.e(TAG,"Response from url: " + jsonString);

            if(jsonString!=null)
            {
                try {
                    JSONObject jsonObject=new JSONObject(jsonString);
                    JSONArray contacts=jsonObject.getJSONArray("contacts");

                    for(int i=0;i<contacts.length();i++)
                    {
                        JSONObject c=contacts.getJSONObject(i);
                        String id=c.getString("id");
                        String name = c.getString("name");
                        String email = c.getString("email");
                        String address = c.getString("address");
                        String gender = c.getString("gender");

                        JSONObject phone = c.getJSONObject("phone");
                        String mobile = phone.getString("mobile");
                        String home = phone.getString("home");
                        String office = phone.getString("office");

                        HashMap<String,String> contact=new HashMap<>();

                        contact.put("id", id);
                        contact.put("name", name);
                        contact.put("email", email);
                        contact.put("mobile", mobile);

                        contactJsonList.add(contact);

                        int listSize=contactJsonList.size();

                        sharedPreferencesHandler=new SharedPreferencesHandler(MainActivity.this);
                        sharedPreferencesHandler.setIntPref("numOfContacts",listSize);
                        sharedPreferencesHandler.setStringPref("myName","Vishal");

                    }

                    Log.e(TAG, "doInBackground: "+contactJsonList.toString() );

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                Log.e(TAG, "Could not get json from server.");
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (progressDialog.isShowing())
                progressDialog.dismiss();

            uAdapter=new UserAdapter(contactJsonList,MainActivity.this);
            RecyclerView.LayoutManager uLayoutManager=new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(uLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(uAdapter);

        }
    }
}
