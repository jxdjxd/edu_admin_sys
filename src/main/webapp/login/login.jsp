<%@ page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>教务管理系统登录</title>
	<base href="http://localhost:8080/edu_admin_sys/">
	<link rel="shortcut icon" href="common/img/logo.ico">
	<link href="common/css/base.css" type="text/css" rel="stylesheet">
	<link href="base/login.css" type="text/css" rel="stylesheet">
	<script src="common/js/jquery-3.3.1.min.js" type="text/javascript"></script>
	<script src="base/login.js" type="text/javascript"></script>
</head>
<body>
	<div>
		<% String tokenValue = new Date().getTime() +""; %>
		<c:set value="<%=tokenValue %>" var="token" scope="session"/>
	</div>
	<div class="w">
		<header>
			<div class="logo">
				<a href="#">
					<img src="common/img/logo.png" alt="logo图片">
				</a>
			</div>
		</header>
		<div class="loginarea">
			<h3>用户登录
				<div class="regist">
					没有账号，去<a href="#">注册</a>
				</div>
			</h3>
			<div class="login_form">
				<form action="loginChangeServlet" method="post">
					<input type="hidden" name="token" value="<%=tokenValue %>"/>
					<ul>
						<li>
							<label for="userName">用户名:</label>
							<input id="userName" type="text" name="username" value="${sessionScope.username }">
							<span id="userNameSpan" class="">
								<i class=""></i>

							</span>
						</li>
						<li>
							<label for="password">密码:</label>
							<input id="password" type="password" name="password" size="21">
							<span id="userPwdSpan" class="">
								<i class=""></i>

							</span>
						</li>
						<li id="code_li">
							<label for="code">验证码:</label>
							<input id="code" type="text" name="CHECK_CODE_PARAM_NAME">
							<img id="code_img" src="getVerifyCode" alt="验证码图片">
						</li>
						<li>
							<input id="submit" type="submit" value="登录" class="btn">
							<span>
								<a id="findPwd_link" href="findPassword.jsp">找回密码</a>
							</span>
						</li>
					</ul>
				</form>
			</div>
		</div>
		<footer>

		</footer>
	</div>
	<script>
		var relCode = "${sessionScope.code}".toLowerCase();
		var sessionUserName = "${sessionScope.user.name}"
		var sessionUserPwd = "${sessionScope.user.password}"

		function flush(){
			relCode = "${sessionScope.code}".toLowerCase();
			sessionUserName = "${sessionScope.user.name}"
			sessionUserPwd = "${sessionScope.user.password}"
		}
	</script>
</body>
</html>