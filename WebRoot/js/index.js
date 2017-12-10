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
    

    $( "#dialog-success" ).dialog({
      autoOpen: false,
      modal:true,
           buttons: {
       "确定": function() {
         $( this ).dialog( "close" );
       }
     }
    });
 
     $( "#dialog-fail" ).dialog({
      autoOpen: false,
      modal:true,
           buttons: {
       "确定": function() {
         $( this ).dialog( "close" );
       }
     }
    });


    Index.ads = false;
    Index.userlist=[{uname:"张三",phone:"13136369541",money:"123456"}];
    var c = document.getElementById("a_g");
                // Index.prizelist =('一等奖,二等奖,三等奖,谢谢').split(",");
                // t = new Turntable({
                //         "canvas"    : c, 
                //         "padding"   :18, 
                //         "background": "./images/Background.png", 
                //         "foreground": "./images/Foreground.png", 
                //         "p"         : "./images/P.png", 
                //         "items"     : Index.prizelist,
                //         "speed"     : 0.2
                //     });


 
              
                // c.onclick = function() {
                //     if (t.exec()) {
                //         k=parseInt(Math.random() * a.length);
                //         t.resp(k, undefined, function() {alert(a[k]);});
                //     }
                // }

                 
    initPosition();


    Index.loadprizelist=function(){
    creatMask();
      request.post('http://'+getPath()+'/dezaoshake/Wechat!getPrizeList.action').success(function(data){
        //alert(JSON.stringify(data));
       if(data.errcode==8200000) {
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

removeMask();

        }).error(function(data,status,headers,config){
         if((status>=200&&status<300)||status===304||status===1223||status===0){
           
         }
         });
  }

Index.test=function(){
 
   if(Index.ads == true) return;
    Index.ads = true;
      creatMask();
          $http.post('http://'+getPath()+'/dezaoshake/Wechat!getPrize.action?id='+user.id).success(function(data){
             removeMask();
             console.log(data);
            if(data.errcode==8400005)  //中奖
            {     
                          if (t.exec()) {
                          var indexprize =  getIndex(Index.prizelist,data.name);
                         t.resp(indexprize, undefined, function() {
                        
                          alert("恭喜您,"+data.name+",您还有"+(data.timeleft-1)+"次机会!");
                          Index.ads = false;
                          });
                     }
            }
            else if(data.errcode==8400001)  //未中奖
            {
                          if (t.exec()) {                            
                         t.resp(Index.prizelist.length-1, undefined, function() {

                          alert(data.errmsg.toString()+",您还有"+(data.timeleft-1)+"次机会!");
                          Index.ads = false;
                          });
                     }
            }
            else 
            {
               alert(data.errmsg); 
               Index.ads = false;
            }
          }).error(function(data,status,headers,config){
             removeMask();
           if((status>=200&&status<300)||status===304||status===1223||status===0){
            Index.ads = false;
           }
           });

     


}

Index.myAlert = function(){
$( "#dialog-success" ).dialog( "open" );
}


Index.loadprizelist();

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