<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>   
<%                                       
String path = request.getContextPath();  
String server = request.getServerName();
%>                                       
<!doctype html>
<html ng-app="Index">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,user-scalable=no"/>
<meta name="format-detection" content="telephone=no, email=no"/>
<title>摇奖</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link href="css/css_mobile.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/tinyscrollbar.css" type="text/css"/>
<script type="text/javascript" src="js/jquery.min.js"></script>
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
 <script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
 <link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
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
  .item-name {width: 25%;float: left;height: 28px;line-height: 28px}
  .item-content {width: 70%;float: left;}
  input.edit {margin-bottom: 0px;}
  .bottom-menu {height: 40px;width: 100%;position: fixed;bottom: 0px}
  .bottom-menu p {width: 33.33%;float: left;background:#ffd61a;height: 100%;text-align: center;
    line-height: 40px;}
  .bottom-menu p.current a{color: #f16100}
    .bottom-menu p a{color: black;font-size: 12px}
</style>
<script type="text/javascript">
          function getPath(){
          return '<%=server%>';
        }  

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
                 var ds = ${opendialog};
                 if(ds==1){
                   $('#myModal').modal({keyboard: true});
                 }
                var scrollbar = tinyscrollbar(document.getElementById("scrollbar1"),{thumbSize:10,trackSize:150,thumbSizeMin:20});

            }

          function initPosition(){
            var a = document.getElementById("ban");
            var width = getStyle(a,"width");
       
            var b =parseInt(width)-300;
            document.getElementById("a_g").style.marginLeft=b/2+"px";
          }




 var isCommit=false 
  function save(){                                 
        if(isCommit==false){   
         isCommit=true       
                 $.ajax({
          type:"post",
          url:"<%=path%>/Wechat!commentsubmit.action",
          data:"commentbean.userid="+parseInt($(":input[name='commentbean.userid']").val())
          + "&commentbean.realname="+$(":input[name='commentbean.realname']").val()
          + "&commentbean.casepoint="+$(":input[name='commentbean.casepoint']").val()
          + "&commentbean.feelpoint="+$(":input[name='commentbean.feelpoint']").val()
          + "&commentbean.servicepoint="+$(":input[name='commentbean.servicepoint']").val()
          + "&commentbean.healthpoint="+$(":input[name='commentbean.healthpoint']").val()
          + "&commentbean.impress="+$(":input[name='commentbean.impress']").val()    
          ,
          success:function(data){
          var response=eval("("+data+")");
             console.log(response);
              $('#myModal').modal('hide');
             if(response.errcode==840007){
                     $( "#dialog-success" ).dialog( "open" ); 
             }else{
                     $( "#dialog-fail" ).dialog( "open" ); 
             }
          }
          });                     
      }                 
                                     
  }  

    </script>


</head>
<body style="background:#ffed5d;" ng-controller="IndexController as Index">
<div class="body">
  <!-- <div class="guangao"><img src="images/zhuanzhuan_01.png"  alt=""/></div> -->
  <div class="logo"><img src="images/left_02.png" style="width:50px;float: left;"><img src="images/logo_02.png"  style="width:200px;" alt=""/><img src="images/right_02.png" style="width:50px;float: right;">
  </div>
  <!--<div style="overflow-x:hidden;">--> 
    <div class="banner" id="ban">

        <canvas class="item" id="a_g" width="300" height="300" ng-click="Index.test()"></canvas>

  </div>
  <div class="zhongjian"><img src="images/zhongj.png" style="    width: 136px;" alt=""/><marquee    scrollamount="3"  direction="up"  class="imgRadius2_title">
    <p style="width:100%" ng-repeat="map in Index.userlist">{{map.uname}}&nbsp;&nbsp;{{map.phone | phoneFilter}}&nbsp;&nbsp;&nbsp;恭喜获得{{map.money}}元</p>
    </marquee > </div>
<!--   <div class="guangao1"><img src="images/zhuanzhuan_11.png"  alt=""/></div> -->
<!--</div>-->
<button class="btn btn-primary btn-lg" ng-click="Index.myAlert()">
  开始演示模态框
</button>
<!-- 模态框（Modal） -->
 <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <input type="hidden" name="commentbean.userid" value="${user.id}" />
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" 
            aria-hidden="true">×
        </button>
        <h4 class="modal-title" id="myModalLabel">
          请写下你对半铺园的印象
        </h4>
      </div>
      <div class="modal-body">

        <div id="scrollbar1">
            <div class="scrollbar"><div class="track"><div class="thumb"><div class="end"></div></div></div></div>
            <div class="viewport" style="height:150px">
                 <div class="overview" id="notice" >
                     <div class="item-is">
                       <div class="item-name">真实姓名</div>
                       <div class="item-content"><input  class="edit" placeholder="点击输入" name="commentbean.realname" type="text"  required/></div>
                       <div class="clear"></div>
                     </div>
                      <div class="item-is">
                      <div class="item-name">课程评分</div>
                       <div class="item-content"><input  class="edit" placeholder="点击输入" name="commentbean.casepoint" type="number"  required/></div>
                        <div class="clear"></div>
                     </div>
                     <div class="item-is">
                      <div class="item-name">体验感评分</div>
                       <div class="item-content"><input  class="edit" placeholder="点击输入" name="commentbean.feelpoint" type="number"  required/></div>
                        <div class="clear"></div>
                     </div>
                     <div class="item-is">
                      <div class="item-name">服务评分</div>
                       <div class="item-content"><input  class="edit" placeholder="点击输入" name="commentbean.servicepoint" type="number"  required/></div>
                        <div class="clear"></div>
                     </div>
                      <div class="item-is">

                      <div class="item-name">卫生评分</div>
                       <div class="item-content"><input  class="edit" placeholder="点击输入" name="commentbean.healthpoint" type="number"  required/></div>
                        <div class="clear"></div>
                     </div>
                      <div class="item-is">
                        <div class="item-name">半铺园印象</div>
                       <div class="item-content"><input  class="edit" placeholder="点击输入" name="commentbean.impress" type="text"  required/></div>
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
        <button type="button" class="btn btn-primary" onclick="save();">
          提交
        </button>
      </div>
    </div>
</div> 

<div class="bottom-menu"><p class="current"><a>抽奖</a></p><p><a href="<%=path%>/Wechat!mine.action">我的</a></p><p><a>说明</a></p></div>
<div id="dialog-success" title="提示">
  <p>评论成功</p>
</div>

<div id="dialog-fail" title="提示">
  <p>评论失败</p>
</div>

</body>
</html>
                               
