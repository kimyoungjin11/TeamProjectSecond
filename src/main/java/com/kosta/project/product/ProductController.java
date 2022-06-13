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

import com.kosta.project.reply.Reply;
import com.kosta.project.reply.ReplyService;


@WebServlet("*.do")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProductService productService;
	Product product;
	Reply reply;
	ReplyService replyService;
	
	
	public void init() throws ServletException{
		productService = new ProductService();
		replyService = new ReplyService();
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
//				productList = productService.listProduct();
//				request.setAttribute("productList", productList);
//				nextPage= "/jsp/board/boardList.jsp";
				System.out.println("하이");
//			} else if(action.equals("/listProduct.do")) {
//				productList = productService.listProduct();
//				request.setAttribute("productList", productList);
//				nextPage= "/jsp/board/boardList.jsp";
			} else if(action.equals("/product/view.do")) {
				System.out.println("view호출");
				String productId = request.getParameter("productId");
				List<Reply> replylist = replyService.replyList(Integer.parseInt(productId));
				product = productService.view(Integer.parseInt(productId));
				request.setAttribute("productView", product);
				request.setAttribute("replyList", replylist);
				nextPage = "/jsp/board/boardDetail.jsp";
			} else if(action.equals("/writeReply.do")) {
				System.out.println("reply작성");
				String productId = request.getParameter("productId");
				nextPage = "/product/view.do?productId="+productId;
			}
			
			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
