package servlet;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import bean.ProdottoBean;
import bean.ProdottoBeanDao;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet (name="/FileUploadServlet", urlPatterns ={"/Fileupload"}, initParams = {@WebInitParam(name ="FIle-upload", value = "tmpDir")})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize =1024 * 1024 * 10, maxRequestSize =1024 * 1024 * 50)	

public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String SAVE_DIR="";
  
	
	public void init() {
		SAVE_DIR = getServletConfig().getInitParameter("file-upload");
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");

		out.write("E' stato usato il metodo get ma e' richiesto il post");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter out =  response.getWriter();
		
		response.setContentType("text/plain");
		String savePath= request.getServletContext().getRealPath("") + "NewImages";
		
		String URLPath= "images" + File.separator + "NewImages";
		
		//salvo la patch nel db
		
		
		String fileName="";
		File fileSavedDir = new File(savePath);
		String tipo = request.getParameter("tipo");
		String nome = request.getParameter("nomeProdotto");
		String descizione = request.getParameter("descrizione");
		double prezzo = Double.parseDouble(request.getParameter("prezzo"));
		
		ProdottoBeanDao bndao = new ProdottoBeanDao();
		ProdottoBean bn = new ProdottoBean();
		if(!fileSavedDir.exists()){
			fileSavedDir.mkdir();
		}
		
	//	out.write("upload =\n");
		for(Part part: request.getParts()) {
			 fileName = extractFileName(part);
			if(fileName != null && !fileName.equals("")) {
				part.write(savePath + File.separator + fileName);
				bn.setNome(nome);
				bn.setDesc(descizione);
				bn.setPrezzo(prezzo);
				bn.setTipo(tipo);
				bn.setImmagine(URLPath + File.separator + fileName);
				//bn.setImmagine(savePath + File.separator + fileName);
				try {
					bndao.doSave(bn);
					
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddProdotto.jsp");
						dispatcher.forward(request, response);
						
						
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//out.write(savePath + File.separator + fileName +"\n");
			}
		}
		//out.close();
		
		
	}
	private String extractFileName(Part part) {
		String conentDisp= part.getHeader("content-disposition");
		String[] items = conentDisp.split(";");
		for(String s:items) {
			if(s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") +2 , s.length() -1 );
			}
		}
		return "";
	}
	
}
