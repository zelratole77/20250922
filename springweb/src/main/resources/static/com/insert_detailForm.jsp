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

	});
</script>
</head>

<body>
	<div class="jumbotron text-center">
		<h2>등록/상세폼</h2>

	</div>

	<div class="container">
		<form method="post">
			<div class="form-group">
				<label for="subject">제목</label> 
				<input type="text" value="" class="form-control" id="subject" name="subject"
					placeholder="제목을 입력하세요" required>
			</div>
			<button id="regBtn" type="button" class="btn btn-primary">등록</button>
			<button id="lstBtn" type="button" class="btn btn-info">메인</button>
		</form>
	</div>

</body>
</html>