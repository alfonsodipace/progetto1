package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



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
		
		
		if(action.equals("aggiungi")) {
			Riempie1BeanDao fill= new Riempie1BeanDao();
			Riempie1Bean bean = new Riempie1Bean();
			CarrelloBeanDao carDao= new CarrelloBeanDao();
			String tipo = request.getParameter("tipo");
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			
			Double prezzo = Double.parseDouble(request.getParameter("prezzo"));
			try{
			bean.setEmail(email);
			bean.setNome(nome);
			bean.setPrezzo(prezzo);
			bean.setTipo(tipo);
			bean.setIdCarrello(carDao.doRetrieveIDByEmail(email));
			fill.doSave(bean);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
