import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		 Properties properties = new Properties();

	        try (FileInputStream fileInputStream = new FileInputStream("src/config/db.properties")) {
	            // Properties 파일을 읽어옵니다.
	            properties.load(fileInputStream);

	            // 원하는 프로퍼티 값을 가져옵니다.
	            String dbUrl = properties.getProperty("url");
	            String dbUsername = properties.getProperty("username");
	            String dbPassword = properties.getProperty("password");

	            // 가져온 값을 출력합니다.
	            System.out.println("Database URL: " + dbUrl);
	            System.out.println("Database Username: " + dbUsername);
	            System.out.println("Database Password: " + dbPassword);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	





