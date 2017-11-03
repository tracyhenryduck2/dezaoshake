package com.wechat.action;

import java.util.List;
import java.util.Map;
import com.wechat.bean.PrizeconfBean;
import com.wechat.dao.PrizeconfDAO;
import com.common.Common;
import com.common.BaseActionSupport;

/**
 * 奖项设置
 * @author jj.xue
 *
 */
public class PrizeconfAction extends BaseActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private PrizeconfDAO dao = new PrizeconfDAO(); 
    private PrizeconfBean prizeconfBean = new PrizeconfBean();    
    private final String tableDesc = "奖项设置";
    /**    
     * 转向添加页面  
     * @return  
     */    
    public String toAddPrizeconf() {
        if ("1".equals(oper)) {   
    	    prizeconfBean = dao.select(PrizeconfBean.class,prizeconfBean.getId());  
    	}    
    	return "toAddPrizeconf";    
    } 
 
    /**    
     * 新增
     */    
    public String addPrizeconf() {  
        try {   
            showMessage = "新增"+tableDesc; 
            boolean result = true;  
            if ("1".equals(oper)) {    
                showMessage = "编辑"+tableDesc;  
                result = dao.update(prizeconfBean); 
            } else { 
                result = dao.insert(prizeconfBean); 
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
            "id","name","sum","p"
        };
        boolean result=dao.update(prizeconfBean,param);
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
    public String delPrizeconf() {  
    	try {
    		boolean result = dao.delete(PrizeconfBean.class,prizeconfBean.getId());  
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
    public String delPrizeconfs() { 
    	try {
    		String[] idArr = request.getParameterValues("idArr");   
    		String ids = Common.array2String(idArr);   
    		boolean result = dao.deletes(PrizeconfBean.class,ids);
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
    	List<Map<String, Object>> list = dao.getPageList(page, prizeconfBean);
    	request.setAttribute("list", list);   
    	return "list";    
    } 
 
    public PrizeconfBean getPrizeconfBean() { 
    	return prizeconfBean;    
    } 
 
    public void setPrizeconfBean(PrizeconfBean prizeconfBean) {   
    	this.prizeconfBean = prizeconfBean;
    } 
}
