<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="www.web1.javaBean.*" %>
<%@page import="www.web1.dataDAO.*" %>
<%@page import="www.web1.utils.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/head.css" rel="stylesheet"/>
<style>
	body{background-image: url("pic/白光背景.jpg");width: 1300px;padding: 0;margin: 0;}
	ul.top {position:fixed;width:1334px;list-style-type: none;margin: 0;padding: 0;overflow: hidden;background-color: #333;}
	.top> li { float: left;}
	 .top>li a {display: block; color: white; text-align: center; padding: 14px 16px; text-decoration: none;}
	 .top>li a:hover:not(.active) {background-color: #111;}
	.active {background-color: #4CAF50;}
	.left{border-radius:5px;margin-top:50px;margin-left:75px;margin-right:20px;float:left;width: 800px;background-color: white;}
	.index{float: left;padding: 0px;padding-left: 150px;padding-bottom:20px;margin:0 auto;width: 650px;height:49px;list-style-type: none;background-image: url("pic/蓝色白砖.jpg");}
	.index li{float: left;margin-left: 20px;}
	.index li a:link{border:white;display: block;text-align: center;text-decoration: none;padding: 4px;color: black;font-size: 30px;}
	.index li a:hover, a:after{background:	#5CACEE;border-bottom-left-radius: 10px;border-bottom-right-radius: 10px;}
	article{border-top: solid salmon;margin-top: 50px;}
	.articleArea{border-bottom: solid 	#9AC0CD 2px;border-top: solid 	#9AC0CD 2px;}
	.articleArea:hover{background: 	#ADD8E6;}
	.articleArea h3{text-align: center;}
	.articleArea >a{display:block;width:inherit;padding-left: 450px;}
	.articleArea p{padding-left: 250px;}
	.articleArea span{display:block;text-align: center;}
	form input{float: right;}
	form span{float: right;margin-top: 3px;}
	#btn{border: none;font-size: 16px;}
	.right{border-radius:5px;margin-top:50px;float:right;width: 400px;background-image: url("pic/彩花2.jpg");}
	.right> span{display: block;text-align: center;}
	.dynamic{margin-bottom:20px;width: inherit;height: 200px;overflow-y: scroll;background-image: url("pic/白板.jpg");}
</style>
<title>短文网</title>
</head>
<body>
	<%@include file="head.jsp" %>
	<%
	int begin;
	int length = 2; //将要获取的文章数
	int size = 0;//获取得到的文章数
	if(request.getParameter("begin") == null){
		begin = 0;
		length =2;
	}else{
		begin = Integer.valueOf(request.getParameter("begin"));
		length =2;
	}
	if(request.getParameter("pageNum") != null){
		begin = Integer.valueOf(request.getParameter("pageNum"));
		length =2;
	}
	EssayDAO essayDAO = new EssayDAO();
	List<Eassy> essays = new ArrayList<Eassy>();
	essays = essayDAO.list2(begin, begin+length);
	Eassy essay = new Eassy();
	if(essays.size() < 2){
		size = essays.size();
	}else{
		size = length;
	}
	session.setAttribute("begin", begin);
	session.setAttribute("size", size);
	int temp = 0;
%>
	<div class="left">
		<ul class="index">
			<li><a href="#">小说</a></li>
			<li><a href="#">随笔</a></li>
			<li><a href="#">散文</a></li>
			<li><a href="#">作文</a></li>
			<li><a href="#">日记</a></li>
			<li><a href="#">知识</a></li>
		</ul>
		<article>
			<c:if test="${size != 0}">
				<c:forEach begin="0" end="${size-1 }" step="1">
					<%essay = essays.get(temp); %>
				<div class="articleArea">
					<h3><%=essay.getHeadline()%></h3>
				 	<a href="#"><%=essay.getID()%></a>
					<p><%=essay.getContent().substring(0, 3) %>...<a href="content.jsp?title=<%=BaseUtils.Encoder(essay.getHeadline())%>&authorID=<%=essay.getID()%>">详情</a></p>
				<div style="background-color:white;border-radius:5px;width: 800px;height:35px;">
						<img src="pic/转发.png" style="float: right;"/>
						<img src="pic/评论.png" style="float: right;"/>
						<img src="pic/点赞.png" style="float: right;"/>
					</div>
				</div>
				<%temp++; %> 
				</c:forEach>
			</c:if>
		</article>
		<form action="index.jsp" method="get" >
			<a href="index.jsp?begin=<%= begin-length %>">上一页</a>
			<a href="index.jsp?begin=<%= begin+length %>">下一页</a>
			<input id="btn" type="submit" name="turnPage" value="确定"/>
			<input type="text" name="pageNum"/>
			<span>跳转到</span>
		</form>
	</div>
	<div class="right">
		<div class="dynamic">
			<h3>关注动态</h3>
			<span>你关注的<a href="#">莎士比亚</a>发布了小说短文<a href="#">哈姆雷特短篇版</a></span><br />
			<span>时间:2016-07-01 21:15</span><br />
			<span>你关注的<a href="#">莎士比亚</a>发布了小说短文<a href="#">哈姆雷特短篇版</a></span><br />
			<span>时间:2016-07-01 21:12</span><br />
			<span>你关注的<a href="#">莎士比亚</a>发布了小说短文<a href="#">哈姆雷特短篇版</a></span><br />
			<span>时间:2016-07-01 21:12</span><br />
			<span>你关注的<a href="#">莎士比亚</a>发布了小说短文<a href="#">哈姆雷特短篇版</a></span><br />
			<span>时间:2016-07-01 21:12</span><br />
			<span>你关注的<a href="#">莎士比亚</a>发布了小说短文<a href="#">哈姆雷特短篇版</a></span><br />
			<span>时间:2016-07-01 21:12</span><br />
		</div>
		<span>热门排行</span>
		<ol class="rankings">
			<li><a href="#">哈姆雷特</a></li>
			<li><a href="#">装在套子里的人</a></li>
			<li><a href="#">我的大学</a></li>
			<li><a href="#">最后的生还者</a></li>
			<li><a href="#">陈年旧事</a></li>
			<li><a href="#">项链</a></li>
		</ol>
		<span>点赞最多</span>
		<ol class="rankings">
			<li><a href="#">哈姆雷特</a></li>
			<li><a href="#">装在套子里的人</a></li>
			<li><a href="#">我的大学</a></li>
			<li><a href="#">最后的生还者</a></li>
			<li><a href="#">陈年旧事</a></li>
			<li><a href="#">项链</a></li>
		</ol>
		<span>评论最多</span>
		<ol class="rankings">
			<li><a href="#">哈姆雷特</a></li>
			<li><a href="#">装在套子里的人</a></li>
			<li><a href="#">我的大学</a></li>
			<li><a href="#">最后的生还者</a></li>
			<li><a href="#">陈年旧事</a></li>
			<li><a href="#">项链</a></li>
		</ol>
	</div>
</body>
</html>