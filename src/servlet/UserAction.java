package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

import bean.CarrelloBean;
import bean.CarrelloBeanDao;
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

    
    protected int generaIdCarrello(){
    	int id =0,i = 0;
    	CarrelloBeanDao daoCar= new CarrelloBeanDao();
    	while(i==0)
    	{
    	Random r= new Random();
    	id = r.nextInt(899999)+100000;
    	try {
			if(daoCar.doRetrieveById(id))
				i = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
    	return id;
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
			CarrelloBeanDao daoCar = new CarrelloBeanDao();
			CarrelloBean car = new CarrelloBean();
			UtenteBeanDao dao = new UtenteBeanDao();
			UtenteBean bn = new UtenteBean();
			
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			String cognome = request.getParameter("lastname");
			String nome = request.getParameter("firstname");
			String indirizzo = request.getParameter("indirizzo");
			int idCar=generaIdCarrello();
			
			try {
				bn.setCognome(cognome);
				bn.setEmail(email);
				bn.setIndirizzo(indirizzo);
				bn.setNome(nome);
				bn.setPass(pass);
				bn.setTipo("utente");
				dao.doSave(bn);		
				car.setIdCarrello(idCar);
				car.setEmail(email);
				car.setTotale(0);
				daoCar.doSave(car);
				session.setAttribute("goodReg", "ok");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Accesso.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
											    // LOGIN //
		if(action.equals("login")) {
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			
			UtenteBeanDao dao = new UtenteBeanDao();
			UtenteBean bn = new UtenteBean();
			
			try {
				bn = dao.doRetrieveByKey(email);
			} catch (SQLException e) {
				session.setAttribute("failedLog", "true");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Accesso.jsp");
				dispatcher.forward(request, response);	
			}
			
			
			if(!(bn==null)&&(bn.getPass().equals(pass))) {
				bn.setState("loggato");
				session.setAttribute("user", bn);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Home.jsp");
				dispatcher.forward(request, response);	
			} else{ 
				session.setAttribute("failedLog", "true");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Accesso.jsp");
			dispatcher.forward(request, response);	
				}
			}
			else{ 
		if(action.equals("logout")) {
			session.invalidate();
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Home.jsp");
			dispatcher.forward(request, response);	
			}
		}
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
