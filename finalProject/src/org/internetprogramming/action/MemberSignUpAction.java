package org.internetprogramming.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.internetprogramming.dao.MemberDao;
import org.internetprogramming.model.MemberBean;

public class MemberSignUpAction implements Action {
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		ServletContext context = req.getServletContext();
		req.setCharacterEncoding("EUC-KR");
		context.log(">>>>>>>>> " + req.getParameter("name"));
		String uid = req.getParameter("uid");
		MemberBean member = new MemberBean();
		MemberDao dao = new MemberDao();
		member.setName(req.getParameter("name"));
		member.setUid(req.getParameter("uid"));
		member.setPw(req.getParameter("pw"));
		
		dao.insertMember(member);
		forward.setRedirect(true);
		forward.setNextPath("home.do");
		
		return forward;
	}
}
