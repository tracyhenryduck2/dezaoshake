<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ include file="/common/taglibs.jsp" %>  
<%                                       
String path = request.getContextPath();  
%>                                       
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>                                   
<title></title>                          
<script type="text/javascript">        
 var isCommit=false 
	function save(){                        
		if($("#form1").valid()) {           
        if(isCommit==false){   
         isCommit=true       
			form1.submit();                     
      }                 
		}                                     
	}                                       
	                                        
	function result(messageType, message){  
		if(messageType=="error"){           
			Dialog.error(message);				      
		} else if (messageType == "reload_success") {   
			Dialog.alert(message,function(){    
				Dialog.opener().location.reload(); //;= "<%=path%>/system/Member!list.action";   
				parentDialog.close();             
			});                                 
		} else if(messageType == "exception") { 
			                                    
		}                                     
	}                                       
	                                        
	$(function(){                           
		/* form1表单进行验证 */               
		$("#form1").validate({              
			rules:{                             
			    "memberBean.nickname":{            
			        CNRangeLength:[0,255]
			    },                              
			    "memberBean.province":{            
			        CNRangeLength:[0,255]
			    },                              
			    "memberBean.city":{            
			        CNRangeLength:[0,255]
			    },                              
			    "memberBean.headimgurl":{            
			        CNRangeLength:[0,255]
			    },                              
			    "memberBean.openid":{            
			        CNRangeLength:[0,255]
			    }                              
			},                                  
			messages:{                          
//			    "memberBean.code":{          
//				    required : "",CNRangeLength:""  
//			    },                            
			}                                   
		});                                   
	});                                     
	                                        
	                                        
</script>                                
</head>                                  
<body>                                   
<form name="form1" id="form1" action="<%=path %>/system/Member!addMember.action" method="post" target="fram" >   
<input type="hidden" name="oper" value="${oper}" />
<input type="hidden" name="memberBean.id" id="id" value="${memberBean.id }"/>  
<table cellpadding="0" cellspacing="0" width="100%" class="GF-grid"> 
  <tr>                                    
    	<td align="right" width="30%" > 
                            用户名<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="memberBean.nickname" id="nickname"  value="${memberBean.nickname}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            省份<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="memberBean.province" id="province"  value="${memberBean.province}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            城市<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="memberBean.city" id="city"  value="${memberBean.city}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            头像<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="memberBean.headimgurl" id="headimgurl"  value="${memberBean.headimgurl}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            openid<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="memberBean.openid" id="openid"  value="${memberBean.openid}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                
      <td>&nbsp;</td>		
      <td><input type="button" name="提交" value="提交" onclick="save();" class="GF-btn"/></td>		
  </tr>                                
</table>                                 
<iframe name="fram" id="fram" style="display:none"></iframe>   
</form>                                  
</body>                                  
</html>                                  
