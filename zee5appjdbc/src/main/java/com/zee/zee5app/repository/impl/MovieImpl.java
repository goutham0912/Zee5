package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.repository.impl.MovieImpl;
import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.LocationNotFound;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.repository.MovieInterface;
@Repository
public class MovieImpl implements MovieInterface {
	private static DBUtils utils=null;
	@Autowired
	DataSource datasource;
	private static int count=-1;
	private static MovieInterface repo;
	public MovieImpl() throws IOException
	{
//		 utils=DBUtils.getinstance();
	}
//	public static MovieInterface getInstance() throws IOException
//	{
//		if(repo==null)
//		{
//			repo=new MovieImpl();
//			return repo;
//		}
//		return repo;
//	}
	@Override
	public String addmovie(Movies m) {
		// TODO Auto-generated method stub
		Connection connection=null;
		try {
			connection=datasource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement preparedStatement=null;
		String insertstatement="INSERT INTO movies(id,name,age_limit,cast,genre,length,trailer,release_date,language)"
				+ " VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			preparedStatement=connection.prepareStatement(insertstatement);
			preparedStatement.setString(1,m.getId());
			preparedStatement.setString(2,m.getMoviename());
			preparedStatement.setInt(3,m.getAge_limit());
//			String cast=String.join(",", m.getCast());
			preparedStatement.setString(4,m.getCast());
			preparedStatement.setString(5,m.getGenre());
			preparedStatement.setBigDecimal(6,m.getLength());
			preparedStatement.setString(7,m.getTrailer());
			SimpleDateFormat format1=new SimpleDateFormat("yyyy-mm-dd");
			Date date=Date.valueOf(m.getReleasedate());
//			java.sql.Date date=new java.sql.Date(format1.parse(m.getReleasedate()));
			preparedStatement.setDate(8, date );
			preparedStatement.setString(9,m.getLanguage());
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
			utils.closeConnection(connection);
		}
		return "Movie not added";
		
		
	}

	@Override
	public String deleteMovie(String id) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		PreparedStatement preparedstatement;
		String deleteStatement="delete from movies where name=?";
				
		try {
			connection =datasource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
				return "Successfully deleted the movie";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed to delete the move";
		}
		finally {
		utils.closeConnection(connection);
		}
	
		
		return "failed";
	}

	@Override
	public Optional<Movies> getMoviedetails(String name) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		//hold the complete set
		
		ResultSet resultset=null;
		String selectstatement="select * from movies where name=?";
		try {
			connection=datasource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			try {
				preparedStatement=connection.prepareStatement(selectstatement);
				preparedStatement.setString(1, name);
				resultset=preparedStatement.executeQuery();
				
				if(resultset.next())
						{
					Movies m=new Movies();
					m.setId(resultset.getString("id"));
					m.setMoviename(resultset.getString("name"));
					m.setAge_limit(resultset.getInt("age_limit"));
					m.setGenre(resultset.getString("genre"));
					m.setLength(resultset. getBigDecimal("length"));
					m.setTrailer(resultset.getString("trailer"));
					m.setReleasedate(resultset.getDate("release_date").toString());
					m.setCast(resultset.getString("cast"));
					m.setLanguage(resultset.getString("language"));
					return Optional.ofNullable(m);
						}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				utils.closeConnection(connection);
			}
							
					
		return Optional.empty();
	}

	@Override
	public String[] getMovieCast(String moviename) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Movies>> getallMovies() {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		//hold the complete set
	
		ResultSet resultset=null;
		String selectstatement="select * from movies";
		try {
			connection=datasource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			try {
				preparedStatement=connection.prepareStatement(selectstatement);
				
				resultset=preparedStatement.executeQuery();
				ArrayList<Movies> l=new ArrayList();
				while(resultset.next())
						{
					Movies m=new Movies();
					m.setId(resultset.getString("id"));
					m.setMoviename(resultset.getString("name"));
					m.setAge_limit(resultset.getInt("age_limit"));
					m.setGenre(resultset.getString("genre"));
					m.setLength(resultset. getBigDecimal("length"));
					m.setTrailer(resultset.getString("trailer"));
					m.setReleasedate(resultset.getDate("release_date").toString());
					m.setCast(resultset.getString("cast"));
					m.setLanguage(resultset.getString("language"));
					l.add(m);
					
						}
				return Optional.ofNullable(l);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				utils.closeConnection(connection);
			}
							
					
		return Optional.empty();
	}

	@Override
	public String updatemoviedetails(String id, Movies m) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		Connection connection=null;
		try {
			connection=datasource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement preparedStatement=null;
		String insertstatement="Update  movies set id=?,name=?,age_limit=?,cast=?,"
				+ "genre=?,length=?,trailer=?,release_date=?,language=? where id=?";
				
		try {
			preparedStatement=connection.prepareStatement(insertstatement);
			preparedStatement.setString(1,m.getId());
			preparedStatement.setString(2,m.getMoviename());
			preparedStatement.setInt(3,m.getAge_limit());
//			String cast=String.join(",", m.getCast());
			preparedStatement.setString(4,m.getCast());
			preparedStatement.setString(5,m.getGenre());
			preparedStatement.setBigDecimal(6,m.getLength());
			preparedStatement.setString(7,m.getTrailer());
			SimpleDateFormat format1=new SimpleDateFormat("yyyy-mm-dd");
			Date date=Date.valueOf(m.getReleasedate());
//			java.sql.Date date=new java.sql.Date(format1.parse(m.getReleasedate()));
			preparedStatement.setDate(8, date );
			preparedStatement.setString(9,m.getLanguage());
			preparedStatement.setString(10,id);
			int result=preparedStatement.executeUpdate();
			if(result>0)
			{
				connection.commit();
				return "Success";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	
			e.printStackTrace();
			return "Movie not updates";
		}
		finally {
			utils.closeConnection(connection);
		}
		return "Movie not updated";
	}

	@Override
	public String watchmovie(String moviename) throws LocationNotFound, NameNotFound {
		// TODO Auto-generated method stub
		return null;
	}

}
