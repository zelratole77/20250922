<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="UTF-8"/> 
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/com/bootstrap.min.css" >
<style>
	td{text-align:center;}
</style>
<script src="${path}/com/jquery-3.7.1.js"></script>
<script src="${path}/com/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#regBtn").click(function(){
			if(confirm("파일을 추가하겠습니까?")){
				location.href="/upload"
			}
		})
	});
</script>
</head>
<body>
<div class="jumbotron text-center">
  <h2>등록된 파일 정보</h2>
</div>

<div class="container">
	<form id="frm01" class="form"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input placeholder="검색할 파일명" name="fname" value="${param.fname}" class="form-control mr-sm-2" />
	    <button class="btn btn-info" type="submit">Search</button>
	    <button class="btn btn-success" id="regBtn"
	        type="button">등록</button>
 	</nav>
	</form>
   <table class="table table-hover table-striped">
   	<col width="10%">
   	<col width="30%">
   	<col width="20%">
   	<col width="20%">
   	<col width="20%">
    <thead>
      <tr class="table-success text-center">
        <th>번호</th>
        <th>파일명</th>
        <th>등록일</th>
        <th>수정일</th>
        <th>기타</th>
      </tr>
    </thead>	
    <tbody>
    	<%-- // fno fname regdte uptdte etc --%>
    	<c:forEach var="fInfo" items="${flist}">
    	<tr ondblclick="download('${fInfo.fname}')"><td>${fInfo.fno}</td><td>${fInfo.fname}</td>
    		<td><fmt:formatDate value="${fInfo.regdte}"/></td>
    		<td><fmt:formatDate value="${fInfo.uptdte}"/></td>
    		<td>${fInfo.etc}</td></tr>
    	</c:forEach>
    </tbody>
	</table>    
	<script type="text/javascript">
		function download(fname){
			if(confirm(fname+" 다운로드 하시겠습니까?")){
				location.href="/download?fname="+fname
			}
		}
	</script>
</div>
</body>
</html>