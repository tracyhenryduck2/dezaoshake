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
	function search(){                          
			Dialog.opener().document.getElementById("userid").value = $("#userid").val()||"";    
			Dialog.opener().document.getElementById("realname").value = $("#realname").val()||"";    
			Dialog.opener().document.getElementById("casepoint").value = $("#casepoint").val()||"";    
			Dialog.opener().document.getElementById("feelpoint").value = $("#feelpoint").val()||"";    
			Dialog.opener().document.getElementById("servicepoint").value = $("#servicepoint").val()||"";    
			Dialog.opener().document.getElementById("healthpoint").value = $("#healthpoint").val()||"";    
			Dialog.opener().document.getElementById("impress").value = $("#impress").val()||"";    
			Dialog.opener().document.form1.submit();                     
			ownerDialog.close();
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
<form name="form1" id="form1" action="#" method="post" target="fram" >   
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
    	<td align="right" width="30%" > 
                            真实姓名<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="commentBean.realname" id="realname"  value="${commentBean.realname}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            课程评分<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="commentBean.casepoint" id="casepoint"  value="${commentBean.casepoint}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            体验感评分<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="commentBean.feelpoint" id="feelpoint"  value="${commentBean.feelpoint}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            服务评分<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="commentBean.servicepoint" id="servicepoint"  value="${commentBean.servicepoint}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            卫生评分<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="commentBean.healthpoint" id="healthpoint"  value="${commentBean.healthpoint}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            半铺园印象<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="commentBean.impress" id="impress"  value="${commentBean.impress}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                
      <td>&nbsp;</td>		
      <td><input type="button" name="查询" value="查询" onclick="search();" class="GF-btn"/></td>		
  </tr>                                
</table>                                 
<iframe name="fram" id="fram" style="display:none"></iframe>   
</form>                                  
</body>                                  
</html>                                  
