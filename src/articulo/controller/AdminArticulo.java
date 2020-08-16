package articulo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import articulo.dao.ArticuloDAO;
import articulo.model.Articulo;
import articulo.model.Venta;

/**
 * Servlet implementation class AdminArticulo
 */
@WebServlet("/adminArticulo")
public class AdminArticulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticuloDAO articuloDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {

			articuloDAO = new ArticuloDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminArticulo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "nuevo":
				nuevo(request, response);
				break;
			case "register":
				System.out.println("entro");
				registrar(request, response);
				break;
			case "nuevocontacto":
				nuevocontacto(request, response);
				break;
			case "mostrar":
				mostrar(request, response);
				break;
			case "showedit":
				showEditar(request, response);
				break;	
			case "editar":
				editar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			case "venta":
				venta(request,response);
				break;
			case "registrarventa":
				registrarventa(request,response);
				break;
			case "historial":
				historial(request,response);
				break;
			case "estadisticas":
				estadisticas(request, response);
				break;
			case "buscar":
				buscar(request, response);
				break;
			default:
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace(); 
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		doGet(request, response);
	}
	
	private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Articulo articulo = new Articulo(0, request.getParameter("codigo"), request.getParameter("nombre"), request.getParameter("descripcion"), Double.parseDouble(request.getParameter("cantidad")), Double.parseDouble(request.getParameter("precio")));
		articuloDAO.insertar(articulo);
		mostrar(request,response);
	}
	
	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/registrar.jsp");
		dispatcher.forward(request, response);
	}
	
	private void nuevocontacto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/registrarcontacto.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrar.jsp");
		List<Articulo> listaArticulos= articuloDAO.listarArticulos();
		request.setAttribute("lista", listaArticulos);
		dispatcher.forward(request, response);
	}	
	
	private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Articulo articulo = articuloDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("articulo", articulo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editar.jsp");
		dispatcher.forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		System.out.println(request.getParameter("id"));
		Articulo articulo = new Articulo(Integer.parseInt(request.getParameter("id")), request.getParameter("codigo"), request.getParameter("nombre"), request.getParameter("descripcion"), Double.parseDouble(request.getParameter("existencia")), Double.parseDouble(request.getParameter("precio")));
		articuloDAO.actualizar(articulo);
		mostrar(request, response);
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Articulo articulo = articuloDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
		articuloDAO.eliminar(articulo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
	}
	private void venta(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		double ganancias = articuloDAO.getGanancias();
		request.setAttribute("ganancias", ganancias);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/registrarventa.jsp");
		dispatcher.forward(request, response);
	}
	private void registrarventa(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		System.out.println(request.getParameter("codigo"));
		System.out.println(request.getParameter("cantidad"));
		Venta venta=new Venta(request.getParameter("codigo"), Double.parseDouble(request.getParameter("cantidad")),articuloDAO.getprecio(request.getParameter("codigo")));
		articuloDAO.registrarventa(venta);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/registrarventa.jsp");
		dispatcher.forward(request, response);
	}
	private void historial(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/historial.jsp");
		List<Venta> listaArticulos= articuloDAO.listarVentas();
		request.setAttribute("lista", listaArticulos);
		dispatcher.forward(request, response);
	}
	private void estadisticas(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/vista/estadisticas.jsp");
		dispatcher.forward(request, response);
	}
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrar.jsp");
		System.out.println(request.getParameter("codigo"));
		List<Articulo> listaArticulos;
		if(request.getParameter("codigo")=="" & request.getParameter("categoria").equals("Todos")) {
			mostrar(request,response);
		}
		else if(request.getParameter("codigo")!=""){
			listaArticulos= articuloDAO.obtenerPorCodigo(request.getParameter("codigo"));
			if(listaArticulos.isEmpty()) {
				if(request.getParameter("categoria").equals("Todos")==false) {
					if(request.getParameter("categoria").equals("Existencia Baja")) {
						listaArticulos = articuloDAO.listarPorCategoriamenor(request.getParameter("codigo"));
					}
					else {
						listaArticulos = articuloDAO.listarPorCategoriamayor(request.getParameter("codigo"));
					}
				}
				else {
					listaArticulos = articuloDAO.obtenerPorNombre(request.getParameter("codigo"));
				}
			}
			request.setAttribute("lista", listaArticulos);
			dispatcher.forward(request, response);
		}
		else {
			if(request.getParameter("categoria").equals("Existencia Baja")) {
				listaArticulos = articuloDAO.listarPorCategoriamenor();
			}
			else {
				listaArticulos = articuloDAO.listarPorCategoriamayor();
			}
			request.setAttribute("lista", listaArticulos);
			dispatcher.forward(request, response);
		}	
	}	
}
