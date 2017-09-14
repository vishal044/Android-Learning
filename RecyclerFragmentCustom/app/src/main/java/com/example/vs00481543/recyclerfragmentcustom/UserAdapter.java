package com.example.vs00481543.recyclerfragmentcustom;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by VS00481543 on 26-07-2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private Context mContext;

    public UserAdapter(List<UserDetails> userDetailsList, onItemClickListener onItemClickListener) {
    }

    public interface onItemClickListener
    {
        public void onItemClick(View view,int position);
    }


    List<UserDetails> userDetailsList;
    private onItemClickListener listener=null;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView name,age,city,even;

        public MyViewHolder(View view)
        {
            super(view);
            name=(TextView) view.findViewById(R.id.text_name);
            age=(TextView) view.findViewById(R.id.text_age);
            city=(TextView) view.findViewById(R.id.text_city);
            even=(TextView) view.findViewById(R.id.text_even);
        }

        public void bind(final UserDetails userDetailsList, final onItemClickListener listener, final int pos) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Toast.makeText(mContext,userDetailsList.getName()+" is at position "+pos,Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

        public UserAdapter(Context context, List<UserDetails> userDetailsList, onItemClickListener listener)
    {
        mContext=context;
        this.userDetailsList=userDetailsList;
        this.listener=listener;
    }

    @Override
    public int getItemViewType(int position) {
        UserDetails ud=userDetailsList.get(position);
        int ages=ud.getAge();
        if(ages%2==0)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        /*View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list, parent, false);
        return new MyViewHolder(itemView);*/

        MyViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType)
        {
            case 0:
                View v1= inflater.inflate(R.layout.user_list, parent, false);
                viewHolder= new MyViewHolder(v1);
                break;
            case 1:
                View v2= inflater.inflate(R.layout.user_list_odd, parent, false);
                viewHolder= new MyViewHolder(v2);
                break;
        }
            return viewHolder;
    }

    public void onBindViewHolder (MyViewHolder holder,int position)
    {
        UserDetails userdetails=userDetailsList.get(position);
        holder.bind(userdetails,listener,position);
        switch(holder.getItemViewType() )
        {
            case 0:
                holder.name.setText(userdetails.getName());
                holder.age.setText(userdetails.getAge()+"");
                holder.city.setText(userdetails.getCity());
                holder.even.setText("Even");
                break;
            case 1:
                holder.name.setText(userdetails.getName());
                holder.age.setText(userdetails.getAge()+"");
                holder.city.setText(userdetails.getCity());
                break;
        }
    }

    public int getItemCount()
    {
        return userDetailsList.size();
    }




}
