package com.system.bean;

import java.util.Map;

import com.avatar.db.annotation.*;
import com.common.*;

/**
 * 成员表
 * @author jj.xue
 *
 */
@Table(name="member")
public class MemberBean {
	/**
	 *  
	*/
	@Column(name="id",primaryKey=true,generatorType=GeneratorType.AUTO_INCREMENT)
	private Long id;

	/**
	 * 用户名 
	*/
	@Column(name="nickname")
	private String nickname;

	/**
	 * 省份 
	*/
	@Column(name="province")
	private String province;

	/**
	 * 城市 
	*/
	@Column(name="city")
	private String city;

	/**
	 * 头像 
	*/
	@Column(name="headimgurl")
	private String headimgurl;

	/**
	 * openid 
	*/
	@Column(name="openid")
	private String openid;
    	
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
    public String getNickname() {
    	return nickname;
    }
    
    /** 
     * 用户名
     * @param 
     */ 
    public void setNickname(String nickname) {
    	this.nickname = nickname;
    }
    	
    /** 
     * 省份
     * @return 
     */ 
    public String getProvince() {
    	return province;
    }
    
    /** 
     * 省份
     * @param 
     */ 
    public void setProvince(String province) {
    	this.province = province;
    }
    	
    /** 
     * 城市
     * @return 
     */ 
    public String getCity() {
    	return city;
    }
    
    /** 
     * 城市
     * @param 
     */ 
    public void setCity(String city) {
    	this.city = city;
    }
    	
    /** 
     * 头像
     * @return 
     */ 
    public String getHeadimgurl() {
    	return headimgurl;
    }
    
    /** 
     * 头像
     * @param 
     */ 
    public void setHeadimgurl(String headimgurl) {
    	this.headimgurl = headimgurl;
    }
    	
    /** 
     * openid
     * @return 
     */ 
    public String getOpenid() {
    	return openid;
    }
    
    /** 
     * openid
     * @param 
     */ 
    public void setOpenid(String openid) {
    	this.openid = openid;
    }
}