package org.internetprogramming.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.internetprogramming.dao.MemberDao;
import org.internetprogramming.model.MemberBean;

public class MemberLogoutAction implements Action {
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		HttpSession session = req.getSession();
		if(session != null) {
			session.invalidate();
		}
		forward.setRedirect(true);
		forward.setNextPath("home.do");
		return forward;
	}
}
