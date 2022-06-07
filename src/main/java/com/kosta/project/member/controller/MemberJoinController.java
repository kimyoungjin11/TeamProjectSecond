package com.kosta.project.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.project.member.model.service.MemberService;
import com.kosta.project.member.vo.Member;

/**
 * Servlet implementation class MemberJoinController
 */
@WebServlet("/member/memberEnroll")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수정하기
		request.setCharacterEncoding("utf-8");
		Member member = makeEmp(request);
		MemberService service = new MemberService();
		int result = service.insertMember(member);
		request.setAttribute("message", result>0?"직원정보 insert성공":"직원정보 insert실패");
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}
	
	private Member makeEmp(HttpServletRequest request) {
		Member emp = new Member();
		String userId = request.getParameter("userId");
		System.out.println(userId);
		String userName = request.getParameter("userName");
		System.out.println(userName);
		String userPassword = request.getParameter("userPassword");
		System.out.println(userPassword);
		String nickName = request.getParameter("nickName");
		System.out.println(nickName);
		String phone = request.getParameter("phone");
		System.out.println(phone);
		
		emp.setUserId(userId);
		emp.setUserName(userName);
		emp.setUserPassword(userPassword);
		emp.setNickName(nickName);
		emp.setPhone(phone);
		return emp;
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
			request
				.getRequestDispatcher("/jsp/memberEnroll.jsp")
				.forward(request, response);
	
	
	}
	
	}
