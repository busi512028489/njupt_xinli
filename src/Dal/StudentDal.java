//package Dal;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import Model.StudentModel;
//import mysql.DBSession;
//
//public class StudentDal {
//	private Connection con = null;
//	private PreparedStatement ps = null;
//	private ResultSet rs = null;
//	public boolean addStu(StudentModel stu) {
//		con = DBSession.getCon();
//		Date date = new Date();//获得系统时间.
//		String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//将时间格式转换成符合Timestamp要求的格式.
//		Timestamp goodsC_date =Timestamp.valueOf(nowTime);//把时间转换
//		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
//		String time =sf.format(date.getTime());
//		String sql = "insert into student(xh,name,sex,tel,academy,grade,reason,state,require1,emergency,week1,time1,week2,time2,arrange,riqi,zcdate) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//		try {
//			ps = con.prepareStatement(sql);
//			ps.setString(1, stu.getXh());
//			ps.setString(2, stu.getName());
//			ps.setString(3, stu.getSex());
//			ps.setString(4, stu.getTel());
//			ps.setString(5, stu.getAcademy());
//			ps.setString(6, stu.getGrade());
//			ps.setString(7, stu.getReason());
//			ps.setString(8, stu.getState());
//			ps.setString(9, stu.getRequire1());
//			ps.setString(10, stu.getEmergency());
//			ps.setString(11, stu.getWeek1());
//			ps.setString(12, stu.getTime1());
//			ps.setString(13, stu.getWeek2());
//			ps.setString(14, stu.getTime2());
//			ps.setString(15, stu.getArrange());
//			ps.setTimestamp(16, goodsC_date);
//			ps.setString(17, time);
//			return ps.executeUpdate() > 0 ? true : false;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBSession.closeAll(con, ps, rs);
//		}
//		return false;
//	}
//}

