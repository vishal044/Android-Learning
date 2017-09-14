package com.example.vs00481543.recyclerfragmentcustom;

/**
 * Created by VS00481543 on 26-07-2017.
 */

public class UserDetails {

    private String name,city;
    private int age;

    UserDetails()
    {

    }

    UserDetails(String name,int age,String city)
    {
        this.name=name;
        this.age=age;
        this.city=city;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }

    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age=age;
    }

    public String getCity()
    {
        return city;
    }
    public void setCity(String city)
    {
        this.city=city;
    }
}
