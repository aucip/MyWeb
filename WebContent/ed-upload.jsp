<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.util.ArrayList" %>
    <%@page import="java.util.List" %>
    <jsp:useBean id="draft" scope="request" class="www.web1.javaBean.Draft"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="css/head.css" rel="stylesheet"/>
		<title id="sdf">上传短文</title>
		<script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
		<style>
			body {background:url("pic/灰色.jpg");width: 1300px;padding: 0;margin: 0;}
			ul.top {position:fixed;width:1350px;z-index:1;list-style-type: none;margin: 0;padding: 0;overflow: hidden;background-color: #333;}
			.top>li { float: left;}
			.top>li a {display: block; color: white; text-align: center; padding: 14px 16px; text-decoration: none;}
			.top>li a:hover:not(.active) {background-color: #111;}
			.active {background-color: #4CAF50;}
			.left {border-radius:5px;width:400px;height:580px; float: left;margin-top: 60px;margin-left: 20px; background:url("pic/灰圈.jpg");}
			.left1 {border-radius:5px;width: 120px;height: 500px;float: left;margin-left: 20px;margin-top: 10px;background-color:#B0B0B0;}
			.left2 {border-radius:5px;margin-right:25px;width: 220px;height: 500px;float: right;margin-top: 10px;background-color: #D1D1D1;}
			.index1 {width: 100px;height:20px;text-align: center;}
			.index1 p a:link{text-decoration: none;color: white;font-size: 20px;}
			.index1 p a:hover, a:after{background:	#DCDCDC;}
			.index2 {width: 100px;height:10px;text-align: center;}
			.index2 p a:link{text-decoration: none;color: black;font-size: 20px;}
			.index2 p a:hover, a:after{background:	#DCDCDC;}
			.right {border-radius:5px;width:850px;height:580px;margin-top: 60px; float:right;background:url("pic/灰圈.jpg");}
			.right1 {margin-left: 40px;margin-top: 20px;}
			.right2 {margin-left: 40px;margin-top: 10px;}
			#headline {background: #DCDCDC; display: block;padding: 5px;text-align: center;width: inherit;}
		</style>
		<title>上传短文</title>
	</head>

	<body>

		<%@include file="ed-head.jsp"%>
		<div class="left">
			<div style="margin-left: 40px;margin-top: 20px;">
				<span style="font-size: 150%;">草稿：</span>
			</div>
			
			<div class="left2">
				<div class="index2">
				<c:forEach items="${drafts }" var="d" varStatus="c">
					<p><a href="?pid=${d.getPid() }">${d.getHeadline() }</a></p>
				</c:forEach>
				</div>
			</div>
		</div>
		
		<div class="right">

			<form action="saveDraft" method="post" class="right2" id="draftForm">
				<input name="pid" type="hidden" value="${draft.getPid() }"/>
				<input name="ID" type="hidden" value="${draft.getID() }"/>
				<div class="right1">
					<span style="font-size: 150%;">题目：</span>
					<input name="theme" type="text" value="${draft.getHeadline()  }" />
				</div>
				<textarea id="con" name="comCon" rows="30" cols="100" wrap="physical" >${draft.getContent()  }</textarea>
				<script type="text/javascript">
					function submitD(){  
			         	document.getElementById("draftForm").action = "submitDraft";  
			         	document.getElementById("draftForm").submit();  
			     	} 
					function saveD(){
						document.getElementById("draftForm").action = "saveDraft";  
			         	document.getElementById("draftForm").submit();  
					}
				</script>
				<select name="type" >
					<option value="小说">小说</option>
					<option value="随笔">随笔</option>
					<option value="散文">散文</option>
					<option value="作文">作文</option>
					<option value="日记">日记</option>
					<option value="知识">知识</option>
				</select>
				<input name="submit" type="submit" value="上传" onclick="submitD()"/>
				<input name="submit" type="submit" value="保存" onclick="saveD()"/>
			</form>
		</div>
	</body>

</html>