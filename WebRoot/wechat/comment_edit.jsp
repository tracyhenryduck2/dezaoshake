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
				Dialog.opener().location.reload(); //;= "<%=path%>/wechat/Comment!list.action";   
				parentDialog.close();             
			});                                 
		} else if(messageType == "exception") { 
			                                    
		}                                     
	}                                       
	                                        
	$(function(){                           
		/* form1表单进行验证 */               
		$("#form1").validate({              
			rules:{                             
			    "commentBean.userid":{            
			        number:true,range:[0,9999999999]
			    },                              
			    "commentBean.realname":{            
			        CNRangeLength:[0,255]
			    },                              
			    "commentBean.casepoint":{            
			        number:true,range:[0,9999999999]
			    },                              
			    "commentBean.feelpoint":{            
			        number:true,range:[0,9999999999]
			    },                              
			    "commentBean.servicepoint":{            
			        number:true,range:[0,9999999999]
			    },                              
			    "commentBean.healthpoint":{            
			        number:true,range:[0,9999999999]
			    },                              
			    "commentBean.impress":{            
			        CNRangeLength:[0,255]
			    }                              
			},                                  
			messages:{                          
//			    "commentBean.code":{          
//				    required : "",CNRangeLength:""  
//			    },                            
			}                                   
		});                                   
	});                                     
	                                        
	                                        
</script>                                
</head>                                  
<body>                                   
<form name="form1" id="form1" action="<%=path %>/wechat/Comment!addComment.action" method="post" target="fram" >   
<input type="hidden" name="oper" value="${oper}" />
<input type="hidden" name="commentBean.id" id="id" value="${commentBean.id }"/>  
<table cellpadding="0" cellspacing="0" width="100%" class="GF-grid"> 
  <tr>                                    
    	<td align="right" width="30%" > 
                            <span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="commentBean.userid" id="userid"  value="${commentBean.userid}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            真实姓名<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="commentBean.realname" id="realname"  value="${commentBean.realname}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            课程评分<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="commentBean.casepoint" id="casepoint"  value="${commentBean.casepoint}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            体验感评分<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="commentBean.feelpoint" id="feelpoint"  value="${commentBean.feelpoint}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            服务评分<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="commentBean.servicepoint" id="servicepoint"  value="${commentBean.servicepoint}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            卫生评分<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="commentBean.healthpoint" id="healthpoint"  value="${commentBean.healthpoint}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            半铺园印象<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="commentBean.impress" id="impress"  value="${commentBean.impress}" class="GF-field"/>   
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
