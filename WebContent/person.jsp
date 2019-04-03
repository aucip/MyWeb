<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
        	
        	body{background-color: white;
        		width: inherit;overflow: hidden;overflow-x: auto;overflow-y: auto;white-space: nowrap;}
        	ul {position:fixed;width:1334px;z-index:1;list-style-type: none;margin: 0;padding: 0;overflow: hidden;background-color: #333;}
			li { float: left;}
			li a {display: block; color: white; text-align: center; padding: 14px 16px; text-decoration: none;}
			li a:hover:not(.active) {background-color: #111;}
			.active {background-color: #4CAF50;}
        	.pic1{background: url(../src/head1.jpg);width: inherit; height: 300px;}
        	#pic2{position: absolute;left: 650px;top: 120px;border: solid darkblue;border-radius: 50%}
        	.name{position: absolute;left: 650px;top: 210px;font-size: 150%;color: white;}
        	#faction1{position: absolute;left: 580px;top: 250px;}
        	#faction1 a:nth-child(1){padding:6px;text-decoration: none;margin-right: 5px;background: orangered;color: white;border-radius: 10%;display: block;float: left;}
        	#faction1 a:nth-child(2){padding:6px;text-decoration: none;margin-left: 5px;margin-right: 5px;background: grey;color: white;border-radius: 10%;display: block;float: left;}
        	#faction1 span{float:left;margin:2px;padding: 4px;border: dashed red;color: white;}
        	.left{border-radius:5px;margin-top:20px;float:left;width: 850px;height:700px;background-image: url("pic/白板.jpg");}
        	.left1{border-radius:5px;margin-top:20px;margin-left:20px;float:left;width: 800px;background-color: white;}
          	.left2{border-radius:5px;margin-top:20px;margin-left:20px;float:left;width: 800px;height:130px;background-image: url("pic/落叶.jpg");}
        	.left2> h3 {color: 	#8B8B83;}
        	.right{border-radius:5px;margin-top:20px;float:right;width: 450px;height:400px;background-image: url("pic/白板.jpg");}
        	.right1{border-radius:5px;margin-top:20px;margin-right:20px;float:right;width: 400px;background-color: white;}
        	.right2{border-radius:5px;margin-top:20px;margin-right:20px;float:right;width: 400px;height:180px;background-image: url("pic/绿色白色.jpg");background-size: 400px 300px;}
        	.changeBgd{position: absolute;left: 1200px;top:250px;text-decoration: none;background: inherit;color: white;border-radius: 10%;padding: 5px;}
      		.person{font-size: 120%;margin-left: 15px;color: #668B8B;}
        </style>
        <title>个人中心</title>
    </head>
    <body>
    	
    	<ul>
		  <li><a href="#">主页</a></li>
		  <li><a href="#">个人中心</a></li>

		  <li ><a href="#" >短文</a></li>
		  <li><a href="#">找回密码</a></li>
		  <li style="float:right"><a class="active" href="">登陆</a></li>
		</ul>
    	
    	<div class="pic1">
    		<a href="#"><img id="pic2" src="../src/title1.jpg" width="80px" height="80px"/></a>
    		<span class="name">刘力铭</span>
    		<div id="faction1">
    			<a href="#">关注</a><a href="#">私信</a>
    			<span>粉丝：5</span><span>关注：6</span>
    		</div>
 
    		<a class="changeBgd" href="#">更换背景</a>
    	</div>
    	
    <div class="left">
    		<div class="left1">
				<h3>最近动态</h3>
    		</div>
    		
    		<div class="left2">
    		<h3>一篇小说的题目</h3>
				<p>这篇小说开头的一点点...<a href="#">详情</a></p>
				
				<div style="background-color:white;border-radius:5px;width: 800px;height:35px;">
					<img src="../src/转发.png" style="float: right;"/>
					<img src="../src/评论.png" style="float: right;"/>
					<img src="../src/点赞.png" style="float: right;"/>
				</div>
    		</div>
    		
    		<div class="left2">
    		<h3>一篇小说的题目</h3>
				<p>这篇小说开头的一点点...<a href="#">详情</a></p>
				<div style="background-color:white;border-radius:5px;width: 800px;height:35px;">
					<img src="../src/转发.png" style="float: right;"/>
					<img src="../src/评论.png" style="float: right;"/>
					<img src="../src/点赞.png" style="float: right;"/>
				</div>
    		</div>
    		
    		<div class="left2">
    		<h3>一篇小说的题目</h3>
				<p>这篇小说开头的一点点...<a href="#">详情</a></p>
				<div style="background-color:white;border-radius:5px;width: 800px;height:35px;">
					<img src="../src/转发.png" style="float: right;"/>
					<img src="../src/评论.png" style="float: right;"/>
					<img src="../src/点赞.png" style="float: right;"/>
				</div>
    		</div>
    		
    		<div class="left2">
    		<h3>一篇小说的题目</h3>
				<p>这篇小说开头的一点点...<a href="#">详情</a></p>
				<div style="background-color:white;border-radius:5px;width: 800px;height:35px;">
					<img src="../src/转发.png" style="float: right;"/>
					<img src="../src/评论.png" style="float: right;"/>
					<img src="../src/点赞.png" style="float: right;"/>
				</div>
    		</div>
    		
    		
    	</div>
    	
    	<div class="right">
    		<h3 style="float: right;margin-right: 20px;">修改资料</h3>
    		<div class="right1">
    			<h3>个人资料</h3>
    		</div>
    		
    		<div class="right2">
    			<span class="person">19岁</span> 
    			<span class="person">摩羯座</span>
    			<span class="person">属虎</span><br />
    			<span class="person">  四川    广安   岳池县 </span><br />
    			
    			<h3 style="color:	#006400;margin-left: 20px;">座右铭:</h3>
    				<h3 style="color:#008B00;margin-left: 50px;">世事漫随流水，算来一梦浮生</h3>
    		
    		</div>
    	</div>
    
    </div>
    

</body>
</html>