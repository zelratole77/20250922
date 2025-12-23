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
		$("#lstBtn").click(function(){
			location.href="idolGrpList"
		})
		// idolGrpUpdate idolGrpDelete
		$("#uptBtn").click(function(){
			if(confirm("수정하시겠습니까?")){
				$("#frm").attr("action","idolGrpUpdate")
				$("#frm").submit()
			}
		})
		$("#delBtn").click(function(){
			if(confirm("삭제하시겠습니까?")){
				$("#frm").attr("action","idolGrpDelete")
				$("#frm").submit()				
			}
		})
		let msg = "${msg}"
		if(msg!=""){
			// 수정처리시
			if( msg.indexOf("수정") > -1 ){
				if(confirm(msg+"\n메인 화면으로 이동하시겠니까?")){
					location.href="idolGrpList"
				}
			}
			// 삭제처리시
			if( msg.indexOf("삭제") > -1 ){
				alert(msg)
				location.href="idolGrpList"
			}			
		}
		
	});
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>아이돌 그룹 상세(수정/삭제)</h2>

</div>
<%-- 
// ${group.groupNo} ${group.groupName}  ${group.debutDate} ${group.fandomName}		
--%>
<div class="container">
    <form  method="post" id="frm" >
      	<div class="form-group">
            <label for="groupNo">그룹번호</label>
            <input type="text" readonly value="${group.groupNo}" class="form-control" id="groupNo" name="groupNo"  required>
        </div>
      	<div class="form-group">
            <label for="groupName">그룹이름</label>
            <input type="text" value="${group.groupName}" class="form-control" id="groupName" name="groupName"  required>
        </div>      
      	<div class="form-group">
            <label for="debutDate">데뷰날짜</label>
            <input type="date" value='<fmt:formatDate value="${group.debutDate}" pattern="yyyy-MM-dd"/>' 
            	class="form-control" id="debutDate" name="debutDate"  required>
        </div>      
      	<div class="form-group">
            <label for="fandomName">팬이름</label>
            <input type="text" value="${group.fandomName}" class="form-control" id="fandomName" name="fandomName"  required>
        </div>      
            <button id="uptBtn" type="button" class="btn btn-success">수정</button>
            <button id="delBtn" type="button" class="btn btn-warning">삭제</button>
	    	<button id="lstBtn" type="button" class="btn btn-info">메인</button>              
        </form>
    </form>     
</div>

</body>
</html>