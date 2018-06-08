package Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dal.DetailDal;
import Model.Order1Model;
import Model.StudentModel;

import com.google.gson.Gson;

public class DetailAction extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ActionFlag=req.getParameter("ActionFlag");
		try{
			if ("detail_list_all".equals(ActionFlag)) {
				chaxun(req, resp);
			}else if("detail_update".equals(ActionFlag)){
				xiugai(req, resp);
			}else if("detail_list_all1".equals(ActionFlag)){
				chaxun1(req, resp);
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		};
	}
	public final void chaxun(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String xh = request.getParameter("xh");
		String zcdate = request.getParameter("zcdate");
		DetailDal dal = new DetailDal();
		List<Order1Model> list = dal.show(xh,zcdate);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
		out.flush();
		out.close();
	}
	public final void chaxun1(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String xh = request.getParameter("xh");
		DetailDal dal = new DetailDal();
		List<StudentModel> list = dal.show1(xh);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
		out.flush();
		out.close();
	}
	public final void xiugai(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String xh =request.getParameter("xh");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String tel= request.getParameter("tel");
		String academy =request.getParameter("academy");
		String reason = request.getParameter("reason");
		String grade = request.getParameter("grade");
		String state =request.getParameter("state");
		String require = request.getParameter("require");
		String emergency = request.getParameter("emergency");
		String timelist = request.getParameter("timelist");
		String tea = request.getParameter("xinli_tea");
		String zcdate = request.getParameter("zcdate");
		java.sql.Timestamp zcdate1 = null;
		if (zcdate.equals("null")) {
			Date date = new Date();
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			zcdate1 =java.sql.Timestamp.valueOf(sf.format(date.getTime()));
		}else {
			DateFormat formatFrom = new SimpleDateFormat("MMM dd,yyyy KK:mm:ss aa", Locale.ENGLISH);
			Date date = formatFrom.parse(zcdate);
			DateFormat formatTo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String zcdate3=formatTo.format(date);
			zcdate1=java.sql.Timestamp.valueOf(zcdate3);
		}
		Order1Model ord=new Order1Model();
		StudentModel stu=new StudentModel();
		stu.setXh(xh);
		ord.setXh(xh);
		stu.setName(name);
		stu.setSex(sex);
		stu.setTel(tel);
		stu.setAcademy(academy);
		ord.setReason(reason);
		stu.setGrade(grade);
		ord.setState(state);
		ord.setRequire1(require);
		ord.setEmergency(emergency);
		ord.setTimelist(timelist);
		ord.setTea(tea);
		ord.setZcdate(zcdate1);
		DetailDal dal = new DetailDal();
		
		if (dal.c(xh,zcdate1)) {
			if (dal.xiugai(stu) && dal.c1(ord)) {
				out.print("yes");
			} else {
				out.print("no");
			}
		} else {
			if(dal.j(ord)){
				out.print("yes");
			}else{
				out.print("no");
			}
			
		}
		
		out.flush();
		out.close();
	}
}
