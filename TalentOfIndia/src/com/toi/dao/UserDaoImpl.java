package com.toi.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.toi.util.DbConnection;
import com.toi.util.DbQueries;
import com.toi.model.*;

public class UserDaoImpl {

	Connection con;
	PreparedStatement pstm;
	CallableStatement cstm;
	ResultSet rst;
	DbConnection dbcon;
	
	public UserDaoImpl()
	{
	  dbcon = new DbConnection();
      con =  dbcon.getConnection();
    }
	
	public List<States> getStates(){
		dbcon = new DbConnection();
	    con =  dbcon.getConnection();
	    States s; 
        List<States> states = new ArrayList();
	    try 
		{
		  pstm = con.prepareStatement(DbQueries.GETSTATES);
		  rst = pstm.executeQuery();
		  while(rst.next())
		  {
			s = new States();
			s.setStateid(rst.getString("StateID"));  
			s.setStatename(rst.getString("StateName"));
			states.add(s);
		  }
		}
		catch (Exception e)
		{
		 System.out.println(e);
		}
		finally
		{
			try
			{
			 if(con!=null)
		        {
				 con.close();
				}
			  if(pstm!=null)
				  pstm.close();
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return states;
	}
	
	public List<AuditionCity> audCities(){
		dbcon = new DbConnection();
	    con =  dbcon.getConnection();
	    AuditionCity a; 
        List<AuditionCity> ac = new ArrayList();
	    try 
		{
		  pstm = con.prepareStatement(DbQueries.GETAUDCITIES);
		  rst = pstm.executeQuery();
		  while(rst.next())
		  {
			a = new AuditionCity();
			a.setAcityId(rst.getString("Audition_cityId"));  
			a.setAcityname(rst.getString("CityName"));
			ac.add(a);
		  }
		}
		catch (Exception e)
		{
		 System.out.println(e);
		}
		finally
		{
			try
			{
			 if(con!=null)
		        {
				 con.close();
				}
			  if(pstm!=null)
				  pstm.close();
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return ac;
	}
	
	public List<City> getCities(String state){
		dbcon = new DbConnection();
	    con =  dbcon.getConnection();
	    City c; 
        List<City> cities = new ArrayList();
	    try 
		{
		  pstm = con.prepareStatement(DbQueries.GETCITIES);
		  pstm.setString(1,state);
		  rst = pstm.executeQuery();
		  while(rst.next())
		  {
			c = new City();
			c.setCityId(rst.getInt("DistrictID"));  
			c.setCityname(rst.getString("DistrictName"));
			cities.add(c);
		  }
		}
		catch (Exception e)
		{
		 System.out.println(e);
		}
		finally
		{
			try
			{
			 if(con!=null)
		        {
				 con.close();
				}
			  if(pstm!=null)
				  pstm.close();
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return cities;
	}

	public String insertUser(User user){
		dbcon = new DbConnection();
	    con =  dbcon.getConnection();
	    City c; 
	    ResultSet rs;
	    String t_id = null;
        try 
		{
	      CallableStatement stm = con.prepareCall(DbQueries.INSERTUSER);
		  stm.setString(1,user.getUfname());
		  stm.setString(2,user.getUmname());
		  stm.setString(3,user.getUlname());
		  stm.setString(4,user.getFfname());
		  stm.setString(5,user.getFmname());
		  stm.setString(6,user.getFlname());
		  stm.setString(7,user.getMfname());
		  stm.setString(8,user.getMmname());
		  stm.setString(9,user.getMlname());
		  stm.setString(10,user.getEmail());
		  stm.setLong(11,user.getMobile());
		  stm.setString(12,user.getCategory());
		  stm.setString(13,user.getAudCity());
		  stm.setString(14,user.getGender());
		  java.sql.Date sqlDate = new java.sql.Date(user.getDob().getTime() );
		  stm.setDate( 15, sqlDate); 
		  stm.setString(16,user.getAddress());
		  stm.setString(17,user.getState());
		  stm.setString(18,user.getCity());
		  stm.setInt(19,user.getPincode());
		  stm.setString(20,user.getPicture());
		  stm.setString(21,user.getDocument());
		  stm.setString(22,user.getSignature());
		  rs = stm.executeQuery();
		  if(rs.next()) {
			  t_id = rs.getString("TransactionID");
		   }
		}
		catch (Exception e)
		{
		 System.out.println(e);
		}
		finally
		{
			try
			{
			 if(con!=null)
		        {
				 con.close();
				}
			  if(pstm!=null)
				  pstm.close();
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return t_id;
	 }
	
	public String insertTransDetails(int regid){
		dbcon = new DbConnection();
	    con =  dbcon.getConnection();
	    String query = "{ call SP_Payment(?)}";
        ResultSet rs;
        String t_id = null;
	   try 
		{
		  CallableStatement stmt = con.prepareCall(query);
		  stmt.setInt(1,regid);
	      rs = stmt.executeQuery();
	      if(rs.next()) {
	       t_id = rs.getString("TransactionID");
	      // System.out.println(rs.getString("TransactionID"));
	      }
		}
		catch (Exception e)
		{
		 System.out.println(e);
		}
		finally
		{
			try
			{
			 if(con!=null)
		        {
				 con.close();
				}
			  if(pstm!=null)
				  pstm.close();
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return t_id;	
	}
	
	public String updateTransaction(String pid,String psid, String tid){
	dbcon = new DbConnection();
    con =  dbcon.getConnection();
    String uc = null;
    ResultSet rs;
    try 
	{
	  CallableStatement stmt = con.prepareCall(DbQueries.UPDATETRANSACTON);
	  stmt.setString(1,pid);
	  stmt.setString(2,psid);
	  stmt.setString(3,tid);
      rs = stmt.executeQuery();
      if(rs.next()) {
       uc = rs.getString("UserCode");
      // System.out.println(rs.getString("UserCode"));
      }
	}
	catch (Exception e)
	{
	 System.out.println(e);
	}
	finally
	{
		try
		{
		 if(con!=null)
	        {
			 con.close();
			}
		  if(pstm!=null)
			  pstm.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	return uc;
   }
	
}
