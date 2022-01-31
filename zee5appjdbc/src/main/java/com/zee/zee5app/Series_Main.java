package com.zee.zee5app;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.LocationNotFound;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.service.Movie_Service1;
import com.zee.zee5app.service.Series_Service1;
import com.zee.zee5app.service.impl.MoviesImpl1;
import com.zee.zee5app.service.impl.SeriesImpl1;

public class Series_Main {
public static void main(String[] args) {
	Series series=new Series("s000007","ABC",8,"A,B","Action",null,"abc","2022-02-01","English",10);
	BigDecimal b=new BigDecimal(7000);
	Series_Service1 service=null;
	

	try {
		 service=SeriesImpl1.getInstance();
		String result=service.addSeries(series);
		
		System.out.println(result);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//get movie details
	try {
		 service=SeriesImpl1.getInstance();
		Optional<Series> result=service.getSeriesdetails("Friends");
		if(result.isPresent())
		{
			System.out.println(result.get());
		}
		else {
			System.out.println("Series Not found");
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NameNotFound e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		 service=SeriesImpl1.getInstance();
		Optional<List<Series>> result1=service.getallSeries();
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
		 service=SeriesImpl1.getInstance();
		String result=service.deleteSeries("ABC");
		
		System.out.println(result);
		
	} catch (IOException | NameNotFound e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
