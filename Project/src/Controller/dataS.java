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


@WebServlet("/dataS")
public class dataS extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public dataS() { super(); }

    protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

    	String id = request.getParameter("id");

    	request.setCharacterEncoding("UTF-8");


    	userDao userDao = new userDao();
    	UserBeans UserData = userDao.findByDataInfo(id);
    	request.setAttribute("UserData",UserData );




    	RequestDispatcher dispatcher = request.getRequestDispatcher
				("/WEB-INF/jsp/data.jsp");
        dispatcher.forward(request, response);
	}



}