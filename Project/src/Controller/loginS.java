package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.userDao;
import model.UserBeans;


@WebServlet("/loginS")
public class loginS extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public loginS() { super(); }

    protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher
				("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        // リクエストパラメータの文字コードを指定
        request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの入力項目を取得
		String LoginId = request.getParameter("id");
		String password = request.getParameter("pass");

		userDao userDao = new userDao();
		UserBeans user = userDao.findByLoginInfo(LoginId, password);

				if (user == null ) {
					// リクエストスコープにエラーメッセージをセット
					request.setAttribute("errMsg", "ログインに失敗しました。");

					// ログインjspにフォワード
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
					dispatcher.forward(request, response);
					return;
				}

				/** テーブルに該当のデータが見つかった場合 **/
				// セッションスコープにuser(ログイン時のidとpass,管理者含む)を、属性名UserInfoとして保存
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", user);

				// ユーザ一覧のサーブレットにリダイレクト
				response.sendRedirect("listS");

			}

}
