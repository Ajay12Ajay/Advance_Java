package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserBean bean = null;
		int pageNo = 1;
		int pageSize = 5;

		UserModel model = new UserModel();
		try {
			List list = model.search(bean, pageNo, pageSize);

			req.setAttribute("list", list);
			req.setAttribute("pageNo", pageNo);

			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = null;
		int pageNo = 1;
		int pageSize = 5;

		String op = req.getParameter("operation");

		String[] ids = req.getParameterValues("ids");

		pageNo = Integer.parseInt(req.getParameter("pageNo"));

		UserModel model = new UserModel();

		try {
			if (op.equalsIgnoreCase("next")) {
				pageNo++;
			}

			if (op.equalsIgnoreCase("previous")) {
				pageNo--;
			}

			if (op.equalsIgnoreCase("search")) {
				pageNo = 1;
				bean = new UserBean();

				bean.setFirstName(req.getParameter("firstName"));

				bean.setDob(sdf.parse(req.getParameter("dob")));

			}

			if (op.equalsIgnoreCase("delete")) {
				pageNo = 1;
				if (ids != null && ids.length > 0) {
					for (String id : ids) {

						model.delete(Integer.parseInt(id));

					}
				}

			}

			List list = model.search(bean, pageNo, pageSize);

			req.setAttribute("list", list);
			req.setAttribute("pageNo", pageNo);

			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
