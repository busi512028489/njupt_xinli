package Dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Model.Order1Model;
import Model.StudentModel;

import mysql.DBSession;

public class InformationDal {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public List<Order1Model> show() {
		con = DBSession.getCon();
		String sql = "select * from order1";
		List<Order1Model> list = new ArrayList<Order1Model>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order1Model stu = new Order1Model();
				stu.setXh(rs.getString("xh"));
				stu.setTime1(rs.getString("time1"));
				stu.setInsertdate(rs.getDate("insertdate"));
				stu.setZcdate(rs.getTimestamp("zcdate"));
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBSession.closeAll(con, ps, rs);
		}
		return list;
	}
	public List<Order1Model> showa(String dd1,String dd2) {
		con = DBSession.getCon();
		java.sql.Date date1=java.sql.Date.valueOf(dd1);
		java.sql.Date date2=java.sql.Date.valueOf(dd2);
		String sql = "select * from order1 where insertdate between ? and ?";
		List<Order1Model> list = new ArrayList<Order1Model>();
		try {
			ps = con.prepareStatement(sql);
			ps.setDate(1, date1);
			ps.setDate(2, date2);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order1Model stu = new Order1Model();
				stu.setXh(rs.getString("xh"));
				stu.setTime1(rs.getString("time1"));
				stu.setInsertdate(rs.getDate("insertdate"));
				stu.setZcdate(rs.getTimestamp("zcdate"));
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBSession.closeAll(con, ps, rs);
		}
		return list;
	}
	public List<Order1Model> showb() throws ParseException {
		Calendar calendar1 = Calendar.getInstance();
		java.util.Date date1 = null;
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		calendar1.add(Calendar.DATE, -3);
		String three_days_ago = sdf1.format(calendar1.getTime());
		date1=sdf1.parse(three_days_ago);
		java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
		con = DBSession.getCon();
		String sql = "SELECT * FROM order1 where riqi < ? and arrange = '0'";
		List<Order1Model> list = new ArrayList<Order1Model>();
		try {
			ps = con.prepareStatement(sql);
			ps.setDate(1, sqlDate);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order1Model stu = new Order1Model();
				stu.setXh(rs.getString("xh"));
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBSession.closeAll(con, ps, rs);
		}
		return list;
	}
	public boolean del(String xh,String zcdate) {
		con = DBSession.getCon();
		java.sql.Date date1 = java.sql.Date.valueOf(zcdate);
		String sql = "update order1 set arrange = '0',time1 = null,room = null,insertdate = null,tea =null where xh = ? and zcdate = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, xh);
			ps.setDate(2, date1);
			return ps.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBSession.closeAll(con, ps, rs);
		}
		return false;
	}
	
	
	
}
