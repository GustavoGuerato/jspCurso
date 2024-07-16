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

@WebServlet("/salvarUsuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoUsuario daoUsuario = new DaoUsuario();

	public UsuarioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String user = request.getParameter("user");

		try {
			if (acao != null) {
				switch (acao) {
				case "delete":
					daoUsuario.delete(user);
					listarUsuarios(request, response);
					break;

				case "edit":
					BeansCursoJsp usuario = daoUsuario.consultar(user);
					request.setAttribute("usuario", usuario);
					RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
					view.forward(request, response);
					break;

				case "listartodos":
					listarUsuarios(request, response);
					break;

				default:
					response.sendRedirect(request.getContextPath() + "/home.jsp");
					break;
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/home.jsp");
			}
		} catch (SQLException e) {
			throw new ServletException("Erro ao processar a ação: " + acao, e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if ("reset".equalsIgnoreCase(acao)) {
			try {
				listarUsuarios(request, response);
			} catch (SQLException e) {
				throw new ServletException("Erro ao listar usuários", e);
			}
		} else {
			String id = request.getParameter("id");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			String nome = request.getParameter("nome");
			String telefone = request.getParameter("telefone");
			String cep = request.getParameter("cep");
			String rua = request.getParameter("rua");
			String bairro = request.getParameter("bairro");
			String cidade = request.getParameter("cidade");
			String estado = request.getParameter("estado");
			String ibge = request.getParameter("ibge");

			BeansCursoJsp usuario = new BeansCursoJsp();
			usuario.setId(id != null && !id.isEmpty() ? Long.parseLong(id) : null);
			usuario.setLogin(login);
			usuario.setSenha(senha);
			usuario.setNome(nome);
			usuario.setTel(telefone);
			usuario.setCep(cep);
			usuario.setRua(rua);
			usuario.setBairro(bairro);
			usuario.setCidade(cidade);
			usuario.setEstado(estado);
			usuario.setIbge(ibge);

			try {
				String msg = validarCampos(login, senha, nome, telefone);
				if (msg != null) {
					request.setAttribute("msg", msg);
				} else {
					if (id == null || id.isEmpty()) {
						if (!daoUsuario.validarLogin(login)) {
							request.setAttribute("msg", "Usuário já existe com este login");
						} else {
							daoUsuario.salvar(usuario);
							request.setAttribute("msg", "Usuário salvo com sucesso!");
						}
					} else {
						daoUsuario.atualizar(usuario);
						request.setAttribute("msg", "Usuário atualizado com sucesso!");
					}
				}
				listarUsuarios(request, response);
			} catch (SQLException e) {
				throw new ServletException("Erro ao salvar ou atualizar usuário", e);
			}
		}
	}

	private void listarUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
		request.setAttribute("usuarios", daoUsuario.listar());
		request.setAttribute("msg", "salvo com sucesso");
		view.forward(request, response);
	}

	private String validarCampos(String login, String senha, String nome, String telefone) {
		if (login == null || login.isEmpty()) {
			return "Login deve ser informado";
		}
		if (senha == null || senha.isEmpty()) {
			return "Senha deve ser informada";
		}
		if (nome == null || nome.isEmpty()) {
			return "Nome deve ser informado";
		}
		if (telefone == null || telefone.isEmpty()) {
			return "Telefone deve ser informado";
		}
		return null;
	}
}
