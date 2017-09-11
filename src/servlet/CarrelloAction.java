package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.*;


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
		HttpSession session = request.getSession(); 
		String action = request.getParameter("action");
	
		
		
											// AGGIUNGI
		if(action.equals("aggiungi")) {
			UtenteBean utente = (UtenteBean) session.getAttribute("user");
			
			if(utente.getState().equals("loggato")){
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
		} else {
			CarrelloBean carrello = (CarrelloBean) session.getAttribute("carrello");
			Riempie1Bean bean = new Riempie1Bean();
			@SuppressWarnings("unchecked")
			ArrayList<Riempie1Bean> listCar =( ArrayList<Riempie1Bean> ) session.getAttribute("oggettiCar");
			String tipo = request.getParameter("tipo");
			String nome = request.getParameter("nome");
			Double prezzo = Double.parseDouble(request.getParameter("prezzo"));
			int idProd = Integer.parseInt(request.getParameter("idprodotto"));
			
				carrello.setEmail("");
				carrello.setIdCarrello(generaIdCarrello());
				bean.setEmail(carrello.getEmail());
				bean.setNome(nome);
				bean.setPrezzo(prezzo);
				bean.setTipo(tipo);
				bean.setIdCarrello(carrello.getIdCarrello());
				bean.setIdProdotto(idProd);
				listCar.add(bean);
			
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
			
			
		}
			
			
			
													// RIMUOVI	
		} else if (action.equals("rimuovi")){
			UtenteBean utente = (UtenteBean) session.getAttribute("user");
			
			if(utente.getState().equals("loggato")){
			
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
			
			} else {
				int idProd = Integer.parseInt(request.getParameter("idprodotto"));
				@SuppressWarnings("unchecked")
				ArrayList<Riempie1Bean> listCar =( ArrayList<Riempie1Bean> ) session.getAttribute("oggettiCar");
				for(int i=0;i< listCar.size();i++){
				if(listCar.get(i).getIdProdotto()==idProd){
					listCar.remove(i);
					break;
				}
				}
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Carrello.jsp");
				dispatcher.forward(request, response);
			}
			
		} else if(action.equals("buy")) {
			UtenteBean utente = (UtenteBean) session.getAttribute("user");
			
			if(utente.getState().equals("loggato")){
			ProdottoBeanDao prodDao = new ProdottoBeanDao();
			ArrayList<Riempie1Bean> inCar = new ArrayList<>();
			Riempie1BeanDao daoIncar = new Riempie1BeanDao();
			OrdinaBeanDao daoOrdine = new OrdinaBeanDao();
			String email = request.getParameter("email");	
			try {
				inCar=daoIncar.doRetrieveByKey(email);
				if(!inCar.isEmpty()){
				for(Riempie1Bean s : inCar){
					OrdinaBean ordine = new OrdinaBean();
					int idProdotto = s.getIdProdotto();
					ordine.setIdProdotto(idProdotto);
					ordine.setEmail(email);
					daoOrdine.doSave(ordine);
					prodDao.incrementaVenduti(idProdotto);
				}
				
				for(Riempie1Bean s : inCar){
					daoIncar.doDelete(s);
				}
				session.setAttribute("acquistato", "si");
					} 	
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally{
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Carrello.jsp");
				dispatcher.forward(request, response);
			}
			}   else {
		  	session.setAttribute("acquistato", "no");
		  	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Registrazione.jsp");
			dispatcher.forward(request, response);
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

}
