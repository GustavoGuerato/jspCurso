package filter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.*;

import connection.SingleConnection;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = {"/*"})
public class MyFilter implements javax.servlet.Filter{

	private static Connection connection;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		try {
			arg2.doFilter(arg0,arg1);
			connection.commit();
		}catch(Exception e){
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}


	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		connection = SingleConnection.getConnection();

	}

}