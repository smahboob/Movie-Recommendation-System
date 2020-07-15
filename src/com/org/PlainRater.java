package com.org;


import java.util.*;

public class PlainRater implements Rater{
    
    private String myID; //this is the id of the rater not the imdb_movie id like other classes 
    private ArrayList<Rating> myRatings;  // an arraylist of ratings

    public PlainRater(String id) {
        myID = id;
        myRatings = new ArrayList<Rating>();
    }

    //a new rating is created and added to the myratings
    // itme = IMDB ID of the movie being rated

    public void addRating(String item, double rating) {
        myRatings.add(new Rating(item,rating));
    }


    public boolean hasRating(String item) {
        for(int k=0; k < myRatings.size(); k++){
            if (myRatings.get(k).getItem().equals(item)){
                return true;
            }
        }
        
        return false;
    }

    public String getID() {
        return myID;
    }

    public double getRating(String item) {
        for(int k=0; k < myRatings.size(); k++){
            if (myRatings.get(k).getItem().equals(item)){
                return myRatings.get(k).getValue();
            }
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
        ArrayList<String> list = new ArrayList<String>();
        for(int k=0; k < myRatings.size(); k++){
            list.add(myRatings.get(k).getItem());
        }
        return list;
    }
}
