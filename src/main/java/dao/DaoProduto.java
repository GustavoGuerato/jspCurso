package dao;

import connection.SingleConnection;
import java.sql.*;

public class DaoProduto {

    public void adicionarProduto(String nome, String codigo, String validade, String quantidade, String preco) {
        String sql = "INSERT INTO produtos (nome, codigo, validade, quantidade, preco) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = SingleConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, codigo);
            preparedStatement.setString(3, validade);
            preparedStatement.setString(4, quantidade);
            preparedStatement.setString(5, preco);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao adicionar produto: " + e.getMessage());
        }
    }

    public void removerProduto(String codigo) {
        String sql = "DELETE FROM produtos WHERE codigo = ?";

        try (Connection connection = SingleConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, codigo);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Registro excluído com sucesso!");
            } else {
                System.out.println("Nenhum registro foi excluído.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao remover produto: " + e.getMessage());
        }
    }

    public void visualizarEstoque() {
        String sql = "SELECT * FROM produtos";
        try (Connection connection = SingleConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numColumns = metaData.getColumnCount();
            for (int i = 1; i <= numColumns; i++) {
                System.out.printf("%-20s", metaData.getColumnName(i));
            }
            System.out.println();
            
            while (resultSet.next()) {
                for (int i = 1; i <= numColumns; i++) {
                    System.out.printf("%-20s", resultSet.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao visualizar estoque: " + e.getMessage());
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
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    public void buscarProduto(String codigo) {
        String sql = "SELECT * FROM produtos WHERE codigo = ?";
        try (Connection connection = SingleConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, codigo);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    String validade = resultSet.getString("validade");
                    String quantidade = resultSet.getString("quantidade");
                    String preco = resultSet.getString("preco");

                    System.out.println("O produto com o código " + codigo + " foi localizado:");
                    System.out.println("Nome: " + nome);
                    System.out.println("Validade: " + validade);
                    System.out.println("Quantidade: " + quantidade);
                    System.out.println("Preço: " + preco);
                } else {
                    System.out.println("Produto não localizado: " + codigo);
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar produto: " + e.getMessage());
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
                    String nome = resultSet.getString("nome");
                    String validade = resultSet.getString("validade");
                    String quantidade = resultSet.getString("quantidade");
                    String preco = resultSet.getString("preco");

                    System.out.println("O produto com o código " + codigo + " foi localizado:");
                    System.out.println("Nome: " + nome);
                    System.out.println("Validade: " + validade);
                    System.out.println("Quantidade: " + quantidade);
                    System.out.println("Preço: " + preco);

                    encontrado = true;
                } else {
                    System.out.println("Produto não localizado: " + codigo);
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar produto: " + e.getMessage());
        }

        return encontrado;
    }

    public void gerarRelatorioEstoque() {
        String sql = "SELECT * FROM produtos";
        try (Connection connection = SingleConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String codigo = resultSet.getString("codigo");
                String validade = resultSet.getString("validade");
                String quantidade = resultSet.getString("quantidade");
                String preco = resultSet.getString("preco");

                // Aqui você pode formatar a saída como desejar
                System.out.println("Nome: " + nome);
                System.out.println("Código: " + codigo);
                System.out.println("Validade: " + validade);
                System.out.println("Quantidade: " + quantidade);
                System.out.println("Preço: " + preco);
                System.out.println("-----------------------");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao gerar relatório de estoque: " + e.getMessage());
        }
    }
}
