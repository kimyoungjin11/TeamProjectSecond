package com.kosta.project.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.project.member.model.service.MemberService;
import com.kosta.project.member.vo.Member;

/**
 * Servlet implementation class NickDuplicateCheck
 */
@WebServlet("/member/nickname")
public class NickDuplicateCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String nickname = request.getParameter("nickName");
       //System.out.println("emp_Id:" + nickname);
        //DB에 직원id가 존재하는지 체크한다. ???empService->empDAO-->DB
        MemberService service = new MemberService();
        Member member = service.selectByNick(nickname);
        PrintWriter out = response.getWriter();
        out.print(member==null?0:1);
	}

	

}
