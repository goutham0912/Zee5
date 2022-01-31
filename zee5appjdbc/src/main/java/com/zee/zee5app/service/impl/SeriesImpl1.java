package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5app.repository.SeriesInterface;
import com.zee.zee5app.repository.impl.SeriesImpl;
import com.zee.zee5app.service.impl.SeriesImpl1;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.service.Series_Service1;
@Service
public class SeriesImpl1 implements Series_Service1 {
	SeriesInterface service1=null;
	private static Series_Service1 service;
	public SeriesImpl1() throws IOException
	{
		
	}
//	public static Series_Service1 getInstance() throws IOException
//	{
//		if(service==null)
//		{
//			service=new SeriesImpl1();
//			return service;
//		}
//		return service;
//	}
	@Override
	public String addSeries(Series s) {
		// TODO Auto-generated method stub
		return service1.addSeries(s);
	}

	@Override
	public String deleteSeries(String id) throws NameNotFound {
		// TODO Auto-generated method stub
		return service1.deleteSeries(id);
	}

	@Override
	public Optional<Series> getSeriesdetails(String id) throws NameNotFound {
		// TODO Auto-generated method stub
		return service1.getSeriesdetails(id);
	}

	@Override
	public Optional<List<Series>> getallSeries() {
		// TODO Auto-generated method stub
		return service1.getallSeries();
	}

	@Override
	public String updateseriesdetails(String id, Series s) throws NameNotFound {
		// TODO Auto-generated method stub
		return service1.updateseriesdetails(id, s);
	}

}
