package articulo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import articulo.model.Contacto;
import articulo.model.Conexion;

public class ContactDAO {
	private Conexion con;
	private Connection connection;

	public ContactDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar artículo
	public boolean insertar(Contacto articulo) throws SQLException {
		String sql = "INSERT INTO contacts (idContacts,nombre, telefono, correo) VALUES (?, ?, ?,?)";
		System.out.println(articulo.getNombre());
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, null);
		statement.setString(2, articulo.getNombre());
		statement.setString(3, articulo.getTelefono());
		statement.setString(4, articulo.getCorreo());
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todos los productos
	public List<Contacto> listarArticulos() throws SQLException {

		List<Contacto> listaArticulos = new ArrayList<Contacto>();
		String sql = "SELECT * FROM contacts";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int id = resulSet.getInt("idContacts");
			String nombre = resulSet.getString("nombre");
			String telefono = resulSet.getString("telefono");		
			String correo = resulSet.getString("correo");
			Contacto articulo = new Contacto(id, nombre, telefono, correo);
			listaArticulos.add(articulo);
		}
		con.desconectar();		
		return listaArticulos;
	}
	public List<Contacto> Buscar(String nombre) throws SQLException {

		List<Contacto> listaArticulos = new ArrayList<Contacto>();
		String sql = "SELECT * FROM contacts WHERE nombre=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, nombre);
		ResultSet resulSet = statement.executeQuery();
		while (resulSet.next()) {
			int id = resulSet.getInt("idContacts");
			String telefono = resulSet.getString("telefono");		
			String correo = resulSet.getString("correo");
			Contacto articulo = new Contacto(id, nombre, telefono, correo);
			listaArticulos.add(articulo);
		}
		con.desconectar();		
		return listaArticulos;
	}	

	// obtener por id
	public Contacto obtenerPorId(int id) throws SQLException {
		Contacto articulo = null;

		String sql = "SELECT * FROM contacts WHERE idContacts= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			articulo = new Contacto(res.getInt("idContacts"), res.getString("nombre"),
					res.getString("telefono"), res.getString("correo"));
		}
		res.close();
		con.desconectar();

		return articulo;
	}

	// actualizar
	public boolean actualizar(Contacto articulo) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE contacts SET codigo=?,nombre=?,descripcion=?,existencia=?, precio=? WHERE id=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, articulo.getNombre());
		statement.setString(2, articulo.getTelefono());
		statement.setString(3, articulo.getCorreo());
		statement.setInt(4, articulo.getId());
		System.out.println(sql);
		rowActualizar = statement.executeUpdate() > 0;
		System.out.println(sql);
		statement.close();
		con.desconectar();
		return rowActualizar;
	}

}
