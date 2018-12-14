package org.internetprogramming.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.internetprogramming.action.Action;
import org.internetprogramming.action.ActionForward;
import org.internetprogramming.action.KpopAction;
import org.internetprogramming.action.popAction;

/**
 * Servlet implementation class popController
 */
@WebServlet("/popController")
public class popController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public popController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("EUC-KR");
		resp.setContentType("text/html;charset=EUC-KR");
		
		ServletContext context = req.getServletContext();

		context.log(">>>>>>>>> kpopcontroller do process");
		String ctxPath = req.getContextPath(); //root 경로
		String reqUri = req.getRequestURI();   //전체 주소
		String command = reqUri.substring(ctxPath.length()); // ctx주소부터 마지막까지
		
		ActionForward forward = null;
		Action action = null;
		context.log("command>>>>>>" + command);
		if("/kpopList.po".equals(command)) {
			action = new KpopAction();
			forward = action.execute(req, resp);
		} else if("/kpopListPage.po".equals(command)) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setNextPath("kpop.jsp");
		} else if("/popList.po".equals(command)) {
			action = new popAction();
			forward = action.execute(req, resp);
		} else if("/popListPage.po".equals(command)) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setNextPath("pop.jsp");
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
