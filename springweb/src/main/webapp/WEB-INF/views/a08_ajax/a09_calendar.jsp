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
<script src="${path}/dist/index.global.js"></script>
<script src="${path}/com/jquery-3.7.1.js"></script>
<script src="${path}/com/bootstrap.min.js"></script>


<script>

  document.addEventListener('DOMContentLoaded', function() {
	  $("#regBtn").click(function(){
		  if(confirm("등록하시겠습니까?")){
			  $.ajax({
				  url:"insertCalendarRoom",
				  type:"post",
				  data:$("#frm02").serialize(),
				  success:function(msg){
					  alert(msg)
					  location.reload();
					  
				  },
				  error:function(err){
					  console.log(err)
				  }
			  })
			  
		  }
	  })
	  
	  
	  
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      initialDate: '2026-01-08',
      navLinks: true, // can click day/week names to navigate views
      selectable: true,
      selectMirror: true,
      select: function(arg) {
     	 // 등록시는 등록 기능 버튼만 보이게 처리
     	 $("#frmTitle").text("회의실 예약 등록")
     	 $("#regBtn").show()
     	 $("#uptBtn").hide()
     	 $("#delBtn").hide()
     	 $("#frm02")[0].reset() // 상세화면 확인하고, 다시 볼 때 초기화면으로 처리.
     	  $("#regLoadBtn").click() 
     	  // 강제 이벤트 처리(javascript 클릭하지 않더라도 클릭한 것 동일한 효과 코드)
     	console.log("# 일정 데이터(api) 매개변수 #")
     	console.log(arg.startStr)
     	console.log(arg.endStr)
     	console.log(arg.allDay)
     	$("[name=start]").val(arg.startStr.substring(0,19))
     	$("[name=end]").val(arg.endStr.substring(0,19))
     	$("[name=allDay]").val(arg.allDay?1:0) // 입력시 실제 전송할 내용
     	$("#allDay").val(arg.allDay?"종일":"시간") // 화면에 보이는 레이블 내용

     	
     	
      },
      eventClick: function(arg) {
      	 $("#frmTitle").text("회의실 예약 상황")
    	 $("#regBtn").hide()
    	 $("#uptBtn").show()
    	 $("#delBtn").show()
    	 $("#frm02")[0].reset() // 상세화면 확인하고, 다시 볼 때 초기화면으로 처리.
    	  $("#regLoadBtn").click() 
    	  
    	  console.log("# 저장된 일정 #")
    	  console.log(arg.event)
    	  
      },
      editable: true,
      dayMaxEvents: true, // allow "more" link when too many events
      events: function(info, successCallback, failureCallback){
    	  $.ajax({
    		  url:"fullCalendarRoomList",
    		  dataType:"json",
    		  success:function(calendarList){
    			  successCallback(calendarList)
    			  
    		  }
    	  })
      }
    });

    calendar.render();
  });

</script>
<style>

  body {
    margin: 40px 10px;
    padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 1100px;
    margin: 0 auto;
  }

</style>
</head>
<body>

  <div id='calendar'></div>
  <div id="regLoadBtn" data-toggle="modal" data-target="#exampleModalCenter" ></div>

<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="frmTitle">일정등록</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <%-- 	
 예약명 회의실 이름  예약자 회의 안건 
      
      // id 	title start end backgroundColor textColor allDay roomName writer content members
			// 아이디 일정   시작    종료 배경색상    		글자색상	  종일    회의실      작성자   내용--%>
      <div class="modal-body">
		<form id="frm02" class="form"  method="post">
		 <input type="hidden" id="id" value="0"/>
	     <div class="row">
	      <div class="col" id="title">
	        <input type="text" class="form-control" placeholder="예약명 입력"   name="title" >
	      </div>
	      <div class="col">
	        <input type="text" class="form-control" placeholder="예약자 입력" name="writer">
	      </div>
	     </div>
	     <div class="row">
	      <div class="col">
	        <input type="text" class="form-control" name="start" title="시작일" readonly>
	      </div>
	      <div class="col">
	        <input type="text" class="form-control" name="end" title="종료일"  readonly>
	      </div>
	     </div>
	     <div class="row">
	      <div class="col" >
	        <input type="color" class="form-control"  value="#0099cc"  name="backgroundColor" >
	      </div>
	      <div class="col">
	        <input type="color" class="form-control"  value="#ccffff" name="textColor">
	      </div>
	     </div>
	     <div class="row">
	      <div class="col" >
	        <input type="text" class="form-control" id="allDay" readonly>
	        <input type="hidden" name="allDay" value="0"/>
	      </div>
	      <div class="col">
	        <input type="text" class="form-control"  placeholder="예약할 회의실 입력"   name="roomName">
	      </div>
	     </div>
	     <div class="row">
	      <div class="col">
	      	<textarea class="form-control"  placeholder="참석 예정자 입력" name="members"></textarea>
	      </div>
	     </div>	 
	     	     
	     <div class="row">
	      <div class="col">
	      	<textarea class="form-control" rows="5"  placeholder="회의 안건  입력" name="content"></textarea>
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

