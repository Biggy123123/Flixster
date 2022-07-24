package com.morisseau.flixster.Models;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    String backdropPath;
    String posterPath;
    String title;
    String overview;

    public Movie(@NonNull JSONObject JsonObject) throws JSONException {
        backdropPath=JsonObject.getString("backdrop_path");
        posterPath=JsonObject.getString("poster_path");
        title=JsonObject.getString("title");
        overview=JsonObject.getString("overview");
    }

    @NonNull
    public static List<Movie>FromJsonArray(@NonNull JSONArray movieJsonArray)throws JSONException{
        List<Movie> movie=new ArrayList<>();
        for (int i=0; i<movieJsonArray.length(); i++){
            movie.add(new Movie(movieJsonArray.getJSONObject(i)));

        }
        return movie;
    }
    public String getBackdropPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);

    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}






