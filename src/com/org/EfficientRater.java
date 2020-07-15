package com.org;


import java.util.*;
import java.util.HashMap;

public class EfficientRater implements Rater{
    
    private String myID; //this is the id of the rater not the imdb_movie id like other classes 
    private HashMap<String,Rating> myRatings;  // an arraylist of ratings

    public EfficientRater(String id) {
        myID = id;
        myRatings = new HashMap<String,Rating>();
    }

    //a new rating is created and added to the myratings
    // itme = IMDB ID of the movie being rated

    public void addRating(String item, double rating) {
        Rating r = new Rating(item,rating);
        myRatings.put(item,r);
    }


    public boolean hasRating(String item) {
        return myRatings.containsKey(item);        

    }

    public String getID() {
        return myID;
    }

    public double getRating(String item) {

        if(hasRating(item)){
            return myRatings.get(item).getValue();
        }        
        return -1;
    }

    //number of ratings this rater has
    public int numRatings() {
        return myRatings.size();
    }

    /*This method returns an ArrayList of Strings representing a list of all 
    the items that have been rated.*/

    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String>(myRatings.keySet());        
        return list;
    }
}
