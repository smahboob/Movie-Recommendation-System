package com.org;

import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.csv.*;


public class FirstRatings{


    public ArrayList<Movie> loadMovies(String filename) {
    	
        ArrayList<Movie> listOfMovies = new ArrayList<Movie>();
        
        CSVParser parser = null;
		try {
			parser = new CSVParser(new FileReader(filename), CSVFormat.DEFAULT.withHeader());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        for(CSVRecord record : parser) {

            Movie movie = new Movie(record.get("id"),record.get("title"),record.get("year"),record.get("genre"),
            record.get("director"),record.get("country"),record.get("poster"),record.get("minutes"));
            
            listOfMovies.add(movie);
        }
        return listOfMovies;
    }

    public  int checkGenere(ArrayList<Movie> list, String genere){
        int count = 0;
        for(Movie m: list){
            String rating = m.getGenres();
            if(rating.indexOf(genere) != -1){
                count++;
            }
        }

        System.out.println(count + " movies are of genere: " + genere);
        return count;
    }

    public  int checkTimeLength(ArrayList<Movie> list, int minutes){
        int count = 0;
        for(Movie m: list){
            int time = m.getMinutes();
            if(time > minutes){
                count++;
            }
        }

        System.out.println(count + " movies are more than " + minutes + " minutes.");
        return count;
    }

    public  int maxMoviesByDirector(ArrayList<Movie> list){
        HashMap<String,Integer> out = new HashMap<String,Integer>();

        int max  = 0;
        String answer_direc = "";
        for(Movie m: list){
            String [] director = m.getDirector().split(",");
            for(String direc: director){
                if(out.containsKey(direc)){
                    int value = out.get(direc);
                    if(value > max){
                        max = value;
                        answer_direc = direc;
                    }
                    out.put(direc,value+1);
        
                }
                else{
                    out.put(direc, 1);
                }
            }
        }

        System.out.println("director name: " + answer_direc);

        return max;
    }

    public ArrayList<Rater> loadRaters(String filename) {
        HashMap<String,Rater> myMap = new HashMap<String,Rater>();
        
        CSVParser parser = null;
		try {
			parser = new CSVParser(new FileReader(filename), CSVFormat.DEFAULT.withHeader());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        for(CSVRecord record : parser) {        
            String rater_id = record.get("rater_id");
            if(!myMap.containsKey(rater_id)) {
                Rater ra = new EfficientRater(rater_id);
                ra.addRating(record.get("movie_id"),Double.parseDouble(record.get("rating")));
                myMap.put(rater_id,ra);                
            } else {
                Rater rater = myMap.get(rater_id);
                rater.addRating(record.get("movie_id"),Double.parseDouble(record.get("rating")));
            }
        }
        
        //hashMap to ArrayList
        ArrayList<Rater> listOfRaters = new ArrayList<Rater>();
        for(String raterID : myMap.keySet()){
            listOfRaters.add(myMap.get(raterID));
        }
        return listOfRaters;
    }   
    

    public  int numOfRatingsPerId(ArrayList<Rater> list, String id){
        for(Rater r: list){
            if(r.getID().equals(id)){
                return r.numRatings();
            }
        }
        return -1;
    }


    public  void maxRatingsPerId(ArrayList<Rater> list){
        int max = 0;
        for(Rater r: list){
            if(r.numRatings() > max){
                max = r.numRatings();
            }
        }
        for(Rater r: list){
            if(r.numRatings() == max){
                System.out.println("ID: " + r.getID() + " has max ratings of: " + r.numRatings());
            }
        }
    }

    public  void numRatingPerMovie(ArrayList<Rater> list, String movieId){
        int numRaters = 0;
        for(Rater r: list){
            if(r.hasRating(movieId)){
                numRaters ++;
            }
        }

        System.out.println("Number of Raters of: " + movieId + " are: " +  numRaters);
    }

    public  void numOfUniqueMovies(ArrayList<Rater> list){

        HashMap<String,Integer> map =  new HashMap<String,Integer>();
        for(Rater r: list){
            ArrayList<String> arr = r.getItemsRated();
            for(String str: arr){
                if(!map.containsKey(str)){
                    map.put(str, 1);
                }
                else{
                    int value = map.get(str);
                    map.put(str, value+1);
                }
            }
        }

        System.out.println("Number of Unique movies rated: " + map.keySet().size());
    }

}
