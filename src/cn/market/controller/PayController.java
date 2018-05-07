package cn.market.controller;

import java.io.BufferedReader;
import java.io.StringReader;
import java.security.MessageDigest;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpRequest;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.market.pojo.CustomOrder;
import cn.market.pojo.CustomOrderDetail;
import cn.market.pojo.GoodsReturn;
import cn.market.pojo.GoodsUnit;
import cn.market.pojo.Returndata;
import cn.market.service.WxappService;
import cn.market.tools.DefinedChars;
import cn.market.tools.HttpsUtil;
import cn.market.tools.NumberUtil;
import cn.market.tools.RamdomUtil;

@RestController
@RequestMapping("/wxapp")
public class PayController {

	@Resource
	private WxappService wxappService;

	@ResponseBody
	@RequestMapping("/getPaymentInfo")
	public Returndata transfer(HttpServletRequest request) throws Exception {
		String orderid = request.getParameter("orderId");
		String rdsession = request.getParameter("rdSession");

		if (orderid == null || rdsession == null)
			throw new Exception("orderId或rdSession未输入");
		/*
		 * String orderid = "10000001"; String rdsession =
		 * "Ov1JHyQgF54IB0qGISxLAgbZ563TM4nBlGt5osPzUVQThHnughyC0vAG4nAHro7ShOT3rWlAWEv5LbZ51yLYO1JnBWfleCmwTkZYrOXEQs9GGMvdkakIKwtjTDyOcYcN"
		 * ;
		 */
		if (!wxappService.ismachienHasClosetime(orderid))
			throw new Exception("货柜未关闭,无法付款");
		String appid = DefinedChars.APPID;
		String mchid = DefinedChars.MCH_ID;
		String nonceStr = RamdomUtil.generateString(DefinedChars.NONCE); // 随机字符串
		String body = "售货机商品支付";
		String outTradeno = orderid; // 商品订单号

		double orderprice = wxappService.findOrderprice(orderid);
		/* double orderprice =1; */
		System.out.println(orderprice);

		int totalFee = (int) (orderprice * 100); // 单位为分
		String spbillCreateIp = DefinedChars.CREATE_IP;
		String notityUrl = DefinedChars.NOTIFY; // 通知地址
		String tradeType = DefinedChars.TRADE_TYPE; // 交易类型,小程序取值为JSAPI

		String openid = wxappService.findOpenid(rdsession); // 对于小程序来说必填
		/* String openid = "oqw8D0Szqn-ORlRDNuQJftLMOTiA"; */

		String sign = "";
		SortedMap<Object, Object> signParams = new TreeMap<Object, Object>();

		/*
		 * signParams.put("appid", "wxd930ea5d5a258f4f");
		 * signParams.put("mch_id", "10000100"); signParams.put("device_info",
		 * "1000"); signParams.put("body", "test"); signParams.put("nonce_str",
		 * "ibuaiVcKdpRxkhJA");
		 */
		signParams.put("appid", appid);
		signParams.put("mch_id", mchid);
		signParams.put("nonce_str", nonceStr);
		signParams.put("body", body);
		signParams.put("out_trade_no", outTradeno);
		signParams.put("total_fee", totalFee);
		signParams.put("spbill_create_ip", spbillCreateIp);
		signParams.put("notify_url", notityUrl);
		signParams.put("trade_type", tradeType);
		signParams.put("openid", openid);
		sign = createSign("UTF-8", signParams);
		System.out.println("生成的数字签名:" + sign);
		System.out.println(notityUrl);

		String data = "<xml>";
		data += "<appid>" + signParams.get("appid") + "</appid>";
		data += "<body>" + signParams.get("body") + "</body>";
		data += "<mch_id>" + signParams.get("mch_id") + "</mch_id>";
		data += "<nonce_str>" + signParams.get("nonce_str") + "</nonce_str>";
		data += "<notify_url>" + signParams.get("notify_url") + "</notify_url>";
		data += "<openid>" + signParams.get("openid") + "</openid>";
		data += "<out_trade_no>" + signParams.get("out_trade_no")
				+ "</out_trade_no>";
		data += "<spbill_create_ip>" + signParams.get("spbill_create_ip")
				+ "</spbill_create_ip>";
		data += "<total_fee>" + signParams.get("total_fee") + "</total_fee>";
		data += "<trade_type>" + signParams.get("trade_type") + "</trade_type>";
		data += "<sign>" + sign + "</sign></xml>";
		System.out.println("发送的数据为" + data);
		String response = HttpsUtil.httpsRequestToString(
				DefinedChars.UNIFIEDORDER, "POST", data);
		System.out.println("返回的数据为" + response); // 返回的数据是xml形式的

		Document doc = DocumentHelper.parseText(response);
		System.out.println("转换过后" + doc);
		Element rootElement = doc.getRootElement();
		System.out.println("root element: " + rootElement.getName());
		Element element = rootElement.element("return_code");

		System.out.println(element.getData());
		if (element.getData().equals("FAIL"))
			throw new Exception("获取prepay_id失败,"
					+ rootElement.element("return_msg").getData());
		else
			System.out.println("获取prepay_id成功!");

		Element e = rootElement.element("prepay_id");
		String prepayId = (String) e.getData();

		if (verifySign(rootElement, (String) rootElement.element("sign")
				.getData()))
			System.out.println("签名验证成功!");
		else
			throw new Exception("签名验证失败,数据可能被篡改!");

		long timeMillis = System.currentTimeMillis() / 1000;
		String timeStamp = String.valueOf(timeMillis);
		String noncestr = RamdomUtil.generateString(32);
		String packAge = "prepay_id=" + prepayId;
		String signType = "MD5";
		SortedMap<Object, Object> signprepay = new TreeMap<Object, Object>();
		signprepay.put("appId", appid);
		signprepay.put("nonceStr", noncestr);
		signprepay.put("package", packAge);
		signprepay.put("signType", signType);
		signprepay.put("timeStamp", timeStamp);

		for (Map.Entry<Object, Object> entry : signprepay.entrySet()) {
			System.out.println("key= " + entry.getKey() + " and value= "
					+ entry.getValue());
		}

		String prepaysign = createSign("UTF-8", signprepay);
		System.out.println("再次签名的结果为" + prepaysign);

		Map<String, String> map = new HashMap<String, String>();
		map.put("timeStamp", timeStamp);
		map.put("nonceStr", noncestr);
		map.put("package", packAge);
		map.put("signType", "MD5");
		map.put("paySign", prepaysign);

		Returndata returnData = new Returndata("0000", map, "返回支付所需参数");

		return returnData;
	}

