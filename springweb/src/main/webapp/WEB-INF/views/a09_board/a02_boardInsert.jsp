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
		
		var msg = "${msg}"
		if(msg!=""){
			if(!confirm(msg+"\n계속 등록하시겠습니까?")){
				location.href="boardList"
			}
		}
		$("#regBtn").click(function(){
			if(confirm("게시물 등록하시겠습니까?")){
				//$("form").attr("action","boardInsert")
				$("form").submit();
			}
		})
		$("#lstBtn").click(function(){ 
			location.href="boardList"
		})
			
	});
</script>
</head>

<body>
	<div class="jumbotron text-center">
		<h2>게시물 등록</h2>
	</div>
	<%-- 	// refno subject content writer
	
	 name="subject" value="게시물 등록"
 	 name="writer"  value="마길동"
	 name="content"  value="내용"
	 $("form").submit(); type="submit" 클릭한 것과 동일..
	 ==> 
	 post /boardInsert
	 ?subject=게시물 등록&writer=마길동&content=내용
	 
	 controller
	 @PostMapping("boardInsert")
	 public boardInsert(@RequestParam("subject") String  subject ){
	 public boardInsert(Board ins ){
	 
	 }
	 post /insertRecord
	 ?name=홍길동&kor=70&eng=80
	 
	 controller
	 @PostMapping("insertRecord")
	 public insertRecord(@RequestParam("name") String name,
	                     @RequestParam("kor") int kor, 
	                     @RequestParam("eng") int eng 
	                     
	 public insertRecord(Record ins)
	 	 
	 class Record{
	 	private String name;
	 	private int kor;
	 	private int eng;
	 }      
	 
	 
	 get /callFruits
	 ?fruit=사과&price=3000&cnt=5
	 @GetMapping("callFruits")
	 public callFruits(@RequestParam("fruit") String fruit,
	 				   @RequestParam("price") int price,
	 				   @RequestParam("cnt") int cnt
	 				   
	 public callFruits(	Fruits ins){} 				   
	 				   
	 class Fruits{
	 	private String fruit;
	 	private int price;
	 	privaet int cntg;
	 
	 }
	 
	 
	 
	 
	 
	 
	               
	                     
	                     
	                      
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 class Board{
	 	private String subject;
	 	private String writer;
	 	private String content;
	 
	 }
	 
	 --%>
	<div class="container">
		<h6 class="text-right" >${mem.name}님 [${mem.auth}]로그인중</h6>
		<%--
		아래 form 하위에 있는 name=""  value=""
		submit를 클릭시, method="post"과 action="이동할 url"로 호출되어 controller 메서드.. 
		refno=0&subject=게시물등록&content=내용&writer=홍길동
		
		 --%>
		<form method="post"  enctype="multipart/form-data">
			<input type="hidden" name="refno" value="0"/>
			<%-- 답글시는 처리가 필요하기에.. 답글과 등록글은 동일 화면에서 처리 --%>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="subject">제목</label> <input type="text" 
							value="" class="form-control" id="subject" name="subject">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="writer">작성자</label> 
							<input type="hidden" value="${mem.id}" name="writer"> 
							<%-- 실제 등록되는 사용자는 세션 id --%>
							<input type="text" value="${mem.name}[ ${mem.id} ]" class="form-control" readonly>
							<%-- 보이는 것은 세션 이름과 세션아이디 
							세션값을 등록했기에 권한별 처리가 각 화면과 기능 버튼에 처리가 가능하다..
							--%>
							
					</div>
				</div>
			</div>		
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="reports">첨부파일</label> 
						<input type="file" class="form-control" id="reports" 
							name="reports" placeholder="파일을 선택하세요"
							multiple="multiple">
					</div>
				</div>
			</div>				
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="content">내용</label> 
						<textarea class="form-control" id="content" name="content" rows="5" ></textarea>	
					</div>
				</div>
			</div>					

			<div class="btn-group-custom">
				<button id="regBtn" type="button" class="btn btn-success btn-lg">등록</button>
				<button id="lstBtn" type="button" class="btn btn-info btn-lg">메인으로</button>
			</div>
		</form>
	</div>
</body>
</html>