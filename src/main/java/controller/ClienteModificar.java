package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.PersonaDto;
import modelo.ClienteDao;

/**
 * Servlet implementation class ClienteModificar
 */
@WebServlet("/ClienteModificar")
public class ClienteModificar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClienteModificar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// modificar al cliente
		try {
			ClienteDao dao = new ClienteDao();
			String idStr = request.getParameter("id");
			String idNombreStr = request.getParameter("nombre");
			String EdadStr = request.getParameter("edad");
			int idInt = Integer.parseInt(idStr);
			int edadInt = Integer.parseInt(EdadStr);
			PersonaDto cli = new PersonaDto(idInt, idNombreStr, edadInt);
			dao.actualizar(cli);
			ArrayList<PersonaDto> array = dao.listar();
			request.setAttribute("lista", array);
			RequestDispatcher rd = request.getRequestDispatcher("/clienteListar.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}