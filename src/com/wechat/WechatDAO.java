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
}
