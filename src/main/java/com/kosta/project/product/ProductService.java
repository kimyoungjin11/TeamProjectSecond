package com.kosta.project.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kosta.project.product.vo.CategoryVO;

public class ProductService {
	ProductDAO productDAO = new ProductDAO();
	

	/* //상품 전체
	 * public List<Product> listProduct(){ List<Product> productList =
	 * productDAO.selectAllProduct(); return productList;
	 */
	
	//상품 검색
	public List<Product> listProduct(String category_id, String keyword, String sort){
		List<Product> productList = productDAO.selectAllProduct(category_id, keyword, sort);
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
	

	//insert 후 productid 얻기(이미지 업로드 시 전달)
	public int maxProductNO() {
		return productDAO.maxProductNO();
	}
	
	//이미지삽입
	public int insertProductImages(int pid, List<String> imageList) {
		return productDAO.insertProductImages(pid, imageList);


	
	public Product view(int productId) {
		Product viewProduct = productDAO.selectProductById(productId);
		return viewProduct;

	}


}
