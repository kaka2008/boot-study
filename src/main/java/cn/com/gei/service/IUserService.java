package cn.com.gei.service;

import cn.com.gei.entity.User;

public interface IUserService {
	/**
	 * 根据名字获取用户信息
	 * 
	 * @param name
	 * @return
	 */
	public User getUserByName(String name);

	/**
	 * 测试事务
	 */
	public void testTran();

	/**
	 * 保存用户
	 * 
	 * @param user
	 */
	public void saveUser(User user);

	/**
	 * 根据id删除用户
	 * 
	 * @param id
	 */
	public void deleteById(int id);
}
