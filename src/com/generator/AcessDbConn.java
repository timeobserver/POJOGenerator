package com.generator;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class AcessDbConn {

	private static String driver;
	private static String url;
	private static String username;
	private static String password;

	static {
		InputStream in = null;
		in = new BufferedInputStream(Object.class.getResourceAsStream("/properties/DataBaseConfig.properties"));
		Properties dbProperties = new Properties();
		try {
			dbProperties.load(in);
			;
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = dbProperties.getProperty("DB_DRIVER");
		url = dbProperties.getProperty("DB_URL");
		username = dbProperties.getProperty("DB_USERNAME");
		password = dbProperties.getProperty("DB_PASSWORD");
	}

	public static Connection getConn() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException se) {
			System.out.println("数据库连接失败！");
			se.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("数据库驱动未找到！");
		}
		return con;

	}

	public static void main(String[] args) {
		getConn();
	}

}
