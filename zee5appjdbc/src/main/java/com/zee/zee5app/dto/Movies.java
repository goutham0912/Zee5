package com.zee.zee5app.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
@Data
public class Movies {
	private String id;
	private String moviename;
	private int age_limit;
	private String cast;
	
	private String genre;
	private BigDecimal length;
public Movies()
{
	
}
	public Movies(String id, String moviename, int age_limit, String cast, String genre, 
			String trailer, String releasedate, String language) {
		super();
		this.id = id;
		this.moviename = moviename;
		this.age_limit = age_limit;
		this.cast = cast;
		this.genre = genre;
//		this.length = length;
		this.trailer = trailer;
		this.releasedate = releasedate;
		this.language = language;
	}
	private String trailer;
	private String releasedate;
	private String  language;
	
		
	
		private List<String> allowed_locations;
	private String category;

}
