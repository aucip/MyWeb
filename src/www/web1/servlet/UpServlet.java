package www.web1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.web1.dataDAO.DraftDAO;
import www.web1.dataDAO.EssayDAO;
import www.web1.javaBean.Draft;
import www.web1.javaBean.Eassy;
import www.web1.javaBean.User;

/**
 * Servlet implementation class UpServlet
 */
@WebServlet("/UpServlet")
public class UpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpServlet() {
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
		request.setCharacterEncoding("utf-8");
		User user = (User)request.getSession().getAttribute("user");
		String theme =request.getParameter("theme");
		String comCom =request.getParameter("comCon");
		if(theme == null|| comCom==null){
			System.out.println("error");
		}
		if(theme == "" || comCom==""){
			System.out.println("error2");
		}
		if(user == null){
			System.out.println("error3");
		}
		//获得草稿
		Draft draft = new Draft();
		draft.setHeadline(request.getParameter("theme"));
		draft.setContent(request.getParameter("comCon"));
		draft.setID(user.getID());
		System.out.println("title"+draft.getHeadline());
		//数据库连接
	    DraftDAO draftDAO = new DraftDAO();
	    //判断草稿箱里是否有该文章
		Draft temp = draftDAO.get(user.getID(), draft.getHeadline());
		if(request.getParameter("submit").equals("上传")){
			Eassy eassy = new Eassy();
			EssayDAO essayDAO = new EssayDAO();
			//新建文章
			eassy.setHeadline(draft.getHeadline());
			eassy.setID(user.getID());
			eassy.setContent(draft.getContent());
			eassy.setType("小说");
			eassy.setSkim(0);
			eassy.setThump(0);
			if(temp == null){
				essayDAO.add(eassy);
			}else{
				essayDAO.add(eassy);
				//删除草稿中的该文章
				draftDAO.delete(draft.getID(), draft.getHeadline());
			}
		}else if(request.getParameter("submit").equals("保存")){
		    //保存草稿
		    if(temp == null){
		    	draftDAO.add(draft);
		    }
		    else{
		    	draftDAO.update(draft, request.getParameter(theme));
		    }
		}
		response.sendRedirect("upload.jsp");
	}

}
