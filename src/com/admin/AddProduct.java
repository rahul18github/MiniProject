package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.project.connection.ConnectionEstablish;

public class AddProduct {
	
	public void inserProduct(String pid){
		
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			
			 con = ConnectionEstablish.getconnection();
			 String sql="select pname,quantity from product where id="+pid+" ";
			 ps=con.prepareStatement(sql);
			 ResultSet rs=ps.executeQuery();
			 
			 while(rs.next()){
				 
				 System.out.println("product name :"+rs.getString(1));
				 System.out.println("Available Quantity :"+rs.getString(2));
				 System.out.println("=============================================");
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
	
	public void execute(){
		
        Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the product Id");
		String pid=sc.next();
		
		this.inserProduct(pid);
		
		
		
	}
	

}
