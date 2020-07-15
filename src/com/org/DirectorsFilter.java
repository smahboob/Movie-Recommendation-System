package com.org;

public class DirectorsFilter implements Filter {
    private String myDirector;

	
	public DirectorsFilter(String directors) {
        myDirector = directors;
	}
	
	@Override
	public boolean satisfies (String id) {        
        String[] directors = MovieDatabase.getDirector(id).trim().split("\\s*,\\s*");
        for(String dr : directors) { 
            if(myDirector.contains(dr)){
                return true;
            }
        }
        return false;
    }   

}
