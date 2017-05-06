package cn.com.gei.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.gei.dao.UserMapper;
import cn.com.gei.entity.User;

@Service("userService")
@Transactional(propagation = Propagation.REQUIRED) // 配置事务
// @Transactional(propagation = Propagation.REQUIRED, transactionManager =
// "springTransactionManager")
// //这样写也可以，但注意，不要把transactionManager写错了，要写成对应的transactionManager
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserByName(String name) {
		return userMapper.findUserInfo(name);
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public void testTran() {
		userMapper.deleteById(10);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int a = 0 / 0;
		userMapper.findUserInfo("7player");
	}

	@Override
	public void saveUser(User user) {
		userMapper.insertUser(user);
	}

	@Override
	public void deleteById(int id) {
		userMapper.deleteById(id);
	}

}
