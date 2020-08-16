package articulo.model;

import java.util.Date;

public class Venta {
	private String codigo;
	private double cantidad;
	private double total;
	private java.sql.Date fecha;
	
	public Venta(String codigo, double cantidad, double precio) {
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.total = cantidad * precio;
		Date fechaux = new Date();
		this.fecha = new java.sql.Date(fechaux.getTime());
	}
	public Venta(String codigo, double cantidad, double precio,double total) {
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.total = total;
		Date fechaux = new Date();
		this.fecha = new java.sql.Date(fechaux.getTime());
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public java.sql.Date getFecha() {
		return fecha;
	}
	public void setFecha(java.sql.Date fecha) {
		this.fecha = fecha;
	}
}
