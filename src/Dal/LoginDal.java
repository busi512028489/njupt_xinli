package Dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Model.LoginModel;


import mysql.DBSession;

public class LoginDal {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public boolean logindal(String sql) {
		StringBuilder strSql = new StringBuilder();
		strSql.append("select * from login where ");
		strSql.append(sql);
		String strl=new String(strSql);
		DBSession dbSession=new DBSession();
		return dbSession.isExist(strl);
	}
	
	public String panduan(String strWhere) {
		con = DBSession.getCon();
		String strSql="select quanxian from login where ";
		strSql+=strWhere;
		String a = null;
		try {
			ps = con.prepareStatement(strSql);
			rs = ps.executeQuery();
			if (rs.next()) {
				a=rs.getString("quanxian");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBSession.closeAll(con, ps, rs);
		}
		return a;
	}
}

