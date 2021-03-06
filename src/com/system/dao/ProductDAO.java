package com.system.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.common.BaseDAO;
import com.common.Page;
import com.system.bean.ProductBean;
                        
/**                     
 *                      
 * 产品 <br>          
 *                      
 * @author   <br>   
 * @taskId   <br>   
 */                     
public class ProductDAO extends BaseDAO { 
    /**                 
     * 分页查询         
     * @param page      
     * @param           
     * @return          
     */                 
    public List<Map<String,Object>> getPageList(Page page, ProductBean productBean) {   
    	String sql ="select a.* from product a "; 
    	List<Object> objectList = new ArrayList<Object>();
    	String sqlWhere = " where 1=1 ";  
    	if(productBean!=null) { 
    		if(productBean.getId() != null) { 
    			objectList.add(productBean.getId());
    			sqlWhere += " AND a.id = ? ";
    		} 
    		if(productBean.getName() != null && productBean.getName().trim().length()>0) { 
    			objectList.add(productBean.getName());
    			sqlWhere += " AND a.name = ? ";
    		} 
    		if(productBean.getParentId() != null) { 
    			objectList.add(productBean.getParentId());
    			sqlWhere += " AND a.parent_id = ? ";
    		} 
    		if(productBean.getDescription() != null && productBean.getDescription().trim().length()>0) { 
    			objectList.add(productBean.getDescription());
    			sqlWhere += " AND a.description = ? ";
    		} 
    	}                 
    	sql = sql + sqlWhere; 
    	Object[] pram = objectList.toArray(); 
    	if(page.getSortname()!=null && page.getSortorder()!=null) {   
    		sql += " order by "+page.getSortname()+" " +page.getSortorder(); 
    	}                 
    	page.setTotalRows(j.queryForInteger("select count(*) from product a "+sqlWhere, pram));
    	List<Map<String,Object>> list=j.queryForPageList(sql, page.getPageNo(),page.getPageSize(),pram);  
    	return list;      
    }                   
}                       
