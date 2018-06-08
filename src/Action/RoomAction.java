package Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Dal.RoomDal;
import Model.Order1Model;

import com.google.gson.Gson;

public class RoomAction extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ActionFlag=req.getParameter("ActionFlag");
		try{
			if ("Information_list_A".equals(ActionFlag)) {
				chaxuna(req, resp);
			}else if("Information_list_B".equals(ActionFlag)){
				chaxunb(req, resp);
			}else if("Information_list_C".equals(ActionFlag)){
				chaxunc(req, resp);
			}else if("Information_list_D".equals(ActionFlag)){
				chaxund(req, resp);
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		};
	}
	public final void chaxuna(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PrintWriter out=response.getWriter();
		String dd1 = request.getParameter("dd1");
		RoomDal dal = new RoomDal();
		List<Order1Model> list = dal.showa(dd1);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
		out.flush();
		out.close();
	}
	public final void chaxunb(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PrintWriter out=response.getWriter();
		String dd1 = request.getParameter("dd1");
		RoomDal dal = new RoomDal();
		List<Order1Model> list = dal.showb(dd1);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
		out.flush();
		out.close();
	}
	public final void chaxunc(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PrintWriter out=response.getWriter();
		String dd1 = request.getParameter("dd1");
		RoomDal dal = new RoomDal();
		List<Order1Model> list = dal.showc(dd1);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
		out.flush();
		out.close();
	}
	public final void chaxund(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PrintWriter out=response.getWriter();
		String dd1 = request.getParameter("dd1");
		RoomDal dal = new RoomDal();
		List<Order1Model> list = dal.showd(dd1);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
		out.flush();
		out.close();
	}
}
