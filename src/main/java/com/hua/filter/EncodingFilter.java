package com.hua.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �ַ���Ź�����
 * ѡ��utf-8
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/*" })
public class EncodingFilter extends HttpFilter{
	
	
	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		// ����Ҫ���˵ľ�̬��Դ����
		String[] urls = {"/login","/json",".css",".js",".ico",".jpg",".png"};
		String path = request.getServletPath();
		boolean b = false;
		for (String url : urls) {
			if(path.contains(url)){
				b = true;
				break;
			}
		}
		// ���Ǿ�̬��ԴҪ���ñ���
		if(!b){
			response.setContentType("text/html;charset=utf-8");
		}
		filterChain.doFilter(request, response);
	}
}
