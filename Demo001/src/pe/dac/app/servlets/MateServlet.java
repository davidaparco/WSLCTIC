package pe.dac.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MateServlet
 */
@WebServlet({ "/Sumar", "/Restar", "/Multiplicar", "/Dividir", "/Mayor" })
public class MateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    /**
     * Se recibe dos par�metros: n1 y n2
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String path = request.getServletPath();
		if(path.equals("/Sumar")) {
			sumar(request,response);
		} else if(path.equals("/Restar")) {
			restar(request,response);
		} else if(path.equals("/Multiplicar")) {
			multiplicar(request,response);
		} else if(path.equals("/Dividir")) {
			dividir(request,response);
		} else if(path.equals("/Mayor")) {
			mayor(request,response);
		}
	}

	private void mayor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// Datos
		int num1 = Integer.parseInt(request.getParameter("n1"));
		int num2 = Integer.parseInt(request.getParameter("n2"));
		int num3 = Integer.parseInt(request.getParameter("n3"));
		// Mayor
		int lista[] = {num1, num2, num3};
		Arrays.sort(lista);
		int numMayor = lista[lista.length - 1];
		// Reporte
		request.setAttribute("n1", num1);
		request.setAttribute("n2", num2);
		request.setAttribute("n3", num3);
		request.setAttribute("mayor", numMayor);
		// Forward
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("mayor.jsp");
		rd.forward(request, response);
	}

	private void dividir(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int num1 = Integer.parseInt(request.getParameter("n1"));
		int num2 = Integer.parseInt(request.getParameter("n2"));
		// Proceso
		double dividir = (double) num1 / num2;
		// Reporte
		response.setContentType("text/html");
		PrintWriter out = response. getWriter();
		out.println("<p>N�mero 1: " + num1 + "</p>");
		out.println("<p>N�mero 2: " + num2 + "</p>");
		out.println("<p>Divisi�n: " + dividir + "</p>");
		out.flush();
	}

	private void multiplicar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int num1 = Integer.parseInt(request.getParameter("n1"));
		int num2 = Integer.parseInt(request.getParameter("n2"));
		// Proceso
		int multiplicar = num1 * num2;
		// Reporte
		response.setContentType("text/html");
		PrintWriter out = response. getWriter();
		out.println("<p>N�mero 1: " + num1 + "</p>");
		out.println("<p>N�mero 2: " + num2 + "</p>");
		out.println("<p>Producto: " + multiplicar + "</p>");
		out.flush();
		
	}

	private void restar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int num1 = Integer.parseInt(request.getParameter("n1"));
		int num2 = Integer.parseInt(request.getParameter("n2"));
		// Proceso
		int restar = num1 - num2;
		// Reporte
		response.setContentType("text/html");
		PrintWriter out = response. getWriter();
		out.println("<p>N�mero 1: " + num1 + "</p>");
		out.println("<p>N�mero 2: " + num2 + "</p>");
		out.println("<p>Resta: " + restar + "</p>");
		out.flush();
	}

	private void sumar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int num1 = Integer.parseInt(request.getParameter("n1"));
		int num2 = Integer.parseInt(request.getParameter("n2"));
		// Proceso
		int suma = num1 + num2;
		// Reporte
		response.setContentType("text/html");
		PrintWriter out = response. getWriter();
		out.println("<p>N�mero 1: " + num1 + "</p>");
		out.println("<p>N�mero 2: " + num2 + "</p>");
		out.println("<p>Suma: " + suma + "</p>");
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
