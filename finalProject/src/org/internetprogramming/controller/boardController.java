package org.internetprogramming.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.internetprogramming.action.Action;
import org.internetprogramming.action.ActionForward;
import org.internetprogramming.action.BoardDetailAction;
import org.internetprogramming.action.BoardListAction;
import org.internetprogramming.action.BoardWriteAction;
import org.internetprogramming.action.FileDownloadAction;

/**
 * Servlet implementation class boardController
 */
@WebServlet("/boardController")
public class boardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doProcess(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("EUC-KR");
		resp.setContentType("text/html;charset=EUC-KR");
		
		ServletContext context = req.getServletContext();

		context.log(">>>>>>>>> boardController do process");
		String ctxPath = req.getContextPath(); //root 경로
		String reqUri = req.getRequestURI();   //전체 주소
		String command = reqUri.substring(ctxPath.length()); // ctx주소부터 마지막까지
		
		ActionForward forward = null;
		Action action = null;
		context.log("command>>>>>>" + command);
		if("/boardList.bo".equals(command)) {
			action = new BoardListAction();
			forward = action.execute(req, resp);
		} else if("/boardWritePage.bo".equals(command)) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setNextPath("boardWrite.jsp");
		} else if("/boardWrite.bo".equals(command)) {
			action = new BoardWriteAction();
			forward = action.execute(req, resp);
		} else if("/boardList.bo".equals(command)) {
			action = new BoardListAction();
			forward = action.execute(req, resp);
		} else if("/boardListPage.bo".equals(command)) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setNextPath("board.jsp");
		} else if("/boardListAction.bo".equals(command)) {
			action = new BoardListAction();
			forward = action.execute(req, resp);
		} else if("/boardDetailAction.bo".equals(command)) {
			context.log("command>>>>>>들옴");
			action = new BoardDetailAction();
			forward = action.execute(req, resp);
		} else if("/boardDetailPage.bo".equals(command)) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setNextPath("boardDetail.jsp");
		} else if("/FileDownloadAction.bo".equals(command)) {
			action = new FileDownloadAction();
			forward = action.execute(req, resp);
		}
		
		
		if(forward != null) {
			if(forward.isRedirect()) {
				resp.sendRedirect(forward.getNextPath());
			} else {
				RequestDispatcher view = req.getRequestDispatcher(forward.getNextPath());
				view.forward(req, resp);
			}
		}
	}
}
