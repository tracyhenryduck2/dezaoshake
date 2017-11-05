package com.bean;

public enum ErrCode {
     
	  
	  SUCCESS_GETLIST(8200000,"获取列表成功"), 

	  UNKNOWN_DEVICE_ERROR(8400000,"未知错误"), 
      SERVER_INERNAL_ERROR(8500000,"服务器内部错误"),
	  UNPRIZE_ERROR(8400001,"未中奖"),
	  NO_THIS_CLIENT_ERROR(8400002,"系统无此人"),
	  PARAMS_EMPTY_ERROR(8400003,"参数为空"),
	  PRIZE_NUMBER_EMPTY_ERROR(8400004,"您的抽奖次数已用完，请明天再试"),
	  SUCCESS_PRIZE(8400005,"中奖"),
	  NO_THIS_PRIZE_CONF_ERROR(8400006,"未设置该奖项");
	  
	  
	
	
	    // 成员变量  
	    private String name;  
	    private int code;  
	    // 构造方法  
	    private ErrCode( int code,String name) {  
	        this.name = name;  
	        this.code = code;  
	    }  
	    // 普通方法  
	    public static String getName(int index) {  
	        for (ErrCode c : ErrCode.values()) {  
	            if (c.getCode() == index) {  
	                return c.name;  
	            }  
	        }  
	        return null;  
	    }  
	    // get set 方法  
	    public String getName() {  
	        return name;  
	    }  
	    public void setName(String name) {  
	        this.name = name;  
	    }  
	    public int getCode() {  
	        return code;  
	    }  
	    public void setCode(int code) {  
	        this.code = code;  
	    } 
}
