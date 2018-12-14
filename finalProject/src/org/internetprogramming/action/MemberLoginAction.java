package org.internetprogramming.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.internetprogramming.dao.MemberDao;
import org.internetprogramming.model.MemberBean;

public class MemberLoginAction implements Action{
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		ServletContext context = req.getServletContext();
		String uid = req.getParameter("uid");
		String pw = req.getParameter("pw");
		
		//context.log(uid + "/" + pw);
		MemberBean member = null;
		MemberDao dao = new MemberDao();
		member =dao.selectById(uid);
		if(member != null) {
			if(pw.equals(member.getPw())) {
				HttpSession session = req.getSession();
				if(uid.equals("admin")) 
					session.setAttribute("admin", member);
				else
					session.setAttribute("member", member);
				forward.setNextPath("home.do");
				forward.setRedirect(true);
			}else {
				forward.setNextPath("login_page.do");
				forward.setRedirect(false);
			}
		}else {
			context.log(">>>>>>>>>> no id");
			forward.setNextPath("login_page.do");
			forward.setRedirect(false);
		}
		return forward;
	}
}

