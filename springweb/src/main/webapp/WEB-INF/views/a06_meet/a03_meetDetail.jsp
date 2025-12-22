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
  <h2>타이틀</h2>

</div>
<%-- 
		
--%>
<div class="container">
<div class="jumbotron text-center">
  <h2>등록/상세폼</h2>

</div>
<%-- 
// ${meet.dateNo}  ${meet.partnerName} ${meet.partnerAge} ${meet.job}
///${meet.location}  ${meet.meetDate} ${meet.status} ${meet.score} ${meet.review}		
--%>
<div class="container">
    <form  method="post"  >
      	<div class="form-group">
            <label for="dateNo">번호</label>
            <input type="text" readonly value="${meet.dateNo}" class="form-control" id="dateNo" name="dateNo" required>
        </div>
       	<div class="form-group">
            <label for="partnerName">파트너이름</label>
            <input type="text" value="${meet.partnerName}" class="form-control" id="partnerName" name="partnerName" required>
        </div>
       	<div class="form-group">
            <label for="partnerAge">파트너나이</label>
            <input type="number" value="${meet.partnerAge}" class="form-control" id="partnerAge" name="partnerAge" required>
        </div>
       	<div class="form-group">
            <label for="job">파트너직업</label>
            <input type="text" value="${meet.job}" class="form-control" id="job" name="job" required>
        </div>         
        	<div class="form-group">
            <label for="location">사는곳</label>
            <input type="text" value="${meet.location}" class="form-control" id="location" name="location" required>
        </div>
       	<div class="form-group">
            <label for="partnerName">파트너이름</label>
            <input type="text" value="${meet.partnerName}" class="form-control" id="partnerName" name="partnerName" required>
        </div>
       	<div class="form-group">
            <label for="meetDate">만남일</label>
            <input type="datetime-local" 
            	value='<fmt:formatDate value="${meet.meetDate}" pattern="yyyy-MM-dd'T'HH:mm"/>' 
            	class="form-control" id="meetDate" name="meetDate" required>
        </div>
       	<div class="form-group">
            <label for="status">현재상태</label>
            <select class="form-control" id="status" name="status" >
            	<option value="SUCCESS">성공</option>
            	<option value="FAIL">실패</option>
            	<option value="ING">진행중</option>
            	<option value="WAITING">기다림</option>
            </select>
            <script type="text/javascript">
            	$("#status").val("${meet.status}")
            </script>
        </div>
        <div class="form-group">
            <label for="score">평점</label>
            <input type="number" value="${meet.score}" class="form-control" id="score" name="score" required>
        </div>                                      
        <div class="form-group">
            <label for="review">리뷰</label>
            <textarea id="review"  class="form-control"  name="review">${meet.review}</textarea>
        </div>           
            <button id="uptBtn" type="button" class="btn btn-success">수정</button>
            <button id="delBtn" type="button" class="btn btn-danger">삭제</button>
	    	<button id="lstBtn" type="button" class="btn btn-info">메인</button>              
        </form>
    </form>     
</div>
</div>
</body>
</html>