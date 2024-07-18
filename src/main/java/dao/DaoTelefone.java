package dao;

import connection.SingleConnection;
import java.sql.*;

public class DaoTelefone {

    public void adicionarTelefone(String nome, String numero) {
        String sql = "INSERT INTO telefones (nome, numero) VALUES (?, ?)";

        try (Connection connection = SingleConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, numero);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao adicionar telefone: " + e.getMessage());
        }
    }

    public void removerTelefone(String numero) {
        String sql = "DELETE FROM telefones WHERE numero = ?";

        try (Connection connection = SingleConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, numero);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Telefone excluído com sucesso!");
            } else {
                System.out.println("Nenhum telefone foi excluído.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao remover telefone: " + e.getMessage());
        }
    }

    public void visualizarTelefones() {
        String sql = "SELECT * FROM telefones";
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
            System.err.println("Erro ao visualizar telefones: " + e.getMessage());
        }
    }

    public void atualizarTelefone(String numero, String novoNome, String novoNumero) {
        String sql = "UPDATE telefones SET nome = ?, numero = ? WHERE numero = ?";
        try (Connection connection = SingleConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, novoNome);
            preparedStatement.setString(2, novoNumero);
            preparedStatement.setString(3, numero);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar telefone: " + e.getMessage());
        }
    }

    public void buscarTelefone(String numero) {
        String sql = "SELECT * FROM telefones WHERE numero = ?";
        try (Connection connection = SingleConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, numero);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    String numeroTelefone = resultSet.getString("numero");

                    System.out.println("O telefone com o número " + numero + " foi localizado:");
                    System.out.println("Nome: " + nome);
                    System.out.println("Número: " + numeroTelefone);
                } else {
                    System.out.println("Telefone não localizado: " + numero);
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar telefone: " + e.getMessage());
        }
    }

    public boolean buscarTelefoneBool(String numero) {
        String sql = "SELECT * FROM telefones WHERE numero = ?";
        boolean encontrado = false;

        try (Connection connection = SingleConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, numero);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    String numeroTelefone = resultSet.getString("numero");

                    System.out.println("O telefone com o número " + numero + " foi localizado:");
                    System.out.println("Nome: " + nome);
                    System.out.println("Número: " + numeroTelefone);

                    encontrado = true;
                } else {
                    System.out.println("Telefone não localizado: " + numero);
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar telefone: " + e.getMessage());
        }

        return encontrado;
    }

    public void gerarRelatorioTelefones() {
        String sql = "SELECT * FROM telefones";
        try (Connection connection = SingleConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String numero = resultSet.getString("numero");

                // Aqui você pode formatar a saída como desejar
                System.out.println("Nome: " + nome);
                System.out.println("Número: " + numero);
                System.out.println("-----------------------");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao gerar relatório de telefones: " + e.getMessage());
        }
    }
}
