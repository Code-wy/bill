package com.Spring.bill.login;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.Spring.bill.login.User;;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectByUId(Integer id);  //

    @Select("SELECT * FROM user WHERE name = #{name}")
    User selectByName(String name);
    
    @Select("SELECT * FROM role WHERE id = #{id}")
    Role selectByRId(Integer id);
    
    @Select("SELECT * FROM user_role WHERE user_id = #{userId}")
    List<UserRole> listByUserId(Integer userId); //一定要导入java.util.List 包
    
}