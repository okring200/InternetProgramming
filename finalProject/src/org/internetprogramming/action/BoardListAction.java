package org.internetprogramming.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.internetprogramming.dao.BoardDao;
import org.internetprogramming.model.BoardBean;

public class BoardListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		int spage = 1;
		String page = request.getParameter("page");
		
		if(page != null)
			spage = Integer.parseInt(page);
		
		BoardDao dao = new BoardDao();
		int listCount = dao.getBoardListCount();
		ArrayList<BoardBean> list =dao.getBoardList(spage);
		int maxPage = (int)(listCount/10.0 + 9.0);
		int startPage = (int)(spage/5.0 + 0.8) * 5 - 4;
		int endPage = startPage + 4;
		if(endPage > maxPage)endPage = maxPage;
		
		request.setAttribute("spage", spage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		request.setAttribute("list", list);
		
		forward.setRedirect(false);
		forward.setNextPath("boardListPage.bo");
		return forward;
	}
	
}
