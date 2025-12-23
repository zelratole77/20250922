<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="UTF-8" />

<fmt:formatDate value="${meet.meetDate}" pattern="yyyy-MM-dd'T'HH:mm"
	var="fmtDate" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>만남 상세/수정</title>
<link rel="stylesheet" href="${path}/com/bootstrap.min.css">
<style>
/* 추가적인 커스텀 스타일 */
.form-title {
	margin-bottom: 20px;
	border-bottom: 1px solid #eee;
	padding-bottom: 10px;
}

.btn-group-custom {
	margin-top: 20px;
	text-align: center;
}
</style>
<script src="${path}/com/jquery-3.7.1.js"></script>
<script src="${path}/com/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// 상태값 초기화 (JSP 변수를 JS로 주입)
		$("#status").val("${meet.status}");

		// 버튼 이벤트 핸들러 (기능에 맞게 action 설정 필요)
		$("#uptBtn").click(function() {
			if (confirm("수정하시겠습니까?")) {
				$("form").attr("action", "${path}/updateMeet.do"); // 예시 action
				$("form").submit();
			}
		});

		$("#delBtn").click(function() {
			if (confirm("정말로 삭제하시겠습니까?")) {
				$("#method").val("DELETE"); // Hidden 필드 등을 이용한 처리 예시
				// location.href = ... 혹은 form submit
				alert("삭제 기능 구현 필요");
			}
		});

		$("#lstBtn").click(function() {
			location.href = "${path}/meetList.do"; // 예시 이동 경로
		});
	});
</script>
</head>

<body>
	<div class="jumbotron text-center">
		<h2>미팅 상세 정보</h2>
	</div>

	<div class="container">
		<div class="panel panel-default">
			<div class="panel-body">
				<form method="post">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="dateNo">번호</label> <input type="text" readonly
									value="${meet.dateNo}" class="form-control" id="dateNo"
									name="dateNo">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="meetDate">만남일</label> 
									<input type="datetime-local"
									value="${fmtDate}" pattern="yyyy-MM-dd'T'HH:mm" class="form-control" id="meetDate"
									name="meetDate" required>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="partnerName">파트너 이름</label> <input type="text"
									value="${meet.partnerName}" class="form-control"
									id="partnerName" name="partnerName" required>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="partnerAge">파트너 나이</label> <input type="number"
									value="${meet.partnerAge}" class="form-control" id="partnerAge"
									name="partnerAge" required>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="job">파트너 직업</label> <input type="text"
									value="${meet.job}" class="form-control" id="job" name="job"
									required>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="location">사는 곳</label> <input type="text"
									value="${meet.location}" class="form-control" id="location"
									name="location" required>
							</div>
						</div>
					</div>

					<hr>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="status">현재 상태</label> <select class="form-control"
									id="status" name="status">
									<option value="SUCCESS">성공</option>
									<option value="FAIL">실패</option>
									<option value="ING">진행중</option>
									<option value="WAITING">기다림</option>
								</select>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="score">평점 (1~10)</label> <input type="number"
									value="${meet.score}" class="form-control" id="score"
									name="score" min="0" max="10" required>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label for="review">리뷰 / 메모</label>
								<textarea id="review" class="form-control" name="review"
									rows="4">${meet.review}</textarea>
							</div>
						</div>
					</div>

					<div class="btn-group-custom">
						<button id="uptBtn" type="button" class="btn btn-success btn-lg">수정</button>
						<button id="delBtn" type="button" class="btn btn-danger btn-lg">삭제</button>
						<button id="lstBtn" type="button" class="btn btn-info btn-lg">메인으로</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>