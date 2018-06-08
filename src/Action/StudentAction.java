//package Action;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//import Dal.StudentDal;
//import Model.StudentModel;
//
//
//
//
//
//public class StudentAction extends HttpServlet{
//	
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String ActionFlag=req.getParameter("ActionFlag");
//		try{
//			if ("stu_order".equals(ActionFlag)) {
//				CheckLogin(req, resp);
//			}
//			
//		}catch(Exception e){
//			System.out.println(e.getMessage());
//		};
//	}
//	public final void CheckLogin(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		PrintWriter out=response.getWriter();
//		response.setCharacterEncoding("utf-8");
//		request.setCharacterEncoding("utf-8");
//		StudentDal dal=new StudentDal();
//		String xh =request.getParameter("xh");
//		String name = request.getParameter("name");
//		String sex = request.getParameter("sex");
//		String tel= request.getParameter("tel");
//		String academy =request.getParameter("academy");
//		String reason = request.getParameter("reason");
//		String grade = request.getParameter("grade");
//		String state =request.getParameter("state");
//		String require = request.getParameter("require");
//		String emergency = request.getParameter("emergency");
//		String week1 =request.getParameter("week1");
//		String week2 = request.getParameter("week2");
//		String time1 = request.getParameter("time1");
//		String time2 = request.getParameter("time2");
//		String arrange = "0";
//		StudentModel stu=new StudentModel();
//		stu.setXh(xh);
//		stu.setName(name);
//		stu.setSex(sex);
//		stu.setTel(tel);
//		stu.setAcademy(academy);
//		stu.setReason(reason);
//		stu.setGrade(grade);
//		stu.setState(state);
//		stu.setRequire1(require);
//		stu.setEmergency(emergency);
//		stu.setWeek1(week1);
//		stu.setWeek2(week2);
//		stu.setTime1(time1);
//		stu.setTime2(time2);
//		stu.setArrange(arrange);
//		if (dal.addStu(stu)) {
//			out.print("yes");
//		} else {
//			out.print("no");
//		}
//		out.flush();
//		out.close();
//	}
//}
