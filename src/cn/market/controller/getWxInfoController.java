package cn.market.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.market.pojo.Banner;
import cn.market.pojo.Returndata;
import cn.market.pojo.Title;
import cn.market.service.WxappService;
import cn.market.tools.DefinedChars;
import cn.market.tools.ReadFile;

import org.apache.commons.lang.StringUtils; 

@Controller
@RequestMapping("/wxapp")
public class getWxInfoController {
	@Resource
	private WxappService wxappService;

	public static Logger logger = Logger.getLogger(getUserInfoController.class);

	@RequestMapping("/banner/list")
	@ResponseBody
	public Returndata getbanner() {
		List<Banner> bannerlist = new ArrayList<Banner>();
		
		for(int i = 1 ; i <4 ; i ++)
		{
		Banner banner = new Banner();
		banner.setBusinessId(i);
		/*banner.setPicUrl("http://ot308644c.bkt.clouddn.com/signalslotimg1.png");*/
		banner.setPicUrl("https://www.blue-turtle.cn/AutoSeller/img/banner"+i+".png");
		bannerlist.add(banner);
		}
		Returndata returndata = new Returndata(DefinedChars.SUCCESSCODE,
				bannerlist, "SUCCESS");
		return returndata;
	}

	/*@RequestMapping("/notice/list")
	@ResponseBody
	public Returndata getnotice() {
		List<Title> titlelist = new ArrayList<Title>();
		for (int i = 1; i < 4; i++) {
			Title title = new Title();
			title.setId(i);
			title.setTitle(i + "欢迎使用自动售货机");
			titlelist.add(title);
		}
		Returndata returndata = new Returndata(DefinedChars.SUCCESSCODE,
				titlelist, "SUCCESS");
		return returndata;
	}*/
	
	@RequestMapping("/notice/list")
	@ResponseBody
	public Returndata readnotice(HttpServletRequest request)
	{
		/*String path = "https://www.blue-turtle.cn/AutoSeller/notice/notice1.txt";
		System.out.println(path);*/
		List<Title> titlelist = new ArrayList<Title>();
		/*String localaddress = request.getSession().getServletContext().getRealPath("/")+"upload/"+"notice"+".txt";
		List<String> readfile = readfile(localaddress);*/
		for(int i = 1; i<4; i++)
		{
			String path = "https://www.blue-turtle.cn/AutoSeller/notice/notice"+i+".txt";
			List<String> file = ReadFile.getFile(path);
			Title title = new Title();
			title.setId(i);
			/*System.out.println(readfile.get(i-1));*/
			title.setTitle(file.get(0));
			titlelist.add(title);
		}
		Returndata returndata = new Returndata(DefinedChars.SUCCESSCODE,
					titlelist, "SUCCESS");
		return returndata;
	}
	
	@RequestMapping("/notice/detail")
	@ResponseBody
	public Returndata noticeData(HttpServletRequest request) throws Exception
	{
		String Strid = request.getParameter("id");
		if(Strid == null)
			throw new Exception("未输入id");
		int id = Integer.parseInt(Strid);
		String path = "https://www.blue-turtle.cn/AutoSeller/notice/notice"+id+".txt";
		List<String> file = ReadFile.getFile(path);
		Map<String, Object>map = new HashMap<String, Object>();
		List<String> content = new ArrayList<String>();
		for(int  i = 1; i < file.size()-1; i++)
		{
			String contentlet =  file.get(i);
			System.out.println(contentlet);
			content.add(contentlet);
		}
		String contentstr = "";
		contentstr += "<div style=\"margin-top:10px; text-align:center; font-size:20px; font-weight:bold\">";
		contentstr += file.get(0)+ "</div>";
		for(int i = 0 ; i < content.size(); i++)
		{
			contentstr += "<div style=\"margin-top:10px; text-align:center; font-size:14px\">";
			contentstr += content.get(i) + "</div>";
		}
		System.out.println(contentstr);
		map.put("content", contentstr);
		map.put("dateAdd", file.get(file.size()-1));
		map.put("id", id);
		map.put("title",  file.get(0));
		Returndata returndata = new Returndata(DefinedChars.SUCCESSCODE, map, "SUCCESS");
		return returndata;
	}
	
	public List<String> readfile(String path)
	{
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null; //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
		List<String> list = new ArrayList<String>();
		 try {
			   String str = "";
			   String str1 = "";
			   fis = new FileInputStream(path);// FileInputStream
			   // 从文件系统中的某个文件中获取字节
			   isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
			   br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
			   while ((str = br.readLine()) != null) {
				list.add(str);
			    str1 += str + "\n";
			   }
			   // 当读取的一行不为空时,把读到的str的值赋给str1
			   System.out.println(str1);// 打印出str1
			  } catch (FileNotFoundException e) {
			   System.out.println("找不到指定文件");
			  } catch (IOException e) {
			   System.out.println("读取文件失败");
			  } finally {
			   try {
			     br.close();
			     isr.close();
			     fis.close();
			    // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
			   } catch (IOException e) {
			    e.printStackTrace();
			   }
			  }
		return list;
	}
}
