package com.example.vs00481543.jsonsharepref;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by VS00481543 on 14-09-2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    ArrayList<HashMap<String,String>> contactJsonList;
    Context context;


    public UserAdapter(ArrayList<HashMap<String,String>> contactJsonList, Context context)
    {
        this.contactJsonList=contactJsonList;
        this.context=context;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,email,mobile;
        public MyViewHolder(View itemView) {
            super(itemView);

            name=(TextView) itemView.findViewById(R.id.name);
            email=(TextView) itemView.findViewById(R.id.email);
            mobile=(TextView) itemView.findViewById(R.id.mobile);

        }

        public void bind(final int position)
        {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(context,Main2Activity.class);
                    intent.putExtra("name",contactJsonList.get(position).get("name"));
                    intent.putExtra("position",position);
                    context.startActivity(intent);

                    //Toast.makeText(context,contactJsonList.get(position).get("name")+" is at position "+position,Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());

        return new MyViewHolder(layoutInflater.inflate(R.layout.list_view,parent,false));
    }

    @Override
    public void onBindViewHolder(UserAdapter.MyViewHolder holder, int position) {

        holder.bind(position);

        holder.name.setText(contactJsonList.get(position).get("name"));
        holder.email.setText(contactJsonList.get(position).get("email"));
        holder.mobile.setText(contactJsonList.get(position).get("mobile"));
    }

    @Override
    public int getItemCount() {
        return contactJsonList.size();
    }
}
