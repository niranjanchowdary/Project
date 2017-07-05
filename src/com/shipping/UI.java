package com.shipping;

import java.util.Scanner;

public class UI {
	
	//user profile
	int option;
	Boolean choice = true;
	Integer product_id;
	String admin_name, admin_pass, product;
	Float product_price;
	Scanner scanner = new Scanner(System.in);
	Admin admincheck_object = new Admin(); // admin_class_object
	ProductsMapClass productmapclass_obj = new ProductsMapClass(); // product_map_class_object
	Cart ct = new Cart();

	UI() {
		System.out.println("enter product details to store in your site\n 1.product_id \t 2.product_name\t 3.product_price");
		System.out.println("product-ID :");
		product_id = scanner.nextInt();
		System.out.println("product-Name :");
		product = scanner.next();
		System.out.println("product-price :");
		product_price = scanner.nextFloat();
		AddProduct obb = new AddProduct(product_id, product, product_price);
		productmapclass_obj.addProduct(product_id, obb);
	}

	UI(int i) {
		System.out.println("-------------------------------------------");
		System.out.println("-----------------welcome-------------------");
		System.out.println("-------------------------------------------");
		menu();
	}

	public void menu() {
		// TODO Auto-generated method stub
		do {
			System.out.println("1.Admin \t2.user\t\t3.exit");
			option = scanner.nextInt();
			if (option == 1) {
				System.out.println("enter admin-name and password");
				System.out.print("UserName :");
				admin_name = scanner.next();
				System.out.print("password :");
				admin_pass = scanner.next();
				if (admincheck_object.ckeckAdmin(admin_name, admin_pass)) {
					new UI();

				} else {

					System.out.println("oops!..invalid details please check once again and try..");
					menu();
				}
			} else if (option == 2) {
				productmapclass_obj.viewProducts();
				ct.userMenu();

			} else if (option == 3) {
				choice = false;
				System.out.println("Thank you, Visit Again...!!!!");
			} else {
				System.out.println("oop!... please try again..");
				menu();
			}
		} while (choice);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UI(1);

	}
	// classs starts Here....
}
