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
		let sessCk = "${mem.name}"===""  
		if(sessCk){ //세션이 없을 때..- 로그인 처리가 되지 않을 때..
			alert("로그인 하셔야 합니다.")
			location.href="login"
		}		
		// 기능 버튼 권한별로 설정. uptBtn delBtn
		let sessId = "${mem.id}"
		let sessAuth = "${mem.auth}"
		let writer = $("[name=writer]").val()
		// 1. 수정, 삭제 버튼이 보일 조건(수정/삭제 처리가능)
		if( sessId === writer || sessAuth === "admin" ){
			$("#uptBtn, #delBtn").show()
		}else{
			$("#uptBtn, #delBtn").hide()
		}
		let msg = "${msg}"
		if(msg!=""){
			alert(msg)
			if(msg.indexOf("삭제")>=0){ // 삭제라는 키워드가 시작되는 index리턴, 즉, 삭제 성공/삭제 실패일 시, 리스트로 바로 이동
				$("form").attr("action", "boardList");
		        $("form").submit();	
			}
		}
		
		
		
		$("#repBtn").click(function(){
			if(confirm("답글을 처리하겠습니까?")){
				$("form").attr("action","boardReply")
				$("form").submit()
			}
		})
		

		$("#uptBtn").click(function(){ 
			if(confirm("수정하시겠습니까?")){
				$("form").attr("action","boardUpdate")
				$("form").submit()
			}
		})
		$("#delBtn").click(function(){ 
			if(confirm("삭제하시겠습니까?")){
				$("form").attr("action","boardDelete")
				$("form").submit()
			}
		})
		$("#lstBtn").click(function(){ 
			$("form").attr("action", "boardList");
	        $("form").submit();			
			
		})  	
	});
	</script>
	</head>

	<body>
	<div class="jumbotron text-center">
	  <h2>게시물 상세</h2>
	</div>
	<%--

	
	 --%>
	 <div class="container">
	 	<h6 class="text-right" >${mem.name}님 [${mem.auth}]로그인중</h6>
	    <form  method="post">
			<input type="hidden" name="curPage" value="${sch.curPage}" />
		    <input type="hidden" name="pageSize" value="${sch.pageSize}" />
		    <input type="hidden" name="schSubject" value="${sch.schSubject}" />
		    <input type="hidden" name="schWriter" value="${sch.schWriter}" />
    	    
	    	<div class="row">
		        <div class="col-md-6">
		            <div class="form-group">
		                <label for="no">번호</label>
		                <input type="text" readonly class="form-control" id="no" name="no" value="${board.no}" required>
		            </div>
		        </div>    
		        <div class="col-md-6">
		            <div class="form-group">
		                <label for="refno">상위번호</label>
		                <input type="text" readonly class="form-control" id="refno" name="refno" value="${board.refno}" required>
		            </div>
		        </div>
		   </div>
		   <div class="row">         
		        <div class="col-md-6">	
		            <div class="form-group">
		                <label for="subject">제목</label>
		                <input type="text" class="form-control" id="subject" name="subject" value="${board.subject}" required>
		            </div>	
		        </div>
		    	<div class="col-md-6">	    	        	            
		            <div class="form-group">
		                <label for="writer">작성자</label>
		                <input type="text" class="form-control" id="writer" name="writer" value="${board.writer}" readonly>
		            </div>              
		        </div>
	     	</div>   
	     	<div class="row">       
		        <div class="col-md-6">

		            <div class="form-group">
		                <label for="regdte">등록일</label>
		                <%-- 등록일 수정일은 DB에서 처리하는 name 속성 반드시 빼야 한다. --%>
		                <input type="text" class="form-control" readonly
		                 value="<fmt:formatDate type="both" value='${board.regdte}'/>">
		            </div>  
		       	</div>
		    	<div class="col-md-6">	     
		            <div class="form-group">
		                <label for="uptdte">수정일</label>
		                <input type="text" class="form-control" readonly 
		                value="<fmt:formatDate  type="both" value='${board.uptdte}'/>">
		            </div>		            
		        </div>
		   </div>
		   <div class="row">     
		        <div class="col-md-6">        
		            <div class="form-group">
		                <label for="">첨부파일</label><br>
		                
		                <c:forEach var="bfile" items="${bfiles}">
		                <button type="button"  class="btn btn-success"
		                	ondblclick="download('${bfile.fname}')">${bfile.fname}</button>
		                </c:forEach>
		                
		            </div>	
		           	<script type="text/javascript">
		           	function download(fname){
		           		if(confirm(fname+"을 다운로드하시겠습니까?")){
		           			location.href="/download?fname="+fname
		           		}
		           	}
		           	</script>
		        </div>    
				<div class="col-md-6">	
		            <div class="form-group">
		                <label for="readcnt">조회수</label>
		                <input type="text" class="form-control" readonly id="readcnt" value="${board.readcnt}">
		            </div>  
		        </div>
		    </div>  
		    <div class="row">  
		        <div class="col-md-12">
		            <div class="form-group">
		            <label for="content">내용</label>
		            <textarea class="form-control" name="content" rows="5" placeholder="내용을 입력하세요">${board.content}</textarea>
		            </div>
		        </div>
		    </div>    
		    <button id="uptBtn" type="button" class="btn btn-primary">수정</button>
		    <button id="delBtn"  type="button" class="btn btn-danger">삭제</button>
		    <button id="repBtn" type="button" class="btn btn-warning">답글</button>
		    <button id="lstBtn" type="button" class="btn btn-info">메인</button>        
	   </form>	
	</div>
	</body>
	</html>