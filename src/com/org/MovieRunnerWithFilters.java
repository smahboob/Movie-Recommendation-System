package com.org;

import java.util.*;


public class MovieRunnerWithFilters{

    public static void printAverageRatings(){
        ThirdRatings thirdRating = new ThirdRatings("data/ratings_short.csv");
        int raterSize = thirdRating.getRaterSize();

        MovieDatabase.initialize("ratedmovies_short.csv");
        int movieSize = MovieDatabase.size();

        System.out.println("Total raters read from file: " + raterSize);
        System.out.println("Total movies read from file: " + movieSize);

        ArrayList<Rating> result = thirdRating.getAverageRatings(1);
        Collections.sort(result);
        System.out.println("Number of movies found: " +  result.size());

        for(Rating r: result){
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
        }

    }

    public static void printAverageRatingsByYear(){
        ThirdRatings thirdRating = new ThirdRatings("data/ratings_short.csv");
       // YearAfterFilter yf = new YearAfterFilter(2000);
       // GenreFilter gf = new GenreFilter("Crime");
       // MinutesFilter mf = new MinutesFilter(110, 170);
        DirectorsFilter df = new DirectorsFilter("Charles Chaplin,Michael Mann,Spike Jonze");
        MovieDatabase.initialize("ratedmovies_short.csv");
        int raterSize = thirdRating.getRaterSize();
        int movieSize = MovieDatabase.size();

        ArrayList<Rating> result = thirdRating.getAverageRatingsByFilter(df, 1);
        Collections.sort(result);

        System.out.println("Total raters read from file: " + raterSize);
        System.out.println("Total movies read from file: " + movieSize);
        System.out.println("Number of movies found: " +  result.size());
        
        for(Rating r: result){
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
            System.out.println("     " + MovieDatabase.getDirector(r.getItem()));
        }
    }

    public static void printAverageRatingsByYearAfterAndGenre(){
        ThirdRatings thirdRating = new ThirdRatings("data/ratings_short.csv");
        MovieDatabase.initialize("ratedmovies_short.csv");

        AllFilters af = new AllFilters();
        YearAfterFilter yf = new YearAfterFilter(1980);
        GenreFilter gf = new GenreFilter("Romance");
        af.addFilter(yf);
        af.addFilter(gf);

        ArrayList<Rating> result = thirdRating.getAverageRatingsByFilter(af, 1);
        Collections.sort(result);

        for(Rating r: result){
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
            System.out.println("  Genere: " + MovieDatabase.getGenres(r.getItem()));
            System.out.println("  Year: " + MovieDatabase.getYear(r.getItem()));

        }
    }


    public static void printAverageRatingsByDirectorsAndMinutes(){
        ThirdRatings thirdRating = new ThirdRatings("data/ratings_short.csv");
        MovieDatabase.initialize("ratedmovies_short.csv");

        AllFilters af = new AllFilters();
        MinutesFilter yf = new MinutesFilter(30,170);
        DirectorsFilter gf = new DirectorsFilter("Spike Jonze,Michael Mann,Charles Chaplin,Francis Ford Coppola");
        af.addFilter(yf);
        af.addFilter(gf);

        ArrayList<Rating> result = thirdRating.getAverageRatingsByFilter(af, 1);
        Collections.sort(result);

        for(Rating r: result){
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
            System.out.println("  Minutes: " + MovieDatabase.getMinutes(r.getItem()));
            System.out.println("  Directors: " + MovieDatabase.getDirector(r.getItem()));

        }
    }

    public static void main(String[] args) {
        //printAverageRatings();
        //printAverageRatingsByYear();
        //printAverageRatingsByYearAfterAndGenre();
        printAverageRatingsByDirectorsAndMinutes();
    }
}