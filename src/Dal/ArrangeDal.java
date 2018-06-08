package Dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import mysql.DBSession;

import Model.Order1Model;
import Model.StudentModel;


public class ArrangeDal {
	private Connection con = null;
	private PreparedStatement ps = null;
	private PreparedStatement ps1 = null;
	private ResultSet rs = null;
	public List<Order1Model> show() {
		con = DBSession.getCon();
		String sql = "select * from order1 where arrange = '0'";
		List<Order1Model> list = new ArrayList<Order1Model>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order1Model stu = new Order1Model();
				stu.setXh(rs.getString("xh"));
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
	public void save(String a,String b,String c,String room,String dd1) throws NumberFormatException, Exception {
		con = DBSession.getCon();
		java.util.Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		date = sdf.parse(dd1);
		java.util.Date insertdate=getSomeDay(date,Integer.parseInt(a)-dayForWeek(dd1));
		java.sql.Date sqlDate = new java.sql.Date(insertdate.getTime());
		String time = null;
		String time1 = null;
		if (a.equals("1")) {
			time="[\"周一:";
		} else if(a.equals("2")){
			time="[\"周二:";
		} else if(a.equals("3")){
			time="[\"周三:";
		} else if(a.equals("4")){
			time="[\"周四:";
		} else if(a.equals("5")){
			time="[\"周五:";
		}
		if (b.equals("1")) {
			time1 ="上午9点-10点\"]";
		} else if(b.equals("2")){
			time1="上午10点-11点\"]";
		} else if(b.equals("3")){
			time1="下午2点-3点\"]";
		} else if(b.equals("4")){
			time1="下午3点-4点\"]";
		}
		String time2 = time + time1;
		String sql = "update order1 set time1=?,room=?,insertdate=? where xh= ? and arrange='0'";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, time2);
			ps.setString(2, room);
			ps.setDate(3, sqlDate);
			ps.setString(4, c);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBSession.closeAll(con, ps, rs);
		}
	}
	public void update(String a) {
		con = DBSession.getCon();
		String sql = "update order1 set arrange = '1' where xh = ? and arrange = '0'";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, a);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBSession.closeAll(con, ps, rs);
		}
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
	
	public static java.util.Date getSomeDay(java.util.Date date, int day){
	      Calendar calendar = Calendar.getInstance();
		  calendar.setTime(date);
		  calendar.add(Calendar.DATE, day);
		  return calendar.getTime();
	}

}
