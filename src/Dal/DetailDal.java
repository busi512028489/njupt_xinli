package Dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import mysql.DBSession;
import Model.Order1Model;
import Model.StudentModel;

public class DetailDal {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public List<Order1Model> show(String xh,String zcdate) throws ParseException {
		con = DBSession.getCon();
		String sql = "select * from order1 where xh = ? and zcdate = ?";
		DateFormat formatFrom = new SimpleDateFormat("MMM dd,yyyy KK:mm:ss aa", Locale.ENGLISH);
		Date date = formatFrom.parse(zcdate);
		DateFormat formatTo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String zcdate1=formatTo.format(date);
		
		java.sql.Timestamp zcdate2=java.sql.Timestamp.valueOf(zcdate1);
		List<Order1Model> list = new ArrayList<Order1Model>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, xh);
			ps.setTimestamp(2, zcdate2);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order1Model ord = new Order1Model();
				ord.setXh(rs.getString("xh"));
				ord.setState(rs.getString("state"));
				ord.setReason(rs.getString("reason"));
				ord.setRequire1(rs.getString("require1"));
				ord.setEmergency(rs.getString("emergency"));
				ord.setTimelist(rs.getString("timelist"));
				ord.setTea(rs.getString("tea"));
				list.add(ord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBSession.closeAll(con, ps, rs);
		}
		return list;
	}
	public List<StudentModel> show1(String xh) {
		con = DBSession.getCon();
		String sql = "select * from student where xh = ?";
		List<StudentModel> list = new ArrayList<StudentModel>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, xh);
			rs = ps.executeQuery();
			while (rs.next()) {
				StudentModel stu = new StudentModel();
				stu.setName(rs.getString("name"));
				stu.setSex(rs.getString("sex"));
				stu.setAcademy(rs.getString("academy"));
				stu.setTel(rs.getString("tel"));
				stu.setGrade(rs.getString("grade"));
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBSession.closeAll(con, ps, rs);
		}
		return list;
	}
	public boolean xiugai(StudentModel stu) {
		con = DBSession.getCon();
		String sql = "update student set name= ?,sex= ?,tel= ?,academy= ?,grade= ? where xh= ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, stu.getName());
			ps.setString(2, stu.getSex());
			ps.setString(3, stu.getTel());
			ps.setString(4, stu.getAcademy());
			ps.setString(5, stu.getGrade());
			ps.setString(6, stu.getXh());
			return ps.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBSession.closeAll(con, ps, rs);
		}
		return false;
	}
	public boolean c1(Order1Model ord) {
		con = DBSession.getCon();
		String sql = "update order1 set reason= ?,state= ?,require1= ?,emergency= ?,timelist= ?,tea= ? where xh= ? and zcdate = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ord.getReason());
			ps.setString(2, ord.getState());
			ps.setString(3, ord.getRequire1());
			ps.setString(4, ord.getEmergency());
			ps.setString(5,ord.getTimelist());
			ps.setString(6, ord.getTea());
			ps.setString(7, ord.getXh());
			ps.setTimestamp(8, ord.getZcdate());
			return ps.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBSession.closeAll(con, ps, rs);
		}
		return false;
	}
	public boolean c(String xh,Timestamp zcdate) {
		con = DBSession.getCon();
		String sql = "select * from order1 where xh =? and zcdate =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, xh);
			ps.setTimestamp(2, zcdate);
			rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBSession.closeAll(con, ps, rs);
		}
		return false;
	}
	public boolean j(Order1Model ord) {
		con = DBSession.getCon();
		Date date = new Date();//获得系统时间.
		String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//将时间格式转换成符合Timestamp要求的格式.
		Timestamp goodsC_date =Timestamp.valueOf(nowTime);//把时间转换
		String sql = "insert into order1(xh,reason,state,require1,emergency,timelist,tea,riqi,arrange,zcdate) values (?,?,?,?,?,?,?,?,'0',?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ord.getXh());
			ps.setString(2, ord.getReason());
			ps.setString(3, ord.getState());
			ps.setString(4, ord.getRequire1());
			ps.setString(5, ord.getEmergency());
			ps.setString(6, ord.getTimelist());
			ps.setString(7, ord.getTea());
			ps.setTimestamp(8, goodsC_date);
			ps.setTimestamp(9, ord.getZcdate());
			return ps.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBSession.closeAll(con, ps, rs);
		}
		return false;
	}
}
