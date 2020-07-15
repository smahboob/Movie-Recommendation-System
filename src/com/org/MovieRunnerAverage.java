package com.org;

import java.util.ArrayList;
import java.util.*;

public class MovieRunnerAverage{
    
    public static void printAverageRatings(){
        SecondRatings sr = new SecondRatings("data/ratedmovies_short.csv", "data/ratings_short.csv");
        int movieSize = sr.getMovieSize();
        int raterSize = sr.getRaterSize();

        System.out.println("Total movies read from file: " + movieSize);
        System.out.println("Total raters read from file: " + raterSize);

        ArrayList<Rating> out = sr.getAverageRatings(3);
        Collections.sort(out);
        for(Rating r: out){
            String title = sr.getTitle(r.getItem());
            Double rating = r.getValue();
            System.out.println(rating  + " " +  title);
        }

    }

    public static void getAverageRatingOneMovie(){
        SecondRatings sr = new SecondRatings("data/ratedmovies_short.csv", "data/ratings_short.csv");
        ArrayList<Rating> ratingList = sr.getAverageRatings(1);
        String movieName = "The Godfather";

        for(Rating r: ratingList){
            String title = sr.getTitle(r.getItem());
            if(title.equals(movieName)){
                System.out.println(r.getValue());
                break;
            }
        }
    }

    public static void main(String[] args) {
        printAverageRatings();
        getAverageRatingOneMovie();
    }
}