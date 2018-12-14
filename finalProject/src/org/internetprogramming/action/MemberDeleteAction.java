package org.internetprogramming.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.internetprogramming.dao.MemberDao;

public class MemberDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		
		ServletContext context = request.getServletContext();
		String uid = request.getParameter("uid");
		
		MemberDao dao = new MemberDao();
		if(uid != null) {
			dao.deleteMember(uid);
		}
		
		forward.setNextPath("manage.do");
		forward.setRedirect(false);
		return forward;
	}

}
