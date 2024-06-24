package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import beans.BeansCursoJsp;
import dao.DaoUsuario;

@WebServlet("/salvarUsuario")
public class Usuario extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private DaoUsuario daoUsuario = new DaoUsuario();
    
    public Usuario() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String login = request.getParameter("login");
      String senha = request.getParameter("senha");
      
      BeansCursoJsp usuario = new BeansCursoJsp();
      
      daoUsuario.salvar(usuario);
    }
}
