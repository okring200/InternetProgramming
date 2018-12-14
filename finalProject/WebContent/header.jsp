<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<link type="text/css" href="css/common.css" rel = "stylesheet">
	<link type="text/css" href="css/common.header.css" rel = "stylesheet">
	<title>Home</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			var member = '<%= session.getAttribute("member") %>';
			var admin = '<%= session.getAttribute("admin") %>';
			if(member != 'null')
				$('#account').append('<li><a href="logout.do" class="button blue">로그아웃</a></li>');
			else if(admin != 'null') {
				$('#account').append('<li><a href="logout.do" class="button blue">로그아웃</a></li>');
				$('#account').append('<li><a href="manage.do" class="button white">회원관리</a></li>');
			}
				
			else{
				$('#account').append('<li><a href="signup_page.do" class ="button blue">회원가입</a></li>');
				$('#account').append('<li><a href="login_page.do" class="button white">로그인</a></li>');
			}
		});
		function chkLogin(){
			var member = '<%= session.getAttribute("member") %>';
			var admin = '<%= session.getAttribute("admin") %>';
			if(member == 'null' && admin == 'null'){
				alert("로그인해야합니다");
				return false;
			}
			else{
				location.href="boardList.bo";
				return true;
			}
		}
	</script>
</head>
<body>
	<header>
		<nav>
			<div class="wrap">
				<div id = "logo">
					<a href="home.do"><image src="images/music.png"></a>
					<p><span class = "name multiple">INHA</span><span class="subname">MUSIC</span></p>
				</div>
				<ul id="menu">
					<li class="active"><a href="#" onclick='chkLogin()'>자유게시판</a></li>
					<li><a href="kpop.jsp">K-POP</a></li>
					<li><a href="pop.jsp">POP</a></li>
				</ul>
				<ul id="account">
				</ul>
			</div>
		</nav>
		<!--  
		<div id="submenu">
			<div class="wrap">
				<div class = "divider"></div>
				<div class = "group">
					<h5>1990년대</h5>
					<ul>
						<li><a>1990</a></li>
						<li><a>1991</a></li>
						<li><a>1992</a></li>
						<li><a>1993</a></li>
						<li><a>1994</a></li>
					</ul>
				</div>
				<div class = "group">
					<h5>&nbsp;</h5>
					<ul>
						<li><a>1995</a></li>
						<li><a>1996</a></li>
						<li><a>1997</a></li>
						<li><a>1998</a></li>
						<li><a>1999</a></li>
					</ul>
				</div>
				<div class = "divider"></div>
				<div class = "group">
					<h5>2000년대</h5>
					<ul>
						<li><a>2000</a></li>
						<li><a>2001</a></li>
						<li><a>2002</a></li>
						<li><a>2003</a></li>
						<li><a>2004</a></li>
					</ul>
				</div>
				<div class = "group">
					<h5>&nbsp;</h5>
					<ul>
						<li><a>2005</a></li>
						<li><a>2006</a></li>
						<li><a>2007</a></li>
						<li><a>2008</a></li>
						<li><a>2009</a></li>
					</ul>
				</div>
				<div class = "divider"></div>
				<div class = "group">
					<h5>2000년대</h5>
					<ul>
						<li><a>2010</a></li>
						<li><a>2011</a></li>
						<li><a>2012</a></li>
						<li><a>2013</a></li>
						<li><a>2014</a></li>
					</ul>
				</div>
				<div class = "group">
					<h5>&nbsp;</h5>
					<ul>
						<li><a>2015</a></li>
						<li><a>2016</a></li>
						<li><a>2007</a></li>
					</ul>
				</div>
			</div>
		</div>
		-->
	</header>
</body>
</html>