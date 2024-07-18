package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import beans.BeansCursoJsp;
import dao.DaoUsuario;

@WebServlet("/salvarTelefones")
public class TelefoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoUsuario daoUsuario = new DaoUsuario();

	public TelefoneServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String user = request.getParameter("user");

			BeansCursoJsp usuario = daoUsuario.consultar(user);

			request.getSession().setAttribute("userEscolhido", usuario);
			request.setAttribute("userEscolhido", usuario.getId());
			request.setAttribute("userEscolhidoNome", usuario.getNome());

			RequestDispatcher view = request.getRequestDispatcher("/telefones.jsp");
			// request.setAttribute("usuarios", daoUsuario.listar());
			request.setAttribute("msg", "salvo com sucesso");
			request.getSession().setAttribute("user", usuario.getId());
			request.getSession().setAttribute("nomeUser", usuario.getId());
			view.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
