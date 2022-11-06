package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.tomcat.jdbc.pool.ConnectionPool;

import dto.PersonaDto;

public class ClientePool {

	public ArrayList<PersonaDto> listar() {
		// TODO Auto-generated method stub

		ArrayList<PersonaDto> listaPersonas = new ArrayList<PersonaDto>();
		Connection con = ConexionPoolBD.getConexion();
		try {
			PreparedStatement ps = con.prepareStatement("select * from clientes");
			ResultSet resultado = ps.executeQuery();
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String nombre = resultado.getString("nombre");
				int edad = resultado.getInt("edad");
				PersonaDto personaDao = new PersonaDto(id, nombre, edad);
				listaPersonas.add(personaDao);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listaPersonas;
	}

}
