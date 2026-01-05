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
		$("#schBtn").click(function(){
			ajaxFun()
		})
		$("[name=groupId]").keyup(function(){
			//alert(event.keyCode)
			
			if(event.keyCode==13){	 // 입력 후, enter 키를 누렀을 때..
				ajaxFun()
			}
			
		})
		
	});
	function ajaxFun(){
		// groupdId
		let groupIdVal = $("[name=groupId]").val()
		//alert(groupIdVal)
		$.ajax({
			url:"/idoleInfo",
			data:{groupId:groupIdVal},
			dataType:"json",
			success:function(group){
				console.log(group)
				// groupId groupName agency debutSong members
				let view = `<tr><td>\${group.groupId}</td><td>\${group.groupName}</td>
								<td>\${group.agency}</td><td>\${group.debutSong}</td>
								<td>\${group.members}</td></tr>`
				$("#showInfo").html(view)
				
			},
			error:function(err){
				console.log(err)
			}
		})		
	}
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>아이돌 그룹 정보</h2>

</div>
<%-- 
	// groupId groupName agency debutSong members	
--%>
<div class="container">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input type="number" placeholder="아이돌 그룹 아이디" name="groupId"  class="form-control mr-sm-2" />
	    <button id="schBtn" class="btn btn-info" type="button">데이터 검색</button>
 	</nav>
   <table class="table table-hover table-striped">
   	<col width="10%">
   	<col width="15%">
   	<col width="15%">
   	<col width="20%">
   	<col width="40%">
    <thead>
    
      <tr class="table-success text-center">
        <th>번호</th>
        <th>그룹명</th>
        <th>에이전트</th>
        <th>데뷰곡</th>
        <th>멤버</th>
      </tr>
    </thead>	
    <tbody id="showInfo">
    </tbody>
	</table>    
    
</div>
</body>
</html>