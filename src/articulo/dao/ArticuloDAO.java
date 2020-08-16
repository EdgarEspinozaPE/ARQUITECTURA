package articulo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import articulo.model.Articulo;
import articulo.model.Conexion;
import articulo.model.Venta;
/*
 * @autor: Elivar Largo
 * @web: www.ecodeup.com
 */

public class ArticuloDAO {
	private Conexion con;
	private Connection connection;

	public ArticuloDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar artículo
	public boolean insertar(Articulo articulo) throws SQLException {
		String sql = "INSERT INTO articulos (id, codigo, nombre, descripcion, existencia, precio) VALUES (?, ?, ?,?,?,?)";
		System.out.println(articulo.getDescripcion());
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, null);
		statement.setString(2, articulo.getCodigo());
		statement.setString(3, articulo.getNombre());
		statement.setString(4, articulo.getDescripcion());
		statement.setDouble(5, articulo.getExistencia());
		statement.setDouble(6, articulo.getPrecio());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		sql = "INSERT INTO estadisticas (codigo, totalvendido, dinerogenerado) VALUES (?, ?, ?)";
		System.out.println(articulo.getDescripcion());
		con.conectar();
		connection = con.getJdbcConnection();
		statement = connection.prepareStatement(sql);
		statement.setString(1, articulo.getCodigo());
		statement.setDouble(2, 0);
		statement.setDouble(3, 0);
		rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}
	
	//INSERTAR VENTA
	public boolean registrarventa(Venta venta) throws SQLException {
		String sql = "INSERT INTO ventas (codigo, cantidad, total, fecha) VALUES (?, ?, ?,?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, venta.getCodigo());
		statement.setDouble(2, venta.getCantidad());
		statement.setDouble(3, venta.getTotal());
		statement.setDate(4, venta.getFecha() );
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		double existencia = this.getexistencia(venta.getCodigo());
		existencia=existencia - venta.getCantidad();
		sql = "UPDATE articulos SET existencia=? WHERE codigo=?";
		con.conectar();
		connection = con.getJdbcConnection();
		statement = connection.prepareStatement(sql);
		statement.setDouble(1, existencia);
		statement.setString(2, venta.getCodigo());
		boolean rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		double totalvendido = this.gettotalvendido(venta.getCodigo());
		totalvendido=totalvendido + venta.getCantidad();
		double dinerogenerado = this.getdinerogenerado(venta.getCodigo());
		dinerogenerado = dinerogenerado + venta.getTotal();
		sql = "UPDATE estadisticas SET totalvendido=?, dinerogenerado=? WHERE codigo=?";
		con.conectar();
		connection = con.getJdbcConnection();
		statement = connection.prepareStatement(sql);
		statement.setDouble(1, totalvendido);
		statement.setDouble(2, dinerogenerado);
		statement.setString(3, venta.getCodigo());
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		return rowInserted;
	}

	// listar todos los productos
	public List<Articulo> listarArticulos() throws SQLException {

		List<Articulo> listaArticulos = new ArrayList<Articulo>();
		String sql = "SELECT * FROM articulos";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int id = resulSet.getInt("id");
			String codigo = resulSet.getString("codigo");
			String nombre = resulSet.getString("nombre");
			String descripcion = resulSet.getString("descripcion");
			Double existencia = resulSet.getDouble("existencia");
			Double precio = resulSet.getDouble("precio");
			Articulo articulo = new Articulo(id, codigo, nombre, descripcion, existencia, precio);
			listaArticulos.add(articulo);
		}
		con.desconectar();
		return listaArticulos;
	}
	
	public List<Venta> listarVentas() throws SQLException {

		List<Venta> listaVentas = new ArrayList<Venta>();
		String sql = "SELECT * FROM ventas";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			String codigo = resulSet.getString("codigo");
			Double cantidad = resulSet.getDouble("cantidad");
			Double total = resulSet.getDouble("total");
			Venta articulo = new Venta(codigo, cantidad, total,total);
			listaVentas.add(articulo);
		}
		con.desconectar();
		return listaVentas;
	}
	

	// obtener por id
	public Articulo obtenerPorId(int id) throws SQLException {
		Articulo articulo = null;

		String sql = "SELECT * FROM articulos WHERE id= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			articulo = new Articulo(res.getInt("id"), res.getString("codigo"), res.getString("nombre"),
					res.getString("descripcion"), res.getDouble("existencia"), res.getDouble("precio"));
		}
		res.close();
		con.desconectar();

		return articulo;
	}

	public List<Articulo> obtenerPorCodigo(String codigo) throws SQLException {
		List<Articulo> listaArticulos = new ArrayList<Articulo>();
		String sql = "SELECT * FROM articulos WHERE codigo = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1,codigo);
		ResultSet resulSet = statement.executeQuery();
		while (resulSet.next()) {
			int id = resulSet.getInt("id");
			String nombre = resulSet.getString("nombre");
			String descripcion = resulSet.getString("descripcion");
			Double existencia = resulSet.getDouble("existencia");
			Double precio = resulSet.getDouble("precio");
			Articulo articulo = new Articulo(id, codigo, nombre, descripcion, existencia, precio);
			listaArticulos.add(articulo);
		}
		con.desconectar();
		return listaArticulos;
	}
	
	public List<Articulo> obtenerPorNombre(String nombre) throws SQLException {
		List<Articulo> listaArticulos = new ArrayList<Articulo>();
		String sql = "SELECT * FROM articulos WHERE nombre = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1,nombre);
		ResultSet resulSet = statement.executeQuery();
		while (resulSet.next()) {
			int id = resulSet.getInt("id");
			String codigo = resulSet.getString("codigo");
			String descripcion = resulSet.getString("descripcion");
			Double existencia = resulSet.getDouble("existencia");
			Double precio = resulSet.getDouble("precio");
			Articulo articulo = new Articulo(id, codigo, nombre, descripcion, existencia, precio);
			listaArticulos.add(articulo);
		}
		con.desconectar();
		return listaArticulos;
	}
	
	public List<Articulo> listarPorCategoriamenor(String nombre) throws SQLException {
		List<Articulo> listaArticulos = new ArrayList<Articulo>();
		String sql = "SELECT * FROM articulos WHERE nombre = ? AND existencia < 10";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1,nombre);
		ResultSet resulSet = statement.executeQuery();
		while (resulSet.next()) {
			int id = resulSet.getInt("id");
			String codigo = resulSet.getString("codigo");
			String descripcion = resulSet.getString("descripcion");
			Double existencia = resulSet.getDouble("existencia");
			Double precio = resulSet.getDouble("precio");
			Articulo articulo = new Articulo(id, codigo, nombre, descripcion, existencia, precio);
			listaArticulos.add(articulo);
		}
		con.desconectar();
		return listaArticulos;
	}
	public List<Articulo> listarPorCategoriamenor() throws SQLException {
		List<Articulo> listaArticulos = new ArrayList<Articulo>();
		String sql = "SELECT * FROM articulos WHERE existencia < 10";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		while (resulSet.next()) {
			int id = resulSet.getInt("id");
			String nombre = resulSet.getString("nombre");
			String codigo = resulSet.getString("codigo");
			String descripcion = resulSet.getString("descripcion");
			Double existencia = resulSet.getDouble("existencia");
			Double precio = resulSet.getDouble("precio");
			Articulo articulo = new Articulo(id, codigo, nombre, descripcion, existencia, precio);
			listaArticulos.add(articulo);
		}
		con.desconectar();
		return listaArticulos;
	}

	public List<Articulo> listarPorCategoriamayor(String nombre) throws SQLException {
		List<Articulo> listaArticulos = new ArrayList<Articulo>();
		String sql = "SELECT * FROM articulos WHERE nombre = ? AND existencia > 10";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1,nombre);
		ResultSet resulSet = statement.executeQuery();
		while (resulSet.next()) {
			int id = resulSet.getInt("id");
			String codigo = resulSet.getString("codigo");
			String descripcion = resulSet.getString("descripcion");
			Double existencia = resulSet.getDouble("existencia");
			Double precio = resulSet.getDouble("precio");
			Articulo articulo = new Articulo(id, codigo, nombre, descripcion, existencia, precio);
			listaArticulos.add(articulo);
		}
		con.desconectar();
		return listaArticulos;
	}
	public List<Articulo> listarPorCategoriamayor() throws SQLException {
		List<Articulo> listaArticulos = new ArrayList<Articulo>();
		String sql = "SELECT * FROM articulos WHERE existencia > 10";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		while (resulSet.next()) {
			int id = resulSet.getInt("id");
			String nombre = resulSet.getString("nombre");
			String codigo = resulSet.getString("codigo");
			String descripcion = resulSet.getString("descripcion");
			Double existencia = resulSet.getDouble("existencia");
			Double precio = resulSet.getDouble("precio");
			Articulo articulo = new Articulo(id, codigo, nombre, descripcion, existencia, precio);
			listaArticulos.add(articulo);
		}
		con.desconectar();
		return listaArticulos;
	}
	
	// actualizar
	public boolean actualizar(Articulo articulo) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE articulos SET codigo=?,nombre=?,descripcion=?,existencia=?, precio=? WHERE id=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, articulo.getCodigo());
		statement.setString(2, articulo.getNombre());
		statement.setString(3, articulo.getDescripcion());
		statement.setDouble(4, articulo.getExistencia());
		System.out.println(articulo.getPrecio());
		statement.setDouble(5, articulo.getPrecio());
		statement.setInt(6, articulo.getId());
		System.out.println(sql);
		rowActualizar = statement.executeUpdate() > 0;
		System.out.println(sql);
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//eliminar
	public boolean eliminar(Articulo articulo) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM articulos WHERE ID=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, articulo.getId());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
	
	public double getprecio(String codigo) throws SQLException{
		double precio = 0;
		String sql = "SELECT * FROM articulos WHERE codigo= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, codigo);
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			precio = res.getDouble("precio");
		}
		res.close();
		con.desconectar();
		return precio;
	}
	public double getexistencia(String codigo) throws SQLException{
		double existencia = 0;
		String sql = "SELECT * FROM articulos WHERE codigo= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, codigo);
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			existencia = res.getDouble("existencia");
		}
		res.close();
		con.desconectar();
		return existencia;
	}
	public double gettotalvendido(String codigo) throws SQLException{
		double totalvendido = 0;
		String sql = "SELECT * FROM estadisticas WHERE codigo= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, codigo);
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			totalvendido = res.getDouble("totalvendido");
		}
		res.close();
		con.desconectar();
		return totalvendido;
	}
	public double getdinerogenerado(String codigo) throws SQLException{
		double dinerogenerado = 0;
		String sql = "SELECT * FROM estadisticas WHERE codigo= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, codigo);
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			dinerogenerado = res.getDouble("dinerogenerado");
		}
		res.close();
		con.desconectar();
		return dinerogenerado;
	}
	public double getGanancias() throws SQLException{
		double dinerogenerado = 0;
		String sql = "SELECT * FROM estadisticas";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet res = statement.executeQuery(sql);
		while (res.next()) {
			dinerogenerado =dinerogenerado+ res.getDouble("dinerogenerado");
		}
		res.close();
		con.desconectar();
		return dinerogenerado;
	}
}