package com.wechat;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.bean.StaticBean;
import com.common.BaseActionSupport;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.system.bean.MemberBean;
import com.system.dao.MemberDAO;

public class Wechat extends BaseActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MemberDAO memberdao = new MemberDAO();
	
	/**
	 * http://SERVER[:PORT]/PROJECTNAME/Wechat!Login.action
	 * @return
	 */
	public String Login(){
		String code = request.getParameter("code");
        //Map<String, String> result = getUserInfoAccessToken(code);//通过这个code获取access_token
        //String openId = result.get("openid");
//        if (StringUtils.isNotEmpty(openId)) {
//            Map<String, String> userInfo = getUserInfo(result.get("access_token"), openId);//使用access_token获取用户信息
//            System.out.println("received user info. [result="+userInfo+"]");
//            Map<String,Object> d = memberdao.getUserId(openId);
//
//            if(d==null){
//                String nickname = userInfo.get("nickname");
//                String province = userInfo.get("province");
//                String city = userInfo.get("city");
//                String headimgurl = userInfo.get("headimgurl");
                MemberBean member = new MemberBean();
                member.setNickname("张三");
                member.setCity("宁波");
                member.setProvince("浙江");
                member.setHeadimgurl("123");
                member.setOpenid("123");
                Long userid = memberdao.save(member);
                memberdao.inserMember(userid, 0l, 2l);

                request.setAttribute("user", JSONObject.fromObject(member));
            	return "success";
//            }else{
//        		JSONObject rootObject = JSONObject.fromObject(d);
//                request.setAttribute("user", rootObject);
//        		return "success";
//            }
//
//        }else{
//        	return "failed";
//        }

		
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
    
	
}
