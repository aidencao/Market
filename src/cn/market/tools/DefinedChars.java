package cn.market.tools;

/**
 * 自定义的各种字符串
 * 
 * @author Administrator
 *
 */
public class DefinedChars {
	
	//小程序id
	public static final String APPID = "wx6620db08687f9873";
	//wx5b4b30d527cfc1fb wxaa934a72ca9ca314
	
	//小程序秘钥
	public static final String SECRET = "40aca1bed6ddb769a1118355bb302a68";
	//a7cf6ecbaa901f91c64d874096bb12e7 a12b6f346f888e1b90391059741874bd
	
	//rdsesion长度
	public static final int CHECKLENGTH = 16;
	
	//商户ID
	public static final String MCH_ID = "1498364822";
	
	//终端IP
	public static final String CREATE_IP = "118.24.27.69";
	
	//统一订单随机串长度
	public static final Integer NONCE = 32;
	
	//微信小程序支付方式
	public static final String TRADE_TYPE = "JSAPI";
	
	//微信通知返回地址
	public static final String NOTIFY = "https://www.blue-turtle.cn/VendMac/wxapp/notify";
	
	//API密钥
	public static final String API_KEY = "uestc711Ayqp39bACYkpc7vxzituvc3h";
	
	//统一下单API
	public static final String UNIFIEDORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	
	//查询支付状态API
	public static final String QUERYORDER = "https://api.mch.weixin.qq.com/pay/orderquery";
	
	//已支付状态
	public static final int PAID = 1;
	
	//未支付状态
	public static final int UNPAID = 0;
	
	//成功返回的code
	public static final String SUCCESSCODE = "600";
	
	//访问地址
	public static final String PROJECTURL = "https://www.blue-turtle.cn/VendMac";
	
	//七牛云地址
	public static final String QINIU = "http://ozqyhdnqv.bkt.clouddn.com/";
	
	//全局测试变量
	public static int i = 0;
}
