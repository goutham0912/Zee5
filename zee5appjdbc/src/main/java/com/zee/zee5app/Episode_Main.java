package com.zee.zee5app;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.LocationNotFound;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.impl.EpisodeServiceImpl;
import com.zee.zee5app.service.impl.SeriesImpl1;

public class Episode_Main {
public static void main(String[] args) {
	Episodes episodes=new Episodes("F0000e3","episode2",null,"USA","trailer","s000001");
	BigDecimal b=new BigDecimal(2400);
episodes.setLength(b);
EpisodeService service=null;
try {
	 service=EpisodeServiceImpl.getInstance();
	String result=service.addepisode(episodes);
	
	System.out.println(result);
	
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
//get movie details
try {
	 service=EpisodeServiceImpl.getInstance();
	Optional<Episodes> result=service.getEpisodesdetails("GHI");
	if(result.isPresent())
	{
		System.out.println(result.get());
	}
	else {
		System.out.println("Episode Not found");
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

try {
	 service=EpisodeServiceImpl.getInstance();
	Optional<List<Episodes>> result1=service.getallEpisodess("s000001");
	if(result1.isPresent())
	{
		result1.get().forEach(e->System.out.println(e));
	}
	
	else {
		System.out.println("Episode Not found");
	}
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
//delete a movie
try {
	 service=EpisodeServiceImpl.getInstance();
	String result=service.deletepisode("LMN");
	
	System.out.println(result);
	
} catch (IOException | NameNotFound e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (LocationNotFound e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}
