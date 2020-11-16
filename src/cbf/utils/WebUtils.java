package cbf.utils;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import cbf.exception.WebException;

public class WebUtils {
	
	private WebUtils(){}
	
	public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass) {
		
		try {
			T bean = beanClass.newInstance();
			
			// 注册转换器
//			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			Enumeration e = request.getParameterNames();
			
			while(e.hasMoreElements()) {
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				System.out.println("name="+name+" value="+value);
				BeanUtils.setProperty(bean, name, value);
			}
			
			return bean;
		} catch (Exception e) {
			throw new WebException(e);
		}
		
	}
	
	//针对个人信息修改专用
public static <T> T request2Bean2(HttpServletRequest request, Class<T> beanClass) {
		
		try {
			T bean = beanClass.newInstance();
			
			// 注册转换器
//			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			Enumeration e = request.getParameterNames();
			
			while(e.hasMoreElements()) {
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				if (name.equals("level")) {
					if (value.equals("管理员")) {
						value = "2";
					}else if (value.equals("工作者")){
						value = "1";
					}else {
						value = "0";
					}
				}
//				System.out.println("name="+name+" value="+value);
				BeanUtils.setProperty(bean, name, value);
			}
			
			return bean;
		} catch (Exception e) {
			throw new WebException(e);
		}
		
	}
//针对添加用户所用
public static <T> T request2Bean3(HttpServletRequest request, Class<T> beanClass) {
	
	try {
		T bean = beanClass.newInstance();
		
		// 注册转换器
//		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		Enumeration e = request.getParameterNames();
		boolean b = false;
		while(e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String value = request.getParameter(name);
			if (name.equals("level")) {
				b = true;
			}
//			System.out.println("name="+name+" value="+value);
			BeanUtils.setProperty(bean, name, value);
		}
		if (!b) {
			String name = "level";
			String value = "-1";
			BeanUtils.setProperty(bean, name, value);
//			System.out.println("name1="+name+" value1="+value);
		}
		return bean;
	} catch (Exception e) {
		throw new WebException(e);
	}
	
}
	
	// 拷贝bean 的属性
	public static void copyBean(Object dest, Object orig) {
		
		try {
			// 注册转换器
//			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(dest, orig);
		} catch (Exception e) {
			throw new WebException(e);
		}
		
	}

}
