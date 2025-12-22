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
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="dateNo">번호</label> <input type="text" readonly
							value="" class="form-control" id="dateNo" name="dateNo">
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="meetDate">만남일</label> <input type="datetime-local"
							value="" class="form-control" id="meetDate" name="meetDate"
							required>
					</div>
				</div>
			</div>
			<div class="btn-group-custom">
				<button id="uptBtn" type="button" class="btn btn-success btn-lg">수정</button>
				<button id="delBtn" type="button" class="btn btn-danger btn-lg">삭제</button>
				<button id="lstBtn" type="button" class="btn btn-info btn-lg">메인으로</button>
			</div>
		</form>
	</div>
</body>
</html>