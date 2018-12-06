package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userDao;
import model.UserBeans;


@WebServlet("/updateS")
public class updateS extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public updateS() { super(); }

    protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {

    	request.setCharacterEncoding("UTF-8");

    	String Id = request.getParameter("id");
    	request.setAttribute("Id", Id);

    	userDao userDao = new userDao();
    	UserBeans UpDataId = userDao.findByDataInfo(Id);
    	request.setAttribute("UpDataId",UpDataId );

		RequestDispatcher dispatcher = request.getRequestDispatcher
				("/WEB-INF/jsp/update.jsp");
        dispatcher.forward(request, response);

	}

    protected void doPost(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {

    	request.setCharacterEncoding("UTF-8");

    	String Id = request.getParameter("Id");
    	String password = request.getParameter("pass");
    	String confirmPass = request.getParameter("confirmPass");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		request.setAttribute("Id", Id);




		if((!password.equals(confirmPass))||(name.equals(""))||(birthday.equals(""))){
			request.setAttribute("errMsg", "入力された内容は正しくありません。");

	    	userDao userDao = new userDao();
	    	UserBeans UpDataId = userDao.findByDataInfo(Id);
	    	UpDataId.setId(Integer.parseInt(Id));


	    	try {
	    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				UpDataId.setBirthDate(new java.sql.Date(sdf.parse(birthday).getTime()));   //util型を変換
				UpDataId.setName(name);


	    	} catch (ParseException e) {
			}
	    	request.setAttribute("UpDataId",UpDataId );

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
			dispatcher.forward(request, response);
			return;
		}

		if((password.equals(""))&(confirmPass.equals(""))) {

			try {
	        	userDao userDaoDao = new userDao();
	            userDaoDao.update2(password,confirmPass,name,birthday,Id);
	            response.sendRedirect("listS");


	     }catch (SQLException e) {
	        	request.setAttribute("errMsg", "入力された内容は正しくありません。");

	        	userDao userDao = new userDao();
		    	UserBeans UpDataId = userDao.findByDataInfo(Id);
		    	UpDataId.setId(Integer.parseInt(Id));
		    	UpDataId.setName(name);

		    	try {
		    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					UpDataId.setBirthDate(new java.sql.Date(sdf.parse(birthday).getTime()));

				} catch (ParseException ex) {
		}
		   request.setAttribute("UpDataId",UpDataId );
		   RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
		   dispatcher.forward(request, response);
	    }



		    return;
		}







		try {
	        	userDao userDaoDao = new userDao();
	            userDaoDao.update(password,confirmPass,name,birthday,Id);
	            response.sendRedirect("listS");


	     }catch (SQLException e) {
	        	request.setAttribute("errMsg", "入力された内容は正しくありません。");

	        	userDao userDao = new userDao();
		    	UserBeans UpDataId = userDao.findByDataInfo(Id);
		    	UpDataId.setId(Integer.parseInt(Id));
		    	UpDataId.setName(name);

		    	try {
		    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					UpDataId.setBirthDate(new java.sql.Date(sdf.parse(birthday).getTime()));

				} catch (ParseException ex) {
		}
		   request.setAttribute("UpDataId",UpDataId );
		   RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
		   dispatcher.forward(request, response);
	    }
	 }


}