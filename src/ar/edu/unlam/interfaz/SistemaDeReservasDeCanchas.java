package ar.edu.unlam.interfaz;

import java.util.Scanner;

import ar.edu.unlam.dominio.Cancha;
import ar.edu.unlam.dominio.CanchaDeFutbol5;
import ar.edu.unlam.dominio.GestorDeReserva;

public class SistemaDeReservasDeCanchas {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		GestorDeReserva gestor = new GestorDeReserva();

		Menu opcionDelMenu = null;

		do {
			mostrarMensaje("----Sistema De Reservas De Canchas-----");
			opcionDelMenu = ingresarOpcionDelMenu();

			switch (opcionDelMenu) {
			case AGREGAR_CANCHA:
				agregarCancha(gestor);
				break;
			case AGREGAR_RESERVA:
				break;
			case AGREGAR_ITEMS_ADICIONALES:
				break;
			case RESERVAR_CANCHA:
				break;
			case CANCELAR_CANCHA:
				break;
			case SALIR: mostrarMensaje("Saliendo..");
				break;
			default:
				mostrarMensaje("Ingrese una opción valida.");
				break;
			}

		} while (opcionDelMenu != Menu.SALIR);

	}

	private static void agregarCancha(GestorDeReserva gestor) {
		Double precioCancha = ingresarDouble("Ingrese el precio base de la cancha: ");
		Cancha cancha = new CanchaDeFutbol5(precioCancha);
		Boolean seAgrego = gestor.agregarCancha(cancha);
		if(seAgrego) {
			mostrarMensaje("Se agregó la cancha: " + cancha.getIdCancha() + " por $" + cancha.getPrecioBasePorHora());
		}
	}

	public static Menu ingresarOpcionDelMenu() {
		System.out.println(Menu.getMenu());
		int opcion = 0;

		do {
			opcion = ingresarEntero("Ingrese la opcion: ");
		} while (opcion < 1 || opcion > Menu.values().length);

		return Menu.values()[opcion - 1];
	}

	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}

	public static Integer ingresarEntero(String mensaje) {
		mostrarMensaje(mensaje);
		Integer numero = teclado.nextInt();
		teclado.nextLine();
		return numero;
	}

	public static Double ingresarDouble(String mensaje) {
		mostrarMensaje(mensaje);
		Double numero = teclado.nextDouble();
		teclado.nextLine();
		return numero;
	}
}
