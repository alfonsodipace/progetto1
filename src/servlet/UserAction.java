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
import bean.Riempie1Bean;
import bean.Riempie1BeanDao;
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
	}
	// 											
	protected int generaIdCarrello(){
		int id =0,i = 0;
		CarrelloBeanDao daoCar= new CarrelloBeanDao();
		while(i==0) {
			Random r= new Random();
			id = r.nextInt(899999)+100000;
			try {
				if(daoCar.doRetrieveById(id))
					i = 1;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(); 
		String action = request.getParameter("action");


		// REGISTRAZIONE //
		if(action.equals("registrazione")) {

			CarrelloBeanDao daoCar = new CarrelloBeanDao();
			UtenteBeanDao dao = new UtenteBeanDao();
			UtenteBean bn = new UtenteBean();

			
			CarrelloBean car = (CarrelloBean) session.getAttribute("carrello");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			String cognome = request.getParameter("lastname");
			String nome = request.getParameter("firstname");
			String indirizzo = request.getParameter("indirizzo");
			String telefono = request.getParameter("telefono");
			Object oggettiCar=  session.getAttribute("oggettiCar");
			int idCarrello = generaIdCarrello();

			try {
				
				bn.setCognome(cognome);
				bn.setEmail(email);
				bn.setIndirizzo(indirizzo);
				bn.setNome(nome);
				bn.setPass(pass);
				bn.setTipo("utente");
				bn.setTelefono(telefono);
				dao.doSave(bn);	
				car.setIdCarrello(idCarrello);
				car.setEmail(email);
				daoCar.doSave(car);
				
				if(!((ArrayList<Riempie1Bean>)oggettiCar).isEmpty()){
					Riempie1BeanDao fill= new Riempie1BeanDao();
					for(Riempie1Bean s : ((ArrayList<Riempie1Bean>)oggettiCar)){
						s.setEmail(email);
						s.setIdCarrello(idCarrello);
						fill.doSave(s);
					}
				}
				
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
					if(bn.getEmail() == null) {
						session.setAttribute("failedLog", "true");
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Accesso.jsp");
						dispatcher.forward(request, response);
					}
					else if((bn.getPass().equals(pass))) {
						bn.setState("loggato");
						session.setAttribute("user", bn);
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Home.jsp");
						dispatcher.forward(request, response);
					}
					else { 
						session.setAttribute("failedLog", "true");
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Accesso.jsp");
						dispatcher.forward(request, response);	
					}
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block	
				}
 
			}

			// LOG-OUT //
			else if(action.equals("logout")) {
				session.invalidate();
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Home.jsp");
				dispatcher.forward(request, response);	
			}


			// AGGIORNAMENTO //
			else if(action.equals("aggiornamento")) {
				UtenteBeanDao dao = new UtenteBeanDao();
				UtenteBean bn = new UtenteBean();
				UtenteBean utente = (UtenteBean) session.getAttribute("user"); 

				String cognome = request.getParameter("lastname");
				String nome = request.getParameter("firstname");
				String indirizzo = request.getParameter("indirizzo");
				String telefono = request.getParameter("telefono");
				String emai = utente.getEmail();

				bn.setNome(nome); 
				bn.setCognome(cognome);
				bn.setIndirizzo(indirizzo);
				bn.setTelefono(telefono);
				bn.setEmail(emai);

				try {
					dao.doUpdate(bn); //aggiorna il db
					utente.setNome(nome); //aggiorna i campi della sessione
					utente.setCognome(cognome);
					utente.setIndirizzo(indirizzo);
					utente.setTelefono(telefono);
					utente.setEmail(emai);

					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/MyAccount.jsp");
					dispatcher.forward(request, response);

				} catch (SQLException e) {
					e.printStackTrace();
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
