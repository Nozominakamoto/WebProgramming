package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userDao;
import model.UserBeans;


@WebServlet("/listS")
public class listS extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public listS() {super();}


	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException {

		//全てのユーザ情報をuserListに入れる(管理者以外)
		userDao userDao = new userDao();
		List<UserBeans> userList = userDao.findAll();

		//リクエストスコープにuserListを保存
		request.setAttribute("UserList", userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Name = request.getParameter("name");
		String loginId = request.getParameter("loginId");
		String date = request.getParameter("date");
		String day = request.getParameter("day");

		userDao userDao = new userDao();
		List<UserBeans> userList = userDao.search(Name,loginId,date,day);

		request.setAttribute("UserList", userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);
	}

}
