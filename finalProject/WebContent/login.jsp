<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link type="text/css" href="css/login.css" rel = "stylesheet">
	<title>Login</title>
</head>
<body>
	<div id="container" class = "login">
		<a href="home.do"><image src="images/music.png"></image></a>
		<form action="login.do" method="post">
			<p class="input">
				<input type="text" name="uid" maxlength="30" class="text" placeholder="아이디">
			</p>
			<p class="input">
				<input type="password" name="pw" maxlength="30" class="text" placeholder="비밀번호">
			</p>
			<p class="submit">
				<input type="submit" value="로그인" class="text">
			</p>
			<p class="register">
				<span>처음이신가요?</span>
				<a href="signup_page.do">회원가입</a>
			</p>
		</form>
	</div>
</body>
</html>