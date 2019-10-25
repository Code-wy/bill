package com.Spring.bill.register;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.Spring.bill.login.User;

@Mapper
public interface RegisterMapper {
	
	 @Select("SELECT * FROM user WHERE name = #{name}")
	 User selectByName(String name);

	 //向数据库添加用户信息，用于用户注册的model层
  	@Insert("INSERT INTO user(name,password) VALUES(#{name},#{password})")
  	//@Options(useGeneratedKeys=true, keyProperty="id")
  	int insert(User user);
  	
  	//添加用户角色
  	@Insert("INSERT INTO user_role VALUES (#{id}, '2')")
  	int insertUserRole(int id);
  	
    //添加管理员角色
  	@Insert("INSERT INTO user_role VALUES (#{id}, '1')")
  	int insertAdimRole(int id);
}
