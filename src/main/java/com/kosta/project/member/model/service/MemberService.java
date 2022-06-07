package com.kosta.project.member.model.service;

import com.kosta.project.member.model.dao.MemberDAO;
import com.kosta.project.member.vo.Member;

public class MemberService {
	MemberDAO memberDAO = new MemberDAO();
	
	public Member selectOneMember(String userId) {
		return memberDAO.selectOneMember(userId);
		}


	public int insertMember(Member member) {
		return memberDAO.insertMember(member);
	}
	
}
