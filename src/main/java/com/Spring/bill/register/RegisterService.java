package com.Spring.bill.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.bill.login.User;


@Service
public class RegisterService {

	@Autowired
	private RegisterMapper registerMapper;
	
	//通过name查找用户
    public User selectByName(String name) {
        return registerMapper.selectByName(name);
    }
    
    //注册用户,在用户表添加用户
    public int insert(User user) {
		return registerMapper.insert(user);
	}
    //授予用户user角色
    public void insertUserRole(int id) {
    	registerMapper.insertUserRole(id);
	}
    //授予用户admin角色
    public void insertAdimRole(int id) {
    	registerMapper.insertAdimRole(id);
	}
}
