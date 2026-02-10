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
		$("#regBtn").click(function(){
			location.href="pokemonInsert"
		})
	});
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>포켓몬 리스트</h2>

</div>
<%-- 
			name="name"  name="type"
			
	
--%>
<div class="container">
	<form id="frm01" class="form"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input placeholder="이름" name="name" value="${param.name}" class="form-control mr-sm-2" />
	    <input placeholder="종류" name="type" value="${param.type}"   class="form-control mr-sm-2"/>
	    <button class="btn btn-info" type="submit">Search</button>
	    <button id="regBtn" class="btn btn-success" type="button">등록</button>
 	</nav>
	</form>
   <table class="table table-hover table-striped">
   	<col width="20%">
   	<col width="20%">
   	<col width="20%">
   	<col width="20%">
   	<col width="20%">
    <thead>
      <tr class="table-success text-center">
        <th>아이디</th>
        <th>이름</th>
        <th>유형</th>
        <th>레벨</th>
        <th>획득시간</th>
      </tr>
    </thead>	
    <tbody>
    	<c:forEach var="pk" items="${ pokeList }">
    	<tr ondblclick="goDetail(${pk.id})"><td>${pk.id}</td>
    		<td>${pk.name}</td>
    		<td>${pk.type}</td>
    		<td>${pk.pokeLevel}</td>
    		<td><fmt:formatDate value="${pk.capturedAt}"/></td></tr>
    	</c:forEach>
    </tbody>
	</table>    
	<script type="text/javascript">
		function goDetail(pkId){
			location.href="pokemonDetail?id="+pkId
					
		}
	</script> 
    
</div>
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">타이틀</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		<form id="frm02" class="form"  method="post">
	     <div class="row">
	      <div class="col">
	        <input type="text" class="form-control" placeholder="사원명 입력" name="ename">
	      </div>
	      <div class="col">
	        <input type="text" class="form-control" placeholder="직책명 입력" name="job">
	      </div>
	     </div>
	    </form> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>