package servlet;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet (name="/RegServlet", urlPatterns ={"/Fileupload"}, initParams = {@WebInitParam(name ="FIle-upload", value = "tmpDir")})
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out =  response.getWriter();

		String action = request.getParameter("action");
		
		
		String idProdotto = request.getParameter("idProdotto");
		
		
		response.setContentType("text/plain");
		String savePath= request.getServletContext().getRealPath("") + "immagini" + File.separator + SAVE_DIR;
		
		//salvo la patch nel db
		
		
		
		File fileSavedDir = new File(savePath);
		if(!fileSavedDir.exists()){
			fileSavedDir.mkdir();
		}
		
		out.write("upload= \n");
		for(Part part: request.getParts()) {
			String fileName = extractFileName(part);
			if(fileName != null && !fileName.equals("")) {
				part.write(savePath + File.separator + fileName);
				System.out.println(savePath + File.separator + fileName);
				out.write(fileName +"\n");
			}
		}
		out.close();
		
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
	
	private String metodo(String origin, String replacement) {
		if((origin==null) || (origin.trim().equals("")) ) {
			return replacement;
		}
		else 
			return origin;
	}
}
