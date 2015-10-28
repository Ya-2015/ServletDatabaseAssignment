package ServletAssignment;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAssignment
 */
@WebServlet("/ServletAssignment")
public class ServletDatabaseAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseCollection databaseCollection;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDatabaseAssignment() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException
    {
        // Do required initialization
    	databaseCollection = new DatabaseCollection();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");

		// Actual logic goes here.
	    PrintWriter out = response.getWriter();
	      
	    //get data from database
	    ArrayList<DemoCustomer> cus =  databaseCollection.getCustomerName(2);
	      
	    //print out in html
	    printHtml(out, cus);
	      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void destroy() 
	   { 
	     // do nothing. 
	   } 
	
	private void printHtml(PrintWriter out, ArrayList<DemoCustomer> cus){
		out.println("<!DOCTYPE html>");
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("<title>Display by Bootstrap</title>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\" integrity=\"sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		
		//display content in body
		out.println("<div class=\"container\">");
		out.println("<div class=\"jumbotron\">");
		//display customized data 
		out.println("<h2>Customer Name:</h2>");
		for (DemoCustomer d : cus){
			out.println("<h3>"+d.getFirstName()+", "+d.getLastName()+"</h3>");
		}
		
		//continue to complete body content
		out.println("</div>");
		out.println("</div>");
		//library links
		out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>");
		out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\" integrity=\"sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==\" crossorigin=\"anonymous\"></script>");
		out.println("</body>");
		out.println("</html>");
	    
	}
}
