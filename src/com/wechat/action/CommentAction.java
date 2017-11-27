package com.wechat.action;

import java.util.List;
import java.util.Map;
import com.wechat.bean.CommentBean;
import com.wechat.dao.CommentDAO;
import com.common.Common;
import com.common.BaseActionSupport;

/**
 * 评价
 * @author jj.xue
 *
 */
public class CommentAction extends BaseActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private CommentDAO dao = new CommentDAO(); 
    private CommentBean commentBean = new CommentBean();    
    private final String tableDesc = "评价";
    /**    
     * 转向添加页面  
     * @return  
     */    
    public String toAddComment() {
        if ("1".equals(oper)) {   
    	    commentBean = dao.select(CommentBean.class,commentBean.getId());  
    	}    
    	return "toAddComment";    
    } 
 
    /**    
     * 新增
     */    
    public String addComment() {  
        try {   
            showMessage = "新增"+tableDesc; 
            boolean result = true;  
            if ("1".equals(oper)) {    
                showMessage = "编辑"+tableDesc;  
                result = dao.update(commentBean); 
            } else { 
                result = dao.insert(commentBean); 
            }
            if (result) {  
                showMessage += "成功";  
                return reload_success; 
            } else {
                showMessage += "失败";  
                return error;   
            }  
        } catch (Exception e) {    
            showMessage = "数据异常，操作失败";   
            return error;  
        } 
    } 
 
    /**    
     * 编辑部分字段专用
     * @return
     */
    public String addTest2(){
        showMessage = "编辑2"+tableDesc;
        String[] param={
            "id","userid","realname","casepoint","feelpoint","servicepoint"
            ,"healthpoint","impress"
        };
        boolean result=dao.update(commentBean,param);
        if (result) { 
            showMessage += "成功";
            return reload_success;
        } else {
            showMessage += "失败"; 
           return error; 
        }
    }
    /**    
     * 删除操作 
     */    
    public String delComment() {  
    	try {
    		boolean result = dao.delete(CommentBean.class,commentBean.getId());  
    		if (result) {
    		    showMessage = "删除"+tableDesc+"成功"; //reload   
    		    return reload_success;  
    		} else {
    		    showMessage = "删除"+tableDesc+"失败";  
    		    return error; 
    		}  
    	} catch (Exception e) {  
    		return exception; 
    	}    
    } 
 
 
    /**    
     * 删除操作 
     */    
    public String delComments() { 
    	try {
    		String[] idArr = request.getParameterValues("idArr");   
    		String ids = Common.array2String(idArr);   
    		boolean result = dao.deletes(CommentBean.class,ids);
    		if (result) {
    		    showMessage = "删除"+tableDesc+"成功"; //reload   
    		    return reload_success;  
    		} else {
    		    showMessage = "删除"+tableDesc+"失败";  
    		    return error; 
    		}  
    	} catch (Exception e) {  
    		return exception; 
    	}    
    } 
    public String search() {
        return "search"; 
    }
 
    /**    
     * 查询列表页面  
     * @return  
     */    
    public String list() {
    	page.execute(request, "ID", "desc");
    	List<Map<String, Object>> list = dao.getPageList(page, commentBean);
    	request.setAttribute("list", list);   
    	return "list";    
    } 
 
    public CommentBean getCommentBean() { 
    	return commentBean;    
    } 
 
    public void setCommentBean(CommentBean commentBean) {   
    	this.commentBean = commentBean;
    } 
}
