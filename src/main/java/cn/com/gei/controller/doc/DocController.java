package cn.com.gei.controller.doc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doc")
public class DocController {
	@RequestMapping("/test")
	public String helloworld() {
		return "hello world test";
	}
}
