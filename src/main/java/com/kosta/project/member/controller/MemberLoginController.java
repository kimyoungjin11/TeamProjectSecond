package com.kosta.project.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.project.member.model.service.MemberService;
import com.kosta.project.member.vo.Member;

/**
 * Servlet implementation class MemberLoginController
 */
@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		Member member = memberService.selectOneMember(userId);
		System.out.println("userId = " + userId + ", password = " + password);

		HttpSession session = request.getSession();

		session.setMaxInactiveInterval(10 * 1800);

		if (member != null && password.equals(member.getUserPassword())) {
			System.out.println("여기서찍었씁니다 : " + member);
			session.setAttribute("loginMember", member);
			session.setAttribute("msg", "로그인되었습니다.");
			Member loginMember = (Member) session.getAttribute("loginMember");

		}

		else if (member == null || !password.equals(member.getUserPassword())) {

			session.setAttribute("msg", "아이디 또는 비밀번호가 맞지 않습니다.");

		}

//               String location = request.getContextPath() + "/";
//                response.sendRedirect(location);
		request.getRequestDispatcher("/jsp/header.jsp").forward(request, response);

	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        
//        String referer = request.getHeader("referer");
//        
//        request.setAttribute("referer", referer);
//        
//
//        request.getRequestDispatcher("/WEB-INF/jsp/common.jsp")
//        .forward(request, response);
//    }

}
