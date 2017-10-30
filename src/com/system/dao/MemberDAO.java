package com.system.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.common.BaseDAO;
import com.common.Page;
import com.system.bean.MemberBean;
                        
/**                     
 *                      
 * 成员表 <br>          
 *                      
 * @author   <br>   
 * @taskId   <br>   
 */                     
public class MemberDAO extends BaseDAO { 
    /**                 
     * 分页查询         
     * @param page      
     * @param           
     * @return          
     */                 
    public List<Map<String,Object>> getPageList(Page page, MemberBean memberBean) {   
    	String sql ="select a.* from member a "; 
    	List<Object> objectList = new ArrayList<Object>();
    	String sqlWhere = " where 1=1 ";  
    	if(memberBean!=null) { 
    		if(memberBean.getId() != null) { 
    			objectList.add(memberBean.getId());
    			sqlWhere += " AND a.Id = ? ";
    		} 
    		if(memberBean.getUsername() != null && memberBean.getUsername().trim().length()>0) { 
    			objectList.add(memberBean.getUsername());
    			sqlWhere += " AND a.username = ? ";
    		} 
    		if(memberBean.getCompany() != null && memberBean.getCompany().trim().length()>0) { 
    			objectList.add(memberBean.getCompany());
    			sqlWhere += " AND a.company = ? ";
    		} 
    		if(memberBean.getPosition() != null && memberBean.getPosition().trim().length()>0) { 
    			objectList.add(memberBean.getPosition());
    			sqlWhere += " AND a.position = ? ";
    		} 
    	}                 
    	sql = sql + sqlWhere; 
    	Object[] pram = objectList.toArray(); 
    	if(page.getSortname()!=null && page.getSortorder()!=null) {   
    		sql += " order by "+page.getSortname()+" " +page.getSortorder(); 
    	}                 
    	page.setTotalRows(j.queryForInteger("select count(*) from member a "+sqlWhere, pram));
    	List<Map<String,Object>> list=j.queryForPageList(sql, page.getPageNo(),page.getPageSize(),pram);  
    	return list;      
    }                   
}                       
