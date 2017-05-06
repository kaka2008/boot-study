package cn.com.gei.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.gei.dao2.UserMapper2;
import cn.com.gei.entity.User;

@Service("userService2")
@Transactional(propagation = Propagation.REQUIRED, transactionManager = "springTransactionManager2") // 配置事务
public class UserServiceImpl2 implements IUserService2 {
	@Autowired
	private UserMapper2 userMapper2;

	@Override
	public User getUserByName(String name) {
		return userMapper2.findUserInfo(name);
	}

	@Override
	public void testTran() {
		userMapper2.deleteById(10);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int a = 0 / 0;
		userMapper2.findUserInfo("7player");
	}

	@Override
	public void saveUser(User user) {
		userMapper2.insertUser(user);
	}

	@Override
	public void deleteById(int id) {
		userMapper2.deleteById(id);
	}

}
