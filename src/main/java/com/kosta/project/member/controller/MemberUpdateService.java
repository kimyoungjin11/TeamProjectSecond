package com.kosta.project.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.kosta.project.member.model.dao.MypageDAO;
import com.kosta.project.member.vo.Member;

@WebServlet("/MemberUpdateService")
public class MemberUpdateService extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 로그인한 id (email)과 수정하고 싶은 pw, phone를 콘솔창에 출력
		
		// 포스트 방식의 한글이 깨지지 않는 인코딩은 request.
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		session.setAttribute("info", new Member("admin", "1234", "01012341234") );
		Member info = (Member) session.getAttribute("info"); // login 정보 담기.
		String userid = info.getUserId(); // login 정보에서 email가져오기.
		
		// 수정하려고 사용자가 입력한 정보는 request에 있으니 옮겨담기
		String userPassword = request.getParameter("pw");
		String phone = request.getParameter("tel");
		
		Member dto = new Member(userid, userPassword, phone); // dto를 통해 회원정보를 하나로 묶어주기
		MypageDAO dao = new MypageDAO(); // dao를 통해 회원정보 수정요청
		int cnt = dao.memberupdate(dto); // 하나로 묶인 회원정보를 매개변수로 받는 dao.update.
		// 결과는 int로 돌려받는다.

		if (cnt > 0) {
			System.out.println("회원정보수정 성공");
		} else {
			System.out.println("회원정보수정 실패");
		}
	}
}
