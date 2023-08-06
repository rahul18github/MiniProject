package com.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.project.connection.ConnectionEstablish;

public class RegisterUser {
	
	Connection con=null;
	PreparedStatement ps=null;

	public void insertUserData(String firstname,String lastname,String username,String pwd,String city,String mail_id,String mobno){
		
		try {
			
		    con = ConnectionEstablish.getconnection();
			String sql="insert into userregister(firstname,lastname,username,upassword,city,mail_id,mobileno)values(?,?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, username);
			ps.setString(4, pwd);
			ps.setString(5, city);
			ps.setString(6, mail_id);
			ps.setString(7, mobno);
			
			int i=ps.executeUpdate();
			System.out.println("data inserted succesfully");
			
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
	
	
	public void excute(){
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the firstname");
		String fname=sc.next();
		
		System.out.println("enter the lastname");
		String lname=sc.next();
		
		System.out.println("enter the username");
		String uname=sc.next();
		
		System.out.println("enter the password");
		String pwd=sc.next();
		
		System.out.println("enter the city name");
		String city=sc.next();
		
		System.out.println("enter the mail Id");
		String mailid=sc.next();
		
		System.out.println("enter the mobileno");
		String mobno=sc.next();
		
		this.insertUserData(fname, lname, uname, pwd, city, mailid, mobno);
		
	}
	
	public void getregisterUserlist(){
		
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			
			 con = ConnectionEstablish.getconnection();
			 String sql="select * from userregister ";
			 ps=con.prepareStatement(sql);
			 ResultSet rs=ps.executeQuery();
			 
			 while(rs.next()){
				 
				 System.out.println("Id :"+rs.getString(1));
				 System.out.println("First Name"+rs.getString(2));
				 System.out.println("Last Name:"+rs.getString(3));
				 System.out.println("User Name :"+rs.getString(4));
				 System.out.println("Password :"+rs.getString(5));
				 System.out.println("City :"+rs.getString(6));
				 System.out.println("mail id :"+rs.getString(7));
				 System.out.println("Mobile No :"+rs.getString(8));
				 
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
		
		
}
	
	
	


