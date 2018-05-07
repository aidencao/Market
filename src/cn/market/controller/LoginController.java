package cn.market.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.market.pojo.Config;
import cn.market.pojo.Custom;
import cn.market.pojo.RdSession;
import cn.market.service.WxappService;
import cn.market.tools.AesCbcUtil;
import cn.market.tools.DefinedChars;
import cn.market.tools.HttpsUtil;
import cn.market.tools.RamdomUtil;
import cn.market.tools.SHA1;
import cn.market.tools.UserInfoUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;


@RestController
@RequestMapping("/wxapp")
public class LoginController {
	@Resource
	private WxappService wxappService;
	
	@SuppressWarnings("null")
	@ResponseBody
	@RequestMapping("/getSessionId")    
	public HashMap<String, String> listVote(@RequestParam(value = "code") String code, HttpServletRequest request) throws Exception  {
		String rawdata = request.getParameter("rawData");
		String signature = request.getParameter("signature");
		String iv = request.getParameter("iv");
		String encrypteddata = request.getParameter("encryptedData");
		
		System.out.println("收到的原始数据为"+rawdata);
		System.out.println("收到请求，请求数据为[ code：" + code + "]");
		System.out.println("发送的数字签名为:"+signature);
		System.out.println("需要解析的是:"+encrypteddata);
		
		HashMap<String, String> map = new HashMap<String, String>();
		// 通过code换取网页授权web_access_token
		if (code != null || !(code.equals(""))) {
			String CODE = code;
			String WebAccessToken = "";
			String openId = "";
			// 替换字符串，获得请求URL
			String token = UserInfoUtil.getWebAccess(CODE);
			System.out.println("组合token为：" + token);
			// 通过https方式请求获得web_access_token
			String response = HttpsUtil.httpsRequestToString(token, "GET", null);
			JSONObject jsonObject = JSON.parseObject(response);
			System.out.println("jsonObject>>>" + jsonObject);
		
			/*String teddata = "VrAvpGmC/7DKPT6Su0rpD+MlMOxhww1tLeQLa7mMtNijgwtAUhvZ/V3eGoY3YsuNnUfGj8HibS/aF+dIfn1KzZo51TSQpFaPsXVHmpRygKXVghjnlOMvIqFQXb0rFeRlvhGhwxcLTTsI5yDJdeB2euBMqhGQ0lx/nS80aFO5BxWH9g1lv8rpkBLo4EVs4rg/mAuZfup1F7DI4FLzP4wSO04UC+PaJan1KSgZWffLLYq+jeDUejvaB49Ngg70gdHMs5GXUm/sPUn1p7ETLF02pdPXecgIkpjZ/beaeP8HgZYaYxuB3IekeNQe1W4seI4n5mnBrKL5DFotHLTOJQBJCkmHMQs3pHTfPt10FuFSeRyLi7HeOK8tTW6SN2UQ3y0wZjJaGuymgta68GdjpsHUzFYs7BXGJIzN+Wj/0QK+CUES1MztdDB7bClX9pye5B4i90UHFmZrFrT/cdKqbWTJCKyoGp5Zhxv0+SRMVTFrJgQ=";
			iv = "ejIskAcD1N1dNOFIqdjuRw==";
			WebAccessToken = "oo9aHdFT59tX64H4YJhN5g==";
			String re = AesCbcUtil.decrypt(teddata, WebAccessToken, iv, "UTF-8");
			JSONObject userInfo = JSONObject.parseObject(re); 
			System.out.println("解析后的数据为:"+userInfo);
			System.out.println("其中元素项为:"+userInfo.getString("nickName"));*/
			
			
			//如果JasonObject或opeid为空则登录失败
			if (null != jsonObject&&jsonObject.getString("openid")!=null) {
				try {
					WebAccessToken = jsonObject.getString("session_key");
					openId = jsonObject.getString("openid");
					System.out.println(	"获取access_token成功[session_key:" + WebAccessToken + "---------------openid:" + openId);
					String checkData = rawdata+WebAccessToken;
					System.out.println("checkData:"+checkData);
					String sign = SHA1.getSha1(checkData);
					System.out.println("生成的数字签名:"+sign);
					if(signature.equals(sign))
						System.out.println("验证成功");
					
					encrypteddata = encrypteddata.replace(" ", "+");
					iv = iv.replace(" ", "+");
					System.out.println("更新后的iv:"+iv);
					String result = AesCbcUtil.decrypt(encrypteddata, WebAccessToken, iv, "UTF-8");
					
					JSONObject userInfoJSON = JSONObject.parseObject(result); 
					System.out.println("解析后的数据为:"+userInfoJSON);
					
					Custom custom = new Custom();
					/*JSONObject jsonrawdata = JSONObject.parseObject(rawdata);*/
					custom.setOpenid(openId);
					custom.setNickname(userInfoJSON.getString("nickName"));
					custom.setGender(userInfoJSON.getInteger("gender"));
					custom.setLanguage(userInfoJSON.getString("language"));
					custom.setCity(userInfoJSON.getString("city"));
					custom.setProvince(userInfoJSON.getString("province"));
					custom.setCountry(userInfoJSON.getString("country"));
					custom.setAvatarurl(userInfoJSON.getString("avatarUrl"));
					
					String Rsession = null;
					Rsession = RamdomUtil.generateString(DefinedChars.CHECKLENGTH);
					System.out.println("生成的随机串为:"+Rsession);
					while(wxappService.hasRdsession(Rsession))
					{
						Rsession = RamdomUtil.generateString(DefinedChars.CHECKLENGTH);
						System.out.println("生成的随机串为:"+Rsession);
					}
					RdSession rdSession = new RdSession();
					rdSession.setOpenid(openId);
					rdSession.setRdsession(Rsession);
					rdSession.setSessionkey(WebAccessToken);
					
					wxappService.login(rdSession, custom, openId, sign, signature);
					map.put("rdSession", Rsession);
					System.out.println("登录成功");
					return map;
					
				} catch (JSONException e) {
					e.printStackTrace();
					WebAccessToken = null;// 获取code失败
					System.out.println("获取session_key失败");
					throw new Exception("登录失败,获取session_key失败");
				}
			}
			else{
				System.out.println("获取openid及session_key失败");
				throw new Exception("登录失败,获取openid及session_key失败");
			}
		}
		return map;
	}
	
}
