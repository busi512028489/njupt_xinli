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
import java.util.GregorianCalendar;
import java.util.List;

import mysql.DBSession;
import Model.Order1Model;

public class TeaDal {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public List<Order1Model> show(String dd1,String tea) throws ParseException {
		con = DBSession.getCon();
		String firstday=getFirstDayOfWeek(dd1);
		String endday=getEndDayOfWeek(dd1);
		String sql = "select * from order1 where tea <> ? and insertdate between ? and ?";
		List<Order1Model> list = new ArrayList<Order1Model>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tea);
			ps.setString(2, firstday);
			ps.setString(3, endday);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order1Model stu = new Order1Model();
				stu.setXh(rs.getString("xh"));
				stu.setRoom(rs.getString("room"));
				stu.setTea(rs.getString("tea"));
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
				list.add(stu);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBSession.closeAll(con, ps, rs);
		}
		return list;
	}
	public List<Order1Model> show2(String dd1,String tea) throws ParseException {
		con = DBSession.getCon();
		String firstday=getFirstDayOfWeek(dd1);
		String endday=getEndDayOfWeek(dd1);
		String sql = "select * from order1 where tea = ? and insertdate between ? and ?";
		List<Order1Model> list = new ArrayList<Order1Model>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tea);
			ps.setString(2, firstday);
			ps.setString(3, endday);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order1Model stu = new Order1Model();
				stu.setXh(rs.getString("xh"));
				stu.setRoom(rs.getString("room"));
				stu.setTea(rs.getString("tea"));
				stu.setZcdate(rs.getTimestamp("zcdate"));
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
				list.add(stu);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBSession.closeAll(con, ps, rs);
		}
		return list;
	}
	public List<Order1Model> show3(String tea) throws ParseException {
		con = DBSession.getCon();
		Date day=new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(day.getTime());
		java.util.Date sqlDate=df.parse(date);
		java.sql.Date d2 = new java.sql.Date(sqlDate.getTime()); 
		String sql = "select * from order1 where tea = ? and insertdate > ?";
		List<Order1Model> list = new ArrayList<Order1Model>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tea);
			ps.setDate(2, d2);
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
	public List<Order1Model> update(String dd2,String week,String time,String xh) throws Exception {
		con = DBSession.getCon();
		String timea = null;
		String timeb = null;
		if (week.equals("1")) {
			timea="[\"周一:";
		} else if(week.equals("2")){
			timea="[\"周二:";
		} else if(week.equals("3")){
			timea="[\"周三:";
		} else if(week.equals("4")){
			timea="[\"周四:";
		} else if(week.equals("5")){
			timea="[\"周五:";
		}
		if (time.equals("1")) {
			timeb ="上午9点-10点\"]";
		} else if(time.equals("2")){
			timeb="上午10点-11点\"]";
		} else if(time.equals("3")){
			timeb="下午2点-3点\"]";
		} else if(time.equals("4")){
			timeb="下午3点-4点\"]";
		}
		String time2 = timea + timeb;
		java.util.Date date1 = null;
		Date day=new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(day.getTime());
		java.util.Date sqlDate=df.parse(date);
		java.sql.Date d2 = new java.sql.Date(sqlDate.getTime()); 
		date1 = df.parse(dd2);
		java.sql.Date sqlDate1 = new java.sql.Date(date1.getTime());
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(sqlDate1);
		calendar.add(calendar.DATE,Integer.parseInt(week)-dayForWeek(dd2));
		java.util.Date sqlDate2=calendar.getTime();
		java.sql.Date sqlDate3 = new java.sql.Date(sqlDate2.getTime());
		String sql = "update order1 set time1 = ? , insertdate = ? where xh = ? and insertdate > ?";
		List<Order1Model> list = new ArrayList<Order1Model>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, time2);
			ps.setDate(2, sqlDate3);
			ps.setString(3, xh);
			ps.setDate(4, d2);
			ps.executeUpdate();
			
			
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
	public static int dayForWeek(String pTime) throws Exception {
		  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		  Calendar c = Calendar.getInstance();
		  c.setTime(format.parse(pTime));
		  int dayForWeek = 0;
		  if(c.get(Calendar.DAY_OF_WEEK) == 1){
		   dayForWeek = 7;
		  }else{
		   dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		  }
		  return dayForWeek;
	}
}
