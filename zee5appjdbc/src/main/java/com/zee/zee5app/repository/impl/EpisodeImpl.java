package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.LocationNotFound;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.repository.EpisodeInterface;
import com.zee.zee5app.utils.DBUtils;
@Repository
public class EpisodeImpl implements EpisodeInterface {
	DBUtils utils=null;

	private static EpisodeInterface repo=null;
	public EpisodeImpl()throws IOException
	{
		
	}
//	public static EpisodeInterface getInstance() throws IOException
//	{
//		if(repo==null)
//			repo=new EpisodeImpl();
//		return repo;
//	}
	@Override
	public String addepisode(Episodes m) {
		// TODO Auto-generated method stub
		Connection connection=null;
		connection=utils.getConnection();
		PreparedStatement preparedStatement=null;
		String insertstatement="INSERT INTO episodes(id,name,length,location,trailer,series_id)"
				+ " VALUES (?,?,?,?,?,?)";
		try {
			preparedStatement=connection.prepareStatement(insertstatement);
			preparedStatement.setString(1,m.getId());
			preparedStatement.setString(2,m.getName());
			preparedStatement.setBigDecimal(3,m.getLength());
//			String cast=String.join(",", m.getCast());
			preparedStatement.setString(4,m.getLocation());
			
			preparedStatement.setString(5,m.getTrailer());

			preparedStatement.setString(6,m.getSeries_id());
			int result=preparedStatement.executeUpdate();
			if(result>0)
			{
				connection.commit();
				return "Success";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	
			e.printStackTrace();
			return "Movie not added";
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "Movie not added";
	}

	@Override
	public String deletepisode(String id) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedstatement;
		String deleteStatement="delete from episodes where name=?";
				
		connection =utils.getConnection();
		try {
			preparedstatement=connection.prepareStatement(deleteStatement);
			preparedstatement.setString(1, id);
			
			int result=preparedstatement.executeUpdate();//returns no of rows affected using insert statement
			System.out.println(id);
			if(result>0)
				
			{
				//on delete cascade deletes the child row automatically if parent is 
				//deleted
				connection.commit();
				return "Successfully deleted the episodes";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed to delete the episodes";
		}
		finally {
		utils.closeConnection(connection);
		}
	
		
		return "failed";
	}

	@Override
	public Optional<Episodes> getEpisodesdetails(String name) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		//hold the complete set
		connection=utils.getConnection();
		ResultSet resultset=null;
		String selectstatement="select * from episodes where name=?";
		connection=utils.getConnection();
		
			try {
				preparedStatement=connection.prepareStatement(selectstatement);
				preparedStatement.setString(1, name);
				resultset=preparedStatement.executeQuery();
				
				if(resultset.next())
						{
					Episodes m=new Episodes();
					m.setId(resultset.getString("id"));
					m.setName(resultset.getString("name"));
					m.setLength(resultset. getBigDecimal("length"));
					m.setTrailer(resultset.getString("trailer"));
					m.setLocation(resultset.getString("location"));
					m.setSeries_id(resultset.getString("series_id"));
					return Optional.ofNullable(m);
						}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
							
					
		return Optional.empty();
	}

	@Override
	public Optional<List<Episodes>> getallEpisodess(String seriesid) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		//hold the complete set
		connection=utils.getConnection();
		ResultSet resultset=null;
		String selectstatement="select * from episodes where series_id=? ";
		connection=utils.getConnection();
		
			try {
				preparedStatement=connection.prepareStatement(selectstatement);
				preparedStatement.setString(1, seriesid);
				resultset=preparedStatement.executeQuery();
				ArrayList<Episodes> l=new ArrayList();
				while(resultset.next())
						{
					Episodes m=new Episodes();
					m.setId(resultset.getString("id"));
					m.setName(resultset.getString("name"));
					m.setLength(resultset. getBigDecimal("length"));
					m.setTrailer(resultset.getString("trailer"));
					m.setLocation(resultset.getString("location"));
					m.setSeries_id(resultset.getString("series_id"));
					l.add(m);
					
						}
				return Optional.ofNullable(l);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
							
					
		return Optional.empty();

	}

	@Override
	public Episodes update_episodedetails(String id, Episodes s) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		return null;
	}
	

}
