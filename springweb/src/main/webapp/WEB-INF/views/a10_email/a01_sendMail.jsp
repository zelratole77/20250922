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
			alert(msg)
		}
	});
</script>
</head>
<body>
<div class="jumbotron text-center">
  <h2>메일발송</h2>\
</div>
<%-- 
		// title receiver sender content
--%>
	<div class="container">
		<form method="post">
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="title">제목</label> <input type="text" 
							class="form-control" id="title" name="title">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="receiver">수신자</label> <input type="text" 
							value="" class="form-control" id="receiver" name="receiver">
					</div>
				</div>
			</div>			
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="sender">발신자</label> <input type="text" readonly
							value="${sender}" class="form-control" id="sender" name="sender">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="content">메일 내용</label> 
							<textarea rows="5" class="form-control" id="content" name="content"></textarea>
					</div>
				</div>
			</div>
			<div class="btn-group-custom">
				<button type="submit" class="btn btn-info btn-lg">메일발송</button>
			</div>
		</form>
	</div>
</body>
</html>