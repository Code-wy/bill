package com.Spring.bill.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    //通过id查找用户
    public User selectById(Integer id) {
        return userMapper.selectByUId(id);
    }

    //通过name查找用户
    public User selectByName(String name) {
        return userMapper.selectByName(name);
    }
    
    //通过role id查找角色
    public Role selectByRId(Integer id){
        return userMapper.selectByRId(id);
    }
    
    //通过user id返回用户角色
    public List<UserRole> listByUserId(Integer userId) {
        return userMapper.listByUserId(userId);
    }
    
   
}