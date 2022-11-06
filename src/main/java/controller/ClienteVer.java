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
 * Servlet implementation class ClienteVer
 */
@WebServlet("/ClienteVer")
public class ClienteVer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClienteVer() {
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
		try {
			ClienteDao dao = new ClienteDao();
			String idStr = request.getParameter("id");
			// String param = request.getParameter("param");
			int idInt = Integer.parseInt(idStr);
			ArrayList<PersonaDto> clientes = dao.listar();
			/*
			 * lo obtengo por id
			 */
			boolean encontrado = false;
			int i = 0;
			PersonaDto cliente = new PersonaDto(1, 1, "");
			do {
				cliente = clientes.get(i);
				if (cliente.getId() == idInt) {
					encontrado = true;
				}
				i++;
			} while (i < clientes.size() && !encontrado);
			request.setAttribute("cli", cliente);
			// request.setAttribute("clave", param);
			RequestDispatcher rd = request.getRequestDispatcher("/clienteVer.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}

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