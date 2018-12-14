<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Detail</title>
</head>
<body>
	<div id="wrap">
    	<br><br>
    	<div id="board">
        	<table id="detailBoard" width="800" border="3" bordercolor="lightgray">
            <tr>
                	<td id="title">작성일</td>
                	<td>${board.date}</td>
            	</tr>
            	<tr>
                	<td id="title">작성자</td>
                	<td>${board.bid}</td>
            	</tr>
            	<tr>
            	    <td id="title">
        	           	 제 목
    	            </td>
	                <td>
                    	${board.subject}
                	</td>        
            	</tr>
            	<tr>
                	<td id="title">
                    		내 용
                	</td>
                	<td>
                    	${board.content}
                	</td>        
            	</tr>
            	<tr>
                	<td id="title">
                    		첨부파일
                	</td>
                	<td>
            	        <a href='FileDownloadAction.bo?file_name=${board.file}'>${board.file}</a>
        	        </td>    
    	        </tr>
    
            	<tr align="center" valign="middle">
                	<td colspan="5">   
                    	<input type="button" value="목록" 
                        onclick="javascript:location.href='boardListAction.bo?page=${pageNum}'">            
                	</td>
            	</tr>
        	</table>
    	</div>
	</div>    
</body>
</html>