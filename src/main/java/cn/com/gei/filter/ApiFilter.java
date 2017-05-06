package cn.com.gei.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * 演示filter如何使用
 * 
 * @author gei
 *
 */
@WebFilter(filterName = "apiFilter", urlPatterns = "/user/*")
public class ApiFilter implements Filter {
	@Value("${api.token}") // 通过@Value可以获取application.properties中值
	private String token;

	private final static Log logger = LogFactory.getLog(ApiFilter.class);

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {

		logger.info("token = " + token);

		// 如果跨域（cors），可以在这里加header
		HttpServletResponse response = (HttpServletResponse) arg1;

		response.addHeader("Access-Control-Allow-Origin", "http://www.test.com");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin,No-Cache,X-Requested-With,If-Modified-Since,Pragma,Last-Modified,Cache-Control,Expires,Content-Type,X-E4M-With,apikey");

		/// 业务逻辑
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
