package com.shipping;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductsMapClass {
	// class starts Here....

	final static HashMap<Integer, AddProduct> hashmap = new HashMap<>(); // hash_map_object
	int option;
	int product_id;
	Scanner scanner = new Scanner(System.in); // scanner class object

	public static AddProduct addCart(Integer pid) { // adding product to cart checking
		if (!hashmap.isEmpty()) {
			AddProduct addproductobject;
			if (hashmap.containsKey(pid)) { // checking condition if key not there in cart then add
				addproductobject = hashmap.get(pid);
				hashmap.remove(pid);

				return addproductobject;

			} else
				addproductobject = null;
			return addproductobject;
		} else {
			System.out.println("sorry there is no item in products...");
			return null;
		}
	}

	public void check_Product(Integer pid) { // checking product is available or
												// not in the products
		if (hashmap.containsKey(pid)) {
			System.out.println("product is available");
			chechProduct();

		} else
			System.out.println("product is not available");
		chechProduct();
	}

	public void addProduct(Integer pid, AddProduct ad) { // adding product to
															// products(hash map)
		if (!hashmap.containsKey(pid)) {
			hashmap.put(pid, ad);
			System.out.println("Details are added to your site.....");
			againAddProduct(); // navigating to again add product
		} else {
			System.out.println("oops!.... Sorry you cant add this item,it is already there .... ");
			againAddProduct(); // navigating to again add product
		}
	}

	public void chechProduct() { // checking products menu
		System.out.println("do you want to check products......1. YES \t2. NO");
		option=0;
		option = scanner.nextInt();
		if (option == 1) {
			System.out.println("enter product-id to check");
			product_id = scanner.nextInt();
			check_Product(product_id); // passing product Id to Check product
		} else {
			System.out.println("Do you want to logout 1.Yes \t2.No");
			option = scanner.nextInt();
			if (option == 2) {
				againAddProduct(); // calling again add product method if admin
									// don't want to logout

			} else {
				UI.main(null);

			}

		}

	}

	private void againAddProduct() { // again-add-products menu
		// TODO Auto-generated method stub
		System.out.println("do you want to add more products.. 1.yes 2.No");
		option = scanner.nextInt();
		if (option == 1) {
			UI oo = new UI();
		} else {
			chechProduct();
		}

	}

	public void viewProducts() { // viewing products for user

		for (Map.Entry<Integer, AddProduct> entry : hashmap.entrySet()) {
			int key = entry.getKey();
			AddProduct b = entry.getValue();
			System.out.print(key + " Details:");
			System.out.println(" " + b.getProduct_id() + " " + b.getProduct_name() + " " + b.getProduct_price());

		}

	}

	public static AddProduct searchProduct(Integer pid) { // searching products
															// for user
		if (hashmap.containsKey(pid))
			return hashmap.get(pid);
		else
			return null;
	}

}
