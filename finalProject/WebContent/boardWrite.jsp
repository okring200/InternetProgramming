<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=EUC-KR">
	<link type="text/css" href="css/board.css" rel = "stylesheet">
	<title>Board Write</title>
	<style>
	      tr,td {
        	border-bottom: 1px solid #ddd; padding:10px;
        }
             input[type=button] {
		  background-color: #0080ff;
		  color: white;
		  padding: 12px 20px;
		  border: none;
		  border-radius: 4px;
		  cursor: pointer;
		}
		     input[type=reset] {
		  background-color: #0080ff;
		  color: white;
		  padding: 12px 20px;
		  border: none;
		  border-radius: 4px;
		  cursor: pointer;
		}
        input[type=submit] {
		  background-color: #0080ff;
		  color: white;
		  padding: 12px 20px;
		  border: none;
		  border-radius: 4px;
		  cursor: pointer;
		}
	</style>
	<script type="text/javascript">
	</script>
</head>
<body>
	<div style="height:100px">
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div style="width:1000px; margin:0 auto;">
		<b>글쓰기</b>
		<form method="post" action="boardWrite.bo" name="boardForm" enctype="multipart/form-data">
			<input type="hidden" name="uid" value="${sessionScope.member.uid }">
			<table width="1000" border="3" bordercolor="lightgray" align="center">
				<tr>
					<td>작성자</td>
					<td>${sessionScope.member.uid }</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input name="bSubject" type="text" maxlength="100">
				</tr>
				<tr>
					<td style="height:16px; font-size:12; text-align:center">내용</td>
					<td><textarea name="bContent" cols="72" rows="20"></textarea></td>
				</tr>
				<tr>
					<td>파일첨부</td>
					<td><input type="file" name="file" ></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="reset" value="작성취소" style="margin-left:150px">
						<input type="submit" value="등록" style="margin-left:150px">
						<input type="button" value="목록" style="margin-left:150px" "onclick="javascript:location.href='boardListAction.bo?page=1'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>