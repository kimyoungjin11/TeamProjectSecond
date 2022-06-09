package com.kosta.project.productInsert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.project.member.vo.Member;
import com.kosta.project.product.Product;
import com.kosta.project.product.ProductService;
import com.kosta.project.product.vo.CategoryVO;
import com.kosta.project.util.UploadFileHelper;

/**
 * Servlet implementation class ProductInsertController
 */
@WebServlet("/jsp/productInsert.do")
public class ProductInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "uploads";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ProductService pService = new ProductService();
		List<CategoryVO> clist = pService.selectCategoryName();
		request.setAttribute("clist", clist);	
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("productInsert.jsp");
		rd.forward(request, response);
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블맀 왔습니다.");
		request.setCharacterEncoding("utf-8"); //한글 인코딩
		Product product = productInsert(request);
		System.out.println("서블맀 왓습니다2");
		ProductService pService = new ProductService();
		String dir = request.getServletContext().getRealPath(UPLOAD_DIR);
		System.out.println("웹서버 경로 : " + dir);
		Map<String, Object> map = UploadFileHelper.uploadFile(UPLOAD_DIR, request);
		
				
		int result = pService.productInsert(product);
		
			
		//request.setAttribute("message", result>0? "게시 성공" : "게시 실패");
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/member/login.jsp");
		rd.forward(request, response);
	
	}
	
	private Product productInsert(HttpServletRequest request) {
		Product product = new Product();
		
		int categoryId = readInt(request, "category_id");
		
		int price = readInt(request, "price");
		int join_number = readInt(request, "join_number");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
	
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginMember");
		
		
		 //Member member = new Member(); member.setUserId("admin");
		 
		System.out.println(member);
		
		
		product.setUserId(member.getUserId());
		product.setCategory(categoryId);
		product.setPrice(price);
		product.setJoinNumber(join_number);
		product.setproductTitle(title);
		product.setproductContent(content);
		
		
		System.out.println(product);
		return product;
	}
	
	private int readInt(HttpServletRequest request, String column) {
		String data = request.getParameter(column);
		System.out.println(data);
		return Integer.parseInt(data);
	}
	

}
