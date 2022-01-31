package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5app.repository.MovieInterface;
import com.zee.zee5app.repository.impl.MovieImpl;
import com.zee.zee5app.service.impl.MoviesImpl1;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.LocationNotFound;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.service.Movie_Service1;
@Service
public class MoviesImpl1 implements Movie_Service1 {
	MovieInterface service1=null;
	private static Movie_Service1 service;
	public MoviesImpl1() throws IOException
	{
		
	}
//	public static Movie_Service1 getInstance() throws IOException
//	{
//		if(service==null)
//		{
//			service=new MoviesImpl1();
//			return service;
//		}
//		return service;
//	}
	@Override
	public String addMovie(Movies m) {
		// TODO Auto-generated method stub
		return service1.addmovie(m);
	}

	@Override
	public String deleteMovie(String id) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		return service1.deleteMovie(id);
	}

	@Override
	public Optional<Movies> getMoviedetails(String name) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		return service1.getMoviedetails(name);
	}

	@Override
	public String[] getMovieCast(String moviename) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Movies>> getallMovies() {
		// TODO Auto-generated method stub
		return service1.getallMovies();
	}

	@Override
	public String updatemoviedetails(String id, Movies s) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		return service1.updatemoviedetails(id, s);
	}

	@Override
	public String watchmovie(String moviename) throws LocationNotFound, NameNotFound {
		// TODO Auto-generated method stub
		return null;
	}

}