	@ResponseBody
	@RequestMapping("/notify")
	public String back(HttpServletRequest request) {
		System.out.println("启动支付回调");
		BufferedReader reader = null;
		try {
			reader = request.getReader();
			String line = "";
			String xmlString = null;
			StringBuffer inputString = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				inputString.append(line);
			}
			xmlString = inputString.toString();
			request.getReader().close();
			System.out.println("接收到的数据如下：---" + xmlString);
			Map<String, String> map = new HashMap<String, String>();
			String resultCode = "";
			String returnCode = "";
			String outTradeNo = "";
			/* map = XmlUtil.doXMLParse(xmlString); */
			SortedMap<Object, Object> signparam = new TreeMap<Object, Object>(); // 数字签名
			Document doc = DocumentHelper.parseText(xmlString);
			Element root = doc.getRootElement();
			for (Iterator it = root.elementIterator(); it.hasNext();) {
				Element element = (Element) it.next();
				map.put(element.getName(), (String) element.getData());
				signparam.put(element.getName(), (String) element.getData());
			}
			String responReturnsign = (String) signparam.get("sign");
			System.out.println("在支付回调中返回的数字签名" + responReturnsign);
			signparam.put("sign", "");
			String newsign = createSign("UTF-8", signparam); // 创建新签名进行对照
			System.out.println("在支付回调中生成的数字签名:" + newsign);

			resultCode = map.get("result_code");
			outTradeNo = map.get("out_trade_no");
			String Sfee = map.get("total_fee");
			int fee = Integer.parseInt(Sfee);
			double totalfee = fee / 100;
			returnCode = map.get("return_code");
			if (responReturnsign == newsign) {
				System.out.println("验证签名成功!");
				System.out.println("支付金额为" + totalfee);
				// 更新数据库订单
				wxappService.handleCustomOrder(outTradeNo);
				System.out.println("订单状态已修改成功!");
				return returnXML(resultCode);
			} else {
				System.out.println("验证签名失败!");
				return returnXML("FAIL");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return returnXML("FAIL");
		}

	}

