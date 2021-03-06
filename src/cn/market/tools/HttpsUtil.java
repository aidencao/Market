package cn.market.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * 以https方式发送请求的工具类
 * 
 * @author Administrator
 *
 */
public class HttpsUtil {
	/**
	 * 以https方式发送请求并将请求响应内容以String方式返回
	 *
	 * @param path  请求路径
	 * @param method    请求方法
	 * @param body   请求数据体
	 * @return 请求响应内容转换成字符串信息
	 */
	public static String httpsRequestToString(String path, String method, String body) {
		if (path == null || method == null) {
			return null;
		}

		String response = null;
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		HttpsURLConnection conn = null;
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			TrustManager[] tm = {new X509TrustManager(){
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
				@Override
				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
				@Override
				public X509Certificate[] getAcceptedIssuers() {return null;}
				
			}};
			sslContext.init(null, tm, new java.security.SecureRandom());

			// 从上述对象中得到SSLSocketFactory
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			System.out.println("请求网址："+path);

			URL url = new URL(path);
			conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);

			// 设置请求方式（get|post）
			conn.setRequestMethod(method);

			// 有数据提交时
			if (null != body) {
				OutputStream outputStream = conn.getOutputStream();
				outputStream.write(body.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			inputStream = conn.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			response = buffer.toString();
		} catch (Exception e) {

		} finally {
			if (conn != null) {
				conn.disconnect();
			}
			try {
				bufferedReader.close();
				inputStreamReader.close();
				inputStream.close();
			} catch (IOException execption) {

			}
		}
		return response;
	}
	/** 
	 * 自定义信任管理器类 
	 * 自定义信任管理器类的所有方法都是空的实现，表示信任任何服务器端、客户端的证书。 
	 */  
	class JEEWeiXinX509TrustManager implements X509TrustManager {
		
		//检查客户端的证书，若不信任该证书则抛出异常。由于不需要对客户端进行认证，因此只需要执行默认的信任管理器的这个方法。
		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
		//检查服务器的证书，若不信任该证书同样抛出异常。不做任何处理
		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
		//返回受信任的X509证书数组
		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	}
}