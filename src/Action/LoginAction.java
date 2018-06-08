package Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dal.LoginDal;




public class LoginAction extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ActionFlag=req.getParameter("ActionFlag");
		try{
			if ("login".equals(ActionFlag)) {
				CheckLogin(req, resp);
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		};
	}
	public final void CheckLogin(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out=response.getWriter();
		String a = null;
		LoginDal dal=new LoginDal();
		String strWhere ="username='"+username+"' and password='"+password+"'";
		if(dal.logindal(strWhere)){
			a = dal.panduan(strWhere);
		}else{
			a = "no";
		}
		out.print(a);
		out.flush();
		out.close();
	}
}
