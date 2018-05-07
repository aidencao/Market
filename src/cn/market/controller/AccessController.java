package cn.market.controller;

import java.io.File;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import cn.market.service.WxappService;

@Controller
@RequestMapping("/wxapp")
public class AccessController {
	@Resource
	private WxappService wxappService;
	@RequestMapping("/fileUpload")
	@ResponseBody
	//必须使用post方法才有效
	public void fileUpload(HttpServletRequest request) throws Exception{
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
		if(multipartResolver.isMultipart(request))
		{
			/*System.out.println("进入");*/
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
			Iterator iter = multiRequest.getFileNames();
			
			while(iter.hasNext())
			{
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if(file!=null)
				{
					/*String localaddress = request.getSession().getServletContext().getRealPath("/")+"images/"+macid+".png";*/
					String path = request.getSession().getServletContext().getRealPath("/")+"upload/"+file.getOriginalFilename();
					System.out.println(path);
					/*System.out.println("目前路径:"+path);*/
					file.transferTo(new File(path));
				}
			}
		}
	}
}
