<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 모바일 웹 브라우저의 너비를 설정한다.-->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>부서 정보 삭제</title>
<%--포워드로 전송할 경우 스타일시트와 자바스크립트를 지원하기 위해 경로를 현재 작업 디렉터리로 변경한다.--%>
<link rel="stylesheet" type="text/css"
	href="./css/bootstrap.min_4.5.0.css">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script src="./js/jquery.validate.min.js" type="text/javascript"></script>
<script src="./js/dept_validity.js" type="text/javascript"></script>
</head>
<body>
	<header id="main-header" class="py-2 btn-dark text-white">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>부서 정보 삭제</h1>
				</div>
			</div>
		</div>
	</header>
	<section class="py-4 mb-4 bg-light"></section>
	<section id="department">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<h5>부서 삭제</h5>
						</div>
						<div class="card-body">
							<form action="./DeptDelete" method="post" id="sign_dept">
								<fieldset>
									<div class="form-group row">
										<label for="deptno" class="ml-sm-3 col-form-label"> 부서
											번호 </label>
										<div class="ml-sm-3">
											<!-- 컨트롤의 내용은 변경되지 않지만, 데이터는 전송된다.-->
											<input type="text" name="deptno" id="deptno"
												class="form-control form-control-sm bg-white"
												value="<%=request.getParameter("deptno")%>" readonly>
										</div>
									</div>
									<div class="form-group">
										<button type="submit" class="btn btn-secondary">삭제</button>
										<button type="reset" class="btn btn-secondary">취소</button>
									</div>
								</fieldset>
							</form>
							<div class="row">
								<div class="col-md-4">
									<a href="./DeptSelect" class="btn btn-primary btn-block">
										부서 목록 </a>
								</div>
								<div class="col-md-4">
									<a href="./DeptInsert" class="btn btn-success btn-block">
										부서 입력 </a>
								</div>
								<div class="col-md-4">
									<a
										href="./DeptUpdate?deptno=<%=request.getParameter("deptno") %>"
										class="btn btn-warning btn-block"> 부서 수정 </a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>