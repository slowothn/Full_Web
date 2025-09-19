package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class TestDao {

	
	public TestDao() {
		// TODO Auto-generated constructor stub
		System.out.println("--1.TestDao()--");
	}	
	
	public List<String> selectList() {
		
		List<String> list = new ArrayList<String>();
		
		list.add("Java");
		list.add("MySql");
		list.add("Html");
		
		return list;
	}
}
