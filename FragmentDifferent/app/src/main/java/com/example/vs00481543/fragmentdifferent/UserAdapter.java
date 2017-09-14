package com.example.vs00481543.fragmentdifferent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by VS00481543 on 31-07-2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder>{


    private Context context;

    List<UserDevices> userDevicesList;

    public interface onItemClickListener
    {
        public void onItemCLick(View view,int position);
    }

    private onItemClickListener listener=null;

    public UserAdapter(List<UserDevices> userDevicesList,onItemClickListener listener,Context context)
    {
        this.userDevicesList=userDevicesList;
        this.listener=listener;
        this.context=context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView device,data,bill,users,total;

        MyViewHolder(View view)
        {
            super(view);
            device=(TextView) view.findViewById(R.id.dev);
            data=(TextView) view.findViewById(R.id.dat);
            bill=(TextView) view.findViewById(R.id.pla);
            users=(TextView) view.findViewById(R.id.user);
            total=(TextView) view.findViewById(R.id.tot);
        }


        public void bind(final UserDevices userDevicesList, final onItemClickListener listener, final int pos) {


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {

                    String nam= userDevicesList.getDevice();

                    if(nam.equals("Phone")) {
                        Intent intent = null;
                        intent = new Intent(context, Main2Activity.class);
                        intent.putExtra("pos", pos);
                        intent.putExtra("dev", nam);
                        context.startActivity(intent);
                    }
                    else
                    {

                    }
                }
            });
        }

    }

    public int getItemViewType(int position)
    {
        UserDevices ud=userDevicesList.get(position);
        String devi=ud.getDevice();
        if(devi.equals("Phone"))
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {
        MyViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType)
        {
            case 0:
                View v1= inflater.inflate(R.layout.phone, parent, false);
                viewHolder= new MyViewHolder(v1);
                break;
            case 1:
                View v2= inflater.inflate(R.layout.tab, parent, false);
                viewHolder= new MyViewHolder(v2);
                break;
        }
        return viewHolder;
    }

    public void onBindViewHolder (MyViewHolder holder,int position)
    {
        UserDevices ud=userDevicesList.get(position);
        holder.bind(ud,listener,position);
        switch(holder.getItemViewType() )
        {
            case 0:
                holder.device.setText(ud.getDevice());
                holder.data.setText(ud.getData()+" GB");
                holder.bill.setText(ud.getBill());
                break;
            case 1:
                holder.device.setText("Device    : "+ud.getDevice());
                holder.data.setText("Data used : "+ud.getData()+" GB");
                holder.bill.setText("Bill      : "+ud.getBill());
                holder.users.setText("Users     : "+ud.getUsers()+"");
                holder.total.setText("Total users allowed : "+ud.getTotal()+"");
                break;
        }
    }

    public int getItemCount()
    {
        return userDevicesList.size();
    }

}
