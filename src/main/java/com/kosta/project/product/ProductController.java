package com.kosta.project.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProductService productService;
	Product product;
	
	
	public void init() throws ServletException{
		productService = new ProductService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nextPage = "";
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String action = request.getServletPath();
		System.out.println("action:" + action);
		try {
			List<Product> productList = new ArrayList<Product>();
			if(action == null) {
				productList = productService.listProduct();
				request.setAttribute("productList", productList);
				nextPage= "/jsp/board/boardList.jsp";
			} else if(action.equals("/listProduct.do")) {
				productList = productService.listProduct();
				request.setAttribute("productList", productList);
				nextPage= "/jsp/board/boardList.jsp";
			}
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
