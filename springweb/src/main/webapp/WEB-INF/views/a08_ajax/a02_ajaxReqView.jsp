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
		$("#btn01").click(function(){
			$.ajax({
				url:"/callReqAjax01",
				data:"name="+$("[name=name]").val(),
				success:function(msg){
					alert(msg)
					$("h3").text(msg)
				},
				error:function(err){
					console.log(err)	
				}
			})
		})
		// /callReqAjax02?price=3000&cnt=5
		$("#btn02").click(function(){
			let priceVal = $("[name=price]").val()
			let cntVal = $("[name=cnt]").val()
			$.ajax({
				url:"/callReqAjax02",
				data:{price:priceVal, cnt:cntVal},
				success:function(msg){
					alert(msg)
					$("h3").text(msg)
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
  <h2>요청값 처리 ajax</h2>
  <h3></h3>

</div>
<%-- 
		
--%>
<div class="container">
	<form id="frm01" class="form"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input placeholder="이름입력" name="name"  class="form-control mr-sm-2" />
	    <button class="btn btn-info" id="btn01" type="button">ajax처리1(요청)</button>
 	</nav>
 	<%-- ex) 가격과 구매갯수 입력 버튼 클릭시, 
 			/callReqAjax02에 가격과 구매갯수을 전달하고,
 			결과로 총비용 @@@를  alert()띄우고, h3에 출력 처리..
 			1) controller 메서드 선언 (v)
 			2) view단 ajax 처리..
 			
 			
 	--%>
   	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input placeholder="가격입력" name="price"  class="form-control mr-sm-2" />
	    <input placeholder="갯수입력" name="cnt"  class="form-control mr-sm-2" />
	    <button class="btn btn-info" id="btn02" type="button">총계 계산</button>
 	</nav>	
 	
	</form>
   <table class="table table-hover table-striped">
   	<col width="10%">
   	<col width="50%">
   	<col width="15%">
   	<col width="15%">
   	<col width="10%">
    <thead>
    
      <tr class="table-success text-center">
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회</th>
      </tr>
    </thead>	
    <tbody>
    	<tr><td></td><td></td><td></td><td></td><td></td></tr>
    	<tr><td></td><td></td><td></td><td></td><td></td></tr>
    	<tr><td></td><td></td><td></td><td></td><td></td></tr>
    </tbody>
	</table>    
    
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