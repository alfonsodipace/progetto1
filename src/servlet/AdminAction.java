package servlet;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CarrelloBeanDao;
import bean.OrdinaBean;
import bean.OrdinaBeanDao;
import bean.PagamentoBean;
import bean.PagamentoBeanDao;
import bean.ProdottoBean;
import bean.ProdottoBeanDao;

/**
 * Servlet implementation class AdminAction
 */
@WebServlet("/AdminAction")
public class AdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//	response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");

		if(action.equals("rimuoviProdotto")) {
			int idProdotto = Integer.parseInt(request.getParameter("idprodotto"));
			String tipo = request.getParameter("tipo");

			ProdottoBeanDao bndao = new ProdottoBeanDao();
			ProdottoBean bn = new ProdottoBean();


			bn.setIdProdotto(idProdotto);
			bn.setTipo(tipo);

			try {
				bndao.doDelete(bn);

				if(tipo.equals("bibita")){

					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Bibite.jsp");
					dispatcher.forward(request, response);
				}
				if(tipo.equals("panino")){

					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Panini.jsp");
					dispatcher.forward(request, response);
				}
				if(tipo.equals("rosticceria")){

					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Rosticceria.jsp");
					dispatcher.forward(request, response);
				}
				if(tipo.equals("dolce")){

					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Dolci.jsp");
					dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		else if(action.equals("evadiOrdine")){
			CarrelloBeanDao daoCar = new CarrelloBeanDao();
			OrdinaBeanDao daoOrd = new OrdinaBeanDao();
			OrdinaBean ordBea = new OrdinaBean();
			PagamentoBean pag = new PagamentoBean();
			PagamentoBeanDao daop = new PagamentoBeanDao();
			int idOrdine = Integer.parseInt(request.getParameter("idordine"));
			String email = request.getParameter("email");
			int idCarrello=0;

			try {
				idCarrello = daoCar.doRetrieveIDByEmail(email);

				ordBea=daoOrd.doRetrieveByeId(idOrdine);
				pag.setDataAcquisto(ordBea.getDataOrdine());

				pag.setIdCarrello(idCarrello);
				pag.setEmail(email);

				daop.doSave(pag);
				daoOrd.evadiOrdine(idOrdine);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GestisciOrdini.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
			}
		}
		// REINDIRIZZA ALLA PAGINA DI MODIFICA PRODOTTO
		else if(action.equals("modifica")) { 
			int idProd = Integer.parseInt(request.getParameter("idprodotto"));
			request.setAttribute("idProd", idProd);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/SetProdotto.jsp");
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
