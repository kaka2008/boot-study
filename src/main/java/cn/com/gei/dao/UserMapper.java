package cn.com.gei.dao;

import cn.com.gei.entity.User;

/**
 * 
 * @author gei
 *
 */
public interface UserMapper {
	public User findUserInfo(String name);

	public void deleteById(int id);

	public void insertUser(User user);
}
