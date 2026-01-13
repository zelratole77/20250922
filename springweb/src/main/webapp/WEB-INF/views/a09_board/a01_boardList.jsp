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
		// session값이 설정되어 있을 때만, 현재 화면을 사용할 수 있고,
		// session값이 없을 때는 로그인 메시지가 뜨고, 로그인 화면으로 이동 처리.
		let sessCk = "${mem.name}"===""  
		if(sessCk){ //세션이 없을 때..- 로그인 처리가 되지 않을 때..
			alert("로그인 하셔야 합니다.")
			location.href="login"
		}
		
		
		
		
		$("#regBtn").click(function(){
			location.href="boardInsert"
		})
	});
	function goDetail(no){
		location.href="boardDetail?no="+no
	}	
	function logout(){
		if(confirm("로그 아웃 하시겠습니까?")){
			location.href="login"  // get방식으로 이동..
		}
	}
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>게시판리스트</h2>

</div>
<%-- 
		
--%>
<div class="container">
	<h6 class="text-right" onclick="logout()">${mem.name}님 로그인중</h6>
	<form id="frm01" class="form"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input placeholder="제목" name="subject" value="${param.subject}" class="form-control mr-sm-2" />
	    <input placeholder="작성자" name="writer"  value="${param.writer}" class="form-control mr-sm-2"/>
	    <button class="btn btn-info" type="submit">Search</button>
	    <button id="regBtn" class="btn btn-success" type="button">등록</button>
 	</nav>
	</form>
	<%--
	@RequestMapping("boardList")   // get/post    action="boardList" get방식으로 해당 url호출 했기에 생략 가능
									RequestMapping 둘다 처리..
	public String boardList(Board sch, Model d) {	subject=공지&writer=홍길동    ==> Board sch 데이터 입력
												setSubject, setWriter
	
	 --%>
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
    <tbody>
    	<c:forEach var="board" items="${boardList}">
    	<tr ondblclick="goDetail(${board.no})"><td>${board.no}</td><td>${board.subject}</td>
    		<td>${board.writer}</td>
    		<td><fmt:formatDate value="${board.regdte}"/></td><td>${board.readcnt}</td></tr>
    	</c:forEach>
    </tbody>
	</table>    
</div>
</body>
</html>