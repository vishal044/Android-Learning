package com.example.vs00481543.recyclerfragment;

/**
 * Created by VS00481543 on 26-07-2017.
 */

public class Movie {

    private String title,genre,year;

    Movie()
    {

    }

    Movie(String title,String genre,String year)
    {
        this.title=title;
        this.genre=genre;
        this.year=year;
    }

    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title=title;
    }


    public String getGenre()
    {
        return genre;
    }
    public void setGenre(String genre)
    {
        this.genre=genre;
    }


    public String getYear()
    {
        return year;
    }
    public void setYear(String year)
    {
        this.year=year;
    }
}
