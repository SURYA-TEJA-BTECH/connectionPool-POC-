package com.surya.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IstudentDaoImpl implements IstudentDao {

	@Autowired
	private DataSource ds;

	private static final String STUDENT_COUNT_QUERY = "SELECT COUNT(*) FROM STUDENT";

	@Override
	public int getStudentsCount() throws Exception {

		try (Connection con = ds.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(STUDENT_COUNT_QUERY)) {

			rs.next();

			return rs.getInt(1);

		}
	}
}
