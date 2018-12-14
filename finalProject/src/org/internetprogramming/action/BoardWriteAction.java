package org.internetprogramming.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.internetprogramming.dao.BoardDao;
import org.internetprogramming.model.BoardBean;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		int fileSize = 5*1024*1024;
		String uploadPath = request.getServletContext().getRealPath("uploadFolder");
		MultipartRequest multi = new MultipartRequest(request, uploadPath, fileSize,"euc-kr", new DefaultFileRenamePolicy());
		
		String fileName = "";
		Enumeration<String> names = multi.getFileNames();
		if(names.hasMoreElements()) {
			String name = names.nextElement();
			fileName = multi.getFilesystemName(name);
		}
		
		BoardDao dao = new BoardDao();
		BoardBean borderData = new BoardBean();
		request.setCharacterEncoding("euc-kr");
		borderData.setUid(multi.getParameter("uid"));
		borderData.setSubject(multi.getParameter("bSubject"));
		borderData.setContent(multi.getParameter("bContent"));
		borderData.setFile(fileName);
		boolean result = dao.boardInsert(borderData);
		if(result) {
			forward.setRedirect(true);
			forward.setNextPath("boardList.bo");
		}
		
		return forward;
	}
	
}
