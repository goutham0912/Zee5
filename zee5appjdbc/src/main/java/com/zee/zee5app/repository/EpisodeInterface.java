package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.exception.LocationNotFound;
import com.zee.zee5app.exception.NameNotFound;

public interface EpisodeInterface {
	public String addepisode(Episodes m);
	public String deletepisode(String id) throws NameNotFound, LocationNotFound;
	public Optional<Episodes> getEpisodesdetails(String name) throws NameNotFound, LocationNotFound;
//	public String[] getEpisodesCast(String episodename) throws NameNotFound, LocationNotFound;
	public Optional<List<Episodes>> getallEpisodess(String seriesid);
	public Episodes update_episodedetails(String id,Episodes s) throws NameNotFound, LocationNotFound;

}
