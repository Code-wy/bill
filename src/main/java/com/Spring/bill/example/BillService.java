package com.Spring.bill.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.bill.login.User;

@Service
public class BillService{

	@Autowired
	private BillMapper billMapper;


	public int insert(Bill billAuth) {
		if (billAuth == null) {
			System.out.println("必要参数缺失");
        }

		return billMapper.insert(billAuth);
	}


	
	public int delete(int id) {
		return billMapper.delete(id);
	}


	public int update(Bill billAuth) {
		return billMapper.update(billAuth);
	}


	
	public List<Bill> load(int id) {
		return billMapper.load(id);
	}

	public Bill selectByBillid(int billid) {
		return billMapper.selectByBillid(billid);
	}

	public User selectByName(String id) {
		return billMapper.selectByName(id);
	}

}