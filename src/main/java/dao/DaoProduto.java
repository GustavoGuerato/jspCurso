package dao;

import connection.SingleConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoProduto {

    private static final Logger LOGGER = Logger.getLogger(DaoProduto.class.getName());

    public void adicionarProduto(String nome, String codigo, String validade, String quantidade, String preco) {
        String sql = "INSERT INTO produtos (nome, codigo, validade, quantidade, preco) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = SingleConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            setProdutoParameters(preparedStatement, nome, codigo, validade, quantidade, preco);
            int rowsAffected = preparedStatement.executeUpdate();
            
            if (rowsAffected > 0) {
                LOGGER.info("Produto adicionado com sucesso.");
            } else {
                LOGGER.warning("Nenhum produto foi adicionado.");
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao adicionar produto: ", e);
        }
    }

    public void removerProduto(String codigo) {
        String sql = "DELETE FROM produtos WHERE codigo = ?";

        try (Connection connection = SingleConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, codigo);
            int rowsDeleted = preparedStatement.executeUpdate();
            
            if (rowsDeleted > 0) {
                LOGGER.info("Produto com código " + codigo + " excluído com sucesso.");
            } else {
                LOGGER.warning("Nenhum produto encontrado com o código: " + codigo);
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao remover produto: ", e);
        }
    }

    public void visualizarEstoque() {
        String sql = "SELECT * FROM produtos";

        try (Connection connection = SingleConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            printColumnHeaders(metaData);

            while (resultSet.next()) {
                printRow(resultSet, metaData.getColumnCount());
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao visualizar estoque: ", e);
        }
    }

    public void atualizarProduto(String codigo, String novoNome, String novaValidade, String novaQuantidade, String novoPreco) {
        String sql = "UPDATE produtos SET nome = ?, validade = ?, quantidade = ?, preco = ? WHERE codigo = ?";

        try (Connection connection = SingleConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, novoNome);
            preparedStatement.setString(2, novaValidade);
            preparedStatement.setString(3, novaQuantidade);
            preparedStatement.setString(4, novoPreco);
            preparedStatement.setString(5, codigo);
            
            int rowsUpdated = preparedStatement.executeUpdate();
            
            if (rowsUpdated > 0) {
                LOGGER.info("Produto com código " + codigo + " atualizado com sucesso.");
            } else {
                LOGGER.warning("Nenhum produto encontrado com o código: " + codigo);
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar produto: ", e);
        }
    }

    public void buscarProduto(String codigo) {
        String sql = "SELECT * FROM produtos WHERE codigo = ?";

        try (Connection connection = SingleConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, codigo);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    printProdutoDetails(resultSet);
                } else {
                    LOGGER.warning("Produto não encontrado com o código: " + codigo);
                }
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar produto: ", e);
        }
    }

    public boolean buscarProdutoBool(String codigo) {
        String sql = "SELECT * FROM produtos WHERE codigo = ?";
        boolean encontrado = false;

        try (Connection connection = SingleConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, codigo);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    printProdutoDetails(resultSet);
                    encontrado = true;
                } else {
                    LOGGER.warning("Produto não encontrado com o código: " + codigo);
                }
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar produto: ", e);
        }

        return encontrado;
    }

    public void gerarRelatorioEstoque() {
        String sql = "SELECT * FROM produtos";

        try (Connection connection = SingleConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                printProdutoDetails(resultSet);
                System.out.println("-----------------------");
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao gerar relatório de estoque: ", e);
        }
    }

    private void setProdutoParameters(PreparedStatement preparedStatement, String nome, String codigo, String validade, String quantidade, String preco) throws SQLException {
        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, codigo);
        preparedStatement.setString(3, validade);
        preparedStatement.setString(4, quantidade);
        preparedStatement.setString(5, preco);
    }

    private void printColumnHeaders(ResultSetMetaData metaData) throws SQLException {
        int numColumns = metaData.getColumnCount();
        for (int i = 1; i <= numColumns; i++) {
            System.out.printf("%-20s", metaData.getColumnName(i));
        }
        System.out.println();
    }

    private void printRow(ResultSet resultSet, int numColumns) throws SQLException {
        for (int i = 1; i <= numColumns; i++) {
            System.out.printf("%-20s", resultSet.getString(i));
        }
        System.out.println();
    }

    private void printProdutoDetails(ResultSet resultSet) throws SQLException {
        String nome = resultSet.getString("nome");
        String codigo = resultSet.getString("codigo");
        String validade = resultSet.getString("validade");
        String quantidade = resultSet.getString("quantidade");
        String preco = resultSet.getString("preco");

        LOGGER.info(String.format("Nome: %s, Código: %s, Validade: %s, Quantidade: %s, Preço: %s",
                nome, codigo, validade, quantidade, preco));
    }
}
