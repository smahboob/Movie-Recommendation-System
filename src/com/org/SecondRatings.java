package com.org;


import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        this("data/ratedmoviesfull.csv", "data/ratings.csv");
    }

    public SecondRatings(String movieFile, String ratingFile){
        FirstRatings a = new FirstRatings();
        myMovies = a.loadMovies(movieFile);
        myRaters = a.loadRaters(ratingFile);
    }
    
    public int getMovieSize(){
        return myMovies.size();
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

        for(Movie m: myMovies){
            String movieID = m.getID();
            Double rating = getAverageByID(movieID, minimalRaters);
            if(rating != 0.0){
                result.add(new Rating(movieID,rating));
            }
        }

        return result;
    }   

    public String getTitle(String movieId){
        for (Movie m: myMovies){
            if(m.getID().equals(movieId)){
                return m.getTitle();
            }
        }

        return "ID: " + movieId + " not found";
    }

    public String getID(String movieTile){
        for(Movie m: myMovies){
            if(m.getTitle().equals(movieTile)){
                return m.getID();
            }
        }

        return "NO SUCH TITLE.";

    }

}