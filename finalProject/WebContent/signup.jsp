<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=EUC-KR">
	<link type="text/css" href="css/signup.css" rel = "stylesheet">
	<title>SignUp</title>
</head>
<body>
	<div id="container" class = "signup">
		<a href="home.do"><image src="images/music.png"></image></a>
		<form action="signup.do" method="post">
			<p class="input">
				<input type="text" name="name" maxlength="30" class="text" placeholder="이름">
			</p>
			<p class="input">
				<input type="text" name="uid" maxlength="30" class="text" placeholder="아이디">
			</p>
			<p class="input">
				<input type="password" name="pw" maxlength="30" class="text" placeholder="비밀번호">
			</p>
			<p class="submit">
				<input type="submit" value="Sign Up" class="text">
			</p>
		</form>
	</div>
</body>
</html>