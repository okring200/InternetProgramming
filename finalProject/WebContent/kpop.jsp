<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KPOP</title>
<style type="text/css">
	html {
		height:100%;
	}
	body {
		height:100%;
		margin: 0;
	}
	#wrap {
		position: relative;
    	width: 1000px;
        margin: 0 auto;
        min-height:100%;
        padding-bottom: 20px;
    }
</style>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
function doChange(srcE, targetId){
    var val = srcE.options[srcE.selectedIndex].value;
    var targetE = document.getElementById(targetId);
    removeAll(targetE);

    if(val == '1990'){
    	addOption('1990', targetE);
        addOption('1991', targetE);
        addOption('1992', targetE);
        addOption('1993', targetE);
        addOption('1994', targetE);
        addOption('1995', targetE);
        addOption('1996', targetE);
        addOption('1997', targetE);
        addOption('1998', targetE);
        addOption('1999', targetE);
    }
    else if(val == '2000'){
    	addOption('2000', targetE);
        addOption('2001', targetE);
        addOption('2002', targetE);
        addOption('2003', targetE);
        addOption('2004', targetE);
        addOption('2005', targetE);
        addOption('2006', targetE);
        addOption('2007', targetE);
        addOption('2008', targetE);
        addOption('2009', targetE);
    }
    else if(val == '2010'){
    	addOption('2010', targetE);
        addOption('2011', targetE);
        addOption('2012', targetE);
        addOption('2013', targetE);
        addOption('2014', targetE);
        addOption('2015', targetE);
        addOption('2016', targetE);
        addOption('2017', targetE);
    }
}

function addOption(value, e){
    var o = new Option(value);
    try{
        e.add(o);
    }catch(ee){
        e.add(o, null);
    }
}

function removeAll(e){
    for(var i = 0, limit = e.options.length; i < limit - 1; ++i){
        e.remove(1);
    }
}

function doChange2(srcE){
	var val = srcE.options[srcE.selectedIndex].value;
	location.href="kpopList.po?year="+val;
}
</script>
</head>
<body>
	<div style="height:100px">
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div id="wrap">
		<form action="">
			<select name="sel1" id="sel1" onchange="doChange(this,'sel2')">
				<option value="default">---Select---</option>
				<option value="1990">1990년대</option>
				<option value="2000">2000년대</option>
				<option value="2010">2010년대</option>
			</select>
			<select name="selTwo" id="sel2" onchange="doChange2(this)">
				<option value="default">---Select---</option>
    		</select>
		</form>
		<div id="board">
			<table id="bList">
				<thead style="border-bottom:1px">
					<tr>
						<td>Ranking</td>
						<td>Title</td>
						<td>Artist</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="kpop" items="${requestScope.list}">
	            		<tr>
	                		<td>${kpop.ranking}</td>
	                		<td>${kpop.title}</td>
	                		<td>${kpop.artist}</td>
	            		</tr>
	       			</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>