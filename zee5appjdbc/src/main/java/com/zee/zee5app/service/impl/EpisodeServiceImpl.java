package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.exception.LocationNotFound;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.repository.EpisodeInterface;
import com.zee.zee5app.repository.impl.EpisodeImpl;
import com.zee.zee5app.service.EpisodeService;
@Service
public class EpisodeServiceImpl implements EpisodeService {
EpisodeInterface service1=null;
	public EpisodeServiceImpl()throws IOException
	{
		
	}
//	private static EpisodeService service=null;
//	public static EpisodeService getInstance() throws IOException
//	{
//		if(service==null)
//		{
//			service=new EpisodeServiceImpl();
//		}
//		return service;
//	}
	@Override
	public String addepisode(Episodes m) {
		// TODO Auto-generated method stub
		return service1.addepisode(m);
	}

	@Override
	public String deletepisode(String id) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		return service1.deletepisode(id);
	}

	@Override
	public Optional<Episodes> getEpisodesdetails(String name) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		return service1.getEpisodesdetails(name);
	}

	@Override
	public Optional<List<Episodes>> getallEpisodess(String seriesid) {
		// TODO Auto-generated method stub
		return service1.getallEpisodess(seriesid);
	}

	@Override
	public Episodes update_episodedetails(String id, Episodes s) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		return null;
	}

}
