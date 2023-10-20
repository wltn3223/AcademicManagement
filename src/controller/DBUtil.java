package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
	static final String driver = "oracle.jdbc.driver.OracleDriver";
	static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	public static Connection getConnection() throws Exception {
		
		 Properties properties = new Properties();
		 Connection con = null;

	        try (FileInputStream fileInputStream = new FileInputStream("src/config/db.properties")) {
	            // Properties 파일을 읽어옵니다.
	            properties.load(fileInputStream);

	            // 원하는 프로퍼티 값을 가져옵니다.
	            String Url = properties.getProperty("url");
	            String Username = properties.getProperty("username");
	            String Password = properties.getProperty("password");
	            
	            Class.forName(driver);
	            con = DriverManager.getConnection( Url, Username, Password);

	            // 가져온 값을 출력합니다.
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

		return con;
		}
	
}
