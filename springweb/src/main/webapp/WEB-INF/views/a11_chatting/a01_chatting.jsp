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
	#chatArea{
		width:100%;height:200px;overflow-y:scroll;text-align:left;
		border:1px solid green;
		padding-right:15px;
	}	
</style>
<script src="${path}/com/jquery-3.7.1.js"></script>
<script src="${path}/com/bootstrap.min.js"></script>
<script type="text/javascript">
	let socketServer = "${socketServer}" // 공통 소켓서버 접속 url
	let wsocket = null // 소켓서버 객체(js)

	$(document).ready(function(){
		$("#entBtn").click(function(){
			connect()
		})
		$("#id").keyup(function(){
			let idValCk = $(this).val().length > 0 
			if(idValCk && event.keyCode==13){
				connect()
			}
		})
	
	});
	function connect(){
		wsocket = new WebSocket(socketServer)
		// 접속시 처리할 내용(핸들러 메서드 선언)
		wsocket.onopen=function(evt){
			console.log(evt)
			// 접속시 입장했다는 메시지 서버에 전달..
			wsocket.send($("#id").val()+"님:입장합니다.")
		}
		// 메시지를 받았을 때(핸들러 메서드 선언)
	}
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>채팅</h2>

</div>
<%-- 
		
--%>
<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="id">입장할 이름</label> 
							<input type="text" value="" class="form-control" id="id" >
							<button id="entBtn" type="button" class="btn btn-success btn-lg">채팅방입장</button>
							<button id="extBtn" type="button" class="btn btn-primary btn-lg">채팅방나가기</button>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="id">메시지</label> 
						<div id="chatArea" class="input-group-append">
							<div id="chatMessageArea"></div>
						</div>	
					</div>
				</div>
			</div>			
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="id">메시지 전송</label> 
							<input type="text" class="form-control" id="msg" 
								placeholder="전송할 메시지 입력" >
							<button id="sndBtn" type="button" 
								class="btn btn-info btn-lg">메시지전송</button>
					</div>
				</div>
			</div>			
</div>
</body>
</html>