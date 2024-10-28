package apiCajeroListaScanner;

import java.util.ArrayList;
import java.util.List;

public class Implementacion implements Metodos {

	private List<Cajero> listClientes = new ArrayList<Cajero>();

	@Override
	public boolean guardar(Cajero cajero) {

		// Validar que el numCuenta no se repita
		for (Cajero c : listClientes) {
			if (c.getNumCuenta() == cajero.getNumCuenta()) {
				return false; // Retorna false si ya existe un cliente con ese número de cuenta
			}
		}
		listClientes.add(cajero);
		return true; // Cliente agregado exitosamente
	}

	@Override
	public List<Cajero> listar() {
		return listClientes;
	}

	@Override
	public Cajero buscar(long numCuenta) {

		for (Cajero c : listClientes) {
			if (c.getNumCuenta() == numCuenta) {
				return c; // Retorna el cliente si encuentra coincidencia
			}
		}
		return null;
	}

	@Override
	public void editar(long numCuenta, Cajero cajero) {
		for (int i = 0; i < listClientes.size(); i++) {
			if (listClientes.get(i).getNumCuenta() == numCuenta) {
				listClientes.set(i, cajero); // Reemplaza el cliente en la posición encontrada
				return;
			}
		}
		System.out.println("Cliente no encontrado.");

	}

	@Override
	public boolean eliminar(long numCuenta) {
		for (int i = 0; i < listClientes.size(); i++) {
			if (listClientes.get(i).getNumCuenta() == numCuenta) {
				listClientes.remove(i);
				return true; // Cliente eliminado exitosamente
			}
		}
		return false;
	}

	public void mostrarNumCuentaNombre() {
		System.out.println("CLIENTES POR ÍNDICE:");
		for (int i = 0; i < listClientes.size(); i++) {
			System.out.println("Número de Cuenta: " + listClientes.get(i).getNumCuenta() + ", Nombre: '"
					+ listClientes.get(i).getNombreCliente() + "'");
		}
	}

}
