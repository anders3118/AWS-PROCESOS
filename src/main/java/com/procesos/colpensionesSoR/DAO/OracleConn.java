package com.procesos.colpensionesSoR.DAO;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class OracleConn {
	
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = 
							"jdbc:oracle:thin:@sorcolpensiones.crb00izbcgdj.us-east-1.rds.amazonaws.com:1521/orcl";
	private static final String DB_USER = "sor";
	private static final String DB_PASSWORD = "testing.14";

	public static Connection  getConnection() {
		
		Connection dbConnection = null;
		
		try {
			Class.forName(DB_DRIVER);
			
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;
			
		} catch (SQLException  e) {
			System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}  
		return dbConnection;
	}
}
