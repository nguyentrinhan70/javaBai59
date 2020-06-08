package nguyentrinhan70.example.com.connect;

import java.sql.Connection;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class MySQLService {
	protected Connection conn;
	public MySQLService(){
		try{
			String strConn = "jdbc:mysql://localhost/csdlQuanLySach?"
					+ "useUnicode=true&characterEncoding=utf-8";
			Properties pro = new Properties();
			pro.put("user", "root");
			pro.put("password", "");
			Driver driver = new Driver();
			conn = driver.connect(strConn, pro);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
