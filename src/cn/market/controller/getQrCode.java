package cn.market.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.market.Client.HttpClientConnectionManager;
import cn.market.Client.upLoadfile;
import cn.market.service.WxappService;
import cn.market.tools.DrawTextInImg;
import cn.market.tools.HttpsUtil;
import cn.market.tools.UserInfoUtil;

@Controller
@RequestMapping("/wxapp")
public class getQrCode {

	@Resource
	private WxappService wxappService;

	@RequestMapping("/getQrCode")
	@ResponseBody
	public Map<String, String> getQrcode(HttpServletRequest request) throws Exception {
		String macid = request.getParameter("macId");
		if(macid == null)
			throw new Exception("macId未输入");
		String access = UserInfoUtil.getAccesstoken();
		String response = HttpsUtil.httpsRequestToString(access, "GET", null);
		com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(response);
		String accesstoken = jsonObject.getString("access_token");
		System.out.println(jsonObject);

		// 二维码请求地址
		String twobarcodepath = UserInfoUtil.getTwobarcode(accesstoken);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("path", "pages/index/index?macId="+macid);// 二维码中跳向的地址
		map.put("width", 430);// 图片大小
		JSONObject json = JSONObject.fromObject(map);
		System.out.println(json);
		String res = HttpClientConnectionManager.httpPostWithJSON(
				twobarcodepath , json.toString(), macid, request
						.getSession().getServletContext().getRealPath("/")
						+ "/images/");
		System.out.println(res);
		
		//本地图片的修改
		String localaddress = request.getSession().getServletContext().getRealPath("/")+"images/"+macid+".png";
		System.out.println(localaddress);
		DrawTextInImg.drawTextInImg(localaddress, localaddress, new cn.market.tools.FontText("machineId:"+macid, 1, "#000000", 40, "微软雅黑"));
		String newpath = upLoadfile.upload(localaddress, macid);
		/*return DefinedChars.PROJECTURL+"/images/"+macid+".png";*/
		/*return "http://localhost:8080/VendMac"+"/images/"+macid+".png";*/
		if(!macid.equals("000015"))
		newpath += "?value="+System.currentTimeMillis();
		Map<String, String>path = new HashMap<String, String>();
		path.put("localaddress", localaddress);
		path.put("path", newpath);
		return path;
	}
}
