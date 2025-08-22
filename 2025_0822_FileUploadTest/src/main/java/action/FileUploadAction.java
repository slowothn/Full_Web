package action;

import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import util.FileUploadUtils;

/**
 * Servlet implementation class FileUploadAction
 */

@WebServlet("/upload.do")
@MultipartConfig(   location="/", 
					fileSizeThreshold=1024*1024, 
					maxFileSize=1024*1024*5, 
					maxRequestSize=1024*1024*5*5)


public class FileUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//parameter변수
        String filename="no_file";
        String title="";
        
        //저장경로..
        //전역객체(현재 웹컨텍스트)를 관리하는 객체
        ServletContext application = request.getServletContext();
        
        //현재 웹프로그램 실제경로
        //System.out.println(application.getRealPath("/"));
        
        String saveDir = application.getRealPath("/upload/");
        //System.out.println(saveDir);
        
        
        request.setCharacterEncoding("utf-8");
        
        String contentType = request.getContentType();
        
        //System.out.println(contentType);
        
        
        // /upload.do?title=병아리&photo=병아리.png
        
        //화일업로드 전송
        if(contentType!=null && contentType.toLowerCase().startsWith("multipart/")) {
        	
        	//업로드된 파라메터 목록을 구한다(text/binary)
        	Collection<Part> parts = request.getParts();
        	
        	for(Part part : parts) {
        		
        		System.out.println(part.getHeader("Content-Disposition"));
        		
        		//upload화일이 있으면
        		if(part.getHeader("Content-Disposition").contains("filename")) {

        			if(part.getHeader("Content-Disposition").contains("photo")) {
        			    filename = FileUploadUtils.saveFile(part, saveDir, "photo");
        			}
        				

        		}else { //일반 파라메터면
        			//String formValue = request.getParameter(part.getName());
        			title = request.getParameter("title");
        		}
        		
        	}
        }//end:if
        
        
        //request binding
        request.setAttribute("title", title);
        request.setAttribute("filename", filename);
        
        //forward
        request.getRequestDispatcher("result1.jsp").forward(request, response);
        
        
		
		
	}

}
