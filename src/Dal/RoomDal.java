package Dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Model.Order1Model;

import mysql.DBSession;

public class RoomDal {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public List<Order1Model> showa(String dd1) throws ParseException {
		con = DBSession.getCon();
		String firstday=getFirstDayOfWeek(dd1);
		String endday=getEndDayOfWeek(dd1);
		String sql = "select * from order1 where room = '1' and insertdate between ? and ?";
		List<Order1Model> list = new ArrayList<Order1Model>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, firstday);
			ps.setString(2, endday);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order1Model stu = new Order1Model();
				stu.setXh(rs.getString("xh"));
				if (rs.getString("time1").substring(2,4).equals("周一")) {
					stu.setWeek1("1");
				} else if(rs.getString("time1").substring(2,4).equals("周二")){
					stu.setWeek1("2");
				} else if(rs.getString("time1").substring(2,4).equals("周三")){
					stu.setWeek1("3");
				} else if(rs.getString("time1").substring(2,4).equals("周四")){
					stu.setWeek1("4");
				} else if(rs.getString("time1").substring(2,4).equals("周五")){
					stu.setWeek1("5");
				}
				if (rs.getString("time1").substring(5,13).equals("上午9点-10点")) {
					stu.setTime1("1");
				} else if(rs.getString("time1").substring(5,14).equals("上午10点-11点")){
					stu.setTime1("2");
				} else if(rs.getString("time1").substring(5,12).equals("下午2点-3点")){
					stu.setTime1("3");
				} else if(rs.getString("time1").substring(5,12).equals("下午3点-4点")){
					stu.setTime1("4");
				}
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
	public List<Order1Model> showb(String dd1) throws ParseException {
		con = DBSession.getCon();
		String firstday=getFirstDayOfWeek(dd1);
		String endday=getEndDayOfWeek(dd1);
		String sql = "select * from order1 where room = '2' and insertdate between ? and ?";
		List<Order1Model> list = new ArrayList<Order1Model>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, firstday);
			ps.setString(2, endday);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order1Model stu = new Order1Model();
				stu.setXh(rs.getString("xh"));
				if (rs.getString("time1").substring(2,4).equals("周一")) {
					stu.setWeek1("1");
				} else if(rs.getString("time1").substring(2,4).equals("周二")){
					stu.setWeek1("2");
				} else if(rs.getString("time1").substring(2,4).equals("周三")){
					stu.setWeek1("3");
				} else if(rs.getString("time1").substring(2,4).equals("周四")){
					stu.setWeek1("4");
				} else if(rs.getString("time1").substring(2,4).equals("周五")){
					stu.setWeek1("5");
				}
				if (rs.getString("time1").substring(5,13).equals("上午9点-10点")) {
					stu.setTime1("1");
				} else if(rs.getString("time1").substring(5,14).equals("上午10点-11点")){
					stu.setTime1("2");
				} else if(rs.getString("time1").substring(5,12).equals("下午2点-3点")){
					stu.setTime1("3");
				} else if(rs.getString("time1").substring(5,12).equals("下午3点-4点")){
					stu.setTime1("4");
				}
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
	public List<Order1Model> showc(String dd1) throws ParseException {
		con = DBSession.getCon();
		String firstday=getFirstDayOfWeek(dd1);
		String endday=getEndDayOfWeek(dd1);
		String sql = "select * from order1 where room = '3' and insertdate between ? and ?";
		List<Order1Model> list = new ArrayList<Order1Model>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, firstday);
			ps.setString(2, endday);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order1Model stu = new Order1Model();
				stu.setXh(rs.getString("xh"));
				if (rs.getString("time1").substring(2,4).equals("周一")) {
					stu.setWeek1("1");
				} else if(rs.getString("time1").substring(2,4).equals("周二")){
					stu.setWeek1("2");
				} else if(rs.getString("time1").substring(2,4).equals("周三")){
					stu.setWeek1("3");
				} else if(rs.getString("time1").substring(2,4).equals("周四")){
					stu.setWeek1("4");
				} else if(rs.getString("time1").substring(2,4).equals("周五")){
					stu.setWeek1("5");
				}
				if (rs.getString("time1").substring(5,13).equals("上午9点-10点")) {
					stu.setTime1("1");
				} else if(rs.getString("time1").substring(5,14).equals("上午10点-11点")){
					stu.setTime1("2");
				} else if(rs.getString("time1").substring(5,12).equals("下午2点-3点")){
					stu.setTime1("3");
				} else if(rs.getString("time1").substring(5,12).equals("下午3点-4点")){
					stu.setTime1("4");
				}
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
	public List<Order1Model> showd(String dd1) throws ParseException {
		con = DBSession.getCon();
		String firstday=getFirstDayOfWeek(dd1);
		String endday=getEndDayOfWeek(dd1);
		String sql = "select * from order1 where room = '4' and insertdate between ? and ?";
		List<Order1Model> list = new ArrayList<Order1Model>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, firstday);
			ps.setString(2, endday);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order1Model stu = new Order1Model();
				stu.setXh(rs.getString("xh"));
				if (rs.getString("time1").substring(2,4).equals("周一")) {
					stu.setWeek1("1");
				} else if(rs.getString("time1").substring(2,4).equals("周二")){
					stu.setWeek1("2");
				} else if(rs.getString("time1").substring(2,4).equals("周三")){
					stu.setWeek1("3");
				} else if(rs.getString("time1").substring(2,4).equals("周四")){
					stu.setWeek1("4");
				} else if(rs.getString("time1").substring(2,4).equals("周五")){
					stu.setWeek1("5");
				}
				if (rs.getString("time1").substring(5,13).equals("上午9点-10点")) {
					stu.setTime1("1");
				} else if(rs.getString("time1").substring(5,14).equals("上午10点-11点")){
					stu.setTime1("2");
				} else if(rs.getString("time1").substring(5,12).equals("下午2点-3点")){
					stu.setTime1("3");
				} else if(rs.getString("time1").substring(5,12).equals("下午3点-4点")){
					stu.setTime1("4");
				}
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
	public static String getFirstDayOfWeek(String date) throws ParseException{        
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(sdf.parse(date));
	    cal.set(Calendar.DAY_OF_WEEK, 2);
	    return sdf.format(cal.getTime());
	}
	public static String getEndDayOfWeek(String date) throws ParseException{        
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(sdf.parse(date));
	    cal.set(Calendar.DAY_OF_WEEK, 7);
	    return sdf.format(cal.getTime());
	}
}
