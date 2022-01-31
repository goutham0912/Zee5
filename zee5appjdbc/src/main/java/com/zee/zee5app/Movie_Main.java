package com.zee.zee5app;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.LocationNotFound;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.service.Movie_Service1;
import com.zee.zee5app.service.impl.MoviesImpl1;

public class Movie_Main {
	public static void main(String[] args) {
		Movies movies=new Movies("m000007","ABC",8,"A,B","Action","abc","2022-02-01","English");
		BigDecimal b=new BigDecimal(7000);
		Movie_Service1 service=null;
		
		movies.setLength(b);
		try {
			 service=MoviesImpl1.getInstance();
			String result=service.addMovie(movies);
			
			System.out.println(result);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//get movie details
		try {
			service=MoviesImpl1.getInstance();
			Optional<Movies> result=service.getMoviedetails("Avengers");
			if(result.isPresent())
			{
				System.out.println(result.get());
			}
			else {
				System.out.println("Movie Not found");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NameNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LocationNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//get all movie details
		
		try {
			service=MoviesImpl1.getInstance();
			Optional<List<Movies>> result1=service.getallMovies();
			if(result1.isPresent())
			{
				result1.get().forEach(e->System.out.println(e));
			}
			
			else {
				System.out.println("Movie Not found");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//delete a movie
		try {
			 service=MoviesImpl1.getInstance();
			String result=service.deleteMovie("ABC");
			
			System.out.println(result);
			
		} catch (IOException | NameNotFound | LocationNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
