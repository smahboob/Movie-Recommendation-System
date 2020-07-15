package com.org;

public class GenreFilter implements Filter {
	private String genre;
	
	public GenreFilter(String genreSelected) {
		genre = genreSelected;
	}
	
	@Override
	public boolean satisfies(String id) {
		return MovieDatabase.getGenres(id).contains(genre);
	}

}
