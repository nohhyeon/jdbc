<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="su.dept.dto.DeptDTO, java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
ArrayList<DeptDTO> arrayList = (ArrayList<DeptDTO>) request.getSession().getAttribute("arrayList");
//파라미터를 호출하고 읽어온 데이터를 부호 없는 정수로 구문 분석하여 int 타입 변수에 할당한다.
int deptno = Integer.parseInt(request.getParameter("deptno"));
for (DeptDTO deptDTO : arrayList) {
	if (deptDTO.getDeptno() == deptno) {
		out.println("<script type='text/javascript'>");
		//경고창으로 부서 번호를 확인할 수 있도록 설정한다.
		out.println("alert('입력하신 " + deptno + "번의 부서 번호가 존재합니다. 다시 입력하세요.')");
		out.println("location.href='../DeptInsert'");
		out.println("</script>");
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 입력</title>
<script type="text/javascript">
alert("입력하신 <%=deptno%>
	번의 부서 번호를 등록하였습니다.");
	location.href = "../DeptSelect"
</script>
</head>
<body>
</body>
</html>