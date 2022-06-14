package com.kosta.project.reply;

import java.util.List;

public class ReplyService {
	
	ReplyDAO replyDAO = new ReplyDAO(); 
	
	public List<Reply> replyList(int boardId){
		List<Reply> list = replyDAO.getReplyList(boardId);
		return list;
	}
	
	public void create(Reply reply) {
		replyDAO.writeReply(reply);
		}
}
