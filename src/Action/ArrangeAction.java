package Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Dal.ArrangeDal;
import Model.Order1Model;
import Model.StudentModel;


public class ArrangeAction extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ActionFlag=req.getParameter("ActionFlag");
		try{
			if ("getinformation".equals(ActionFlag)) {
				chaxun(req, resp);
			}else if ("save1".equals(ActionFlag)) {
				save1(req, resp);
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
		ArrangeDal dal = new ArrangeDal();
		List<Order1Model> list = dal.show();
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
		out.flush();
		out.close();
	}
	public final void save1(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String room = request.getParameter("room");
		String dd1 = request.getParameter("dd1");
		String data_table = request.getParameter("data_table");
		String[] parts = data_table.split(",");
		ArrangeDal dal = new ArrangeDal();
		for (int i = 0; i < jiequ(data_table); i++) {
			String part1 = parts[i];
			String a =String.valueOf(part1.charAt(2));//week1
			String b =String.valueOf(part1.charAt(4));//time1
			String c =part1.substring(8,part1.length());//xh
			dal.save(a,b,c,room,dd1);
			dal.update(c);
		}
		out.print("yes");
		out.flush();
		out.close();
	}
	public int jiequ(String str){
		char a = ',';
		int b=1;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == a) {
				b++;
			}
		}
		return b;
	}
}
