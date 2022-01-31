package com.zee.zee5app.dto;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class Episodes {
	private String id;
	private String name;
	private BigDecimal length;
	private String location;
	private String trailer;
	private String series_id;
	public Episodes()
	{
		
	}
	public Episodes(String id, String name, BigDecimal length, String location, String trailer, String series_id) {
		super();
		this.id = id;
		this.name = name;
		this.length = length;
		this.location = location;
		this.trailer = trailer;
		this.series_id = series_id;
	}

}
