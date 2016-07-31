package cn.com.gei.controller.user;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.gei.entity.User;
import cn.com.gei.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private Log logger = LogFactory.getLog(UserController.class);
	@Autowired
	private IUserService userService;

	@RequestMapping("/{userName}")
	public User getByName(@PathVariable String userName) {
		System.out.println("userName = " + userName);
		logger.error("出错了。。。");
		return userService.getUserByName(userName);
	}

	@RequestMapping("/test_trans")
	public String testTransaction() {
		userService.testTran();
		return "test transaction";
	}

	@RequestMapping("/delete_by_id/{id}")
	public String deleteById(@PathVariable int id) {
		userService.deleteById(1);
		return "删除成功";
	}

	@RequestMapping(value = "/save_user", method = RequestMethod.POST)
	public String saveUser(@RequestParam long id, @RequestParam String name,
			@RequestParam int age, @RequestParam String password) {
		User user = new User();
		user.setAge(age);
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		userService.saveUser(user);
		logger.error("出错了。。。");
		return "保存成功";
	}

}
