package com.org;


import java.util.*;

public class ThirdRatings {

    private ArrayList<Rater> myRaters;
    
    public ThirdRatings() {
        this("data/ratings.csv");
    }

    public ThirdRatings(String ratingFile){
        FirstRatings a = new FirstRatings();
        myRaters = a.loadRaters(ratingFile);
    }
    
    
    public int getRaterSize(){
        return myRaters.size();
    }

    private Double getAverageByID(String movieId, int minimalRaters){
        Double sum = 0.0;
        Double count = 0.0;
        for(Rater r: myRaters){
            Double rating  = r.getRating(movieId);
            if(rating != -1){
                sum = sum + rating;
                count++;
            }
        }

        if(count >= minimalRaters){
            return (sum/count);
        }

        return 0.0;
    }

    public ArrayList<Rating> getAverageRatings(int minimalRaters){
        ArrayList<Rating> result = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());

        for(String movieID: movies){
            Double rating = getAverageByID(movieID, minimalRaters);
            if(rating != 0.0){
                result.add(new Rating(movieID,rating));
            }
        }

        return result;
    }   


    public ArrayList<Rating> getAverageRatingsByFilter(Filter filterCriteria, int minimalRaters){
        ArrayList<Rating> result = new ArrayList<Rating>();

        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        for(String movieID: movies){
            Double rating = getAverageByID(movieID, minimalRaters);
            if(rating != 0.0){
                result.add(new Rating(movieID,rating));
            }
        }

        return result;
    }

}