package com.types;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.generator.AcessDbConn;

public class SqlServerTypes{

	public List getDatatypes() throws SQLException {
		DatabaseMetaData dbmd = null;
			dbmd = AcessDbConn.getConn().getMetaData();

		if (dbmd ==null) {
			System.out.println("数据库信息获取失败!");
		}else{
			ResultSet rs = dbmd.getTypeInfo();
			System.out.println(rs);
		}
		return null;
		
	}
	public static void main(String[] args) throws SQLException {
		SqlServerTypes idt = new SqlServerTypes();
		idt.getDatatypes();
	}

}
