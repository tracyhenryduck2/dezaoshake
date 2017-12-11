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
    			sqlWhere += " AND a.id = ? ";
    		} 
    		if(memberBean.getNickname() != null && memberBean.getNickname().trim().length()>0) { 
    			objectList.add(memberBean.getNickname());
    			sqlWhere += " AND a.nickname = ? ";
    		} 
    		if(memberBean.getProvince() != null && memberBean.getProvince().trim().length()>0) { 
    			objectList.add(memberBean.getProvince());
    			sqlWhere += " AND a.province = ? ";
    		} 
    		if(memberBean.getCity() != null && memberBean.getCity().trim().length()>0) { 
    			objectList.add(memberBean.getCity());
    			sqlWhere += " AND a.city = ? ";
    		} 
    		if(memberBean.getHeadimgurl() != null && memberBean.getHeadimgurl().trim().length()>0) { 
    			objectList.add(memberBean.getHeadimgurl());
    			sqlWhere += " AND a.headimgurl = ? ";
    		} 
    		if(memberBean.getOpenid() != null && memberBean.getOpenid().trim().length()>0) { 
    			objectList.add(memberBean.getOpenid());
    			sqlWhere += " AND a.openid = ? ";
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
    
    
    public Map<String,Object> getUserInfo(String openid){
      	 String sql = "select * from member where openid = ?";
      	 Object[] ds = {openid};
      	 return j.queryForMap(sql, ds);
       }
    
    public Map<String,Object> getUserAllInfo(int id){
     	 String sql = "select * from member where id = ?";
     	 Object[] ds = {id};
     	 return j.queryForMap(sql, ds);
      }
    
    public Map<String,Object> getUserInfoByid(Long id){
     	 String sql = "select a.id,b.timeleft from member a left join memberextended b on a.id=b.userid where a.id = ?";
     	 Object[] ds = {id};
     	 return j.queryForMap(sql, ds);
      }
    
    public boolean inserMember(Long userid,Long sum,Long timeleft){
    	String sql = "insert memberextended (userid,sum,timeleft) values(?,?,?)";
    	Object[] params = {userid,sum,timeleft};
    	return j.execute(sql, params);
    	
    }
}                       
