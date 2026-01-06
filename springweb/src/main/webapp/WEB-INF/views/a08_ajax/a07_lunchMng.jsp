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
		ajaxFun()
		// category menuName
		$("[name=category], [name=menuName]").keyup(function(){
			if(event.keyCode==13){
				ajaxFun()
			}
		})
		$("#schBtn").click(function(){
			ajaxFun()
		})

		$("#regLoadBtn").click(function(){
			$("#menuId").hide()
        	$("#frmTitle").text("점심메뉴 등록");
        	$("#regBtn").show();
        	$("#uptBtn").hide();
        	$("#delBtn").hide();
		})
		$("#regBtn").click(function(){
			$.ajax({
				url:"/insertLunchMenu",
				type:"post",
				data:$("#frm02").serialize(),
				success:function(msg){
					ajaxFun() // 등록된 내용 리스트에 반영.
					$("#frm02")[0].reset(); // 입력된값 처기화
					if( !confirm(msg+"\n계속 등록하시겠습니까?") )	{ // 취소를 눌렀을 때..
						
						
						$(".close").click() // 창닫기..
					}
				}
			})
		})
		
		
		
	});
	function ajaxFun(){
		let categoryVal=$("[name=category]").val()
		let menuNameVal=$("[name=menuName]").val()
		$.ajax({
			url:"lunchMenuList",
			data:{category:categoryVal,menuName:menuNameVal},
			dateType:"json",
			success:function( menuList ){
				let menuListView=''
				// menuId category menuName priceTag
				$(menuList).each(function(idx, menu){
					menuListView+=`<tr><td>\${menu.menuId}</td><td>\${menu.category}</td>
										<td>\${menu.menuName}</td><td>\${menu.priceTag}</td></tr>`
				})
				$("#menuListView").html(menuListView)
			},
			error:function(err){
				console.log(err)
			}
			
		})
	}
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>점심메뉴리스트</h2>

</div>
<%-- 
	// menuId category menuName priceTag	
--%>
<div class="container">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input placeholder="분류" name="category"  class="form-control mr-sm-2" />
	    <input placeholder="메뉴명" name="menuName"  class="form-control mr-sm-2"/>
	    <button id="schBtn" class="btn btn-info" type="button">Search</button>
	    <button id="regLoadBtn" class="btn btn-success" 
	    	data-toggle="modal" data-target="#exampleModalCenter"
	        type="button">등록</button>
 	</nav>
   <table class="table table-hover table-striped">
   	<col width="25%">
   	<col width="25%">
   	<col width="25%">
   	<col width="25%">
    <thead>
    
      <tr class="table-success text-center">
        <th>아이디</th>
        <th>분류</th>
        <th>메뉴명</th>
        <th>가격태그</th>
      </tr>
    </thead>	
    <tbody id="menuListView">
    </tbody>
	</table>    
    
</div>
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="frmTitle">타이틀</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <%-- 	// menuId category menuName priceTag commentMsg
			// 아이디   분류       메뉴명     가격태그   평가태그       좋아요(1~5) --%>
      <div class="modal-body">
		<form id="frm02" class="form"  method="post">
	     <div class="row">
	      <div class="col" id="menuId">
	        <input type="text" class="form-control"  name="menuId"  value="0">
	      </div>
	      <div class="col">
	        <input type="text" class="form-control" placeholder="메뉴명 입력" name="menuName">
	      </div>
	     </div>
	     <div class="row">
	      <div class="col">
	        <input type="text" class="form-control" placeholder="분류 입력" name="category">
	      </div>
	      <div class="col">
	        <input type="text" class="form-control" placeholder="가격태그 입력" name="priceTag">
	      </div>
	     </div>
	     <div class="row">
	      <div class="col">
	      	<textarea class="form-control"  placeholder="평가태그 입력" name="commentMsg"></textarea>
	      </div>
	     </div>	     	     
	    </form> 
      </div>
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