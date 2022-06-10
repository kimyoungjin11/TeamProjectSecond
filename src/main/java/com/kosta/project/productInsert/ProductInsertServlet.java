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
	private static final String UPLOAD_DIR = "uploads"; //test
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ProductService pService = new ProductService();
		List<CategoryVO> clist = pService.selectCategoryName();
		request.setAttribute("clist", clist);	
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("productInsert.jsp");
		rd.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //한글 인코딩

		Product product = new Product();
		ProductService pService = new ProductService();

		String dir = request.getServletContext().getRealPath(UPLOAD_DIR);
		System.out.println("웹서버 경로 : " + dir);
		Map<String, Object> map = UploadFileHelper.uploadFile(UPLOAD_DIR, request);
		Map<String, String> mapParams = (Map<String, String>) map.get("params");
		for(String key:mapParams.keySet()) {
			if(key.equals("category_id")) product.setCategory(Integer.parseInt(mapParams.get("category_id")));
			if(key.equals("price")) product.setPrice(Integer.parseInt(mapParams.get("price")));
			if(key.equals("join_number")) product.setJoinNumber(Integer.parseInt(mapParams.get("join_number")));
			 
			if(key.equals("title")) product.setproductTitle(mapParams.get("title"));
			if(key.equals("content")) product.setproductContent(mapParams.get("content"));
		}
		
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginMember");
		//Member member = new Member(); member.setUserId("admin"); //윗줄과 trade
		product.setUserId(member.getUserId());
		System.out.println(product);
		System.out.println(member.getUserId());
		
		int result = pService.productInsert(product);//product table insert
		int pid = pService.maxProductNO();
		List<String> imageList = (List<String>)map.get("photos");
		int imgresult = pService.insertProductImages(pid, imageList);

		
			
		request.setAttribute("message", result>0? "게시 성공" : "게시 실패");
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("index.jsp");
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
		//Member member = (Member)session.getAttribute("loginMember");
		 Member member = new Member();
		 member.setUserId("admin");

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
		return Integer.parseInt(data);
	}
	

}
