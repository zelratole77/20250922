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
		let msg = "${msg}"  // 모델에 등록 성공 메시지를 가져올 때 처리 하는 내용..
		if(msg!=''){	// 초기 등록화면과 구분하기 위해..
			if(confirm(msg+"\n조회화면 이동하시겠습니까?")){
				location.href="idolGrpList"
			}
		}
		$("#lstBtn").click(function(){
			location.href="idolGrpList"
		})
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
            <input type="text" value="" class="form-control" id="groupName" name="groupName" 
               placeholder="그룹명 입력하세요" required>
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
        <button id="regBtn" type="submit" class="btn btn-info">등록</button>
	    <button id="lstBtn" type="button" class="btn btn-primary" >메인</button>              
    </form>     
</div>

</body>
</html>

