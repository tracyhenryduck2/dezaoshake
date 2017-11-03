package com.wechat.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.common.BaseDAO;
import com.common.Page;
import com.wechat.bean.PrizeconfBean;
                        
/**                     
 *                      
 * 奖项设置 <br>          
 *                      
 * @author   <br>   
 * @taskId   <br>   
 */                     
public class PrizeconfDAO extends BaseDAO { 
    /**                 
     * 分页查询         
     * @param page      
     * @param           
     * @return          
     */                 
    public List<Map<String,Object>> getPageList(Page page, PrizeconfBean prizeconfBean) {   
    	String sql ="select a.* from prizeconf a "; 
    	List<Object> objectList = new ArrayList<Object>();
    	String sqlWhere = " where 1=1 ";  
    	if(prizeconfBean!=null) { 
    		if(prizeconfBean.getId() != null) { 
    			objectList.add(prizeconfBean.getId());
    			sqlWhere += " AND a.id = ? ";
    		} 
    		if(prizeconfBean.getName() != null && prizeconfBean.getName().trim().length()>0) { 
    			objectList.add(prizeconfBean.getName());
    			sqlWhere += " AND a.name = ? ";
    		} 
    		if(prizeconfBean.getSum() != null) { 
    			objectList.add(prizeconfBean.getSum());
    			sqlWhere += " AND a.sum = ? ";
    		} 
    		if(prizeconfBean.getP() != null) { 
    			objectList.add(prizeconfBean.getP());
    			sqlWhere += " AND a.p = ? ";
    		} 
    	}                 
    	sql = sql + sqlWhere; 
    	Object[] pram = objectList.toArray(); 
    	if(page.getSortname()!=null && page.getSortorder()!=null) {   
    		sql += " order by "+page.getSortname()+" " +page.getSortorder(); 
    	}                 
    	page.setTotalRows(j.queryForInteger("select count(*) from prizeconf a "+sqlWhere, pram));
    	List<Map<String,Object>> list=j.queryForPageList(sql, page.getPageNo(),page.getPageSize(),pram);  
    	return list;      
    }                   
}                       
