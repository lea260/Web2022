package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConexionPoolBD {
	private static Connection conexion = null;
	private DataSource dsource;

	public static Connection getConexion() {
		InitialContext ctx;
		DataSource ds;
		Connection con = null;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/bdprog01");
			// dsource = (DataSource) env.lookup("jdbc/ecodeup");
			con = ds.getConnection();

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static void cerrar() {
		try {
			conexion.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
