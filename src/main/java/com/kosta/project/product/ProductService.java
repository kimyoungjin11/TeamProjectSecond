package com.kosta.project.product;

import java.util.List;

import com.kosta.project.product.vo.CategoryVO;

public class ProductService {
	ProductDAO productDAO = new ProductDAO();
	
	public int maxProductNO() {
		return productDAO.maxProductNO();
	}
	
	public List<Product> listProduct(){
		List<Product> productList = productDAO.selectAllProduct();
		return productList;
	}
	
	//상품 등록
	public int productInsert(Product product) {
		return productDAO.productInsert(product);
	}
	
	//카테고리
	public List<CategoryVO> selectCategoryName(){
		return productDAO.selectCategoryName();
	}

	public int inserProductImages(int pid, List<String> imageList) {
		// TODO Auto-generated method stub
		return productDAO.insertProductImages(pid, imageList);
	}


}
