package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.project.connection.ConnectionEstablish;

public class AdminLogin {
	
	
public String checkAdminExist(String username,String pwd){
		
		Connection con=null;
		PreparedStatement ps=null;
		String name="";
		
		try {
			
			con = ConnectionEstablish.getconnection();
			String sql="select ausername from admin where ausername='"+username+"' and apassword='"+pwd+"' ";
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


public String loginAdmin(){
	
	String nm="";
	try {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the username");
		String uname=sc.next();
		
		System.out.println("enter the password");
		String pwd=sc.next();
		
		nm = this.checkAdminExist(uname,pwd);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return nm;
	
}


public void insert(){
	
	
	
	try {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter product name");
		String productname=sc.next();
		
		System.out.println("enter product description");
		String producdescription=sc.next();
		
		System.out.println("enter product price");
		String price=sc.next();
		
		System.out.println("enter product quantity");
		String quantity=sc.next();
		
		this.insertProduct(productname,producdescription,price,quantity);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
	
}

private void insertProduct(String productname, String producdescription, String price, String quantity) {
	
	Connection con=null;
	PreparedStatement ps=null;
	
	try {
		
		con = ConnectionEstablish.getconnection();
		String sql="insert into product(pdescription ,pname ,price ,quantity)values(?,?,?,?)";
		ps=con.prepareStatement(sql);
		
		ps.setString(1, producdescription);
		ps.setString(2, productname);
		ps.setString(3, price);
		ps.setString(4, quantity);
		
		int i=ps.executeUpdate();
		System.out.println("data inserted succesfully");
		
		
		
		
	} catch (Exception e) {
	   e.printStackTrace();	
	}
	
}


public void execute(){
	
	Scanner sc=new Scanner(System.in);
	
	System.out.println("enter the username");
	String uname=sc.next();
	
	this.getuserbyUsername(uname);
	
	
}


private void getuserbyUsername(String uname) {
	
	Connection con=null;
	PreparedStatement ps=null;
	
	try {
		
		con = ConnectionEstablish.getconnection();
		String sql="select * from userregister where username='"+uname+"'  ";
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
			
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
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
