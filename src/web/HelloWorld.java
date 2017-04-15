package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/say-helloworld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    response.setContentType("text/html;charset=utf-8");
            response. setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            Enumeration en = request.getParameterNames();
            while (en.hasMoreElements()){
                String paramName = (String) en.nextElement();
                if((paramName.equals("language"))&&(request.getParameter(paramName).equals("english"))){
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>HelloWorld</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("HelloWorld");
                    out.println("</body>");
                    out.println("</html>");
                    break;
                }
                else if((paramName.equals("language"))&&(request.getParameter(paramName).equals("chinese"))){
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>向世界问好</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("尼玛嗨");
                    out.println("</body>");
                    out.println("</html>");
                    break;
                }
                else if((paramName.equals("language"))&&(request.getParameter(paramName).equals("mars"))){
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Burning Burning Burning</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("B神好");
                    out.println("</body>");
                    out.println("</html>");
                    break;
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
