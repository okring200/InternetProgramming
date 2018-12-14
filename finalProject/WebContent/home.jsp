<%@page import="java.util.List"%>
<%@page import="org.internetprogramming.model.SongBean"%>
<%@page import="org.internetprogramming.model.BoardBean"%>
<%@page import="org.internetprogramming.dao.SongDao"%>
<%@page import="org.internetprogramming.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
	SongDao d = new SongDao();
	BoardDao b = new BoardDao();
	List<SongBean> list = d.getPresentList();
	List<BoardBean> bList = b.getBoardFive();
	SongBean data = new SongBean();
	BoardBean bData = new BoardBean();
%>
<head>
	<meta charset="UTF-8">
	<link type="text/css" href="css/common.css" rel = "stylesheet">
	<link type="text/css" href="css/common.header.css" rel = "stylesheet">
	<link type="text/css" href="css/common.partial.css" rel = "stylesheet">
	<title>Home</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type=""text/javascript">
		$(document).ready(function() {
			var tb = $('#pRank');
			tb.after('<div id="tnav">');
			var tr = $(tb).find('tbody tr');
			var rowTotals = tr.length;
			var rowPerPage = 20;
			var pageTotal = Math.ceil(rowTotals/ rowPerPage);
			var i = 0;
			for(;i < pageTotal; i++){
				$('<a href="#"></a>')
					.attr('rel', i)
					.html(i + 1)
					.appendTo('#tnav');
			}
			
			tr.addClass('off-screen')
				.slice(0,rowPerPage)
				.removeClass('off-screen');

			var pageLink = $('#tnav a');
			pageLink.on('click', function(evt){
				evt.preventDefault();
				var $this = $(this);
				if ($this.hasClass('active')) {
					return;
				}
				pageLink.removeClass('active');
				$this.addClass('active');

				var currPage = $this.attr('rel');
				var startItem = currPage * rowPerPage;
				var endItem = startItem + rowPerPage;

				tr.css('opacity', '0.0')
					.addClass('off-screen')
					.slice(startItem, endItem)
					.removeClass('off-screen')
					.animate({opacity: 1}, 300);
			});
		});
	</script>
</head>
<body>
	<div style="height:100px">
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div id="container">
		<div class="main">
			<image src="images/home.jpg">
			<div class="board">
				<h3>12월 인기차트</h3>
				<table id="pRank">
					<thead>
						<tr>
							<td>랭킹</td>
							<td>곡이름</td>
						</tr>
					</thead>
					<tbody>
						<%
							for(int i=0;i<list.size();i++){
								data = list.get(i);
						%>
						<tr>
							<td><%=data.getRanking() %></td>
							<td><p><%=data.getTitle() %></p><p style="font-size:7px; color:#5D5D5D;"><%=data.getArtist() %></p></td>
						</tr>
						<% } %>
					</tbody>
				</table>
			</div>
		</div>
		<div class="rightside">
			<iframe width="560" height="315" src="https://www.youtube.com/embed/eA8CVQ-kfJA?autoplay=1&mute=1&enablejsapi=1" frameborder="0"  allowfullscreen></iframe>
			<div class="board">
				<h3>자유게시판</h3>
				<table id = "miniBoard">
					<tbody>
						<%
							for(int i=0;i<bList.size();i++){
								bData = bList.get(i);
						%>
						<tr>
							<td><%=bData.getSubject() %></td>
						</tr>
						<% } %>
					</tbody>
				</table>
			</div>
			<div class="board">
				<h3>역대 다 랭크</h3>
				<table>
					<tbody>
						<tr>
						<td><img src="images/bigbang.jpg" style="width:280px; height:260px;"></td>
						<td><img src="images/maroon5.jpg" style="width:280px; height:260px;"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>