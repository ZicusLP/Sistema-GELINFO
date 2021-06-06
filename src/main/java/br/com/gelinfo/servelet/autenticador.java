package br.com.gelinfo.servelet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gelinfo.DAO.UsuarioDAO;
import br.com.gelinfo.domain.Usuario;

@WebServlet("/autenticador")
public class autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public autenticador() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		

		
		response.sendRedirect("pages/index.xhtml");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String nomeUsuario = request.getParameter("login");
		String senhaUsuario = request.getParameter("senha");

		Usuario u = new Usuario();
		u.setLogin(nomeUsuario);
		u.setSenha(senhaUsuario);

		UsuarioDAO udao = new UsuarioDAO();

		Usuario uAutenticado = udao.autenticacao(u);

		if (uAutenticado != null) {
			
			
			request.getRequestDispatcher("pages/index.xhtml").forward(request, response);

		}
	}

}
