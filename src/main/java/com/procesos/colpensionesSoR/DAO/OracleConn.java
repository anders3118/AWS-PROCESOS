package com.procesos.colpensionesSoR.DAO;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class OracleConn {

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@sorcolpensiones.crb00izbcgdj.us-east-1.rds.amazonaws.com:1521/orcl";
	private static final String DB_USER = "sor";
	private static final String DB_PASSWORD = "testing.14";

	private static Connection dbConnection;
	
	private OracleConn() {
		
	}

	private static void initConnection() {
		try {
			Class.forName(DB_DRIVER);

			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		if(null == dbConnection) {
			initConnection();
		}
		return dbConnection;
	}

}
