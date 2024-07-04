package dao;

import connection.SingleConnection;

import java.sql.*;

public class DaoProduto {

	public void AdicionarProduto(String nome, String codigo, String validade, String quantidade, String preco) {
		String sql = "INSERT INTO produtos (nome,codigo,validade,quantidade, preco) VALUES (?,?,?,?,?)";

		try (Connection connection = SingleConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, codigo);
			preparedStatement.setString(3, validade);
			preparedStatement.setString(4, quantidade);
			preparedStatement.setString(5, preco);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void RemoverProduto(String codigo) {
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
			e.printStackTrace();
		}
	}

	public void VisualizarEstoque() {
		String sql = "SELECT * FROM produtos";
		try (Connection connection = SingleConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numColumns = metaData.getColumnCount();
			for (int i = 1; i <= numColumns; i++) {
				System.out.printf("%-20s", metaData.getColumnName(i));
			}

			while (resultSet.next()) {
				for (int i = 1; i <= numColumns; i++) {
					System.out.printf("%-20s", metaData.getCatalogName(i));
				}
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizarProduto(String codigo, String novoNome, String novaValidade, String novaQuantidade,
			String novoPreco) {
		String sql = "UPDATE produtos SET nome = ?, validade = ?, quantidade = ?, preco = ? WHERE codigo = ?";
		try (Connection connection = SingleConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, novoNome);
			preparedStatement.setString(2, codigo);
			preparedStatement.setString(3, novaValidade);
			preparedStatement.setString(4, novaQuantidade);
			preparedStatement.setString(5, novoPreco);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void BuscarProduto(String codigo) {
		String sql = "SELECT * from produtos WHERE codigo = ?";
		try (Connection connection = SingleConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, codigo);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					String nome = resultSet.getString("nome");
					String validade = resultSet.getString("validade");
					String quantidade = resultSet.getString("quantidade");
					String preco = resultSet.getString("preco");

					System.out.println("o produto com o codigo" + codigo + "foi localizado");
					System.out.println("Nome " + nome);
					System.out.println("validade é: " + validade);
					System.out.println("temos uma quantidade de: " + quantidade);
					System.out.println("o preço desse produto é:  " + preco);
				} else {
					System.out.println("produto não foi localizado" + codigo);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean BuscarProdutoBool(String codigo) {
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
					System.out.println("Produto não foi localizado: " + codigo);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return encontrado;
	}

	public void gerarRelatorioEstoque() {

	}
}
