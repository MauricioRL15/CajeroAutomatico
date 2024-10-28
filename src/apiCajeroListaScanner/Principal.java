package apiCajeroListaScanner;

import java.time.LocalDate;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		long numCuenta;
		String nombreCliente;
		double saldo;
		String tipoCuenta;
		LocalDate fechaApertura;

		Cajero cajero = null;

		@SuppressWarnings("resource")
		Scanner lectura = new Scanner(System.in);
		int mainMenu = 0;

		// Realizar la instancia de Implementacion -- Para tener acceso a los métodos
		// con la lógica
		Implementacion imp = new Implementacion();

		do {
			System.out.println("== MENU SANTANDER BIENVENIDO AL SISTEMA ==");
			System.out.println("1 -- ALTA CLIENTE");
			System.out.println("2 -- CONSULTAR SALDO");
			System.out.println("3 -- DEPOSITO EN EFECTIVO");
			System.out.println("4 -- RETIRO EN EFECTIVO");
			System.out.println("5 -- SALIR");
			try {
				lectura = new Scanner(System.in);
				mainMenu = lectura.nextInt();

				switch (mainMenu) {
				case 1:

					System.out.println("== INGRESE LOS DATOS DEL CLIENTE ==");
					try {
						System.out.println("Ingresa el Número de Cuenta");
						lectura = new Scanner(System.in);
						numCuenta = lectura.nextLong();

						System.out.println("Ingresa el Nombre del Cliente");
						lectura = new Scanner(System.in);
						nombreCliente = lectura.nextLine();

						System.out.println("Ingresa el Tipo de Cuenta");
						lectura = new Scanner(System.in);
						tipoCuenta = lectura.nextLine();

						fechaApertura = LocalDate.now(); // Fecha de apertura es la fecha actual

						saldo = 0.0; // Saldo inicial es 0

						// Crear objeto Cajero
						cajero = new Cajero(numCuenta, nombreCliente, saldo, tipoCuenta, fechaApertura);

						// Guardar
						if (imp.guardar(cajero)) {
							System.out.println("== CLIENTE GUARDADO CON ÉXITO: \n"+ "Se agrego a: "+ cajero.getNombreCliente() + " , Con número de cuenta: " + cajero.getNumCuenta() + ", Saldo: " + cajero.getSaldo() 
							+ " , Tipo de cuenta: " + cajero.getTipoCuenta() + ", el Día: " + cajero.getFechaApertura());
						} else {
							System.out.println("== ERROR: EL NÚMERO DE CUENTA YA EXISTE ==");
						}
					} catch (Exception e) {
						System.out.println("== ERROR AL GUARDAR EL CLIENTE INGRESA UN NÚMERO DE CUENTA VALIDO: " + "'" + e.getMessage() + "'" + " ==");
					}

					break;

				case 2:

					if (imp.listar().isEmpty()) {
						System.out.println("No hay clientes agregados");
					} else {
						System.out.println("Ingresa el número de cuenta para consultar el saldo");
						try {
							numCuenta = lectura.nextLong();
							// Buscar
							cajero = imp.buscar(numCuenta);
							if (cajero != null) {
								System.out.println("Hola! " + cajero.getNombreCliente() + " tú saldo actual es de: $"
										+ cajero.getSaldo());
							} else {
								System.out.println("Cliente no encontrado");
							}
						} catch (Exception e) {
							System.out.println("Error: Debes ingresar un número de cuenta válido.");
							lectura.next();
						}
					}
					break;

				case 3:

					if (imp.listar().isEmpty()) {
						System.out.println("No hay clientes agregados");
					} else {
						System.out.println("Ingresa el número de cuenta para depositar");
						try {
							numCuenta = lectura.nextLong();
							cajero = imp.buscar(numCuenta);
							if (cajero != null) {
								System.out.println("Ingresa la cantidad a depositar");
								double deposito = lectura.nextDouble();
								if (deposito > 0 && deposito <= 10000) {
									cajero.setSaldo(cajero.getSaldo() + deposito);
									imp.editar(numCuenta, cajero);
									System.out.println("== DEPÓSITO REALIZADO CON ÉXITO == \n" + cajero.getNombreCliente() +" tú saldo ahora es de: $" + cajero.getSaldo());
								} else {
									System.out
											.println("Cantidad no válida, debe ser mayor a 0 y menor o igual a 10,000");
								}
							} else {
								System.out.println("Cliente no encontrado, no existe ese Número de Cuenta");
							}
						} catch (Exception e) {
							System.out.println(
									"Caracteres incorrectos: Debes ingresar un número de cuenta válido para hacer el depósito.");
							lectura.next();
						}
					}

					break;

				case 4:
					if (imp.listar().isEmpty()) {
						System.out.println("No hay clientes agregados");
					} else {
						System.out.println("Ingresa el número de cuenta para retirar");
						try {
							numCuenta = lectura.nextLong();
							cajero = imp.buscar(numCuenta);
							if (cajero != null) {
								System.out.println("Ingresa la cantidad a retirar");
								double retiro = lectura.nextDouble();
								if (retiro > 0 && retiro <= 10000 && retiro <= cajero.getSaldo()) {
									cajero.setSaldo(cajero.getSaldo() - retiro);
									imp.editar(numCuenta, cajero);
									System.out.println("== RETIRO REALIZADO CON ÉXITO ==\n" + cajero.getNombreCliente() +" tú saldo ahora es de: $" + cajero.getSaldo() );
								} else {
									System.out.println(
											"Cantidad no válida, debe ser mayor a 0, menor o igual a 10,000 y no exceder el saldo disponible que es:\n" + "$"+ cajero.getSaldo());
								}
							} else {
								System.out.println("Cliente no encontrado, no existe ese Número de Cuenta");
							}
						} catch (Exception e) {
							System.out.println("Error: Debes ingresar un número  de cuenta válido para hacer el retiro.");
							lectura.next();
						}
					}
					break;
				}
			} catch (Exception e) {
				System.out.println("Error: Debes ingresar un número válido para la opción del menú.");
				lectura.next();
			}
		} while (mainMenu < 5 );
		System.out.println("GRACIAS POR USAR EL SISTEMA DE SANTANDER, REGRESE PRONTO!");
	}
}