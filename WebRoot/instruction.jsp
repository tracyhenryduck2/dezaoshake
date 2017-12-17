<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"  %>
<%@ taglib uri="/gdk-tags" prefix="GF"%>   
<%                                       
String path = request.getContextPath();  
%>                                       
<!doctype html>
<html ng-app="Index">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,user-scalable=no"/>
<meta name="format-detection" content="telephone=no, email=no"/>
<title>说明</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link href="css/css_mobile.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
 <link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
 <script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/angular.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/henryLIB.js"></script>
<style type="text/css">
  .bottom-menu {height: 40px;width: 100%;position: fixed;bottom: 0px}
  .bottom-menu p {width: 33.33%;float: left;background:#ffd61a;height: 100%;text-align: center;
    line-height: 40px;}
    .bottom-menu p.current a{color: #f16100}
    .bottom-menu p a{color: black;font-size: 12px}
</style>


</head>
<body style="background:#ffed5d;" ng-controller="IndexController as Index">
<div class="body">
  <!-- <div class="guangao"><img src="images/zhuanzhuan_01.png"  alt=""/></div> -->
  <div class="logo"><img src="images/left_02.png" style="width:50px;float: left;"><img src="images/logo_02.png"  style="width:200px;" alt=""/><img src="images/right_02.png" style="width:50px;float: right;">

  <img src="images/dezaocode.JPG" style="width: 200px;height: 250px;margin-top: 25px;" />
  
  </div>

<div class="bottom-menu"><p><a href="<%=path%>/Wechat!play.action">抽奖</a></p><p ><a href="<%=path%>/Wechat!prizeList.action">我的</a></p><p class="current"><a>说明</a></p></div>
</body>
</html>
                               
