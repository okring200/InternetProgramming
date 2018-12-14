package org.internetprogramming.action;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.internetprogramming.dao.PopDao;
import org.internetprogramming.model.PopBean;


public class popAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		String y = request.getParameter("year");
		int year = 0;
		if(y != null)
			year = Integer.parseInt(y);
		
		PopDao dao = new PopDao();
		ArrayList<PopBean> list = dao.getPopList(year);
		ServletContext context = request.getServletContext();

		request.setAttribute("list", list);
		forward.setRedirect(false);
		forward.setNextPath("popListPage.po");
		return forward;
	}

}
