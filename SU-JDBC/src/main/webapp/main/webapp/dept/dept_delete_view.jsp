<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//파라미터를 호출하고 읽어온 데이터를 부호 없는 정수로 구문 분석하여 int 타입 변수에 할당한다.
int deptno = Integer.parseInt(request.getParameter("deptno"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 삭제</title>
</head>
<body>
	<script type="text/javascript">
// 경고창으로 확인 내용을 설정한다.
alert("입력하신 <%=deptno%>
		번의 부서 번호를 삭제하였습니다."); //전체 URL 주소를 반환하여 이동할 웹 페이지를 설정한다.
		location.href = "./DeptSelect";
	</script>
</body>
</html>