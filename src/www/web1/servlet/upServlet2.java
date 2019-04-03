package www.web1.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.web1.dataDAO.DraftDAO;
import www.web1.javaBean.Draft;
import www.web1.javaBean.User;

/**
 * Servlet implementation class upServlet2
 */
@WebServlet("/upServlet2")
public class upServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = (String)request.getParameter("title");
		DraftDAO draftDAO = new DraftDAO();
		List<Draft> drafts = new ArrayList<Draft>();
		User user = (User)request.getSession().getAttribute("user");
		drafts = draftDAO.list(user.getID());
		
		for(int i = 0;i < drafts.size() ;i++){
			if(drafts.get(i).getHeadline().equals(title)){
				request.getSession().setAttribute("nowDraft", drafts.get(i));
				break;
			}
		}
		response.sendRedirect("upload.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
