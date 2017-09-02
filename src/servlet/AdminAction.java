package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		if(action.equals("aggiungiProdotto")) {
			System.out.println("lalla");
			String tipo = request.getParameter("tipo");
			String nome = request.getParameter("nomeProdotto");
			String descizione = request.getParameter("descrizione");
			double prezzo = Double.parseDouble(request.getParameter("prezzo"));
			
			ProdottoBeanDao bndao = new ProdottoBeanDao();
			ProdottoBean bn = new ProdottoBean();
			bn.setNome(nome);
			bn.setDesc(descizione);
			bn.setPrezzo(prezzo);
			bn.setTipo(tipo);
			try {
				bndao.doSave(bn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			// qui sono cazzi, non sembra startare
	        FileUploadServlet ob=new FileUploadServlet();
	        ob.doPost(request, response);
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
