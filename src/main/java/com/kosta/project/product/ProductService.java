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

	//상품 등록
	public int insertProduct(Product product, String userId) {
		return productDAO.productInsert(product, userId);
	}

}
