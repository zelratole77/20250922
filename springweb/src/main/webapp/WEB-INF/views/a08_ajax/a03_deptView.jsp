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
		// deptAjax?deptno=10
		$("[name=deptno]").change(function(){
			let deptnoVal = $(this).val()
			$.ajax({
				url:"/deptAjax",
				data:{deptno:deptnoVal},
				dataType:"json",
				success:function(dept){
					// let dept =  {"deptno":10,"dname":"ACCOUNTING","loc":"NEW YORK"}
					// 문자열을 객체로 변환(dataType:"json") ==> dept 설정..
					// \$  빽틱에 있는 javascript 데이터 변수와 jsp에서 처리할 때, 반드시 \(역슬래시) 처리를 하여야 한다.
					let deptView = `<tr><td>\${dept.deptno}</td>
										<td>\${dept.dname}</td>
										<td>\${dept.loc}</td></tr>`
					$("#deptInfo").html(deptView)					
				},
				error:function(err){
					console.log(err)
				}
			})
		})
	});
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>부서정보 검색(ajax)</h2>

</div>
<%-- 
		
--%>
<div class="container">
	<form id="frm01" class="form"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <select name="deptno"  class="form-control mr-sm-2" >
	    	<option value="0">부서번호 선택</option>
	    	<option >10</option>
	    	<option >20</option>
	    	<option >30</option>
	    	<option >40</option>
	    </select>
 	</nav>
	</form>
   <table class="table table-hover table-striped">
   	<col width="33%">
   	<col width="34%">
   	<col width="33%">
    <thead>
      <tr class="table-success text-center">
        <th>번호</th>
        <th>부서명</th>
        <th>부서위치</th>
      </tr>
    </thead>	
    <tbody id="deptInfo">
    </tbody>
	</table>    
</div>
</body>
</html>