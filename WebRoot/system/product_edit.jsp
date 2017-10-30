<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ include file="/common/taglibs.jsp" %>  
<%                                       
String path = request.getContextPath();  
%>                                       
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>                                   
<title></title>
<link rel="stylesheet" href="<%=path %>/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="<%=path %>/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="<%=path %>/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="<%=path %>/kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="<%=path %>/kindeditor/plugins/code/prettify.js"></script>                             
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
				Dialog.opener().location.reload(); //;= "<%=path%>/Product!list.action";   
				parentDialog.close();             
			});                                 
		} else if(messageType == "exception") { 
			                                    
		}                                     
	}                                       
	                                        
	$(function(){       
	
	
			KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="productBean.description"]', {
				allowUpload : true,
				cssPath : '<%=path%>/kindeditor/plugins/code/prettify.css',
				uploadJson : "<%=path%>/kindeditor/jsp/upload_json.jsp?dirName=article",
				fileManagerJson : '<%=path%>/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				allowImageUpload : true,
				urlType:'relative',
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						if($("#fileUrl").val()==null || $("#fileUrl").val()=="") {
							Dialog.alert("请上传简介图片");
							return;
						}
						if($("#form1").valid()) {
							document.forms['form1'].submit();
						}
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						if($("#fileUrl").val()==null || $("#fileUrl").val()=="") {
							Dialog.alert("请上传简介图片");
							return;
						}
						if($("#form1").valid()) {
							document.forms['form1'].submit();
						}
					});
				},
				afterBlur: function(){this.sync();}
			});
			prettyPrint();
		});  
	                    
		/* form1表单进行验证 */               
		$("#form1").validate({              
			rules:{                             
			    "productBean.name":{            
			        CNRangeLength:[0,255]
			    },                              
			    "productBean.parentId":{            
			        required : true,number:true,range:[0,9999999999]
			    },                              
			    "productBean.description":{            
			        CNRangeLength:[0,4294967295]
			    }                              
			},                                  
			messages:{                          
//			    "productBean.code":{          
//				    required : "",CNRangeLength:""  
//			    },                            
			}                                   
		});                                   
	});                                     
	                                        
	                                        
</script>                                
</head>                                  
<body>                                   
<form name="form1" id="form1" action="<%=path %>/Product!addProduct.action" method="post" target="fram" >   
<input type="hidden" name="oper" value="${oper}" />
<input type="hidden" name="productBean.id" id="id" value="${productBean.id }"/>  
<table cellpadding="0" cellspacing="0" width="100%" class="GF-grid"> 
  <tr>                                    
    	<td align="right" width="30%" > 
                            产品名称<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="productBean.name" id="name"  value="${productBean.name}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            父级id<span class="mark">*</span>   
        </td>                            
        <td>                             
            <input type="text" name="productBean.parentId" id="parentId"  value="${productBean.parentId}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            描述<span class="mark"></span>   
        </td>                            
        <td>                             
            	<textarea cols="120" rows="16" style="width:800px;height:400px;visibility:hidden;" name="productBean.description" id="description" >${productBean.description}</textarea>   
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
