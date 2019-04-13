package www.web1.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.web1.dataDAO.UsersDAO;
import www.web1.javaBean.User;

/**
 * Servlet implementation class RigisterServlet
 */
@WebServlet("/RigisterServlet")
public class RigisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RigisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ID = request.getParameter("rigAccount");
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("rigPswd1");
		int age = Integer.parseInt(request.getParameter("age"));
		String profession = request.getParameter("profession");
		String tele = request.getParameter("tele");
		String email = request.getParameter("rigEmail");
		String habby = request.getParameter("habby");
		String autograph = request.getParameter("autograph");
		File PathOfBg = new File("");
		File PathOfHead = new File("");
		User newUser = new User(ID, nickname, password, age,profession,tele, email,habby,autograph,PathOfBg,PathOfHead);
		UsersDAO con = new UsersDAO();
		con.add(newUser);
		response.sendRedirect("index.jsp");
	}

}
