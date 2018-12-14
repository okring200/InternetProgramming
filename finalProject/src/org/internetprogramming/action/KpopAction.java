package org.internetprogramming.action;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.internetprogramming.dao.KpopDao;
import org.internetprogramming.model.KpopBean;

public class KpopAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		String y = request.getParameter("year");
		int year = 0;
		if(y != null)
			year = Integer.parseInt(y);
		
		KpopDao dao = new KpopDao();
		ArrayList<KpopBean> list = dao.getKpopList(year);
		ServletContext context = request.getServletContext();

		request.setAttribute("list", list);
		forward.setRedirect(false);
		forward.setNextPath("kpopListPage.po");
		return forward;
	}

}
