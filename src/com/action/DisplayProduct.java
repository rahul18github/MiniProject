package com.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.connection.ConnectionEstablish;

public class DisplayProduct {
	
	public void getProductDetails(){
		
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			
			 con = ConnectionEstablish.getconnection();
			 String sql="select * from product order by id asc";
			 ps=con.prepareStatement(sql);
			 ResultSet rs=ps.executeQuery();
			 
			 while(rs.next()){
				 
				 System.out.println("Product Id :"+rs.getString(1));
				 System.out.println("Product Description:"+rs.getString(2));
				 System.out.println("Product Name:"+rs.getString(3));
				 System.out.println("price :"+rs.getString(4));
				 System.out.println("Available Quantity :"+rs.getString(5));
				 System.out.println("===================================================================");
		 
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
