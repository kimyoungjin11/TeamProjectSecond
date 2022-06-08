package com.kosta.project.product;

import java.util.List;

public class ProductService {
	ProductDAO productDAO;
	
	public ProductService() {
		productDAO = new ProductDAO();
	}
	
	public List<Product> listProduct(){
		List<Product> productList = productDAO.selectAllProduct();
		return productList;
	}
}
