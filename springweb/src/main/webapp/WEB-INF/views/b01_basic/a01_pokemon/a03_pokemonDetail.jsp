<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="UTF-8" />
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/com/bootstrap.min.css">
<style>
td {
	text-align: center;
}
</style>
<script src="${path}/com/jquery-3.7.1.js"></script>
<script src="${path}/com/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#lstBtn").click(tunction(){

			location.href="pokemonList"
		})
	});
</script>
</head>

<body>
	<div class="jumbotron text-center">
		<h2>포켓몬 상세(${param.id})</h2>

	</div>
	<%--id name type pokeLevel capuredAt --%>

	<div class="container">
		<form method="post">
			<div class="form-group">
				<label for="id">아이디</label> 
				<input type="text" value="${pk.id}" class="form-control" id="id" name="id"
					readonly required>
			</div>
			<div class="form-group">
				<label for="name">이름</label> 
				<input type="text" value="${pk.name}" class="form-control" id="name" name="name"
					placeholder="이름을 입력하세요" required>
			</div>
			<div class="form-group">
				<label for="type">타입</label> 
				<input type="text" value="${pk.type}" class="form-control" id="type" name="type"
					placeholder="타입을 입력하세요" required>
			</div>
			<div class="form-group">
				<label for="pokeLevel">레벨</label> 
				<input type="text" value="${pk.pokeLevel}" class="form-control" id="pokeLevel" name="pokeLevel"
					placeholder="포켓몬 레벨을 입력하세요" required>
			</div>

			<div class="form-group">
				<label for="capuredAt">잡힌시간</label> 
				<fmt:formatDate value="${pk.capturedAt}" pattern="yyyy-MM-dd'T'HH:mm" 
					var="formattedDate" />				
				<input type="datetime-local" value="${formattedDate}" class="form-control" id="capuredAt" name="capuredAt"
					placeholder="잡힌시간을 입력하세요" required>
			</div>
			<button id="uptBtn" type="button" class="btn btn-success">수정</button>
			<button id="delBtn" type="button" class="btn btn-warning">삭제</button>
			<button id="lstBtn" type="button" class="btn btn-info">메인</button>
		</form>
	</div>

</body>
</html>