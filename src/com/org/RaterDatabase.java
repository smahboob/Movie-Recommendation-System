package com.org;


import java.util.*;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.nio.file.Files;
import java.nio.file.Path; 
import java.nio.file.Paths;
import java.util.ArrayList; 


public class RaterDatabase {
    private static HashMap<String,Rater> ourRaters;
     
	private static void initialize() {
	    // this method is only called from addRatings 
		if (ourRaters == null) {
			ourRaters = new HashMap<String,Rater>();
		}
	}

    public static void initialize(String filename) {
 		if (ourRaters == null) {
 			ourRaters= new HashMap<String,Rater>();
 			addRatings("/Users/saadmahboob/eclipse-workspace/WebProject/data/" + filename);
 		}
 	}	
 	
    public static void addRatings(String filename) {
        initialize(); 
        Path pathToFile = Paths.get(filename);

        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {
            br.readLine();
            String line = br.readLine();

            while (line != null) {

                String[] attributes = line.split(",");

                String id = (attributes[0]);
                String item = String.valueOf(attributes[1]);
                Double rating = Double.parseDouble(attributes[2]);

                addRaterRating(id,item,rating);

                line = br.readLine();
            }
        }

        catch (IOException e){  
            e.printStackTrace();  
        }

    }
    
    public static void addRaterRating(String raterID, String movieID, double rating) {
        initialize(); 
        Rater rater =  null;
                if (ourRaters.containsKey(raterID)) {
                    rater = ourRaters.get(raterID); 
                } 
                else { 
                    rater = new EfficientRater(raterID);
                    ourRaters.put(raterID,rater);
                 }
                 rater.addRating(movieID,rating);
    } 
	         
    public static Rater getRater(String id) {
    	initialize();
    	
    	return ourRaters.get(id);
    }
    
    public static ArrayList<Rater> getRaters() {
    	initialize();
    	ArrayList<Rater> list = new ArrayList<Rater>(ourRaters.values());
    	
    	return list;
    }
 
    public static int size() {
	    return ourRaters.size();
    }
    
    
        
}