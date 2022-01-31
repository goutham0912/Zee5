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

import com.zee.zee5app.repository.impl.SubscriptionImpl;
import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.repository.SubscriptionInterface;
@Repository
public class SubscriptionImpl implements SubscriptionInterface {
	private static int count=-1;
	private static SubscriptionInterface repo;
	private static DBUtils utils=null;
@Autowired
DataSource datasource;
	public SubscriptionImpl() throws IOException{
//		utils=DBUtils.getinstance();
	}
//	public static SubscriptionInterface getInstance() throws IOException
//	{
//		if(repo==null)
//		{
//			repo=new SubscriptionImpl();
//			return repo;
//		}
//		return repo;
//	}
	@Override
	public String addSubscription(Subscriptions m) {
		// TODO Auto-generated method stub
		Connection connection=null;
		try {
			connection=datasource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement preparedStatement=null;
		String insertstatement="INSERT INTO subscription "
				+ " VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			preparedStatement=connection.prepareStatement(insertstatement);
			preparedStatement.setString(1,m.getId());
			preparedStatement.setString(9,m.getRegid());
//			String cast=String.join(",", m.getCast());
			preparedStatement.setString(8,m.getAutorenewal());
			
			
			preparedStatement.setString(7,m.getType());
			SimpleDateFormat format1=new SimpleDateFormat("yyyy-mm-dd");
			Date date=Date.valueOf(m.getDateofpurchase());
			Date date1=Date.valueOf(m.getExpirydate());
//			java.sql.Date date=new java.sql.Date(format1.parse(m.getReleasedate()));
			preparedStatement.setDate(2, date );
			preparedStatement.setDate(3, date1 );
			preparedStatement.setInt(4,m.getSubscription_cost());
			preparedStatement.setString(5,m.getPaymentmode());
			preparedStatement.setString(6,m.getStatus());
			int result=preparedStatement.executeUpdate();
			if(result>0)
			{
				connection.commit();
				return "Success";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	
			e.printStackTrace();
			return "Subscription not added";
		}
		
		return "Subscription not added";
	}

	@Override
	public String deleteSubscription(String id) throws NameNotFound {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedstatement;
		String deleteStatement="delete from subscription where id=?";
				
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
				return "Successfully deleted the subscription";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed to delete the Subscription";
		}
		
		
	
		
		return "failed";
//		return null;
	}

	@Override
	public Optional<Subscriptions> getSubscription(String id) throws NameNotFound {
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
		String selectstatement="select * from subscription where id=?";
		
		
			try {
				preparedStatement=connection.prepareStatement(selectstatement);
				preparedStatement.setString(1, id);
				resultset=preparedStatement.executeQuery();
				
				if(resultset.next())
						{
					System.out.println(resultset.getString("id"));
					Subscriptions m=new Subscriptions();
					m.setId(resultset.getString("id"));
//					m.setM(resultset.getString("name"));
					m.setDateofpurchase(resultset.getDate("dateofpayment").toString());
					m.setExpirydate(resultset.getDate("expiry").toString());
					m.setSubscription_cost(resultset.getInt("amount"));
					m.setPaymentmode(resultset.getString("paymentmode"));
					m.setStatus(resultset.getString("status"));
					m.setType(resultset.getString("type"));
					m.setAutorenewal(resultset.getString("autorenewal"));
					m.setRegid(resultset.getString("regid"));
				 return Optional.ofNullable(m);
						}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
					
		return Optional.empty();
	}

	@Override
	public Optional<ArrayList<Subscriptions>> getallSubscription() {
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
		String selectstatement="select * from subscription";
	
		
			try {
				preparedStatement=connection.prepareStatement(selectstatement);
				
				resultset=preparedStatement.executeQuery();
				ArrayList<Subscriptions> l=new ArrayList();
				while(resultset.next())
						{
					Subscriptions m=new Subscriptions();
					m.setId(resultset.getString("id"));
//					m.setM(resultset.getString("name"));
					m.setDateofpurchase(resultset.getDate("dateofpayment").toString());
					m.setExpirydate(resultset.getDate("expiry").toString());
					m.setSubscription_cost(resultset.getInt("amount"));
					m.setPaymentmode(resultset.getString("paymentmode"));
					m.setStatus(resultset.getString("status"));
					m.setType(resultset.getString("type"));
					m.setAutorenewal(resultset.getString("autorenewal"));
					m.setRegid(resultset.getString("regid"));
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
	public String updatesubscription(String id, Subscriptions m) throws NameNotFound {
		// TODO Auto-generated method stubreturn null;
		Connection connection=null;
		try {
			connection=datasource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement preparedStatement=null;
		String insertstatement="Update subscription set id=?,dateofpayment=?,expiry=?,amount=?,"
				+ "paymentmode=?,status=?,type=?,autorenewal=?,regid=? where id=(?)";
		try {
			preparedStatement=connection.prepareStatement(insertstatement);
			preparedStatement.setString(1,m.getId());
			preparedStatement.setString(9,m.getRegid());
//			String cast=String.join(",", m.getCast());
			preparedStatement.setString(8,m.getAutorenewal());
			
			
			preparedStatement.setString(7,m.getType());
			SimpleDateFormat format1=new SimpleDateFormat("yyyy-mm-dd");
			Date date=Date.valueOf(m.getDateofpurchase());
			Date date1=Date.valueOf(m.getExpirydate());
//			java.sql.Date date=new java.sql.Date(format1.parse(m.getReleasedate()));
			preparedStatement.setDate(2, date );
			preparedStatement.setDate(3, date1 );
			preparedStatement.setInt(4,m.getSubscription_cost());
			preparedStatement.setString(5,m.getPaymentmode());
			preparedStatement.setString(6,m.getStatus());
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
			return "Subscription not updated";
		}
	
		return "Subscription not updated";
	}

}
