package Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dal.InformationDal;
import Model.Order1Model;
import Model.StudentModel;

import com.google.gson.Gson;

public class InformationAction extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ActionFlag=req.getParameter("ActionFlag");
		try{
			if ("Information_all".equals(ActionFlag)) {
				chaxun(req, resp);
			}else if("Informationhistory".equals(ActionFlag)){
				chaxuna(req, resp);
			}else if("Information_no".equals(ActionFlag)){
				chaxunb(req, resp);
			}else if("del".equals(ActionFlag)){
				dele(req, resp);
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
		InformationDal dal = new InformationDal();
		List<Order1Model> list = dal.show();
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
		out.flush();
		out.close();
	}
	public final void chaxuna(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String dd1 = request.getParameter("dd1");
		String dd2 = request.getParameter("dd2");
		InformationDal dal = new InformationDal();
		List<Order1Model> list = dal.showa(dd1,dd2);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
		out.flush();
		out.close();
	}
	public final void chaxunb(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		InformationDal dal = new InformationDal();
		List<Order1Model> list = dal.showb();
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
		out.flush();
		out.close();
	}
	public void dele(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		InformationDal dal=new InformationDal();
		String xh = request.getParameter("xh");
		String zcdate = request.getParameter("zcdate");
		if (!"".equals(xh)) {
			if (dal.del(xh,zcdate)) {
				out.print(1);
			} else {
				out.print(0);
			}
		} else {
			out.print(2);
		}
		out.flush();
		out.close();
	}
	private void SimpleDateFormat(String string) {
		// TODO Auto-generated method stub
		
	}
}
