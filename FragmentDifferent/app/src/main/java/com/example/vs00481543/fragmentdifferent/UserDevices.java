package com.example.vs00481543.fragmentdifferent;

/**
 * Created by VS00481543 on 31-07-2017.
 */

public class UserDevices {
    private String device,bill;
    private int data,users,total;

    UserDevices()
    {

    }

    UserDevices(String device, int data, String bill)
    {
        this.device=device;
        this.data=data;
        this.bill=bill;
    }

    UserDevices(String device, int data, String bill, int users, int total)
    {
        this.device=device;
        this.data=data;
        this.bill=bill;
        this.users=users;
        this.total=total;
    }

    public String getDevice()
    {
        return device;
    }

    public int getData()
    {
        return data;
    }

    public String getBill()
    {
        return bill;
    }

    public int getUsers()
    {
        return users;
    }

    public int getTotal()
    {
        return total;
    }
}
