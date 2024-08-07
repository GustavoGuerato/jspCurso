package servlet;

import java.io.IOException;
import java.sql.SQLException;

import beans.BeansCursoJsp;
import beans.Telefones;
import dao.DaoTelefone;
import dao.DaoUsuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/salvarTelefones")
public class TelefoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoUsuario daoUsuario = new DaoUsuario();
	private DaoTelefone daoTelefone = new DaoTelefone(null);

	public TelefoneServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String acao = request.getParameter("acao");

			if (acao.equalsIgnoreCase("addfone")) {
				String user = request.getParameter("user");

				BeansCursoJsp usuario = daoUsuario.consultar(user);

				request.getSession().setAttribute("userEscolhido", usuario);
				request.setAttribute("userEscolhido", usuario);

				RequestDispatcher view = request.getRequestDispatcher("/telefones.jsp");
				request.setAttribute("usuarios", daoTelefone(usuario));
				request.setAttribute("msg", "Telefone salvo com sucesso");
				view.forward(request, response);
			} else if (acao.equalsIgnoreCase("deleteFone")) {
				String idFone = request.getParameter("idFone");
				daoTelefone.removerTelefone(idFone);

			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao salvar telefone: " + e.getMessage());

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			BeansCursoJsp beansCursoJsp = (BeansCursoJsp) request.getSession().getAttribute("userEscolhido");
			if (beansCursoJsp == null) {
				throw new ServletException("Usuário não encontrado na sessão.");
			}

			String numero = request.getParameter("numero");
			String tipo = request.getParameter("tipo");

			Telefones telefones = new Telefones();
			telefones.setNumero(numero);
			telefones.setTipo(tipo);
			telefones.setUsuario(beansCursoJsp.getId());

			daoTelefone(beansCursoJsp);

			RequestDispatcher view = request.getRequestDispatcher("/telefones.jsp");
			request.setAttribute("usuarios", daoTelefone(beansCursoJsp));
			request.setAttribute("msg", "Telefone salvo com sucesso");
			view.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao salvar telefone: " + e.getMessage());

		}

	}

	private Object daoTelefone(BeansCursoJsp beansCursoJsp) {
		// TODO Auto-generated method stub
		return null;
	}

}