	// 查询详细订单
	@ResponseBody
	@RequestMapping("/getOrderdetail")
	public Returndata findOrderdetail(HttpServletRequest request)
			throws Exception {
		String orderid = request.getParameter("orderId");
		if (orderid == null)
			throw new Exception("orderId未输入");
		Set<Integer> set = new HashSet<Integer>();
		List<GoodsReturn> orderdetail = wxappService
				.findCustomOrderdetail(orderid);
		List<GoodsUnit> goodsunit = new ArrayList<GoodsUnit>();

		int lastgoodstype = orderdetail.get(orderdetail.size() - 1)
				.getCustomOrderDetail().getGoodstypeid();

		for (GoodsReturn goodsReturn : orderdetail) {
			if (set.add(goodsReturn.getCustomOrderDetail().getGoodstypeid())) {
				GoodsUnit onegoods = new GoodsUnit();
				onegoods.setGoodsName(goodsReturn.getGoodsName());
				onegoods.setGoodssalePrice(goodsReturn.getCustomOrderDetail()
						.getSaleprice());
				onegoods.setGoodsSpec(goodsReturn.getGoodsSpec());
				onegoods.setGoodsSum(1);
				onegoods.setGoodsUnit(goodsReturn.getGoodsUnit());
				onegoods.setOrderid(goodsReturn.getCustomOrderDetail()
						.getOrderid());
				onegoods.setGoodsType(goodsReturn.getCustomOrderDetail()
						.getGoodstypeid());
				onegoods.setGoodsPic(wxappService.findgoodsPic(onegoods.getGoodsType()));
				goodsunit.add(onegoods);
			} else {
				for (int i = 0; i < goodsunit.size(); i++) {
					if (goodsunit.get(i).getGoodsType() == goodsReturn
							.getCustomOrderDetail().getGoodstypeid())
						goodsunit.get(i).setGoodsSum(
								goodsunit.get(i).getGoodsSum() + 1);
				}
			}
		}
		for (int i = 0; i < goodsunit.size(); i++) {
			if (goodsunit.get(i).getGoodsType() == lastgoodstype) {
				GoodsUnit firstgoods = new GoodsUnit();
				GoodsUnit lastgoods = new GoodsUnit();
				firstgoods = goodsunit.get(0);
				lastgoods = goodsunit.get(i);
				goodsunit.set(0, lastgoods);
				goodsunit.set(i, firstgoods);
			}
		}

		if (orderdetail != null)
			Collections.reverse(orderdetail);
		/*
		 * Returndata returndata = new Returndata("600", orderdetail,
		 * "SUCCESS");
		 */
		Returndata returndata = new Returndata(DefinedChars.SUCCESSCODE,
				goodsunit, "SUCCESS");
		return returndata;
	}

	// 查询支付结果
	@ResponseBody
	@RequestMapping("/getOrderstate")
	public Map<String, String> findOrderstate(HttpServletRequest request)
			throws Exception {
		String outTradeno = request.getParameter("orderId");
		if (outTradeno == null)
			throw new Exception("orderId未输入");
		String appid = DefinedChars.APPID;
		String mchid = DefinedChars.MCH_ID;
		String nonceStr = RamdomUtil.generateString(32);
		SortedMap<Object, Object> signparam = new TreeMap<Object, Object>();
		signparam.put("appid", appid);
		signparam.put("mch_id", mchid);
		signparam.put("nonce_str", nonceStr);
		signparam.put("out_trade_no", outTradeno);
		String sign = createSign("UTF-8", signparam);
		System.out.println("获取账单信息生成的数字签名为:" + sign);
		String data = "<xml>";
		data += "<appid>" + appid + "</appid>";
		data += "<mch_id>" + mchid + "</mch_id>";
		data += "<nonce_str>" + nonceStr + "</nonce_str>";
		data += "<out_trade_no>" + outTradeno + "</out_trade_no>";
		data += "<sign>" + sign + "</sign>";
		data += "</xml>";
		System.out.println("查询订单发送的数据为" + data);
		String response = HttpsUtil.httpsRequestToString(
				DefinedChars.QUERYORDER, "POST", data);
		System.out.println("查询订单返回的数据为" + response); // 返回的数据是xml形式的
		Document doc = DocumentHelper.parseText(response);
		Element rootElement = doc.getRootElement();
		Element element = rootElement.element("return_code");
		String returnCode = (String) element.getData();
		if (returnCode.equals("SUCCESS")) {
			Element stateElement = rootElement.element("trade_state");
			String state = (String) stateElement.getData();
			if (state.equals("SUCCESS"))
				wxappService.handleCustomOrder(outTradeno);
			Map<String, String> map = new HashMap<String, String>();
			map.put("state", state);
			return map;
		} else {
			throw new Exception("查询订单状态失败!");
		}
	}

