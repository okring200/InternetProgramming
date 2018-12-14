package org.internetprogramming.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.internetprogramming.action.Action;
import org.internetprogramming.action.ActionForward;
import org.internetprogramming.action.MemberDeleteAction;
import org.internetprogramming.action.MemberLoginAction;
import org.internetprogramming.action.MemberLogoutAction;
import org.internetprogramming.action.MemberSignUpAction;

public class MemberController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			doProcess(req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			doProcess(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("EUC-KR");
		resp.setContentType("text/html;charset=EUC-KR");
		
		ServletContext context = req.getServletContext();

		context.log(">>>>>>>>> membercontroller do process");
		String ctxPath = req.getContextPath(); //root 경로
		String reqUri = req.getRequestURI();   //전체 주소
		String command = reqUri.substring(ctxPath.length()); // ctx주소부터 마지막까지
		
		ActionForward forward = null;
		Action action = null;
		context.log("command>>>>>>" + command);
		if("/home.do".equals(command)) {
			forward = new ActionForward();
			forward.setRedirect(false);
			context.log("성공");
			forward.setNextPath("home.jsp");
		} else if("/login_page.do".equals(command)) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setNextPath("login.jsp");
		} else if("/login.do".equals(command)) {
			action = new MemberLoginAction();
			forward = action.execute(req, resp);
		} else if("/logout.do".equals(command)) {
			action = new MemberLogoutAction();
			forward = action.execute(req, resp);
		} else if("/signup_page.do".equals(command)){
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setNextPath("signup.jsp");
		} else if("/signup.do".equals(command)) {
			action = new MemberSignUpAction();
			forward = action.execute(req, resp);
		} else if("/manage.do".equals(command)) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setNextPath("manage.jsp");
		}
		else if("/memberDelete.do".equals(command)) {
			action = new MemberDeleteAction();
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
		/*
		if(isRedirect) {
			resp.sendRedirect(viewName);
		} else {
			RequestDispatcher view = req.getRequestDispatcher(viewName);
			view.forward(req, resp);
		}*/
	}
}
