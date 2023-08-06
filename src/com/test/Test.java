package com.test;

import java.util.Scanner;

import com.action.DisplayProduct;
import com.action.LoginUser;
import com.action.RegisterUser;
import com.admin.AddProduct;
import com.admin.AdminLogin;
import com.product.cart.AddToCart;
import com.product.cart.BillOfProduct;



public class Test {
	
   /* public void display(){
		
		System.out.println("Welcome to E-Commerce based application\n");
		System.out.println("1.User Registration");
		System.out.println("2.User Login");
		System.out.println("3.User view Product item as Sorted Order");
		System.out.println("4.Buy Product");
		System.out.println("5 View Cart ");
		System.out.println("6.Purchase the item");
		System.out.println("7.Cube of number");
		System.out.println("8.Average of numbers");
		System.out.println("9.Factors of numbers");
		System.out.println("10.Find out even or odd number");
		
		System.out.println("=====================================================");
		
		System.out.println("chosse the option from above");
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
		
		choose(ch);

	}

*/
	
	public void userOperation(){
		
		System.out.println("Welcome to E-Commerce based application\n");
		System.out.println("1.User Registration");
		System.out.println("2.User Login");
		System.out.println("3.User view Product item as Sorted Order");
		System.out.println("4 View Cart ");
		System.out.println("5.Buy Product");
		System.out.println("6.Purchase the item");
		System.out.println("7.exit");
		System.out.println("===========================================================");
		
		System.out.println("chosse the option from above");
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
		
		choose(ch);
		
	}
	
	public void adminOperation(){
		
		System.out.println("Welcome to E-Commerce based application\n");
		System.out.println("1.Add product item");
		System.out.println("2.Calculate Bill");
		System.out.println("3.Display amount to End User");
		System.out.println("4.Check Quantity");
		System.out.println("5.Check registered user");
		System.out.println("6.Check the particular user history");
		System.out.println("7.exit");
		System.out.println("====================================================");
		
		System.out.println("chosse the option from above");
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
		
		operationsofAdmin(ch);
		
	}
	
	private void operationsofAdmin(int ch) {
		
		 switch (ch) {
			case 1:

				 System.out.println("===========Add Product================");
		         AdminLogin admin=new AdminLogin();
		         admin.insert();
				 System.out.println("============================================");
			
				break;
				
			case 2:

				 System.out.println("===========Add Product================");
				 System.out.println("============================================");
			
				break;	
		
			case 3:

				 System.out.println("===========Add Product================");
		         /*AdminLogin admin=new AdminLogin();
		         admin.insert();*/
				 System.out.println("============================================");
			
				break;
				
			case 4:

				 System.out.println("===========Check Quantity================");
		         AddProduct add=new AddProduct();
		         add.execute();
				 System.out.println("1.Back");
				 System.out.println("2.Exit");
				 Scanner sc=new Scanner(System.in);
				 ch=sc.nextInt();
				 if(ch==1){
					 this.adminOperation();
				 }else{
					 this.display();
				 }

		         
			    break;	
		
			case 5:

				 System.out.println("===========Registered User List================");
		         RegisterUser user=new RegisterUser();
		         user.getregisterUserlist();
		         
			    break;	 
			    
			case 6:

				 System.out.println("===========User History By Username================");
				 AdminLogin admin1=new AdminLogin();
		         admin1.execute();
		         
		         break;	     
		   
			case 7:
				this.display();
				
			default:
				System.out.println("enter valid number");	
				System.out.println("=====================================================");
				this.adminOperation();
				
	}
}		 

	public void display(){
		
		try {
			
			System.out.println("select role...............");
			System.out.println();
			System.out.println("1.User panel");
			System.out.println("2.Admin panel");
			System.out.println("3.As a guest");
			System.out.println("=============================================================");
			
			
			System.out.println("chosse the option from above");
			Scanner sc=new Scanner(System.in);
			int ch=sc.nextInt();
			
			operation(ch);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
  private void operation(int ch) {
	  
  Scanner sc=new Scanner(System.in);
	  
	  try {
		switch (ch) {
			case 1:

				 System.out.println("===========You are performing user operaTion===============================");
				 this.userOperation();
				 System.out.println("============================================");
			
				break;
				
			case 2:

				 System.out.println("===========You are performing admin operaTion=============================");
				 System.out.println("===========Enter Credential================");
				 
				 AdminLogin admin=new AdminLogin();
				 String name=admin.loginAdmin();
				 
				 if(name.equals("")){
					 System.err.println("invalid userid and password");
				 }else{
					 this.adminOperation();
				 }
				 System.out.println("============================================");
			
				break ;	
				
				
				
			case 3:
				
				 System.out.println("===========As a guest================");
				 System.out.println("1.view product");
				 System.out.println("2.you want to buy product please register here");
				 
				 System.out.println("chosse the option from above");
				 ch=sc.nextInt();
				 
				 DisplayProduct display=new DisplayProduct();
				 if(ch==1){
					 display.getProductDetails();
				 }else{
					 this.userOperation();
				 }
				 
				 break ;
				 
			default:
				System.out.println("enter valid number");	
				System.out.println("=====================================================");
				this.display();
				 
				 
			
				}
	} catch (Exception e) {
		System.out.println("please Enter Numeric values between 1-3");
		System.out.println("---------------------------------------");
	}


  }



private void choose(int ch) {
	  
	  Scanner sc=new Scanner(System.in);
	  
	  switch (ch) {
		case 1:

			 System.out.println("===========You are performing user operaTion================");
			 RegisterUser ruser=new RegisterUser();
             ruser.excute();
			break;
			
		case 2:
			
			 System.out.println("===========User login================");
			 LoginUser loginUser=new LoginUser();
			 String name=loginUser.loginUser();
			 if(name.equals("")){
				 System.err.println("invalid userid and password");
			 }else{
				 this.display();
			 }

			 break;		
			
		case 3:
			
			 System.out.println("===========Display Product================");
			 DisplayProduct display=new DisplayProduct();
			 display.getProductDetails();
			 System.out.println();
			 System.out.println("1.Back");
			 System.out.println("2.Exit");
			 
			 ch=sc.nextInt();
			 if(ch==1){
				 this.userOperation();
			 }else{
				 this.display();
			 }

			 break;
			 
			 
		case 4:
			System.out.println("You have Selected Add to cart");
			System.out.println("-----------------------------------");
			AddToCart cart = new AddToCart();
			cart.addProductToCart();

			break;
			
		case 5:
			System.out.println("You have Selected Buy Product");
			System.out.println("----------------------------");
			BillOfProduct buy = new BillOfProduct();
			buy.addProduct();

			break;
		
			
		case 7:
			this.display();
			 
			 default:
			 System.out.println("enter valid number");	
			 System.out.println("=====================================================");
			 this.userOperation(); 
	
   }

  }

public static void main(String[] args) {
		
		Test test=new Test();
		test.display();
		
	}

}
