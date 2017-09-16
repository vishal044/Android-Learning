package com.example.vs00481543.jsondemo2;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ArrayList<HashMap<String,String>> contactJsonList;
    private ListView listView;
    ProgressDialog progressDialog;
    private static String jsonUrl="https://api.myjson.com/bins/31b8v";
    private String TAG="JsonDemo2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactJsonList=new ArrayList<>();
        listView=(ListView) findViewById(R.id.list1);
        new GetContacts().execute();
    }


    private class GetContacts extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog=new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Ek mint...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }


        @Override
        protected Void doInBackground(Void... params) {
            HttpHandler httpHander=new HttpHandler();
            String jsonString=httpHander.makeServiceCall(jsonUrl);
            Log.e(TAG,"Response from url: " + jsonString);

            if(jsonString!=null)
            {
                try{
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
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (progressDialog.isShowing())
                progressDialog.dismiss();

            ListAdapter listAdapter=new SimpleAdapter(MainActivity.this,contactJsonList,R.layout.list_items,
                    new String[]{"name", "email", "mobile"}, new int[]{R.id.name,
                    R.id.email, R.id.mobile});

            listView.setAdapter(listAdapter);
        }
    }

}
