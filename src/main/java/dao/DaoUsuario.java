package dao;

import java.beans.Beans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeansCursoJsp;
import connection.SingleConnection;
import jakarta.servlet.jsp.jstl.sql.Result;

public class DaoUsuario {

	private Connection connection;

	public DaoUsuario() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(BeansCursoJsp usuario) {
		try {
			String sql = "insert into usuario(login, senha,nome) values (?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, usuario.getLogin());
			insert.setString(2, usuario.getSenha());
			insert.setString(3, usuario.getNome());
			insert.execute();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public List<BeansCursoJsp> listar() throws SQLException {
		List<BeansCursoJsp> listar = new ArrayList<BeansCursoJsp>();
		String sql = "select * from usuario";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			BeansCursoJsp beansCursoJsp = new BeansCursoJsp();
			beansCursoJsp.setId(resultSet.getLong("id"));
			beansCursoJsp.setLogin(resultSet.getString("login"));
			beansCursoJsp.setSenha(resultSet.getString("senha"));
			listar.add(beansCursoJsp);

		}
		return listar;
	}

	public void delete(String id) {
		try {
			String sql = "delete from usuario where id = '" + id + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, login);
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
		String sql = "select * from usuario where id = '" + id + "'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			BeansCursoJsp beansCursoJsp = new BeansCursoJsp();
			beansCursoJsp.setId(resultSet.getLong("id"));
			beansCursoJsp.setLogin(resultSet.getString("login"));
			beansCursoJsp.setSenha(resultSet.getString("senha"));
			beansCursoJsp.setNome(resultSet.getString("nome"));

			return beansCursoJsp;
		}
		return null;
	}

	public void atualizar(BeansCursoJsp usuario) {
		try {
			String sql = "update usuario set login = ?,senha=?,nome=? where id= " + usuario.getId();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getSenha());
			preparedStatement.setString(3, usuario.getNome());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}
}
