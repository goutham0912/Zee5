package com.zee.zee5app.dto;



import java.math.BigDecimal;

import com.zee.zee5app.dto.Series;

import lombok.Data;
@Data

public class Series implements Comparable<Series> {
	private String seriesid;
	private String name;
	private int age_limit;
	
	private String cast;
	private String genre;
	private BigDecimal length;
	private String trailer;
	private String releasedate;
	private String language;
	private int no_episodes;
	private String episodenames[];
	private int no_seasons;
	@Override
	public int compareTo(Series o) {
		// TODO Auto-generated method stub
		return this.seriesid.compareTo(o.getSeriesid());
	}
	public Series() {
		
	}
	public Series(String seriesid, String name, int age_limit, String cast, String genre, BigDecimal length,
			String trailer, String releasedate, String language, int no_episodes) {
		super();
		this.seriesid = seriesid;
		this.name = name;
		this.age_limit = age_limit;
		this.cast = cast;
		this.genre = genre;
		this.length = length;
		this.trailer = trailer;
		this.releasedate = releasedate;
		this.language = language;
		this.no_episodes = no_episodes;
	}

}
