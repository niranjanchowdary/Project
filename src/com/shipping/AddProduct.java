package com.shipping;

public class AddProduct {  //pojo class (AddProduct)
	// classs starts Here....
	private Integer product_id;
	private String product_name;
	private Float product_price;

	public AddProduct(Integer pid, String item, Float price) { // Adding Products with constructor
		// TODO Auto-generated constructor stub
		this.product_id = pid;
		this.product_name = item;
		this.product_price = price;
	}
	
//  getters and setters methods 
	
	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Float getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Float product_price) {
		this.product_price = product_price;
	}

}
