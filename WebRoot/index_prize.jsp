<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ include file="/common/taglibs.jsp" %>  
<%                                       
String path = request.getContextPath();  
%>                                       
<!doctype html>
<html ng-app="Index">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,user-scalable=no"/>
<title>摇奖</title>
<link href="css/css_mobile.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="js/angular.min.js"></script>
<script type="text/javascript" src="js/Turntable2.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/henryLIB.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</head>
<body style="background:#ffed5d;" ng-controller="IndexController as Index">
<div class="body">
  <!-- <div class="guangao"><img src="images/zhuanzhuan_01.png"  alt=""/></div> -->
  <div class="logo"><img src="images/left_02.png" style="width:50px;float: left;"><img src="images/logo_02.png"  style="width:200px;" alt=""/><img src="images/right_02.png" style="width:50px;float: right;">
  </div>
  <!--<div style="overflow-x:hidden;">--> 
    <div class="banner" id="ban">

        <canvas class="item" id="a_g" width="300" height="300" ng-click="Index.test()"></canvas>
              <script type="text/javascript">
            var user =  ${user};
            window.onload = function() {
                /**
                 * 说明
                 *
                 * 请求服务器获取奖项一共有多少种，背景图，栏目图，指针图指向服务器地址
                 * 以上内容可以写死，后期需要设置的不能
                 * 当点击时，让转盘开始转动，同时向服务器请求抽奖
                 * 当服务器返回数据，设置转盘最终的结果
                 *
                 */


            }

          function initPosition(){
          	var a = document.getElementById("ban");
          	var width = getStyle(a,"width");
       
          	var b =parseInt(width)-300;
            document.getElementById("a_g").style.marginLeft=b/2+"px";
          }
            </script>
  </div>
  <div class="zhongjian"><img src="images/zhongj.png" style="    width: 136px;" alt=""/><marquee    scrollamount="3"  direction="up"  class="imgRadius2_title">
    <p ng-repeat="map in Index.userlist">{{map.uname}}&nbsp;&nbsp;&nbsp;{{map.phone | phoneFilter}}&nbsp;&nbsp;&nbsp;恭喜获得{{map.money}}元</p>
    </marquee > </div>
<!--   <div class="guangao1"><img src="images/zhuanzhuan_11.png"  alt=""/></div> -->
<!--</div>-->
</body>
</html>
                               
