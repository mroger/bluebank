package br.com.bluebank.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
class CorsFilter implements Filter {
	
	//TODO Inject value
	//@Value("${schedule.alloworigin}")
	//private String allowOrigin;

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:9000");
		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
		response.setHeader("Access-Control-Max-Age", "3600");
		if (!((HttpServletRequest) req).getMethod().equals("OPTIONS")) {
			chain.doFilter(req, res);
		} else {
		}
	}

	public void init(FilterConfig filterConfig) { }

	public void destroy() { }

}