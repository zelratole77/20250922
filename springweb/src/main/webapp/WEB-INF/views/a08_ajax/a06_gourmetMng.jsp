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
		$("#regLoadBtn").click(function(){
        	$("#frmTitle").text("맛집 등록");
        	$("#regBtn").show();
        	$("#uptBtn").hide();
        	$("#delBtn").hide();
		})
		$("#regBtn").click(function(){
			//alert( $("#frm02").serialize() ) // form하위에 있는 name value 기준으로 한글 encoding 요청값 처리
			$.ajax({
				url:"/insertGourmet",
				type:"post",
				data:$("#frm02").serialize(),
				success:function(msg){
					ajaxList() // 등록된 내용 리스트에 반영.
					$("#frm02")[0].reset(); // 입력된값 처기화
					if( !confirm(msg+"\n계속 등록하시겠습니까?") )	{ // 취소를 눌렀을 때..
						
						
						$(".close").click() // 창닫기..
					}
				}
			})
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
<div class="container">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input placeholder="이름" name="name"  class="form-control mr-sm-2" />
	    <input placeholder="키워드" name="keyword"  class="form-control mr-sm-2"/>
	    <button class="btn btn-info" id="schBtn" type="button">Search</button>
	    <button class="btn btn-success" id="regLoadBtn"
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
        <h5 class="modal-title" id="frmTitle">맛집 등록</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <%-- 	// 등록  name  category  keyword  description  rating		
			//     이름     분류       키워드     설명          좋아요(1~5) --%>
      <div class="modal-body">
		<form id="frm02" class="form"  method="post">
	     <div class="row">
	      <div class="col">
	        <input type="text" class="form-control" placeholder="이름 입력" name="name">
	      </div>
	      <div class="col">
	        <input type="text" class="form-control" placeholder="분류 입력" name="category">
	      </div>
	     </div>
	     <div class="row">
	      <div class="col">
	        <input type="text" class="form-control" placeholder="키워드 입력" name="keyword">
	      </div>
	      <div class="col">
	        <input type="number" class="form-control" placeholder="좋아요 입력" name="rating">
	      </div>
	     </div>
	     <div class="row">
	      <div class="col">
	      	<textarea class="form-control"  placeholder="설명 입력" name="description"></textarea>
	      </div>
	     </div>	     	     
	    </form> 
      </div>  <%-- #frmTitle #regBtn #uptBtn #delBtn --%>
      <div class="modal-footer">
        <button id="regBtn" type="button" class="btn btn-primary">등록</button>      
        <button id="uptBtn" type="button" class="btn btn-success">수정</button>      
        <button id="delBtn" type="button" class="btn btn-danger">삭제</button>      
        <button type="button" class="btn btn-secondary" data-dismiss="modal">창닫기</button>

      </div>
    </div>
  </div>
</div>
</body>
</html>