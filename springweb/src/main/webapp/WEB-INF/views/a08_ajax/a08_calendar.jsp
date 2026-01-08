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
  var calendar =null
  document.addEventListener('DOMContentLoaded', function() {
	  

	  // 등록 처리(ajax)
	  $("#regBtn").click(function(){
		  if(confirm("등록하시겠습니까?")){
			  callAjax("insertCalendar", "post")
		  }
	  })
	  // 수정 처리(ajax) updateCalendar
	  $("#uptBtn").click(function(){
		  if(confirm("수정하시겠습니까?")){
			  callAjax("updateCalendar", "put")
		  }
	  })	  
	  // 수정 처리(ajax)
	  $("#delBtn").click(function(){
		  if(confirm("삭제하시겠습니까?")){
			  callAjax("deleteCalendar", "delete")
		  }
	  })	  
    var calendarEl = document.getElementById('calendar');
    calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      initialDate: '2026-01-08',
      navLinks: true, // can click day/week names to navigate views
      selectable: true,
      selectMirror: true,
      select: function(arg) { // 날짜를 클릭하거나  스클롤시 처리되는 이벤트
    	 // 등록시는 등록 기능 버튼만 보이게 처리
    	 $("#frmTitle").text("일정 등록")
    	 $("#regBtn").show()
    	 $("#uptBtn").hide()
    	 $("#delBtn").hide()
     	 $("#regLoadBtn").click() 
    	  // 강제 이벤트 처리(javascript 클릭하지 않더라도 클릭한 것 동일한 효과 코드)
     	 addForm(arg, "I") // 등록 I
         calendar.unselect()
      },
      eventClick: function(arg) {
     	  $("#frmTitle").text("일정 상세")
    	  $("#regBtn").hide()
    	  $("#uptBtn").show()
    	  $("#delBtn").show()
    	  $("#regLoadBtn").click() 
    	  //id 	title start end backgroundColor textColor allDay urlLink writer content
    	  console.log("# 저장된 일정 #")
	      addForm(arg.event, "D") // 상세 D
      },
      editable: true,
      dayMaxEvents: true, // allow "more" link when too many events
      // ex) 전일일정   2023-01-06   프로젝트 시작
      //     시간일정  2023-01-10에 오전 9시부터 12시까지   프로젝트 회의 일정
      // ajax로 데이터를 처리하여, javascript에서 다른 프로그램지원하지 않는 함수매개변수 전달하여, 
      // 그 함수의 매개값으로 json 데이터를 넣으면, fullcalendar의 전체 데이터를 할당하여 로딩 처리한다.
      events: function(info, successCallback, failureCallback){
    	  // 기능 코드를 통해서 특정한 데이터를 캘린더 데이터를 활용할 수 있기에 함수를 처리한다.
    	  $.ajax({
    		  url:"calendarList",
    		  dataType:"json",
    		  success:function(calenList){
    			  console.log("#가져온 캘린더 데이터#")
    			  console.log(calenList)
    			  successCallback(calenList);
    		  },
    		  error:function(err){
    			  console.log(err)
    		  }
    	  })
    	  
      }
    
    });

    calendar.render();
    // form 데이터 로딩 공통 함수 처리
    function addForm(event, proc){   // event 데이터와  등록/수정 처리 form 공통..
  	  
  	  $("#frm02")[0].reset() // 상세화면 확인하고, 다시 볼 때 초기화면으로 처리.
  	  
  	  // 등록/수정 공통
    	  $("[name=start]").val(event.startStr.substring(0,19))
  	  $("[name=end]").val(event.endStr.substring(0,19))
  	  $("[name=allDay]").val(event.allDay?1:0) // 입력시 실제 전송할 내용
  	  $("#allDay").val(event.allDay?"종일":"시간") // 화면에 보이는 레이블 내용	  
  	  
  	  // 고유 속성(api 지원) 상세화면 데이터 처리..
  	  if(proc=='D'){
  		  $("[name=id]").val(event.id)
  		  $("[name=title]").val(event.title)
  		  $("[name=backgroundColor]").val(event.backgroundColor)
  		  $("[name=textColor]").val(event.textColor)
  		  $("[name=urlLink]").val(event.extendedProps.urlLink)	 	      
  		  $("[name=writer]").val(event.extendedProps.writer)	 	      
  		  $("[name=content]").val(event.extendedProps.content)	 	  
  	  }
    }
    // ajax 처리 공통 함수 
    function callAjax(urlLoc, method){
  	  $.ajax({
  		  url:urlLoc,
  		  type:method,
  		  data:$("#frm02").serialize(),
  		  success:function(msg){
  			  alert(msg)
  			  calendar.refetchEvents();//일정을 전체적으로 재로딩 처리..
  			  $(".close").click() // 현재 모달창 닫기..
  		  },
  		  error:function(err){
  			  console.log(err)
  		  }
  	  })	  
    }

    
    
    
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
      <%-- 	// id 	title start end backgroundColor textColor allDay urlLink writer content
			// 아이디 일정   시작    종료 배경색상    		글자색상	  종일    링크      작성자   내용--%>
      <div class="modal-body">
		<form id="frm02" class="form"  method="post">
		 <input type="hidden" name="id" value="0"/>
	     <div class="row">
	      <div class="col" >
	        <input type="text" class="form-control" placeholder="일정 입력"   name="title" >
	      </div>
	      <div class="col">
	        <input type="text" class="form-control" placeholder="작성자 입력" name="writer">
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
	        <input type="text" class="form-control"  placeholder="링크할 주소 입력"   name="urlLink">
	      </div>
	     </div>
	     <div class="row">
	      <div class="col">
	      	<textarea class="form-control" rows="5"  placeholder="상세 내용 입력" name="content"></textarea>
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
