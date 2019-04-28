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
        	.pic1{background: url(${user.getPathOfBg() });width: inherit; height: 300px;}
        	.pic1 form{width: 100px; height: 100px;margin-top: 50px}
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
	<%@include file="ed-head.jsp"%>
    	<div class="pic1">
    		<form id="subPic" action="#" method="post" enctype="multipart/form-data">
    			<img id="pic2" src="${user.getPathOfHead() }" width="80px" height="80px"/>
    			<input type="file" name="file"/>
    			<script type="text/javascript">
					function subHeadPic(){  
			         	document.getElementById("subPic").action = "subHeadPic";  
			         	document.getElementById("subPic").submit();  
			     	} 
					function subBgPic(){
						document.getElementById("subPic").action = "subBgPic";  
			         	document.getElementById("subPic").submit();  
					}
				</script>
    			<input type="submit" value="上传头像" onclick="subHeadPic()">
    			<input type="submit" value="上传背景" onclick="subBgPic()">
    		</form>
    		<span class="name">${user.getNickname() }</span>
    		<div id="faction1">
    			<span>粉丝：5</span><span>关注：6</span>
    		</div>
    	</div>
    	
    <div class="left">
    		<div class="left1">
				<h3>我发表的文章</h3>
    		</div>
    		
			<c:forEach items="${essays}" var="c" varStatus="st">
				<div class="left2">
					<h3>${c.getHeadline()}</h3>
				 	<!-- <a href="#">${c.getID()}</a> -->
					<p>${c.getContent().substring(0, 3)}...<a href="ed-content?pid=${c.getPid()}">详情</a> <a href="ed-content?pid=${c.getPid()}">修改</a></p>
				</div>
			</c:forEach>
			<a href="?start=${page.start-page.count}">上一页</a>
			<a href="?start=${page.start+page.count}">下一页</a>
			<input id="btn" type="submit" name="turnPage" value="确定"/>
			<input type="text" name="" id="page_id" value="" style="width:40px;">
			<input type="button" value="跳转" onclick="javascript:var po =document.getElementById('page_id');if(po.value=='') return false;window.location='?start='+po.value*5 " id="pageGo"/>
			<span>共${total }页</span>
    		
    	</div>
    	
    	<div class="right">
    		<h3 style="float: right;margin-right: 20px;">修改资料</h3>
    		<div class="right1">
    			<h3>个人资料</h3>
    		</div>
    		
    		<div class="right2">
    			<span class="person">${user.getAge() }岁</span> 
    			<span class="person">职业:${user.getProfession() }</span>
    			<span class="person">爱好:${user.getHabby() }</span><br />
    			<span class="person">email：${user.getEmail() } </span><br />
    			
    			<h3 style="color:	#006400;margin-left: 20px;">座右铭:</h3>
    				<h3 style="color:#008B00;margin-left: 50px;">${user.getAutograph() }</h3>
    		
    		</div>
    	</div>
    
    </div>
    

</body>
</html>