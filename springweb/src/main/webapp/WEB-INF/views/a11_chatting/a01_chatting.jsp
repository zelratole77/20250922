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
			if(event.keyCode==13){
				connect()
			}
		})
		$("#msg").keyup(function(){
			if( event.keyCode==13){
				sendMsg($("#id").val(),$("#msg").val())
			}			
		})
		$("#sndBtn").click(function(){
			sendMsg($("#id").val(),$("#msg").val())
		})
	});
	function sendMsg(id, msg){
		 
		// 메시지 발송..
		if(msg.length > 0 ){
			wsocket.send(id+":"+msg)
		}else{
			alert("메시지 입력시 전송")
		}
		
	}
	
	
	function connect(){
		if($("#id").val().length>0){
			wsocket = new WebSocket(socketServer)
			// 접속시 처리할 내용(핸들러 메서드 선언)
			wsocket.onopen=function(evt){
				console.log(evt)
				// 접속시 입장했다는 메시지 서버에 전달..
				sendMsg($("#id").val()+"", "입장합니다")
			}
			// 메시지를 받았을 때(핸들러 메서드 선언) 서버에서 ==> 클라이언트에 전송한 메시지
			wsocket.onmessage=function(evt){
				console.log(evt)
				revMsg(evt.data)
				
			}
		}else{
			alert("아이디 입력시 접속")
		}
		
	}
	
	// 자동 스크롤을 위해서 최대 크기 전역변수로 설정
	let mx = 0
	function revMsg(msg){
		console.log(msg)
		// 1. 보내는 메시지 오른쪽 정렬, 받는 메시지 왼쪽 정렬 처리
		let alignOpt = "left"
		let msgArr = msg.split(":") // 사용자명:메시지    구분하여 처리된 것을 ==> ["사용자아이디","메시지"]
		let revId = msgArr[0] // 서버로 부터 받은 메시지의 아이디
		if(revId == $("#id").val()){
			console.log(msg)
			alignOpt = "right" // 오른쪽 정렬
			msg =  msgArr[1] // 아이디른 빼고 메시지 표시
		}
		console.log("## 정렬 전 ##")
		console.log(msg)
		// 정렬 처리되 메시지
		/*
		<div style="text-align:정렬옵션">
			메시지내용...
		<div>
		
		*/
		let alignedMsg = $("<div></div>").text(msg).attr("align",alignOpt).css("width"
							,$("#chatArea").width()-20)
		
		$("#chatMessageArea").append(alignedMsg)
		$("#msg").val("").focus()
		let height = parseInt($("#chatMessageArea").height())
		mx += height + 20
		// 데이터가 입력시 마다, 스크롤의 크기를 자동 올라가게 한다.
		$("#chatArea").scrollTop(mx)
		
		
		
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