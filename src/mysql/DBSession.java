package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSession {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://180.209.98.88:3306/yiban?useunicode=true&characterEncoding=utf-8";
	private static final String UID = "root";
	private static final String PWD = "yiban";
	
	public static Connection getCon() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, UID, PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeAll(Connection con, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public boolean isExist(String sql){
		
		try{
			
			Connection con=getCon();
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			if (rs.next()) {
				return true;
			}
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return false;
	}
}
