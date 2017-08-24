package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UtenteBean;
import bean.UtenteBeanDao;

/**
 * Servlet implementation class UserAction
 */
@WebServlet("/UserAction")
public class UserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(); 
		
		String action = request.getParameter("action");
		
		
		 									// REGISTRAZIONE //
		if(action.equals("registrazione")) {
			
			UtenteBeanDao dao = new UtenteBeanDao();
			UtenteBean bn = new UtenteBean();
			
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			String cognome = request.getParameter("lastname");
			String nome = request.getParameter("firstname");
			String indirizzo = request.getParameter("indirizzo");
			
			try {
				bn.setCognome(cognome);
				bn.setEmail(email);
				bn.setIndirizzo(indirizzo);
				bn.setNome(nome);
				bn.setPass(pass);
				bn.setTipo("utente");
				dao.doSave(bn);		
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
											    // LOGIN //
		if(action.equals("login")) {
			
			PrintWriter out = response.getWriter();
			
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			
			UtenteBeanDao dao = new UtenteBeanDao();
			UtenteBean bn = new UtenteBean();
			
			try {
				bn = dao.doRetrieveByKey(email);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(bn.getPass().equals(pass)) {
//				out.println("Benvento "+ bn.getNome());
				bn.setState(true);
				session.setAttribute("user", bn);
				//response.sendRedirect("index.jsp");     da completare
			}
			else
				out.println("Email o Password errati!");
			
		}
		
		
											   	// LOGOUT //
		if(action.equals("logout")) {
					
			session.invalidate();
			//response.sendRedirect("index.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
