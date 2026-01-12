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

		
		// /boardListAjax 
		ajaxList()
		$("[name=name], [name=keyword]").keyup(function(){
			if(event.keyCode==13)
				ajaxList()
		})
		$("#schBtn").click(function(){
			ajaxList()
		})
		$("#regLoadBtn").click(function(){
			$(".bdDetail").hide()
        	$("#frmTitle").text("게시판 등록");
        	$("#regBtn").show();
        	$("#uptBtn").hide();
        	$("#delBtn").hide();
        	$("#frm02")[0].reset(); 
		})
		$("#regBtn").click(function(){
			//alert( $("#frm02").serialize() ) // form하위에 있는 name value 기준으로 한글 encoding 요청값 처리
			if(confirm("등록하시겠습니까?")){
				$.ajax({
					url:"/boardInsertAjax", // boardInsertAjax
					type:"post",
					data:$("#frm02").serialize(),
					success:function(msg){
						ajaxList() // 등록된 내용 리스트에 반영.
						$("#frm02")[0].reset(); // 입력된값 초기화
						if( !confirm(msg+"\n계속 등록하시겠습니까?") )	{ // 취소를 눌렀을 때..
							$(".close").click() // 창닫기..
						}
					},
					error:function(err){
						console.log(err)
					}
				})
			}
		})
		$("#uptBtn").click(function(){
			if(confirm("수정하시겠습니까?")){
				// updateGourmet(@RequestBody GourmetStore upt 
				// form안에 있는 name, value를 json 형식으로 만드는 처리..
				const formData={}
				$.each($("#frm02").serializeArray(), function(){
					formData[this.name] = this.value
				})
				$.ajax({
					url:"/boardUpdateAjax",
					type:"put",
					contentType:"application/json",
					data:JSON.stringify(formData), // json객체 네트웍상 전달 문자열로 변경 JSON.stringify()객체==>문자열
					success:function(msg){
						ajaxList() // 수정된 내용 리스트에 반영.
						if( !confirm(msg+"\n계속 수정하시겠습니까?") )	{ 
							$(".close").click() // 창닫기..
						}
					},
					error:function(err){
						console.log(err)
					}
				})
			}			
		})
		$("#delBtn").click(function(){
			if(confirm("삭제하시겠습니까?")){
				$.ajax({
					url:"/boardDeleteAjax",
					type:"delete",
					data:{no:$("[name=no]").val() },
					success:function(msg){
						ajaxList() // 등록된 내용 리스트에 반영.
						alert(msg)
						$(".close").click() // 창닫기..
					},
					error:function(err){
						console.log(err)
					}
				})
			}			
		})		
		
		
	});
	function goDetail(noVal){
		$("#regLoadBtn").click(); // 강제 이벤트 처리..
		$(".bdDetail").show()
    	$("#frmTitle").text("게시판 상세");
    	$("#regBtn").hide();
    	$("#uptBtn").show();
    	$("#delBtn").show();	
    	// getGourmet?id=1
		$.ajax({
			url:"/boardDetailAjax",
			data:{no:noVal},
			dataType:"json",
			success:function(bd){ 
				console.log("# 전송된 객체 #")
				console.log(bd)
				let regDt = new Date(bd.regdte)
				let uptDt = new Date(bd.uptdte)
				$("#frm02 [name=no]").val(bd.no)
				$("#frm02 [name=refno]").val(bd.refno)
				$("#frm02 [name=subject]").val(bd.subject)
				$("#frm02 [name=writer]").val(bd.writer)
				$("#frm02 [name=readcnt]").val(bd.readcnt)
				$("#frm02 #regdte").val(regDt.toLocaleString())
				$("#frm02 #uptdte").val(uptDt.toLocaleString())
				
				$("#frm02 [name=content]").val(bd.content)
				
			},
			error:function(err){
				console.log(err)
			}
		})  	
    	
	}
	function ajaxList(){
		//showList		
		let subjectVal = $("[name=subject]").val()
		let writerVal = $("[name=writer]").val()
		$.ajax({
			url:"/boardListAjax",
			type:"post",
			data:{subject: subjectVal , writer: writerVal },
			dataType:"json",
			success:function(bList){
				let showList = ""
				$(bList).each(function( idx, bd ){
					console.log(bd.regdte)
					let dt = new Date(bd.regdte)
					// dt.toLocaleDateString()
					showList+=`<tr ondblclick="goDetail(\${bd.no})">
								<td>\${bd.no}</td><td>\${bd.subject}</td>
							  <td>\${bd.writer}</td><td>\${dt.toLocaleDateString()}</td>
						      <td>\${bd.readcnt}</td></tr>`	
				})
				$("#showList").html(showList)
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
  <h2>게시판(AJAX)</h2>

</div>
<%-- 
		
--%>
<div class="container">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input placeholder="작성자" name="writer"  class="form-control mr-sm-2" />
	    <input placeholder="제목" name="subject"  class="form-control mr-sm-2"/>
	    <button class="btn btn-info" id="schBtn" type="button">Search</button>
	    <button class="btn btn-success" id="regLoadBtn"
	    	data-toggle="modal" data-target="#exampleModalCenter"
	        type="button">등록</button>
 	</nav>
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
        <th>조회수</th>
      </tr>
    </thead>	
    <tbody  id="showList">
    </tbody>
	</table>    
    
</div>
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="frmTitle">게시물 등록</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		<form id="frm02" class="form"  method="post">
	     <div class="row g-3 mb-3 bdDetail" >
	      <div class="col ">
	        <label  class="form-label fw-bold">번호</label> 
	        <input type="text" class="form-control" readonly 
  				title="번호" name="no"  value="0">
	      </div>
	      <div class="col">
	        <label  class="form-label fw-bold">상위번호</label>
	        <input type="text"  class="form-control" 
	        	readonly title="상위 번호" 	name="refno" value="0">
	      </div>	      
	     </div>		
		
	     <div class="row  g-3 mb-3">
	      <div class="col" >
	        <label for="subject" class="form-label fw-bold">제목</label>  
	        <input type="text"  id="subject"  class="form-control" name="subject" 
  				title="제목 입력" >
	      </div>
	      <div class="col">
	      	<label for="writer" class="form-label fw-bold">작성자</label> 
	        <input type="text"  id="writer"  class="form-control" name="writer" 
	        	  title="작성자 입력" >
	      </div>
	     </div>
	     <div class="row g-3 mb-3 bdDetail"   >
	      <div class="col">
	      	<label class="form-label fw-bold">등록일</label> 
	        <input type="text" id="regdte"  class="form-control"  
  				title="등록일 입력" readonly>
	      </div>
	      <div class="col">
	      	<label class="form-label fw-bold">수정일</label> 
	        <input type="text" id="uptdte"  class="form-control"  
  				title="수정일 입력" readonly>
	      </div>
	     </div>
	     <div class="row g-3 mb-3">
	      <div class="col">
	      	<label for="fname" class="form-label fw-bold">첨부파일</label> 
	        <input type="file" class="form-control"  
  				title="첨부파일 " >
	      </div>
	      <div class="col bdDetail">
	      	<label class="form-label fw-bold">조회수</label> 
	        <input type="text"  class="form-control"  
  				title="조회수 입력" name="readcnt" value="0" readonly>
	      </div>
	     </div>	     
	     <div class="row g-3 mb-3">
	      <div class="col">
	      	<label for="content" class="form-label fw-bold">내용</label> 
	      	<textarea class="form-control"  id="content" title="내용 입력"  id="content"  name="content"></textarea>
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