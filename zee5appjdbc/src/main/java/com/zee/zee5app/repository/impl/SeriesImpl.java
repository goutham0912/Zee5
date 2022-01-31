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

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.repository.impl.SeriesImpl;
import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.repository.SeriesInterface;
@Repository
public class SeriesImpl implements SeriesInterface {
	private static SeriesInterface seriesrepo;
	private static DBUtils utils=null;
	@Autowired
	DataSource datasource;
	public SeriesImpl()throws IOException
	{
//		utils=DBUtils.getinstance();
	}
//	public static  SeriesInterface getInstance() throws IOException
//	{
//		if(seriesrepo==null)
//		{
//			seriesrepo=new SeriesImpl();
//			return seriesrepo;
//		}
//		return seriesrepo;
//	}

	@Override
	public String addSeries(Series m) {
		// TODO Auto-generated method stub
		Connection connection=null;
		try {
			connection=datasource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement preparedStatement=null;
		String insertstatement="INSERT INTO series(id,name,age_limit,cast,genre,length,trailer,release_date,language,no_episodes)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			preparedStatement=connection.prepareStatement(insertstatement);
			preparedStatement.setString(1,m.getSeriesid());
			preparedStatement.setString(2,m.getName());
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
			preparedStatement.setInt(10,m.getNo_episodes());
			int result=preparedStatement.executeUpdate();
			if(result>0)
			{
				connection.commit();
				return "Success";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	
			e.printStackTrace();
			return "Series not added";
		}
		
		return "Series not added";
	}

	@Override
	public String deleteSeries(String id) throws NameNotFound {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedstatement;
		String deleteStatement="delete from series where name=?";
				
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
			System.out.println(result);
			if(result>0)
				
			{
				//on delete cascade deletes the child row automatically if parent is 
				//deleted
				connection.commit();
				return "Successfully deleted the series";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed to delete the series";
		}
		
	
		
		return "failed";
	}

	@Override
	public Optional<Series> getSeriesdetails(String id) throws NameNotFound {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		//hold the complete set
		try {
			connection=datasource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet resultset=null;
		String selectstatement="select * from series where name=?";
		
		
			try {
				preparedStatement=connection.prepareStatement(selectstatement);
				preparedStatement.setString(1, id);
				resultset=preparedStatement.executeQuery();
				
				if(resultset.next())
						{
					Series m=new Series();
					m.setSeriesid(resultset.getString("id"));
					m.setName(resultset.getString("name"));
					m.setAge_limit(resultset.getInt("age_limit"));
					m.setGenre(resultset.getString("genre"));
					m.setLength(resultset. getBigDecimal("length"));
					m.setTrailer(resultset.getString("trailer"));
					m.setReleasedate(resultset.getDate("release_date").toString());
					m.setCast(resultset.getString("cast"));
					m.setLanguage(resultset.getString("language"));
					m.setNo_episodes(resultset.getInt("no_episodes"));
					return Optional.ofNullable(m);
						}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
					
		return Optional.empty();
	}

	@Override
	public Optional<List<Series>> getallSeries() {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		//hold the complete set
	
		ResultSet resultset=null;
		String selectstatement="select * from series";
		try {
			connection=datasource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			try {
				preparedStatement=connection.prepareStatement(selectstatement);
				
				resultset=preparedStatement.executeQuery();
				ArrayList<Series> l=new ArrayList();
				while(resultset.next())
						{
					Series m=new Series();
					m.setSeriesid(resultset.getString("id"));
					m.setName(resultset.getString("name"));
					m.setAge_limit(resultset.getInt("age_limit"));
					m.setGenre(resultset.getString("genre"));
					m.setLength(resultset. getBigDecimal("length"));
					m.setTrailer(resultset.getString("trailer"));
					m.setReleasedate(resultset.getDate("release_date").toString());
					m.setCast(resultset.getString("cast"));
					m.setLanguage(resultset.getString("language"));
					m.setNo_episodes(resultset.getInt("no_episodes"));
					l.add(m);
					
						}
				return Optional.ofNullable(l);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
							
					
		return Optional.empty();
	}

	@Override
	public String updateseriesdetails(String id, Series m) throws NameNotFound {
		// TODO Auto-generated method stub
		Connection connection=null;
		try {
			connection=datasource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement preparedStatement=null;
		String insertstatement="Update series set id=?,name=?,age_limit=?,cast=?,genre=?,"
				+ "length=?,trailer=?,release_date=?,language=?,no_episodes=? where id=?";
				
		try {
			preparedStatement=connection.prepareStatement(insertstatement);
			preparedStatement.setString(1,m.getSeriesid());
			preparedStatement.setString(2,m.getName());
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
			preparedStatement.setInt(10,m.getNo_episodes());
			preparedStatement.setString(11,id);
			int result=preparedStatement.executeUpdate();
			if(result>0)
			{
				connection.commit();
				return "Success";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	
			e.printStackTrace();
			return "Series not updates";
		}
		
		return "Series not updated";
		
	}

}
