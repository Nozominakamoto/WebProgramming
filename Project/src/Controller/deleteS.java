package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userDao;
import model.UserBeans;

@WebServlet("/deleteS")
public class deleteS extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public deleteS() { super(); }

    protected void doGet(HttpServletRequest request,
		HttpServletResponse response)throws ServletException, IOException {

    	request.setCharacterEncoding("UTF-8");

    	String id = request.getParameter("id");

    	request.setAttribute("id", id);

    	userDao userDao = new userDao();
    	UserBeans UserData = userDao.findByDataInfo(id);
    	request.setAttribute("UserData",UserData );

    	RequestDispatcher dispatcher = request.getRequestDispatcher
				("/WEB-INF/jsp/delete.jsp");
        dispatcher.forward(request, response);

	}

    protected void doPost(HttpServletRequest request,
    		HttpServletResponse response) throws ServletException, IOException {

    	request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        userDao userDao = new userDao();
		userDao.deleteData(id);
    	response.sendRedirect("listS");
    }
}