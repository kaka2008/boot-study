package cn.com.gei.dao2;

import cn.com.gei.entity.User;

/**
 * 第二个数据库的Mapper
 * 
 * @author gei
 *
 */
public interface UserMapper2 {
	User findUserInfo(String name);

	void deleteById(int id);

	void insertUser(User user);
}
