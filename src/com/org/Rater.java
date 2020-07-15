package com.org;

import java.util.*;


public interface Rater{

    public void addRating(String item, double rating);
    public boolean hasRating(String item);
    public double getRating(String item);
    public String getID();
    public int numRatings();
    public ArrayList<String> getItemsRated();

}