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
<link rel="stylesheet" href="css/tinyscrollbar.css" type="text/css"/>
<script type="text/javascript" src="js/angular.min.js"></script>
<script type="text/javascript" src="js/Turntable2.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/henryLIB.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/tinyscrollbar.js"></script>
<style type="text/css">
  #myModal {
     width: 90%;
     margin-left: 0%;
     left:5%;
  }
  
  .clear {clear:both;}
  .item-is {padding: 10px;border-bottom:1px solid #efe4e4;}
  .item-name {width: 25%;float: left}
  .item-content {width: 75%;float: left;}

</style>
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
    

            //var user =  ${user};
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
                   $('#myModal').modal({keyboard: true});
               var scrollbar = tinyscrollbar(document.getElementById("scrollbar1"),{thumbSize:10,trackSize:150,thumbSizeMin:20});


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
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  开始演示模态框
</button>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" 
            aria-hidden="true">×
        </button>
        <h4 class="modal-title" id="myModalLabel">
          模态框（Modal）标题
        </h4>
      </div>
      <div class="modal-body">

        <div id="scrollbar1">
            <div class="scrollbar"><div class="track"><div class="thumb"><div class="end"></div></div></div></div>
            <div class="viewport" style="background: #ff8a44;height:150px">
                 <div class="overview" id="notice" >
                     <div class="item-is">
                       <div class="item-name">真实姓名</div>
                       <div class="item-content"><input  class="edit" placeholder="点击输入" name="mileage" type="text"  required/></div>
                       <div class="clear"></div>
                     </div>
                      <div class="item-is">
                      <div class="item-name">课程评分</div>
                       <div class="item-content"><input  class="edit" placeholder="点击输入" name="mileage" type="text"  required/></div>
                        <div class="clear"></div>
                     </div>
                     <div class="item-is">
                      <div class="item-name">体验感评分</div>
                       <div class="item-content"><input  class="edit" placeholder="点击输入" name="mileage" type="text"  required/></div>
                        <div class="clear"></div>
                     </div>
                     <div class="item-is">
                      <div class="item-name">服务评分</div>
                       <div class="item-content"><input  class="edit" placeholder="点击输入" name="mileage" type="text"  required/></div>
                        <div class="clear"></div>
                     </div>
                      <div class="item-is">

                      <div class="item-name">卫生评分</div>
                       <div class="item-content"><input  class="edit" placeholder="点击输入" name="mileage" type="text"  required/></div>
                        <div class="clear"></div>
                     </div>
                      <div class="item-is">
                        <div class="item-name">半铺园印象</div>
                       <div class="item-content"><input  class="edit" placeholder="点击输入" name="mileage" type="text"  required/></div>
                        <div class="clear"></div>
                     </div>
                 </div>
            </div>
            </div>




      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" 
            data-dismiss="modal">关闭
        </button>
        <button type="button" class="btn btn-primary">
          提交更改
        </button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div>
</body>
</html>
                               
