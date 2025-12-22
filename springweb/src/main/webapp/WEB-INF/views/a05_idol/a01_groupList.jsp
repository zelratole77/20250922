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
			location.href="idolGrpInsert"
		})
	});
	function goDetail(groupNo){
		//alert(groupNo)
		location.href="/idolGrpDetail?groupNo="+groupNo
	}
</script>
</head>
<body>
<div class="jumbotron text-center">
  <h2>아이돌 그룹 리스트</h2>
</div>
<%-- 
 * where 조건 ==> 요청값  groupName, fandomName  ==> DTO (A04Group) 
 * 		<input name="groupName"   <input name="fandomName"  
 * 출력하는 데이터 ==> 화면 테이블에 리스트 ==> DTO List
 * 		테이블의 타이틀명 : 그룹번호   그룹명  데뷰날짜 팬그룹이름		
--%>
<div class="container">
	<form id="frm01" class="form"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input placeholder="그룹명입력" name="groupName"  value="${param.groupName}" class="form-control mr-sm-2" />
	    <input placeholder="팬그룹이름입력" name="fandomName"   value="${param.fandomName}"   class="form-control mr-sm-2"/>
	    <button class="btn btn-info" type="submit">Search</button>
	    <button class="btn btn-success" id="regBtn" type="button">등록</button>
 	</nav>
	</form>
   <table class="table table-hover table-striped">
   	<col width="25%">
   	<col width="25%">
   	<col width="25%">
   	<col width="25%">
    <thead>
      <tr class="table-success text-center">
        <th>그룹번호</th>
        <th>그룹명</th>
        <th>데뷰날짜</th>
        <th>팬그룹이름</th>
      </tr>
    </thead>	
    <tbody>
    	<%-- // groupNo groupName debutDate fandomName --%>
    	<c:forEach var="grp" items="${grpList}">
    	<tr ondblclick="goDetail(${grp.groupNo})"><td>${grp.groupNo}</td><td>${grp.groupName}</td>
    		<td><fmt:formatDate value="${grp.debutDate}"/></td>
    		<td>${grp.fandomName}</td></tr>
    	</c:forEach>
    </tbody>
	</table>    
	<%-- ex) a01_meet 리스트 출력 처리  단계별 진행..
		*dao
		service
		controller
		view
	 --%>
    
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