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
			Dialog.opener().document.getElementById("nickname").value = $("#nickname").val()||"";    
			Dialog.opener().document.getElementById("province").value = $("#province").val()||"";    
			Dialog.opener().document.getElementById("city").value = $("#city").val()||"";    
			Dialog.opener().document.getElementById("headimgurl").value = $("#headimgurl").val()||"";    
			Dialog.opener().document.getElementById("openid").value = $("#openid").val()||"";    
			Dialog.opener().document.form1.submit();                     
			ownerDialog.close();
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
<form name="form1" id="form1" action="#" method="post" target="fram" >   
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
    	<td align="right" width="30%" > 
                            省份<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="memberBean.province" id="province"  value="${memberBean.province}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            城市<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="memberBean.city" id="city"  value="${memberBean.city}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            头像<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="memberBean.headimgurl" id="headimgurl"  value="${memberBean.headimgurl}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            openid<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="memberBean.openid" id="openid"  value="${memberBean.openid}" class="GF-field"/>   
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
