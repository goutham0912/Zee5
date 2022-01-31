package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.NameNotFound;

public interface SeriesInterface {
	public String addSeries(Series s);
	public String deleteSeries(String id) throws NameNotFound;
	public Optional<Series> getSeriesdetails(String id) throws NameNotFound;
	public Optional<List<Series>> getallSeries();
	public String updateseriesdetails(String id,Series s) throws NameNotFound;

}
