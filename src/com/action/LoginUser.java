package com.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.project.connection.ConnectionEstablish;

public class LoginUser {
	
	
	public String checkUserExist(String username,String pwd){
		
		Connection con=null;
		PreparedStatement ps=null;
		String name="";
		
		try {
			
			con = ConnectionEstablish.getconnection();
			String sql="select firstname from userregister where username='"+username+"' and upassword='"+pwd+"' ";
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				name=rs.getString(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return name;
		
	}
	
public String loginUser(){
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the username");
		String uname=sc.next();
		
		System.out.println("enter the password");
		String pwd=sc.next();
		
	    String nm=this.checkUserExist(uname,pwd);
		
		return nm;
		
	}
	

}
