package com.wechat.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.common.BaseDAO;
import com.common.Page;
import com.wechat.bean.CommentBean;
                        
/**                     
 *                      
 * 评价 <br>          
 *                      
 * @author   <br>   
 * @taskId   <br>   
 */                     
public class CommentDAO extends BaseDAO { 
    /**                 
     * 分页查询         
     * @param page      
     * @param           
     * @return          
     */                 
    public List<Map<String,Object>> getPageList(Page page, CommentBean commentBean) {   
    	String sql ="select a.* from comment a "; 
    	List<Object> objectList = new ArrayList<Object>();
    	String sqlWhere = " where 1=1 ";  
    	if(commentBean!=null) { 
    		if(commentBean.getId() != null) { 
    			objectList.add(commentBean.getId());
    			sqlWhere += " AND a.id = ? ";
    		} 
    		if(commentBean.getUserid() != null) { 
    			objectList.add(commentBean.getUserid());
    			sqlWhere += " AND a.userid = ? ";
    		} 
    		if(commentBean.getRealname() != null && commentBean.getRealname().trim().length()>0) { 
    			objectList.add(commentBean.getRealname());
    			sqlWhere += " AND a.realname = ? ";
    		} 
    		if(commentBean.getCasepoint() != null) { 
    			objectList.add(commentBean.getCasepoint());
    			sqlWhere += " AND a.casepoint = ? ";
    		} 
    		if(commentBean.getFeelpoint() != null) { 
    			objectList.add(commentBean.getFeelpoint());
    			sqlWhere += " AND a.feelpoint = ? ";
    		} 
    		if(commentBean.getServicepoint() != null) { 
    			objectList.add(commentBean.getServicepoint());
    			sqlWhere += " AND a.servicepoint = ? ";
    		} 
    		if(commentBean.getHealthpoint() != null) { 
    			objectList.add(commentBean.getHealthpoint());
    			sqlWhere += " AND a.healthpoint = ? ";
    		} 
    		if(commentBean.getImpress() != null && commentBean.getImpress().trim().length()>0) { 
    			objectList.add(commentBean.getImpress());
    			sqlWhere += " AND a.impress = ? ";
    		} 
    	}                 
    	sql = sql + sqlWhere; 
    	Object[] pram = objectList.toArray(); 
    	if(page.getSortname()!=null && page.getSortorder()!=null) {   
    		sql += " order by "+page.getSortname()+" " +page.getSortorder(); 
    	}                 
    	page.setTotalRows(j.queryForInteger("select count(*) from comment a "+sqlWhere, pram));
    	List<Map<String,Object>> list=j.queryForPageList(sql, page.getPageNo(),page.getPageSize(),pram);  
    	return list;      
    }                   
}                       
