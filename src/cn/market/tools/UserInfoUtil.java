package cn.market.tools;

/**
 * 返回URL是让用户去访问的，当用户进入该URL后，如果用户同意授权，微信服务器收到请求，页面将跳转至 redirect_uri/?code=CODE&state=STATE，也就是你的外网访问网址，携带两个参数，一个为code，一个为state
 * @author Administrator
 *
 */
public class UserInfoUtil {
	//获取code的请求地址
    public static String Get_Code = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=STAT#wechat_redirect";
    //替换字符串
    public static String getCode(String APPID, String REDIRECT_URI,String SCOPE) {
        return String.format(Get_Code,APPID,REDIRECT_URI,SCOPE);
    }
    //获取Web_access_tokenhttps的请求地址                https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code
    // wx5bbc2973ea2fd353
    //cceef78dae5a70da64be8c07b532f32d
    public static String Web_access_tokenhttps = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
    //替换字符串
    public static String getWebAccess(String CODE) {
        return String.format(Web_access_tokenhttps,DefinedChars.APPID,DefinedChars.SECRET,CODE);
    }
    
    //拉取用户信息的请求地址
    public static String User_Message = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";
    //替换字符串
    public static String getUserMessage(String access_token, String openid) {
        return String.format(User_Message, access_token,openid);
    }
    
    //获取二维码需要的accesstoken
    public static String Web_get_accesstoken = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    public static String getAccesstoken()
    {
    	return String.format(Web_get_accesstoken, DefinedChars.APPID, DefinedChars.SECRET);
    }
    
    //获取二维码的URL
    public static String two_bar_code = "https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token=%s";
    public static String getTwobarcode(String access)
    {
    	return String.format(two_bar_code, access);
    }
}
