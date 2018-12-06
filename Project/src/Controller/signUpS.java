package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userDao;

@WebServlet("/signUpS")
public class signUpS extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public signUpS() { super(); }

    protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp");
        dispatcher.forward(request, response);
	}

    protected void doPost(HttpServletRequest request,
    		HttpServletResponse response) throws ServletException, IOException {

    	request.setCharacterEncoding("UTF-8");


    	String LoginId = request.getParameter("loginId");
    	String password = request.getParameter("pass");
    	String confirmPass = request.getParameter("confirmPass");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");


		if((!password.equals(confirmPass))||(LoginId.equals(""))||(password.equals(""))||(confirmPass.equals(""))||(name.equals(""))||(birthday.equals(""))) {
			request.setAttribute("errMsg", "入力された内容は正しくありません。");
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp");
			dispatcher.forward(request, response);
		return;}


        try {
        	userDao userDao = new userDao();
            userDao.signUpData(LoginId,password,confirmPass,name,birthday);
            response.sendRedirect("listS");

        }catch (SQLException e) {
        	request.setAttribute("errMsg", "入力された内容は正しくありません。");
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp");
			dispatcher.forward(request, response);

        }
    }
}
