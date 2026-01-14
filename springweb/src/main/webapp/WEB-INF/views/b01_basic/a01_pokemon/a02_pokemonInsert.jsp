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
		let msg = "${msg}"
		if(msg!=""){
			if(!confirm(msg+"\n계속등록하시겠습닊?")){
				location.href="pokemonList"
			}
		}
		
		$("#regBtn").click(function(){
			if(confirm("등록하시겠습니까?")){
				$("form").submit()
			}
		})
	});
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>포켓몬 데이터 등록</h2>

</div>
<%-- 
	name, type, pokeLevel	
--%>
<div class="container">
		<form method="post">
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="name">제목</label> <input type="text" 
							class="form-control" id="name"  name="name">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="type">종류</label> <input type="text" 
							class="form-control" id="type"  name="type">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="pokeLevel">레벨</label> <input type="number" 
							class="form-control" id="pokeLevel"  name="pokeLevel">
					</div>
				</div>
			</div>
											
		

			<button id="regBtn" type="button" class="btn btn-primary">등록</button>
			<button id="lstBtn" type="button" class="btn btn-info">메인</button>
		</form>
</div>

</body>
</html>