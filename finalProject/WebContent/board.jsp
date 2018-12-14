<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link type="text/css" href="css/board.css" rel = "stylesheet">
	<title>Board List</title>
	<style type="text/css">
		 #wrap {
            width: 1000px;
            margin: 0 auto;
        }
        #topForm{
            text-align :right;
        }
        #board, #pageForm, #searchForm{
            text-align :center;
        }
        
        #bList{
            text-align :center; width: 100%;
        }
        
        #bList > tr,td {
        	border-bottom: 1px solid #ddd; padding:10px;
        }
	</style>
	<script type="text/javascript">
		function writeBoard(){
			location.href="boardWritePage.bo"
		}
	</script>
</head>
<body>
	<div style="height:100px">
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div id="wrap">
		<div id="topForm">
			<input type="button" value="글쓰기" onclick="writeBoard()">
		</div>
		<div id="board">
			<table id="bList">
				<tr>
					<td>글번호</td>
					<td style="padding-left:10px;">제목</td>
					<td>작성자</td>
					<td>작성일</td>
					<td>조회수</td>
				</tr>
				<c:forEach var="board" items="${requestScope.list}">
            		<tr>
                		<td>${board.bid}</td>
                		<td >
                    		<a href="boardDetailAction.bo?num=${board.bid}&pageNum=${spage}">
                    			${board.subject}
                    		</a>
                		</td>
                		<td style="padding-left:10px;">
                   				${board.uid}
                		</td>
                		<td>${board.date}</td>
                		<td>${board.cnt}</td>
            		</tr>
       			</c:forEach>
			</table>
		</div>
		<br>
    	<div id="pageForm">
        	<c:if test="${startPage != 1}">
            	<a href='boardListAction.bo?page=${startPage-1}'>[ 이전 ]</a>
        	</c:if>
        
        	<c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
            <c:if test="${pageNum == spage}">
                ${pageNum}&nbsp;
            </c:if>
            <c:if test="${pageNum != spage}">
                <a href='boardListAction.bo?page=${pageNum}'>${pageNum}&nbsp;</a>
            </c:if>
        	</c:forEach>
        
	        <c:if test="${endPage != maxPage }">
	            <a href='boardListAction.bo?page=${endPage+1 }'>[다음]</a>
	        </c:if>	
		</div>
	</div>
	<div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>