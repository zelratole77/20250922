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
	
	});
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>아이돌 그룹 등록</h2>

</div>
<%-- 
groupNo groupName debutDate fandomName		
--%>
<div class="container">
    <form  method="post"  >
      	<div class="form-group">
            <label for="groupName">그룹명</label>
            <input type="text" value="" class="form-control" id="groupName" name="groupName" placeholder="그룹명 입력하세요" required>
        </div>
      	<div class="form-group">
            <label for="debutDate">데뷰일</label>
            <input type="date" class="form-control" id="debutDate" name="debutDate" 
            		placeholder="데뷰일 입력" required>
        </div>
      	<div class="form-group">
            <label for="fandomName">팬이름</label>
            <input type="text" value="" class="form-control" id="fandomName" name="fandomName" 
            	placeholder="팬이름" required>
        </div>
        <button id="regBtn" type="button" class="btn btn-primary">등록</button>
	    <button id="lstBtn" type="button" class="btn btn-info">메인</button>              
    </form>     
</div>

</body>
</html>

