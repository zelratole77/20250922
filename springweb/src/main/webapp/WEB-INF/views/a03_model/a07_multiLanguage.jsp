<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
		$("#selection").val("${param.lang}").change(function(){
			let chVal = $(this).val()
			if(chVal!=''){
				location.href="multilang?lang="+chVal
			}
		})
	});
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2><spring:message code="multilang"/></h2>
  <h2><spring:message code="welcome"/></h2>
  <h2><spring:message code="greet"/></h2>
  <h2><spring:message code="regmen"/></h2>
</div>
<div class="container">
	<div>
		<select  class="form-control mr-sm-2" id="selection" sytle="width:20%;">
			<option value=""><spring:message code="chlang"/></option>
			<option value="ko"><spring:message code="kor"/></option>
			<option value="en"><spring:message code="en"/></option>
		</select>
	</div>
</div>
</body>
</html>