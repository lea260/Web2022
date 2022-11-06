package controller;

import java.io.IOException;
import java.util.ArrayList;
import dto.PersonaDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ClienteDao;

/**
 * Servlet implementation class ClienteListar
 */
@WebServlet("/ClienteListar")
public class ClienteListar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClienteListar() {
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
		ClienteDao dao = new ClienteDao();
		ArrayList<PersonaDto> array = dao.listar();
		// ClientePool pool = new ClientePool();
		// ArrayList<ClienteEntidad> array = pool.obternerListaClientes();
		request.setAttribute("lista", array);
		RequestDispatcher rd = request.getRequestDispatcher("/clienteListar.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
