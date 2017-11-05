package com.wechat;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.bean.ErrCode;
import com.bean.StaticBean;
import com.common.BaseActionSupport;
import com.common.Transaction;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.system.bean.MemberBean;
import com.system.dao.MemberDAO;
import com.wechat.dao.PrizeconfDAO;

public class Wechat extends BaseActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MemberDAO memberdao = new MemberDAO();
	private PrizeconfDAO prizeconfdao = new PrizeconfDAO();
	private WechatDAO wechatdao= new WechatDAO();
	
	/**
	 * http://SERVER[:PORT]/PROJECTNAME/Wechat!play.action
	 * @return
	 */
	public String play(){
		String code = request.getParameter("code");
        Map<String, String> result = getUserInfoAccessToken(code);//通过这个code获取access_token
        String openId = result.get("openid");
        if (StringUtils.isNotEmpty(openId)) {
            Map<String, String> userInfo = getUserInfo(result.get("access_token"), openId);//使用access_token获取用户信息
            System.out.println("received user info. [result="+userInfo+"]");
            Map<String,Object> d = memberdao.getUserInfo(openId);

            if(d==null){
                String nickname = userInfo.get("nickname");
                String province = userInfo.get("province");
                String city = userInfo.get("city");
                String headimgurl = userInfo.get("headimgurl");
                MemberBean member = new MemberBean();
                member.setNickname(nickname);
                member.setCity(city);
                member.setProvince(province);
                member.setHeadimgurl(headimgurl);
                member.setOpenid(openId);
                Long userid = memberdao.save(member);
                member.setId(userid);
                memberdao.inserMember(userid, 0l, 20l);
                request.setAttribute("user", JSONObject.fromObject(member));
            	return "success";
            }else{
        		JSONObject rootObject = JSONObject.fromObject(d);
                request.setAttribute("user", rootObject);
        		return "success";
            }

        }else{
        	return "failed";
        }

		
	}
	
	
	
	 /**
     * 获取请求用户信息的access_token
     *
     * @param code
     * @return
     */
    public Map<String, String> getUserInfoAccessToken(String code) {
        JsonObject object = null;
        Map<String, String> data = new HashMap<String, String>();
        try {
            String url = String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code",
            		StaticBean.WECHAT_APPID, StaticBean.WECHAT_SECRET, code);
            System.out.println("request accessToken from url: "+url);
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String tokens = EntityUtils.toString(httpEntity, "utf-8");
            Gson token_gson = new Gson();
            object = token_gson.fromJson(tokens, JsonObject.class);
            System.out.println("request accessToken success. [result="+object+"]");
            data.put("openid", object.get("openid").toString().replaceAll("\"", ""));
            data.put("access_token", object.get("access_token").toString().replaceAll("\"", ""));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }
	
	
    
    /**
     * 获取用户信息
     *
     * @param accessToken
     * @param openId
     * @return
     */
    public Map<String, String> getUserInfo(String accessToken, String openId) {
        Map<String, String> data = new HashMap<String, String>();
        String url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + accessToken + "&openid=" + openId + "&lang=zh_CN";
        System.out.println("request user info from url: "+url );
        JsonObject userInfo = null;
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String response = EntityUtils.toString(httpEntity, "utf-8");
            Gson token_gson = new Gson();
            userInfo = token_gson.fromJson(response, JsonObject.class);
            System.out.println("get userinfo success. [result="+userInfo+"]");
            data.put("openid", userInfo.get("openid").toString().replaceAll("\"", ""));
            data.put("nickname", userInfo.get("nickname").toString().replaceAll("\"", ""));
            data.put("city", userInfo.get("city").toString().replaceAll("\"", ""));
            data.put("province", userInfo.get("province").toString().replaceAll("\"", ""));
            data.put("country", userInfo.get("country").toString().replaceAll("\"", ""));
            data.put("headimgurl", userInfo.get("headimgurl").toString().replaceAll("\"", ""));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }
    
	/**
	 * 奖项
	 * 获取奖项
	 */
	public void getPrizeList(){


			List<Map<String,Object>> list=prizeconfdao.getPrizeNameList();
			String result="";
			for(Map<String,Object> map:list){
				result+=map.get("name")+",";
			}
			Map<String,Object> rootObj=new HashMap<String,Object>();
			rootObj.put("errcode", ErrCode.SUCCESS_GETLIST.getCode());
			rootObj.put("errmsg", ErrCode.SUCCESS_GETLIST.getName());
			rootObj.put("result", result);
			outPrintJSONObject(rootObj);
	}
	
	
	public void getPrize(){
		String userid = request.getParameter("id");
		final Map<String,Object> result = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(userid)){
			final Long id2 = Long.parseLong(userid);
			final Map<String,Object> userinfo = memberdao.getUserInfoByid(id2);
	        if(userinfo!=null){
	        	
	        	final int timeleft = (Integer)userinfo.get("timeleft");
	        	if(timeleft>0){
	        		final Long id =wechatdao.getPraise();
	        		if(id>0){
	        			
	        			final Map<String,Object> prizeinfo = prizeconfdao.getPrizeName(id);
	        			 if(prizeinfo!=null){
							 new Transaction(){

									@Override
									public void run() throws Exception {
										// TODO Auto-generated method stub
										
										wechatdao.insertPrizeLog(id2,new Date().getTime()/1000,id);
					        			wechatdao.updatePrizeNum(id2, timeleft-1);
										result.put("errcode", ErrCode.SUCCESS_PRIZE.getCode());
										result.put("errmsg", ErrCode.SUCCESS_PRIZE.getName());
										for(String key:userinfo.keySet()){
											result.put(key, userinfo.get(key));
										}
										result.put("name", prizeinfo.get("name"));
										
									}
									
								}.start();
	        			 }else{
	 						result.put("errcode", ErrCode.NO_THIS_PRIZE_CONF_ERROR.getCode());
							result.put("errmsg", ErrCode.NO_THIS_PRIZE_CONF_ERROR.getName());

	        			 }

	        			
	        		}else{
	        			
	        			wechatdao.updatePrizeNum(id2, timeleft-1);
						result.put("errcode", ErrCode.UNPRIZE_ERROR.getCode());
						result.put("errmsg", ErrCode.UNPRIZE_ERROR.getName());
						for(String key:userinfo.keySet()){
							result.put(key, userinfo.get(key));
						}
		
	        		}
	        		
	        	}else{
					result.put("errcode", ErrCode.PRIZE_NUMBER_EMPTY_ERROR.getCode());
					result.put("errmsg", ErrCode.PRIZE_NUMBER_EMPTY_ERROR.getName());
	        	}
	        }else{
				result.put("errcode", ErrCode.NO_THIS_CLIENT_ERROR.getCode());
				result.put("errmsg", ErrCode.NO_THIS_CLIENT_ERROR.getName());
	        }
		}else{
		
			result.put("errcode", ErrCode.PARAMS_EMPTY_ERROR.getCode());
			result.put("errmsg", ErrCode.PARAMS_EMPTY_ERROR.getName());
		}
		
		outPrintJSONObject(result);	
	}
}
