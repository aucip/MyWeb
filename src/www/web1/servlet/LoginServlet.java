package www.web1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.web1.dataDAO.UsersDAO;
import www.web1.javaBean.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String ID = request.getParameter("account");
		String psd = request.getParameter("password");
		UsersDAO userDAO = new UsersDAO();
		User user = userDAO.get(ID);
		System.out.println(psd);
		System.out.println(user.getPassword());
		if(user == null){
			response.sendRedirect("login.jsp");
		}else if(!psd.equals(user.getPassword())){
			response.sendRedirect("login.jsp");
		}else{
			Cookie cookie = new Cookie("user", "ID");
			cookie.setMaxAge(60);
			request.getSession().setAttribute("user", user);
			response.addCookie(cookie);
			response.sendRedirect("index.jsp");
		}
		doGet(request, response);
	}

}
