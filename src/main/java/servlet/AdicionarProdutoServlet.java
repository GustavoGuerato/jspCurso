package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.DaoProduto;

/**
 * Servlet implementation class AdicionarProdutoServlet
 */
@WebServlet("/adicionarProduto")
public class AdicionarProdutoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarProdutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/home.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomeProduto = request.getParameter("nome");
        String codigoProduto = request.getParameter("codigo");
        String validadeProduto = request.getParameter("validade");
        String quantidadeProduto = request.getParameter("quantidade");
        String precoProduto = request.getParameter("preco");

        DaoProduto daoProduto = new DaoProduto(); // Supondo que você tenha uma classe DaoProduto

        if (nomeProduto != null && !nomeProduto.isEmpty() && 
            codigoProduto != null && !codigoProduto.isEmpty() &&
            validadeProduto != null && !validadeProduto.isEmpty() &&
            quantidadeProduto != null && !quantidadeProduto.isEmpty() &&
            precoProduto != null && !precoProduto.isEmpty()) {
        	

            boolean produtoExiste = daoProduto.BuscarProdutoBool(codigoProduto);

            if (!produtoExiste) {
                daoProduto.AdicionarProduto(nomeProduto, codigoProduto, validadeProduto, quantidadeProduto, precoProduto);
                request.setAttribute("mensagem", "Produto adicionado com sucesso!");
            } else {
                request.setAttribute("mensagem", "Produto com código " + codigoProduto + " já existe no estoque.");
            }
        } else {
            request.setAttribute("mensagem", "Por favor, preencha todos os campos antes de adicionar o produto.");
        }

        request.getRequestDispatcher("/adicionarProduto.jsp").forward(request, response);
    }

}
