package apiCajeroListaScanner;

import java.time.LocalDate;

public class Cajero {

	private long numCuenta;
	private String nombreCliente;
	private double saldo;
	private String tipoCuenta;
	private LocalDate fechaApertura;

	public Cajero() {
	}

	public Cajero(long numCuenta, String nombreCliente, double saldo, String tipoCuenta, LocalDate fechaApertura) {
		this.numCuenta = numCuenta;
		this.nombreCliente = nombreCliente;
		this.saldo = saldo;
		this.tipoCuenta = tipoCuenta;
		this.fechaApertura = fechaApertura;
	}

	@Override
	public String toString() {
		return "Cajero [numCuenta=" + numCuenta + ", nombreCliente=" + nombreCliente + ", saldo=" + saldo
				+ ", tipoCuenta=" + tipoCuenta + ", fechaApertura=" + fechaApertura + "]\n";
	}

	public long getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(long numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public LocalDate getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(LocalDate fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

}
