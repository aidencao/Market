package cn.market.mqtt;

import java.security.KeyStore;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.market.controller.getUserInfoController;
import cn.market.pojo.Globalack;
import cn.market.pojo.MachineInfo;
import cn.market.service.MachineService;
import cn.market.service.WxappService;
import cn.market.tools.NumberUtil;

public class MarketMqttClient implements ServletContextListener{
	private static MqttClient client = null;
	private static MachineService machineService;
	private static WxappService wxappService;
	public static Logger logger = Logger.getLogger(getUserInfoController.class);
	static MqttConnectOptions options;
	
	public static void init() throws Exception {
		
		String endpoint = "ssl://neumarket.mqtt.iot.gz.baidubce.com:1884"; // 输入创建endpoint返回的SSL地址ssl://uestctest.mqtt.iot.gz.baidubce.com:1884
		String username = "neumarket/server"; // 输入创建thing返回的username uestctest/server
		String password = "J2F5RWVC/fAnvb89zO7a14BxsH+YYXd9mf26At/DLKw="; // 输入创建principal返回的password NKwOK6dpyy7EGfhqZsWT7Anv3Dyw6OuJWsblrGWCocI=
		/*
		 * String endpoint = "ssl://uestctest.mqtt.iot.gz.baidubce.com:1884";
		 * //输入创建endpoint返回的SSL地址 String username = "uestctest/device_1";
		 * //输入创建thing返回的username String password =
		 * "0e+4RE9ghvs28xIcbHJsyB0jy660njwG4m5yYC36YSk="; //输入创建principal返回的password
		 * String topic = "topic_1"; //订阅的消息主题，本例是指订阅b号楼第五层的温度
		 */
		TrustManagerFactory tmf = TrustManagerFactory.getInstance("X509");
		tmf.init((KeyStore) null);
		TrustManager[] trustManagers = tmf.getTrustManagers();

		SSLContext ctx = SSLContext.getInstance("TLS");
		ctx.init(null, trustManagers, null);

		options = new MqttConnectOptions();
		options.setCleanSession(false);// 设为断线重连后仍能收到短线时的消息
		options.setUserName(username);
		options.setPassword(password.toCharArray());
		options.setSocketFactory(ctx.getSocketFactory());
		options.setAutomaticReconnect(true);// 启动自动重连

		client = new MqttClient(endpoint, "marketServer");
		client.connect(options);

		// 默认事件处理
		client.setCallback(new MqttCallback() {
			public void connectionLost(Throwable cause) {
				System.out.println("连接失败,原因:" + cause);
				cause.printStackTrace();
			}

			public void messageArrived(String topic, MqttMessage message) throws Exception {
				System.out.println(
						"接收到消息,来至Topic [" + topic + "] , 内容是:[" + new String(message.getPayload(), "UTF-8") + "],  ");
			}

			public void deliveryComplete(IMqttDeliveryToken token) {
				// 如果是QoS0的消息，token.resp是没有回复的
				System.out.println("消息发送成功! "
						+ ((token == null || token.getResponse() == null) ? "null" : token.getResponse().getKey()));
			}
		});

		// 关注上货信息并给出处理
		client.subscribe("load/#", new IMqttMessageListener() {

			public void messageArrived(String topic, MqttMessage message) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("收到来自“" + topic + "”的消息，消息内容为：" + new String(message.getPayload(), "UTF-8"));
				// 模拟处理
				System.out.println("模拟处理。。。。。。");
				System.out.println("收到来自" + getNum(topic) + "号柜机的上货消息。");
				String context  = new String(message.getPayload(), "UTF-8");
				try {
					String macid = getNum(topic);
					String[]str = context.split(":");
					String place = str[0];
					String state = str[1];
					machineService.handleExhibit(macid, place, state);
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		});
		
		//订阅ack open时候的确认
		client.subscribe("ack/#", new IMqttMessageListener() {

			public void messageArrived(String topic, MqttMessage message) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("收到来自“" + topic + "”的消息，消息内容为：" + new String(message.getPayload(), "UTF-8"));
				// 模拟处理
				System.out.println("模拟处理。。。。。。");
				System.out.println("收到来自" + getNum(topic) + "号柜机的确认消息。");
				logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>**********************@@@@@@@@@@@@@@@@@$$$$$$$$$$$$$$"+"收到来自" + getNum(topic) + "号柜机的确认消息：" + new String(message.getPayload(), "UTF-8"));
				String macid = getNum(topic);
				Globalack.ackmap.put(macid, System.currentTimeMillis());
				System.out.println("更新完毕"+Globalack.ackmap.get(macid));
			}
		});

		// 关注关门信息并给出处理
		client.subscribe("close/#", new IMqttMessageListener() {

			public void messageArrived(String topic, MqttMessage message) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("收到来自“" + topic + "”的消息，消息内容为：" + new String(message.getPayload(), "UTF-8"));
				// 模拟处理
				System.out.println("模拟处理。。。。。。");
				System.out.println("收到来自" + getNum(topic) + "号柜机的关门消息。");
				logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>**********************@@@@@@@@@@@@@@@@@$$$$$$$$$$$$$$"+"收到来自" + getNum(topic) + "号柜机的关门消息。");
				try {
					machineService.close(getNum(topic));
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.toString());
				}
				
			}
		});

		// 关注取货信息并给出处理
		client.subscribe("take/#", new IMqttMessageListener() {

			public void messageArrived(String topic, MqttMessage message) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("收到来自“" + topic + "”的消息，消息内容为：" + new String(message.getPayload(), "UTF-8"));
				System.out.println(
						"收到来自" + getNum(topic) + "号柜机的取货消息消息，格子编号为：" + new String(message.getPayload(), "UTF-8"));
				String context = new String(message.getPayload(), "UTF-8");
				
				logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>**********************@@@@@@@@@@@@@@@@@$$$$$$$$$$$$$$"+"收到来自" + getNum(topic) + "号柜机的取货消息消息，格子编号为：" + new String(message.getPayload(), "UTF-8"));
				//判断是否是数字
				if(!NumberUtil.isNumeric(context))
				{	
					System.out.println("盒子编号输入格式错误");
					return;
				}
				int boxno = Integer.parseInt(context);
				boxno += 1;
				try {
					machineService.buy(getNum(topic), boxno);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.toString());
				}
			}
		});
		
		
		
		//接收初始化信息
		client.subscribe("init/#", new IMqttMessageListener() {

					public void messageArrived(String topic, MqttMessage message) throws Exception {
						// TODO Auto-generated method stub
						System.out.println("收到来自“" + topic + "”的消息，消息内容为：" + new String(message.getPayload(), "UTF-8"));
						// 模拟处理
						System.out.println("模拟处理。。。。。。");
						System.out.println("收到来自" + getNum(topic) + "号柜机的初始化消息。");
						logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>**********************@@@@@@@@@@@@@@@@@$$$$$$$$$$$$$$"+"收到来自" + getNum(topic) + "号柜机的初始化消息：" + new String(message.getPayload(), "UTF-8"));
						String macid = getNum(topic);
						String context = new String(message.getPayload(), "UTF-8");
						try {
							String[]str = context.split(":");
							if(str[0].equals("init"))
							{
								String state = str[1];
								String version = str[2];
								String backstate = str[3];
								
								if(backstate.equals("open"))
								{
									machineService.handleBackdoorOpen(macid, state);
								}
								else if(backstate.equals("close"))
								{
									machineService.handleBackdoorClose(macid, state, version);
								}
							}
						} catch (Exception e) {
							// TODO: handle exception
							logger.debug(e.toString());
						}
						
					}
				});
		
		// 关注异常信息并给出处理
		client.subscribe("error/#", new IMqttMessageListener() {

			public void messageArrived(String topic, MqttMessage message) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("收到来自“" + topic + "”的消息，消息内容为：" + new String(message.getPayload(), "UTF-8"));
				// 模拟处理
				System.out.println("模拟处理。。。。。。");
				System.out.println(
						"收到来自" + getNum(topic) + "号柜机的异常消息消息，异常编号为：" + new String(message.getPayload(), "UTF-8"));
				logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>**********************@@@@@@@@@@@@@@@@@$$$$$$$$$$$$$$"+"收到来自" + getNum(topic) + "号柜机异常消息：" + new String(message.getPayload(), "UTF-8"));
				String context = new String(message.getPayload(), "UTF-8");
				
				try {
					String[]str = context.split(":");
					String macid = getNum(topic);
					if(str[0].equals("exc"))
					{
						String state = str[1];
						if(state.equals("open"))
							machineService.handleException(macid, state, null);
						else if(state.equals("dropped"))
						{
							machineService.handleDropped(macid);
						}
						else if(state.equals("lowpower"))
						{
							String powerstr = str[2];
							int power = Integer.parseInt(powerstr);
							machineService.handleLowpower(macid, power);
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					logger.debug(e.toString());
				}
			}
		});
	}

	// 获取主题编号的方法
	private static String getNum(String topic) {
		int i = topic.indexOf('/') + 1;
		return topic.substring(i);
	}

	public static boolean send(String topic,String content)  {
		MqttMessage message = new MqttMessage();
		message.setPayload(content.getBytes());
		System.out.println(topic);
		logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>**********************@@@@@@@@@@@@@@@@@$$$$$$$$$$$$$$"+topic);
		try {
			client.publish(topic, message);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			/*System.out.println("发送消息失败:"+e.toString());*/
			logger.debug("发送消息失败:"+e.toString());
			if(!client.isConnected())
				try {
					logger.debug("重连中");
					String endpoint = "ssl://uestctest.mqtt.iot.gz.baidubce.com:1884";
					client = new MqttClient(endpoint, String.valueOf(System.currentTimeMillis()));
					client.connect(options);
					logger.debug("重连成功");
				} catch (MqttSecurityException e1) {
					// TODO Auto-generated catch block
					logger.debug(e1.toString());
				} catch (MqttException e1) {
					// TODO Auto-generated catch block
					logger.debug(e1.toString());
				}
			return false;
		}	
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		machineService = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext()).getBean(MachineService.class);

		try {
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
