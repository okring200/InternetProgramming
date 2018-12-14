<%@page import="java.util.List"%>
<%@page import="org.internetprogramming.model.MemberBean"%>
<%@page import="org.internetprogramming.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
	MemberDao dao = new MemberDao();
	List<MemberBean> list = dao.getMemberList();
	MemberBean data = new MemberBean();
%>
<head>
	<meta charset="UTF-8">
	<title>Manage</title>
	<style type="text/css">
		#container {
			width:1000px;
			margin:0 auto;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type=""text/javascript">
	
	</script>
</head>
<body>
	<div style="height:100px">
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div id="container">
		<div class="main">
			<div class="board">
				<table border="1">
					<thead>
						<tr>
							<td>이름</td>
							<td>아이디</td>
							<td>비밀번호</td>
						</tr>
					</thead>
					<tbody>
						<%
							for(int i=0;i<list.size();i++){
								if(list.get(i).getUid().equals("admin")) continue;
								data = list.get(i);
						%>
						<tr>
							<td><%=data.getName() %></td>
							<td><%=data.getUid() %></td>
							<td><%=data.getPw() %></td>
							<td><a href="memberDelete.do?uid=<%=data.getUid() %>">삭제클릭</a></td>
						</tr>
						<% } %>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div style="position:absolute; bottom:0; width:100%">
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>