package com.shipping;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cart extends ProductsMapClass {
	// classs starts Here....
	ProductsMapClass productsmapclassobj = new ProductsMapClass(); // Products
																	// map class
																	// object
	int option;
	Integer product_id;
	HashMap<Integer, AddProduct> cartmapobj = new HashMap<>(); // hash map for
																// cart class
	Scanner scanner = new Scanner(System.in); // scanner class object

	void userMenu() { // user menu for adding products to cart,searching and
						// delete product from cart
		System.out.println("1.Add product To Cart \t2.search product In Cart\t3.delete product From cart");
		System.out.println("enter your option...");
		option = scanner.nextInt();
		switch (option) {
		case 1:
			System.out.println("enter product id...");
			product_id = scanner.nextInt();
			AddProduct ob = ProductsMapClass.addCart(product_id);
			addMainCart(product_id, ob); // adding product to cart
			break;
		case 2:
			System.out.println("enter pid to search.....");
			product_id = scanner.nextInt();
			searchCart(product_id); // searching product in cart
			break;
		case 3:
			System.out.println("enter which item you want to delete from your cart");
			product_id = scanner.nextInt();
			AddProduct ob1 = delete(product_id); // deleting product from cart
			if (ob1 != null) {
				productsmapclassobj.addProduct(product_id, ob1); // adding_deleted_product_to_products
				againUserMenu();
			}
			break;
		case 4:
			viewCart();
			againUserMenu();
			break;
		default:
			System.out.println("oops.! ... Sorry please select a valid option...");
			userMenu();
			break;
		}
	}

	private void viewCart() { //view cart method
		// TODO Auto-generated method stub
		for(Map.Entry<Integer,AddProduct > entry:cartmapobj.entrySet())
		{
			int key = entry.getKey();
			AddProduct obj = entry.getValue();
			System.out.print(key + " Details:");
			System.out.println(" " + obj.getProduct_id() + " " + obj.getProduct_name() + " " + obj.getProduct_price());
		}
		
	}

	private void searchCart(int pid2) { // searching product form cart
		// TODO Auto-generated method stub
		if (cartmapobj.containsKey(pid2)) {
			System.out.println("product is available ..");
			againUserMenu();
		} else {
			System.out.println("oops!..... sorry searched item ids not there.....");
			userMenu();
		}

	}

	private void againUserMenu() { // navigating to user menu
		// TODO Auto-generated method stub
		System.out.println("do you wnat to continue....1.YES\t2. NO");
		option = scanner.nextInt();
		if (option == 1)
			userMenu();
		else {

		}
	}

	private void addMainCart(int pid2, AddProduct addproduct_obj) { // adding_product_to_cart
		// TODO Auto-generated method stub
		if (!cartmapobj.containsKey(pid2) && addproduct_obj != null) {
			cartmapobj.put(pid2, addproduct_obj);
			System.out.println("Successfully your item is added to cart");
			againUserMenu();
		} else {
			System.out.println("oops!...Sorry try with different ");
			userMenu();
		}
	}

	public AddProduct delete(Integer pid) { // delete product from cart
		if (cartmapobj != null && cartmapobj.containsKey(pid)) {
			AddProduct addproduct_obj = cartmapobj.get(pid);
			cartmapobj.remove(pid);
			System.out.println("successfully item is deleted from cart and added to products....");
			return addproduct_obj;
		} else {
			System.out.println("oops!....Sorry item is not there in cart.....");
			userMenu();
			return null;
		}

	}

}