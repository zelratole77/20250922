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
		var msg = "${msg}"
		if(msg!=""){
			alert(msg)
		}
	});
</script>
</head>

<body>
	<div class="jumbotron text-center">
		<h2>게시물 등록</h2>
	</div>
	<%-- 	// refno subject content writer --%>
	<div class="container">
		<form method="post">
			<input type="hidden" name="refno" value="0"/>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="subject">제목</label> <input type="text" 
							value="" class="form-control" id="subject" name="subject">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="writer">작성자</label> <input type="text" 
							value="" class="form-control" id="writer" name="writer">
					</div>
				</div>
			</div>		
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="content">내용</label> 
						<textarea class="form-control" id="content" name="content" rows="5" ></textarea>	
					</div>
				</div>
			</div>					

			<div class="btn-group-custom">
				<button id="regBtn" type="submit" class="btn btn-success btn-lg">등록</button>
				<button id="lstBtn" type="button" class="btn btn-info btn-lg">메인으로</button>
			</div>
		</form>
	</div>
</body>
</html>