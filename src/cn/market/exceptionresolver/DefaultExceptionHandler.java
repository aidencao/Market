package cn.market.exceptionresolver;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.alibaba.fastjson.support.spring.annotation.FastJsonView;

public class DefaultExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception) {
		// TODO Auto-generated method stub
		ModelAndView mv = new ModelAndView();
		FastJsonJsonView view = new FastJsonJsonView();
		Map<String,Object>attributes = new LinkedHashMap<String, Object>();
		String temp = exception.toString();
		Object data = temp;
		String[] split = temp.split(":");
		attributes.put("code", 500);
		attributes.put("data", split[1] );
		attributes.put("message", "Error");
		
		
		view.setAttributesMap(attributes);
		mv.setView(view);
		return mv;
	}

}
