package apiCajeroListaScanner;

import java.util.List;

public interface Metodos {

	public boolean guardar(Cajero cajero);

	public List<Cajero> listar();

	public Cajero buscar(long numCuenta);

	public void editar(long numCuenta, Cajero cajero);

	public boolean eliminar(long numCuenta);

}
