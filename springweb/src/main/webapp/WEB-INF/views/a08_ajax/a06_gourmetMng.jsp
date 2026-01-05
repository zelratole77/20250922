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
	// id, name, category,  keyword, rating 
		ajaxList()
		$("[name=name], [name=keyword]").keyup(function(){
			if(event.keyCode==13)
				ajaxList()
		})
		$("#schBtn").click(function(){
			ajaxList()
		})
	});
	function ajaxList(){
		//showList		
		let nameVal = $("[name=name]").val()
		let keywordVal = $("[name=keyword]").val()
		$.ajax({
			url:"/gourmetList",
			data:{name:nameVal, keyword:keywordVal},
			dataType:"json",
			success:function(gList){
				let showList = ""
				$(gList).each(function( idx, gm ){
					showList+=`<tr><td>\${gm.id}</td><td>\${gm.name}</td>
							  <td>\${gm.category}</td><td>\${gm.keyword}</td>
						      <td>\${gm.rating}</td></tr>`	
				})
				$("#showList").html(showList)
			}
		})
		
	}
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>맛집 리스트</h2>

</div>
<%-- 
		
--%>
<div class="container">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input placeholder="이름" name="name"  class="form-control mr-sm-2" />
	    <input placeholder="키워드" name="keyword"  class="form-control mr-sm-2"/>
	    <button class="btn btn-info" id="schBtn" type="button">Search</button>
	    <button class="btn btn-success" 
	    	data-toggle="modal" data-target="#exampleModalCenter"
	        type="button">등록</button>
 	</nav>
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
        <th>분류</th>
        <th>키워드</th>
        <th>좋아요</th>
      </tr>
    </thead>	
    <tbody id="showList">
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