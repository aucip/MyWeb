<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
</head>
<body>
	<form action="upPswdServlet" method="post">
			<input type="hidden" name="id" value="${id }">
			<input type="hidden" name="checkCode" value="${checkCode }">
			<div class="find1">
				<span style="font-size: 150%;margin-left: 40px;">新密码</span>
				<input type="text" name="password" style="width: 200px;height: 30px;"/><br />		
			</div>
			
			<div class="find2">
				<span style="font-size: 150%;margin-left: 40px;">确认密码</span>
				<input type="text" name="password2" style="width: 200px;height: 30px;"/><br />	
			</div>
			
			<input type="submit" name="subEmail" value="提交" style="font-size:120%;width:100px;height:40px;float: right; margin-right: 40px;margin-top: 20px;" /><br />
		</form>
</body>
</html>