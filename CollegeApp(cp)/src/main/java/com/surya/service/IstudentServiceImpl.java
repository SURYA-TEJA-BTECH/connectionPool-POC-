package com.surya.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surya.dao.IstudentDao;

@Service
public class IstudentServiceImpl implements IstudentService {

	@Autowired
	private IstudentDao dao;

	@Override
	public String getStudentsCount() throws Exception {

		int count = dao.getStudentsCount();

		return count == 0 ? "no students are there " : " total availble students are " + count;

	}
}
