package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SerchBean;
import servise.KaiinServise;

/**
 * Servlet implementation class SerchSerblet
 */
@WebServlet("/SerchSerblet")
public class SerchSerblet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SerchSerblet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String serchIdStr = request.getParameter("id");
		int serchId = Integer.parseInt(serchIdStr);
		KaiinServise ks = new KaiinServise();
		SerchBean sb = ks.getSerch(serchId);
		request.setAttribute("bean", sb);
		RequestDispatcher disp = request.getRequestDispatcher("/serch.jsp");
		disp.forward(request, response);
	}

}
