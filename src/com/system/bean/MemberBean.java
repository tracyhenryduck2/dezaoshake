package com.system.bean;

import com.avatar.db.annotation.*;
import com.common.*;

/**
 * 成员表
 * @author xin.chou
 *
 */
@Table(name="member")
public class MemberBean {

	/**
	 *  
	*/
	@Column(name="Id",primaryKey=true,generatorType=GeneratorType.AUTO_INCREMENT)
	private Long id;

	/**
	 * 用户名 
	*/
	@Column(name="username")
	private String username;

	/**
	 * 公司 
	*/
	@Column(name="company")
	private String company;

	/**
	 * 职位 
	*/
	@Column(name="position")
	private String position;
    	
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
     * 用户名
     * @return 
     */ 
    public String getUsername() {
    	return username;
    }
    
    /** 
     * 用户名
     * @param 
     */ 
    public void setUsername(String username) {
    	this.username = username;
    }
    	
    /** 
     * 公司
     * @return 
     */ 
    public String getCompany() {
    	return company;
    }
    
    /** 
     * 公司
     * @param 
     */ 
    public void setCompany(String company) {
    	this.company = company;
    }
    	
    /** 
     * 职位
     * @return 
     */ 
    public String getPosition() {
    	return position;
    }
    
    /** 
     * 职位
     * @param 
     */ 
    public void setPosition(String position) {
    	this.position = position;
    }
}