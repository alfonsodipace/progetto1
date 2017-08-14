package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UtenteBean;
import bean.UtenteBeanDao;

/**
 * Servlet implementation class MainTest
 */
@WebServlet("/MainTest")
public class MainTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//PrintWriter out = response.getWriter();
		
		
		
		String email = request.getParameter("email"); //"test@email.it"
		
		System.out.println("sono dentro");
		System.out.println(email);
		UtenteBean bn = new UtenteBean();
		UtenteBeanDao dao = new UtenteBeanDao();
		try {
			bn=dao.doRetrieveByKey(email);
		} catch (SQLException e) {
			System.out.println("email non presente");
			e.printStackTrace();
		}
		
		 request.setAttribute("UtenteBean", bn);

		 // Forward to to the JSP file.
		 request.getRequestDispatcher("Home.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
