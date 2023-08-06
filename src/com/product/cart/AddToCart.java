package com.product.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.project.connection.ConnectionEstablish;


public class AddToCart {
	
	
	public void addProductToCart() {

		Connection con=null;
		PreparedStatement ps=null;
		Scanner input = new Scanner(System.in);

		try {

			con = ConnectionEstablish.getconnection();

			ps = con.prepareStatement("insert into addtoCart (productId,quantity) values(?,?)");

			System.out.println("Enter number of product you want to add to Cart : ");
			int count = input.nextInt();
			for (int i = 1; i <= count; i++) {
				System.out.println("Enter Product Id :");
				int productId = input.nextInt();
				System.out.println("Enter Product Quantity :");
				int quantity = input.nextInt();

				ps.setInt(1, productId);
				ps.setInt(2, quantity);

				int add = ps.executeUpdate();

				System.out.println(add + " Product added Successfully...");
				System.out.println("------------------------------------");
				/*Design d = new Design();
				d.orderOperation();*/
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
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