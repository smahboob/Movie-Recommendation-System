package com.org;

import java.util.*;


public class MovieRunnerSimilarRatings{

    public static void printAverageRatings(){

        FourthRatings fourthRatings = new FourthRatings();

        RaterDatabase.initialize("ratings_short.csv");
        MovieDatabase.initialize("ratedmovies_short.csv");

        int movieSize = MovieDatabase.size();
        int raterSize = RaterDatabase.size();

        System.out.println("Total raters read from file: " + raterSize);
        System.out.println("Total movies read from file: " + movieSize);


        ArrayList<Rating> result = fourthRatings.getAverageRatings(1);
        Collections.sort(result);
        System.out.println("Number of movies found: " +  result.size());

        for(Rating r: result){
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
        }

    }

    public static void printAverageRatingsByYearAfterAndGenre(){

        FourthRatings fourthRatings = new FourthRatings();

        RaterDatabase.initialize("ratings_short.csv");
        MovieDatabase.initialize("ratedmovies_short.csv");

        int movieSize = MovieDatabase.size();
        int raterSize = RaterDatabase.size();

        System.out.println("Total raters read from file: " + raterSize);
        System.out.println("Total movies read from file: " + movieSize);

        AllFilters af = new AllFilters();
        YearAfterFilter yf = new YearAfterFilter(1980);
        GenreFilter gf = new GenreFilter("Romance");
        af.addFilter(yf);
        af.addFilter(gf);

        ArrayList<Rating> result = fourthRatings.getAverageRatingsByFilter(af, 1);
        Collections.sort(result);

        for(Rating r: result){
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
            System.out.println("  Genere: " + MovieDatabase.getGenres(r.getItem()));
            System.out.println("  Year: " + MovieDatabase.getYear(r.getItem()));

        }
    }

    public static void printSimilarRatings(){
        FourthRatings fourthRatings = new FourthRatings();

        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");

        int movieSize = MovieDatabase.size();
        int raterSize = RaterDatabase.size();

        System.out.println("Total raters read from file: " + raterSize);
        System.out.println("Total movies read from file: " + movieSize);

        ArrayList<Rating> out = fourthRatings.getSimilarRatings("65", 20, 5);
        for(Rating r : out){
            System.out.println(MovieDatabase.getTitle(r.getItem()) + " " + r.getValue());
        }
    }

    public static void printSimilarRatingsByGenre() {
        FourthRatings fourthRatings = new FourthRatings();

        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");

        int movieSize = MovieDatabase.size();
        int raterSize = RaterDatabase.size();

        System.out.println("Total raters read from file: " + raterSize);
        System.out.println("Total movies read from file: " + movieSize);


        AllFilters filter = new AllFilters();
        filter.addFilter(new GenreFilter("Action"));  

        ArrayList<Rating> out = fourthRatings.getSimilarRatingsByFilter("65", 20, 5, filter);
        
        for(Rating r : out){
            System.out.println(MovieDatabase.getTitle(r.getItem()) + " " + r.getValue());
        }
    }


    public static void printSimilarRatingsByDirector() {
        FourthRatings fourthRatings = new FourthRatings();

        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");

        int movieSize = MovieDatabase.size();
        int raterSize = RaterDatabase.size();

        System.out.println("Total raters read from file: " + raterSize);
        System.out.println("Total movies read from file: " + movieSize);
        
        AllFilters filter = new AllFilters();
        filter.addFilter(new DirectorsFilter("Clint Eastwood,Sydney Pollack,David Cronenberg,Oliver Stone"));        
        ArrayList<Rating> out = fourthRatings.getSimilarRatingsByFilter("1034", 10, 3, filter);
        
        for(Rating r : out){
            System.out.println(MovieDatabase.getTitle(r.getItem()) + " " + r.getValue());
        }                 
    } 
    
    public static void printSimilarRatingsByGenreAndMinutes() {
        FourthRatings fourthRatings = new FourthRatings();

        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");

        int movieSize = MovieDatabase.size();
        int raterSize = RaterDatabase.size();

        System.out.println("Total raters read from file: " + raterSize);
        System.out.println("Total movies read from file: " + movieSize);
        
        AllFilters filter = new AllFilters();
        filter.addFilter(new MinutesFilter(80,160));        
        filter.addFilter(new GenreFilter("Drama")); 
        ArrayList<Rating> out = fourthRatings.getSimilarRatingsByFilter("65", 20, 5, filter);
        
        for(Rating r : out){
            System.out.println(MovieDatabase.getTitle(r.getItem()) + " " + r.getValue());
        }               
    }     

    public static void printSimilarRatingsByYearAfterAndMinutes() {
        FourthRatings fourthRatings = new FourthRatings();

        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");

        int movieSize = MovieDatabase.size();
        int raterSize = RaterDatabase.size();

        System.out.println("Total raters read from file: " + raterSize);
        System.out.println("Total movies read from file: " + movieSize);
        
        AllFilters filter = new AllFilters();
        filter.addFilter(new YearAfterFilter(1975));
        filter.addFilter(new MinutesFilter(70,200)); 

        ArrayList<Rating> out = fourthRatings.getSimilarRatingsByFilter("65", 20, 5, filter);
        
        for(Rating r : out){
            System.out.println(MovieDatabase.getTitle(r.getItem()) + " " + r.getValue());
        }     
    } 



    public static void main(String[] args) {
        //printSimilarRatings();
        //printSimilarRatingsByGenre();
        printSimilarRatingsByDirector();
    }




}
    