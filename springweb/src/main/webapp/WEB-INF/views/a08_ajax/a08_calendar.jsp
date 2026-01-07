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
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      initialDate: '2023-01-12',
      navLinks: true, // can click day/week names to navigate views
      selectable: true,
      selectMirror: true,
      select: function(arg) { // 날짜를 클릭하거나  스클롤시 처리되는 이벤트
    	console.log("# 일정 데이터(api) 매개변수 #")
    	console.log(arg)
        var title = prompt('Event Title:');
        if (title) {
          calendar.addEvent({
            title: title,
            start: arg.start,
            end: arg.end,
            allDay: arg.allDay
          })
        }
    	console.log("# 메인 calendar #")        
    	console.log(calendar)        
        calendar.unselect()
      },
      eventClick: function(arg) {
    	  console.log("# 저장된 일정 #")
    	  console.log(arg.event)
    	  
        if (confirm('Are you sure you want to delete this event?')) {
          arg.event.remove()
        }
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

</body>
</html>
