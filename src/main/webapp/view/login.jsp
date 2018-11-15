<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
	padding: 1% 0;
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
.login{
	margin: 0;
	border: 0;
	background-color: white;
	border-radius: 5px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	left: 60%;
	width: 30%;
	height: 100%;
	padding: 35px 80px 35px 80px;
	position: relative;
}
</style>
</head>
<body>
<div class="header">asdf</div>
<div class="body">
	<div class="container-fluid login">
		<h3>用户登录</h3>
		<form role="form">
			<div class="form-group">
				<label for="username">账&emsp;号：</label>
				<input type="text" class="form-control" id="username" placeholder="Enter username">
			</div>
			<div class="form-group">
				<label for="password">密&emsp;码：</label>
				<input type="password" class="form-control" id="password" placeholder="Enter password">
			</div>
			<div class="form-group">
				<label for="captcha">验证码：</label>
				<div class="row">
					<div class="col-4">
						<input type="text" class="form-control" maxlength="6" id="captcha" placeholder="Enter captcha">
					</div>
					<div class="col-2">
						<img id="codeImage" class="img-responsive" alt="验证码" src="<%=request.getContextPath()%>/codeImage">
					</div>
				</div>
			</div>
			<div class="form-check" style="line-height: normal;margin-bottom: 15px;">
				<label class="form-check-label">
					<input class="form-check-input" type="checkbox" id="rememberMe">记住密码
				</label>
			</div>
			<div class="row justify-content-center">
				<button type="submit" class="btn btn-primary justify-content-center">登陆</button>
			</div>
		</form>
	</div>
</div>
<div class="footer">
	Copyright&copy;2018
</div>
</body>
<script type="text/javascript">
$(function(){
	$("#codeImage").bind('click',function(e){
		$("#codeImage").attr('src',"<%=request.getContextPath()%>/codeImage");
	});
});
</script>
</html>