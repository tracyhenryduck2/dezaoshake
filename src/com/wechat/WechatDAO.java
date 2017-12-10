package com.wechat;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.common.BaseDAO;

public class WechatDAO extends BaseDAO {

	
    /**
     * 抽奖
     * @return
     */
    public Long getPraise()
    {
    	Long id=0l;
    	String sql="SELECT p FROM prizeconf ORDER BY p DESC LIMIT 1";
    	int max = j.queryForInt(sql);
    	Random rand = new Random();
    	int randNum = rand.nextInt(max);
    	
    	sql="SELECT id, p FROM prizeconf";
    	List<Map<String,Object>> list = j.queryForList(sql);
    	
    	int last=0;
    	for (Map<String,Object> map:list)
    	{
    		int num=last+max/Integer.parseInt(map.get("p").toString());
    		if(randNum>last&&randNum<=num)
    		{
    			id=Long.parseLong(map.get("id").toString());
    			break;
    		}
    		last=num;
    	}
    	
    	return id;
    }
    
    public boolean updatePrizeNum(Long userid,int timeleft){
    	
    	String sql = "update memberextended set timeleft =? where userid = ?";
    	Object[] params = {timeleft,userid};
    	
    	return j.execute(sql, params);
    	
    }
    
    public boolean insertPrizeLog(Long userid,Long time,Long prizeid){
    	String sql = "insert prize_log (userid,ctime,prizeid) values (?,?,?)";
    	Object[] params = {userid,time,prizeid};
    
    	return j.execute(sql, params);
    	
    }
    
    public Long getClientsCommentNum(int userid){
    	String sql = "select count(*) from comment where userid = "+ userid;
    	return j.queryForLong(sql);
    }
}
