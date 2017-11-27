package com.wechat.bean;

import com.avatar.db.annotation.*;
import com.common.*;

/**
 * 评价
 * @author jj.xue
 *
 */
@Table(name="comment")
public class CommentBean {

	/**
	 *  
	*/
	@Column(name="id",primaryKey=true,generatorType=GeneratorType.AUTO_INCREMENT)
	private Long id;

	/**
	 *  
	*/
	@Column(name="userid")
	private Long userid;

	/**
	 * 真实姓名 
	*/
	@Column(name="realname")
	private String realname;

	/**
	 * 课程评分 
	*/
	@Column(name="casepoint")
	private Long casepoint;

	/**
	 * 体验感评分 
	*/
	@Column(name="feelpoint")
	private Long feelpoint;

	/**
	 * 服务评分 
	*/
	@Column(name="servicepoint")
	private Long servicepoint;

	/**
	 * 卫生评分 
	*/
	@Column(name="healthpoint")
	private Long healthpoint;

	/**
	 * 半铺园印象 
	*/
	@Column(name="impress")
	private String impress;
    	
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
     * 
     * @return 
     */ 
    public Long getUserid() {
    	return userid;
    }
    
    /** 
     * 
     * @param 
     */ 
    public void setUserid(Long userid) {
    	this.userid = userid;
    }
    	
    /** 
     * 真实姓名
     * @return 
     */ 
    public String getRealname() {
    	return realname;
    }
    
    /** 
     * 真实姓名
     * @param 
     */ 
    public void setRealname(String realname) {
    	this.realname = realname;
    }
    	
    /** 
     * 课程评分
     * @return 
     */ 
    public Long getCasepoint() {
    	return casepoint;
    }
    
    /** 
     * 课程评分
     * @param 
     */ 
    public void setCasepoint(Long casepoint) {
    	this.casepoint = casepoint;
    }
    	
    /** 
     * 体验感评分
     * @return 
     */ 
    public Long getFeelpoint() {
    	return feelpoint;
    }
    
    /** 
     * 体验感评分
     * @param 
     */ 
    public void setFeelpoint(Long feelpoint) {
    	this.feelpoint = feelpoint;
    }
    	
    /** 
     * 服务评分
     * @return 
     */ 
    public Long getServicepoint() {
    	return servicepoint;
    }
    
    /** 
     * 服务评分
     * @param 
     */ 
    public void setServicepoint(Long servicepoint) {
    	this.servicepoint = servicepoint;
    }
    	
    /** 
     * 卫生评分
     * @return 
     */ 
    public Long getHealthpoint() {
    	return healthpoint;
    }
    
    /** 
     * 卫生评分
     * @param 
     */ 
    public void setHealthpoint(Long healthpoint) {
    	this.healthpoint = healthpoint;
    }
    	
    /** 
     * 半铺园印象
     * @return 
     */ 
    public String getImpress() {
    	return impress;
    }
    
    /** 
     * 半铺园印象
     * @param 
     */ 
    public void setImpress(String impress) {
    	this.impress = impress;
    }
}