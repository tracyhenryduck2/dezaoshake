var url="";
var model;
var request;
var Index;
var t;


(function(){
  var app=angular.module('Index',[ ]);

      app.config(function($httpProvider) {
        $httpProvider.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
        $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
        
    // Override $http service's default transformRequest
    $httpProvider.defaults.transformRequest = [function(data) {
        /**
         * The workhorse; converts an object to x-www-form-urlencoded serialization.
         * @param {Object} obj
         * @return {String}
         */
         var param = function(obj) {
            var query = '';
            var name, value, fullSubName, subName, subValue, innerObj, i;
            
            for (name in obj) {
                value = obj[name];
                
                if (value instanceof Array) {
                    for (i = 0; i < value.length; ++i) {
                        subValue = value[i];
                        fullSubName = name + '[' + i + ']';
                        innerObj = {};
                        innerObj[fullSubName] = subValue;
                        query += param(innerObj) + '&';
                    }
                } else if (value instanceof Object) {
                    for (subName in value) {
                        subValue = value[subName];
                        fullSubName = name + '[' + subName + ']';
                        innerObj = {};
                        innerObj[fullSubName] = subValue;
                        query += param(innerObj) + '&';
                    }
                } else if (value !== undefined && value !== null) {
                    query += encodeURIComponent(name) + '='
                    + encodeURIComponent(value) + '&';
                }
            }
            
            return query.length ? query.substr(0, query.length - 1) : query;
        };
        
        return angular.isObject(data) && String(data) !== '[object File]'
        ? param(data)
        : data;
    }];
});

 app.filter("phoneFilter",function(){
                return function(input){
                     var out = "";
                    var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
                    if(input==null || !myreg.test(input))
                    {
                      out = "";
                    }
                    else
                    {
                      out = (input.substring(0,7)+'****');
                    }

                    return out;
                }
            });

  app.controller('IndexController',['$http','$window','$scope',function($http,$window,$scope){
    Index=this;
    model=Index;
    request=$http;
    Index.ads = true;
    Index.userlist=[{uname:"张三",phone:"13136369541",money:"123456"}];
    var c = document.getElementById("a_g");
                Index.prizelist =('一等奖,二等奖,三等奖,谢谢').split(",");
                t = new Turntable({
                        "canvas"    : c, 
                        "padding"   :18, 
                        "background": "./images/Background.png", 
                        "foreground": "./images/Foreground.png", 
                        "p"         : "./images/P.png", 
                        "items"     : Index.prizelist,
                        "speed"     : 0.2
                    });


 
              
                // c.onclick = function() {
                //     if (t.exec()) {
                //         k=parseInt(Math.random() * a.length);
                //         t.resp(k, undefined, function() {alert(a[k]);});
                //     }
                // }

                 
    initPosition();


    Index.loadprizelist=function(){

      request.post('http://'+url+'/shake_bill/app/ShakeBill!getPriceList.action').success(function(data){
        //alert(JSON.stringify(data));
       if(data.errcode==110) {
                Index.prizelist =(data.result+'谢谢').split(",");
                t = new Turntable({
                        "canvas"    : c, 
                        "padding"   :18, 
                        "background": "./images/Background.png", 
                        "foreground": "./images/Foreground.png", 
                        "p"         : "./images/P.png", 
                        "items"     : Index.prizelist,
                        "speed"     : 0.2
                    });
       } 



        }).error(function(data,status,headers,config){
         if((status>=200&&status<300)||status===304||status===1223||status===0){
         MyAlert("网络连接失败");
         }
         });
  }

Index.test=function(){
 
  var timesleft=null;
  var obj=null;
     if(Index.goingflag==true) return;  //防止转盘转动时多次抽奖的BUG

  
     // if(info==null || info=='')
     // {
     //     if(first==null || first=='')
     //     {
                    if (t.exec()) {
                        var indexprize =  getIndex(Index.prizelist,'5元');
                        console.log(indexprize);
                         t.resp(indexprize, undefined, function() {MyAlert("恭喜您抽到5元电话费,请注册并登陆领取！","gotoResgiter()"); });
                     }
     //     }

 
     // }
     // else
     // {
     //  creatMask();
     //      $http.post('http://'+url+'/shake_bill/app/ShakeBill!getPrize.action').success(function(data){
     //         removeMask();

     //        if(data.errcode==109)  //中奖
     //        {     
     //                      if (t.exec()) {
     //                      Index.goingflag=true;
     //                      var indexprize =  getIndex(Index.prizelist,data.prize.name);
     //                     t.resp(indexprize, undefined, function() {
     //                       Index.goingflag=false;
     //                      var dsa = "";
     //                      if(timesleft>1) dsa = "今天还可以再赚"+(timesleft-1)+"次！赶快试试运气吧！" 
     //                      else            dsa = "今天没有抽奖次数了，明天还可以拿两次话费哦!";                               
     //                      MyAlert("恭喜您抽到 "+data.prize.name.toString()+"电话费,"+dsa);
     //                                var dsa = client.readGlobalInfo("username");
     //                               var dsa2 = client.readGlobalInfo("password");  
     //                               Index.login2(dsa,dsa2);
                         
     //                      });
     //                 }
     //        }
     //        else if(data.errcode==108)  //未中奖
     //        {
     //                      if (t.exec()) {  
     //                      Index.goingflag=true;                          
     //                     t.resp(Index.prizelist.length-1, undefined, function() {
     //                      Index.goingflag=false;
     //                      var dsa = "";
     //                      if(timesleft>1) dsa = ",今天还可以再赚"+(timesleft-1)+"次！赶快试试运气吧！" 
     //                      else            dsa = ",今天没有抽奖次数了，明天还可以拿两次话费哦!"; 
     //                               MyAlert(data.errmsg.toString()+dsa);
     //                                var dsa = client.readGlobalInfo("username");
     //                               var dsa2 = client.readGlobalInfo("password");  
     //                               Index.login2(dsa,dsa2);
 
     //                      });
     //                 }
     //        }
     //        else if(data.errcode==111)
     //        {
     //           MyAlert(data.errmsg.toString()+"，明天还可以拿两次话费哦!"); 
     //        }
     //      }).error(function(data,status,headers,config){
     //         removeMask();
     //       if((status>=200&&status<300)||status===304||status===1223||status===0){
     //        MyAlert("网络连接失败");
     //       }
     //       });
     // }
     


}



  }]);
})();



function getIndex(list,prize){
   
    for(var i=0;i<list.length;i++)
    {
      if(list[i].toString() ==prize.toString())
      {
        return i;
      }
    }
    return null;
}