package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeansCursoJsp;
import connection.SingleConnection;

public class DaoUsuario {

	private Connection connection;

	public DaoUsuario() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(BeansCursoJsp usuario) {
		try {
			String sql = "INSERT INTO usuario (login, senha, nome, telefone, cep, rua, bairro, cidade, estado, ibge) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, usuario.getLogin());
			insert.setString(2, usuario.getSenha());
			insert.setString(3, usuario.getNome());
			insert.setString(4, usuario.getTel());
			insert.setString(5, usuario.getCep());
			insert.setString(6, usuario.getRua());
			insert.setString(7, usuario.getBairro());
			insert.setString(8, usuario.getCidade());
			insert.setString(9, usuario.getEstado());
			insert.setString(10, usuario.getIbge());
			insert.execute();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public List<BeansCursoJsp> listar() throws SQLException {
		List<BeansCursoJsp> listar = new ArrayList<BeansCursoJsp>();
		String sql = "SELECT * FROM usuario";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			BeansCursoJsp beansCursoJsp = new BeansCursoJsp();
			beansCursoJsp.setId(resultSet.getLong("id"));
			beansCursoJsp.setLogin(resultSet.getString("login"));
			beansCursoJsp.setSenha(resultSet.getString("senha"));
			beansCursoJsp.setNome(resultSet.getString("nome"));
			beansCursoJsp.setTel(resultSet.getString("telefone"));
			beansCursoJsp.setCep(resultSet.getString("cep"));
			beansCursoJsp.setRua(resultSet.getString("rua"));
			beansCursoJsp.setBairro(resultSet.getString("bairro"));
			beansCursoJsp.setCidade(resultSet.getString("cidade"));
			beansCursoJsp.setEstado(resultSet.getString("estado"));
			beansCursoJsp.setIbge(resultSet.getString("ibge"));
			listar.add(beansCursoJsp);
		}
		return listar;
	}

	public void delete(String id) {
		try {
			String sql = "DELETE FROM usuario WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public BeansCursoJsp consultar(String id) throws SQLException {
		String sql = "SELECT * FROM usuario WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			BeansCursoJsp beansCursoJsp = new BeansCursoJsp();
			beansCursoJsp.setId(resultSet.getLong("id"));
			beansCursoJsp.setLogin(resultSet.getString("login"));
			beansCursoJsp.setSenha(resultSet.getString("senha"));
			beansCursoJsp.setNome(resultSet.getString("nome"));
			beansCursoJsp.setTel(resultSet.getString("telefone"));
			beansCursoJsp.setCep(resultSet.getString("cep"));
			beansCursoJsp.setRua(resultSet.getString("rua"));
			beansCursoJsp.setBairro(resultSet.getString("bairro"));
			beansCursoJsp.setCidade(resultSet.getString("cidade"));
			beansCursoJsp.setEstado(resultSet.getString("estado"));
			beansCursoJsp.setIbge(resultSet.getString("ibge"));
			return beansCursoJsp;
		}
		return null;
	}

	public boolean validarLogin(String login) throws SQLException {
		String sql = "SELECT COUNT(1) AS qtd FROM usuario WHERE login = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, login);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return resultSet.getInt("qtd") <= 0;
		}
		return false;
	}

	public void atualizar(BeansCursoJsp usuario) {
		try {
			String sql = "UPDATE usuario SET login = ?, senha = ?, nome = ?, telefone = ?, cep = ?, rua = ?, bairro = ?, cidade = ?, estado = ?, ibge = ? WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getSenha());
			preparedStatement.setString(3, usuario.getNome());
			preparedStatement.setString(4, usuario.getTel());
			preparedStatement.setString(5, usuario.getCep());
			preparedStatement.setString(6, usuario.getRua());
			preparedStatement.setString(7, usuario.getBairro());
			preparedStatement.setString(8, usuario.getCidade());
			preparedStatement.setString(9, usuario.getEstado());
			preparedStatement.setString(10, usuario.getIbge());
			preparedStatement.setLong(11, usuario.getId());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
