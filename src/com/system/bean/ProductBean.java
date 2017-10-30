package com.system.bean;

import com.avatar.db.annotation.*;
import com.common.*;

/**
 * 产品
 * @author xin.chou
 *
 */
@Table(name="product")
public class ProductBean {

	/**
	 *  
	*/
	@Column(name="id",primaryKey=true,generatorType=GeneratorType.AUTO_INCREMENT)
	private Long id;

	/**
	 * 产品名称 
	*/
	@Column(name="name")
	private String name;

	/**
	 * 父级id 
	*/
	@Column(name="parent_id")
	private Long parentId;

	/**
	 * 描述 
	*/
	@Column(name="description")
	private String description;
    	
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
     * 产品名称
     * @return 
     */ 
    public String getName() {
    	return name;
    }
    
    /** 
     * 产品名称
     * @param 
     */ 
    public void setName(String name) {
    	this.name = name;
    }
    	
    /** 
     * 父级id
     * @return 
     */ 
    public Long getParentId() {
    	return parentId;
    }
    
    /** 
     * 父级id
     * @param 
     */ 
    public void setParentId(Long parentId) {
    	this.parentId = parentId;
    }
    	
    /** 
     * 描述
     * @return 
     */ 
    public String getDescription() {
    	return description;
    }
    
    /** 
     * 描述
     * @param 
     */ 
    public void setDescription(String description) {
    	this.description = description;
    }
}