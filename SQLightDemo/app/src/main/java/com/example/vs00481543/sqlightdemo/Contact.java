package com.example.vs00481543.sqlightdemo;

/**
 * Created by VS00481543 on 21-09-2017.
 */

public class Contact {

    private int id;
    private String name;
    private String phoneNum;

    public Contact()
    {

    }

    public Contact(int id,String name,String phoneNum)
    {
        this.id=id;
        this.name=name;
        this.phoneNum=phoneNum;
    }

    public Contact(String name,String phoneNum)
    {
        this.name=name;
        this.phoneNum=phoneNum;
    }

    public void setId(int id)
    {
        this.id=id;
    }

    public int getId()
    {
        return this.id;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setPhoneNum(String phoneNum)
    {
        this.phoneNum=phoneNum;
    }

    public String getPhoneNum()
    {
        return this.phoneNum;
    }

}
