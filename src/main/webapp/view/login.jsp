<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/scripts/js/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" charset="utf-8" />
<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/js/bootstrap/js/bootstrap.js"></script>
<style type="text/css">
html,body{
	height: 100%;
	width: 100%;
	margin: 0;
	border: 0;
	padding: 0;
	overflow: hidden;
	position: relative;
}
.header{
	width: 100%;
	height: 15%;
	display: block;
}
.body{
	width: 100%;
	height: 70%;
	display: block;
	background-color: blue;
}
.footer{
	width: 100%;
	height: 15%;
	display: block;
	position: relative;
	text-align: center;
}
.left{
	margin: 0;
	border: 0;
	width: 60%;
	height: 100%;
	display: inline-flex;
	background-color: yellow;
}
.login{
	margin: 0;
	border: 0;
	background-color: green;
	display: inline-flex;
	width: 30%;
	height: 100%;
	text-align: center;
}
</style>
</head>
<body>
<div class="header">1</div>
<div class="body">
	<div class="left">1</div>
	<div class="login">
		<form action="${pageContext.request.contextPath }/toLogin" method="post">  
		    <label for="username">账&emsp;号：</label><input type="text" id="username" name="username" value="${username}"/><br/>
		    <label for="password">密&emsp;码：</label><input type="password" id="password" name="password" value="${password}"><br/>
		    <label for="password">验证码：</label><input type="password" id="password" name="password" value="${password}"><br/>
		    <input type="checkbox" id="rememberMe" name="rememberMe" value="${rememberMe}"><label for="password">记住我</label><br/>
		    <input type="submit" value="login"/><font color="red">${errorMsg}</font>  
		</form>
	</div>
</div>
<div class="footer">
	Copyright&copy;2018
</div>
</body>
</html>