package com.example.vs00481543.recyclerfragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by VS00481543 on 26-07-2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    List<Movie> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title,genre,year;

        public MyViewHolder(View view)
        {
            super(view);
            title=(TextView) view.findViewById(R.id.text1);
            genre=(TextView) view.findViewById(R.id.text2);
            year=(TextView) view.findViewById(R.id.text3);
        }
    }

    public MoviesAdapter(List<Movie> moviesList)
    {
        this.moviesList=moviesList;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.moview_list,parent,false);
        return new MyViewHolder(itemView);
    }

    public void onBindViewHolder(MyViewHolder holder,int position)
    {
        Movie movie=moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
    }

    public int getItemCount()
    {
        return moviesList.size();
    }
}
