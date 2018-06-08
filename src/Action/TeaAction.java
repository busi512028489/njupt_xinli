package Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dal.TeaDal;
import Model.Order1Model;

import com.google.gson.Gson;

public class TeaAction extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ActionFlag=req.getParameter("ActionFlag");
		try{
			if ("all".equals(ActionFlag)) {
				chaxun(req, resp);
			}
			if ("tea".equals(ActionFlag)) {
				chaxun2(req, resp);
			}
			if ("tea2".equals(ActionFlag)) {
				chaxun3(req, resp);
			}
			if ("upd".equals(ActionFlag)) {
				update(req, resp);
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
		String tea = request.getParameter("tea");
		String dd1 = request.getParameter("dd1");
		TeaDal dal = new TeaDal();
		List<Order1Model> list = dal.show(dd1,tea);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
		out.flush();
		out.close();
	}
	public final void chaxun2(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String dd1 = request.getParameter("dd1");
		String tea = request.getParameter("tea");
		TeaDal dal = new TeaDal();
		List<Order1Model> list = dal.show2(dd1,tea);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		out.print(json);
		out.flush();
		out.close();
	}
	public final void chaxun3(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String tea = request.getParameter("tea");
		TeaDal dal = new TeaDal();
		List<Order1Model> list = dal.show3(tea);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
		out.flush();
		out.close();
	}
	public final void update(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String dd2 = request.getParameter("dd2");
		String time = request.getParameter("time1");
		String week = request.getParameter("week1");
		String xh = request.getParameter("xh");
		TeaDal dal = new TeaDal();
		List<Order1Model> list = dal.update(dd2,week,time,xh);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
		out.flush();
		out.close();
	}
}
