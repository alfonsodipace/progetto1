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

import bean.CarrelloBeanDao;
import bean.Riempie1Bean;
import bean.Riempie1BeanDao;

/**
 * Servlet implementation class CarrelloAction
 */
@WebServlet("/CarrelloAction")
public class CarrelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarrelloAction() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		HttpSession session = request.getSession(); 
		
		
											// AGGIUNGI
		if(action.equals("aggiungi")) {
			Riempie1BeanDao fill= new Riempie1BeanDao();
			Riempie1Bean bean = new Riempie1Bean();
			CarrelloBeanDao carDao= new CarrelloBeanDao();
			String tipo = request.getParameter("tipo");
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			Double prezzo = Double.parseDouble(request.getParameter("prezzo"));
			int idProd = Integer.parseInt(request.getParameter("idprodotto"));
			
			try{
				bean.setEmail(email);
				bean.setNome(nome);
				bean.setPrezzo(prezzo);
				bean.setTipo(tipo);
				bean.setIdCarrello(carDao.doRetrieveIDByEmail(email));
				bean.setIdProdotto(idProd);
				fill.doSave(bean);
			
				if(tipo.equals("panino")){
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Panini.jsp");
				dispatcher.forward(request, response);
				}else if(tipo.equals("bibita")){
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Bibite.jsp");
					dispatcher.forward(request, response);
				}else if(tipo.equals("dolce")){
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Dolci.jsp");
					dispatcher.forward(request, response);
				}else if(tipo.equals("rosticceria")){
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Rosticceria.jsp");
					dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
													// RIMUOVI	
		} else if (action.equals("rimuovi")){
			
			String tipo = request.getParameter("tipo");
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			Double prezzo = Double.parseDouble(request.getParameter("prezzo"));
			int idCar = Integer.parseInt(request.getParameter("idcarrello"));
			int idProd = Integer.parseInt(request.getParameter("idprodotto"));
			Riempie1Bean bean = new Riempie1Bean();
			Riempie1BeanDao dao = new Riempie1BeanDao();
			bean.setEmail(email);
			bean.setNome(nome);
			bean.setPrezzo(prezzo);
			bean.setTipo(tipo);
			bean.setIdCarrello(idCar);
			bean.setIdProdotto(idProd);
			try {
				dao.doDelete(bean);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Carrello.jsp");
			dispatcher.forward(request, response);
			
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