	public Map<String, String> getCustomorderstate(String orderid)
			throws Exception {
		String outTradeno = orderid;
		if (outTradeno == null)
			throw new Exception("orderId未输入");
		String appid = DefinedChars.APPID;
		String mchid = DefinedChars.MCH_ID;
		String nonceStr = RamdomUtil.generateString(32);
		SortedMap<Object, Object> signparam = new TreeMap<Object, Object>();
		signparam.put("appid", appid);
		signparam.put("mch_id", mchid);
		signparam.put("nonce_str", nonceStr);
		signparam.put("out_trade_no", outTradeno);
		String sign = createSign("UTF-8", signparam);
		System.out.println("获取账单信息生成的数字签名为:" + sign);
		String data = "<xml>";
		data += "<appid>" + appid + "</appid>";
		data += "<mch_id>" + mchid + "</mch_id>";
		data += "<nonce_str>" + nonceStr + "</nonce_str>";
		data += "<out_trade_no>" + outTradeno + "</out_trade_no>";
		data += "<sign>" + sign + "</sign>";
		data += "</xml>";
		System.out.println("查询订单发送的数据为" + data);
		String response = HttpsUtil.httpsRequestToString(
				DefinedChars.QUERYORDER, "POST", data);
		System.out.println("查询订单返回的数据为" + response); // 返回的数据是xml形式的
		Document doc = DocumentHelper.parseText(response);
		Element rootElement = doc.getRootElement();
		Element element = rootElement.element("return_code");
		String returnCode = (String) element.getData();
		if (returnCode.equals("SUCCESS")) {
			Element errElement = rootElement.element("err_code");
			if(errElement!=null)
			{	
			String err = (String)errElement.getData();
			if(err.equals("ORDERNOTEXIST"))
				return null;
			}
			Element stateElement = rootElement.element("trade_state");
			String state = (String) stateElement.getData();
			if (state.equals("SUCCESS"))
				wxappService.handleCustomOrder(outTradeno);
			Map<String, String> map = new HashMap<String, String>();
			map.put("state", state);
			return map;
		} else {
			throw new Exception("查询订单状态失败!");
		}
	}

	@RequestMapping("/userAmount")
	@ResponseBody
	public Returndata getCustomNopay(HttpServletRequest request)
			throws Exception {
		String rdsession = request.getParameter("rdSession");
		if (rdsession == null)
			throw new Exception("rdSession未输入");
		double nopay = wxappService.findCustomNopay(rdsession);
		CustomOrder order;
		List<CustomOrder> nopayCustomOrderlist = wxappService
				.findNopayCustomOrder(rdsession);
		if (nopayCustomOrderlist != null) {
			Iterator<CustomOrder> it = nopayCustomOrderlist.iterator();
			while (it.hasNext()) {
				CustomOrder customorder = it.next();
				getCustomorderstate(customorder.getOrderid());
			}
			
			nopay = wxappService.findCustomNopay(rdsession);
			nopayCustomOrderlist = wxappService.findNopayCustomOrder(rdsession);
			
			if (nopayCustomOrderlist != null)
				order = nopayCustomOrderlist.get(0);
			else
				order = null;
		} else
			order = null;
		Map<String, Object> map = new HashMap<String, Object>();
		// 格式化输出
		nopay = NumberUtil.formatDouble(nopay);
		map.put("nopay", nopay);
		map.put("nopayorder", order);
		Returndata returndata = new Returndata(DefinedChars.SUCCESSCODE, map,
				"SUCCESS");
		return returndata;
	}


	public static boolean verifySign(Element root, String sign) {
		SortedMap<Object, Object> signparam = new TreeMap<Object, Object>();
		for (Iterator it = root.elementIterator(); it.hasNext();) {
			Element element = (Element) it.next();
			System.out.println(element.getName() + ":" + element.getData());
			signparam.put(element.getName(), (String) element.getData());
		}
		signparam.put("sign", "");
		String verifysign = createSign("UTF-8", signparam);
		System.out.println("签名验证的结果为" + verifysign);
		if (verifysign.equals(sign))
			return true;
		else
			return false;
	}

	private static String createSign(String characterEncoding,
			SortedMap<Object, Object> parameters) {
		StringBuffer sb = new StringBuffer();
		Set<Entry<Object, Object>> es = parameters.entrySet();
		Iterator<Entry<Object, Object>> it = es.iterator();
		while (it.hasNext()) {
			Entry<Object, Object> entry = it.next();
			String k = (String) entry.getKey();
			Object v = entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k)
					&& !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + DefinedChars.API_KEY);
		String sign = MD5Encode(sb.toString(), characterEncoding).toUpperCase();
		return sign;
	}

	private static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname))
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes()));
			else
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes(charsetname)));
		} catch (Exception exception) {
		}
		return resultString;
	}

	// MD5Util工具类中相关的方法
	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	private String returnXML(String return_code) {

		return "<xml><return_code><![CDATA["

		+ return_code

		+ "]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
	}

	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
}
