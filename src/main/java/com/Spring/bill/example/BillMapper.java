package com.Spring.bill.example;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.Spring.bill.login.User;

import java.util.List;

/**
* bill_auth
* @author 王洋
*/
@Mapper
@Repository
public interface BillMapper {

    /**
    * [新增]
    **/
	@Insert("INSERT INTO `bill_Auth`(user_id,bill_name,bill_text) VALUES(#{userId},#{billName},#{billText})")
    int insert(Bill billAuth);

    /**
    * [刪除]
    **/
	@Delete("DELETE FROM `bill_Auth` WHERE bill_id=#{billId};")
    int delete(int id);

    /**
    * [更新]
    **/
	@Update("UPDATE `bill_Auth` SET bill_name=#{billName}, bill_text=#{billText} WHERE bill_id=#{billId};")
    int update(Bill billAuth);

    /**
    * [查詢] 根据用户 id 查詢
    **/
	@Select("SELECT * FROM `bill_Auth` WHERE user_id=#{id};")
	List<Bill> load(int id);
	
	/**
	* [查詢] 根据账单 id 查詢
	**/
	@Select("SELECT * FROM `bill_Auth` WHERE bill_id=#{billid};")
	Bill selectByBillid(int billid);
    
	/**
	 * [查询]
	 */
	@Select("SELECT * FROM user WHERE name = #{name}")
    User selectByName(String name);
	
}

