package com.kosta.project.productsearch;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.project.product.ProductService;

@WebServlet("/listProduct.do")
public class ProductSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService productService = new ProductService();
	 
		
		request.setAttribute("productList", productService.listProduct("%", "%", "asc"));
		request.setAttribute("clist", productService.selectCategoryName());
		
		String nextPage = "/jsp/board/productsearch.jsp";

		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);

	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String category_id = request.getParameter("category_id");
	    String keyword = request.getParameter("keyword");
	    String sort = request.getParameter("sort");
	    System.out.println(category_id);
	    System.out.println(keyword);
	    System.out.println(sort);
	    
	    ProductService productService = new ProductService();
		request.setAttribute("productList", productService.listProduct(category_id, keyword, sort));
		request.setAttribute("clist", productService.selectCategoryName());
		String nextPage = "/jsp/board/productsearch2.jsp";

		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);

	}
	
	
}
