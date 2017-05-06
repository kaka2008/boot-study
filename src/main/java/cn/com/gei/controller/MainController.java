package cn.com.gei.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统一处理500和404页面，错误后，Spring boot会默认调用这里
 * 
 * @author weizhankui
 *
 */
@RestController
public class MainController implements ErrorController {

	private final static Log logger = LogFactory.getLog(MainController.class);

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping("/error")
	public Object handleError(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		logger.info("statusCode = " + statusCode);
		if (statusCode == 404) {
			return "找不到页面";
		} else if (statusCode == 403) {
			return "无权限";
		} else {
			return "系统错误";
		}
	}

}
