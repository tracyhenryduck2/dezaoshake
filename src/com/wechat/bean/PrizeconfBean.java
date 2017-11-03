package com.wechat.bean;

import com.avatar.db.annotation.*;
import com.common.*;

/**
 * 奖项设置
 * @author jj.xue
 *
 */
@Table(name="prizeconf")
public class PrizeconfBean {

	/**
	 *  
	*/
	@Column(name="id",primaryKey=true,generatorType=GeneratorType.AUTO_INCREMENT)
	private Long id;

	/**
	 * 奖项名称 
	*/
	@Column(name="name")
	private String name;

	/**
	 * 积分 
	*/
	@Column(name="sum")
	private Long sum;

	/**
	 * 概率 
	*/
	@Column(name="p")
	private Long p;
    	
    /** 
     * 
     * @return 
     */ 
    public Long getId() {
    	return id;
    }
    
    /** 
     * 
     * @param 
     */ 
    public void setId(Long id) {
    	this.id = id;
    }
    	
    /** 
     * 奖项名称
     * @return 
     */ 
    public String getName() {
    	return name;
    }
    
    /** 
     * 奖项名称
     * @param 
     */ 
    public void setName(String name) {
    	this.name = name;
    }
    	
    /** 
     * 积分
     * @return 
     */ 
    public Long getSum() {
    	return sum;
    }
    
    /** 
     * 积分
     * @param 
     */ 
    public void setSum(Long sum) {
    	this.sum = sum;
    }
    	
    /** 
     * 概率
     * @return 
     */ 
    public Long getP() {
    	return p;
    }
    
    /** 
     * 概率
     * @param 
     */ 
    public void setP(Long p) {
    	this.p = p;
    }
}