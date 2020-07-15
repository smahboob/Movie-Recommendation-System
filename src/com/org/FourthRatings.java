package com.org;


import java.util.*;

public class FourthRatings {


    public FourthRatings() {
        this("ratings.csv");
    } 
    
    public FourthRatings(String ratingsfile) {
        RaterDatabase.initialize(ratingsfile);        
    }    

    private Double getAverageByID(String movieId, int minimalRaters){
        Double sum = 0.0;
        Double count = 0.0;

    
        for(Rater r: RaterDatabase.getRaters()){
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

    private ArrayList<Rating> getSimilarities(String id){
        ArrayList<Rating> result = new ArrayList<Rating>();
        Rater me = RaterDatabase.getRater(id);
        for(Rater r: RaterDatabase.getRaters()){
            if(!r.getID().equals(id)){
                double dot_product = dotProduct(me, r);
                if(dot_product > 0){
                    result.add(new Rating(r.getID(), dot_product));
                }
            }
        }

        Collections.sort(result, Collections.reverseOrder());
        return result;
    }

    //closeness in the vector space
    private double dotProduct(Rater me, Rater r) {
        double dotProduct = 0.0;
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());

        for(String item : movies) {
            if(me.hasRating(item) && r.hasRating(item)){
                dotProduct = dotProduct + (me.getRating(item)-5)*(r.getRating(item)-5);
            }            
        }

        return dotProduct;
    }

    private double getSimilarAverageByID(String id, int minimalRaters, ArrayList<Rating> similarityRating) {
        double average = 0.0;
        double allRating = 0.0;
        int ratingsNum = ratingsNum(id, RaterDatabase.getRaters(), similarityRating);
            
            if(ratingsNum >= minimalRaters){
                for(Rating r : similarityRating) {
                    Rater rater = RaterDatabase.getRater(r.getItem());
                    if(rater.hasRating(id)) {
                        allRating = allRating + rater.getRating(id)*r.getValue();
                    }
                }                
                
            }else{
               return average;
            }
        average = allRating / ratingsNum;
        return average;
    }  

    public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRaters, int minimalRaters) {
        ArrayList<Rating> aveRating = new ArrayList<Rating>();
        
        ArrayList<Rating> similarityRating = new ArrayList<Rating>(getSimilarities(id).subList(0,numSimilarRaters));
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        
        for(String movieID : movies) {            
            double average = getSimilarAverageByID(movieID,minimalRaters,similarityRating);
            if(average != 0.0) {
               Rating rating = new Rating(movieID, average);
               aveRating.add(rating);  
            }            
        }         
        
        Collections.sort(aveRating, Collections.reverseOrder());
        return aveRating;
    }

    public ArrayList<Rating> getSimilarRatingsByFilter(String id, int numSimilarRaters, int minimalRaters, Filter filterCriteria) {
        ArrayList<Rating> aveRating = new ArrayList<Rating>();
        ArrayList<Rating> similarityRating = new ArrayList<Rating>(getSimilarities(id).subList(0,numSimilarRaters));
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        
        for(String movieID : movies) {            
            double average = getSimilarAverageByID(movieID,minimalRaters,similarityRating);
            if(average != 0.0) {
               Rating rating = new Rating(movieID, average);
               aveRating.add(rating);  
            }            
        }         
        
        Collections.sort(aveRating, Collections.reverseOrder());
        return aveRating;
    }    
    
    private int ratingsNum(String item, ArrayList<Rater> listOfRaters, ArrayList<Rating> similarityRating) {
        int ratingsNum = 0;
        for(Rater rater : listOfRaters) {
            if(rater.hasRating(item) && isInSimilar(rater, similarityRating)){
                ratingsNum ++;
            }
        }
        return ratingsNum;
    }    
    
    private boolean isInSimilar(Rater rater, ArrayList<Rating> similarityRating){

        for(Rating r : similarityRating){
            if(r.getItem().equals(rater.getID())){
                return true;
            }
        }
        return false;
    }

}