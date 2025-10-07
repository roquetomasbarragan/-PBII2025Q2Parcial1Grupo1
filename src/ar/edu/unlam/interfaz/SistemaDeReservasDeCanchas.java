package ar.edu.unlam.interfaz;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

import ar.edu.unlam.dominio.*;

public class SistemaDeReservasDeCanchas {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		GestorDeReserva gestor = new GestorDeReserva();

		Menu opcionDelMenu = null;

		do {
			mostrarMensaje("\n----Sistema De Reservas De Canchas-----");
			opcionDelMenu = ingresarOpcionDelMenu();

			switch (opcionDelMenu) {
			case AGREGAR_CANCHA:
				agregarCancha(gestor);
				break;
			case AGREGAR_RESERVA:
				agregarReserva(gestor);
				break;
			case AGREGAR_ITEMS_ADICIONALES:
				agregarItemsAdicionales(gestor);
				break;
			case RESERVAR_CANCHA:
				mostrarMensaje("Use la opción 2 para agregar reservas.");
				break;
			case CANCELAR_CANCHA:
				cancelarReserva(gestor);
				break;
			case SALIR:
				mostrarMensaje("Saliendo...");
				break;
			default:
				mostrarMensaje("Ingrese una opción válida.");
				break;
			}

		} while (opcionDelMenu != Menu.SALIR);

		teclado.close();
	}

	private static void agregarCancha(GestorDeReserva gestor) {
		mostrarMensaje("\n--- Agregar Cancha ---\n"
				+ "1. Cancha de Fútbol 5\n"
				+ "2. Cancha de Fútbol 8\n"
				+ "3. Cancha de Fútbol 11\n"
				+ "4. Cancha de Tenis");

		Integer opcion = ingresarEntero("Seleccione el tipo de cancha: ");
		Double precioCancha = ingresarDouble("Ingrese el precio base por hora");

		Cancha cancha;
		String tipoCancha;

		switch (opcion) {
		case 1:
			cancha = new CanchaDeFutbol5(precioCancha);
			tipoCancha = "Fútbol 5";
			break;
		case 2:
			cancha = new CanchaDeFutbol8(precioCancha);
			tipoCancha = "Fútbol 8";
			break;
		case 3:
			cancha = new CanchaDeFutbol11(precioCancha);
			tipoCancha = "Fútbol 11";
			break;
		case 4:
			cancha = new CanchaDeTenis(precioCancha);
			tipoCancha = "Tenis";
			break;
		default:
			mostrarMensaje("Opción inválida.");
			return;
		}

		Boolean seAgrego = gestor.agregarCancha(cancha);
		if (seAgrego) {
			mostrarMensaje("Se agregó la cancha de " + tipoCancha + " con ID: " + cancha.getIdCancha() + " por $"
					+ cancha.getPrecioBasePorHora() + "/hora");
		}
	}

	private static void agregarReserva(GestorDeReserva gestor) {
		
		mostrarMensaje("\n--- Reservar Cancha ---");

		Cancha cancha = validarIdDeCancha(gestor);

		Cliente cliente = crearCliente();
		LocalDateTime horaDeInicio = asignarHoraDeReserva();

		ReservaBase nuevaReserva = new ReservaBase(cliente, cancha, horaDeInicio);
		
		gestor.agregarReserva(nuevaReserva);
	}

	public static Cancha validarIdDeCancha(GestorDeReserva gestor) {
		
		Boolean idInvalido;
		Cancha cancha;
		
		do {			
			Integer idCancha = ingresarEntero("Ingrese el ID de la cancha: ");
			cancha = gestor.obtenerCanchaPorId(idCancha);
			
			idInvalido = (cancha == null);
			
			if(idInvalido) {
				mostrarMensaje("No hay ninguna cancha disponible con ese ID, intentelo nuevamente");
			}
			
		} while (idInvalido);
		return cancha;
	}

	public static Cliente crearCliente() {
		String nombreCliente = ingresarString("Ingrese el nombre del cliente: ");
		Integer dniCliente = ingresarEntero("Ingrese el DNI del cliente: ");
		Cliente cliente = new Cliente(nombreCliente, dniCliente);
		return cliente;
	}

	public static LocalDateTime asignarHoraDeReserva() {

		LocalDateTime horaDeInicio;
		Boolean esValida;

		do {
			mostrarMensaje("Ingrese la fecha y hora de inicio:");
			Integer mes = validarMes();
			Integer dia = validarDia();
			Integer hora = validarHora();
			Integer minuto = validarMinuto();

			horaDeInicio = LocalDateTime.of(2025, mes, dia, hora, minuto);
			esValida = validarHoraDeInicio(horaDeInicio);

			if (!esValida) {
				mostrarMensaje("Hubo un error, intentelo de nuevo\n");
			}

		} while (!esValida);

		return horaDeInicio;
	}

	private static Integer validarMinuto() {
		Boolean minutoValido;
		Integer minutoElegido;

		do {
			minutoElegido = ingresarEntero("Minuto: ");
			minutoValido = minutoElegido < 60 && minutoElegido >= 0;

			if (!minutoValido) {
				mostrarMensaje("Minuto invalido, intentelo nuevamente");
			}
		} while (!minutoValido);

		return minutoElegido;
	}

	private static Integer validarHora() {
		Boolean horaValida;
		Integer horaElegida;

		do {
			horaElegida = ingresarEntero("Hora: ");
			horaValida = horaElegida < 24 && horaElegida > 0;

			if (!horaValida) {
				mostrarMensaje("Hora invalida, intentelo nuevamente");
			}
		} while (!horaValida);

		return horaElegida;
	}

	private static Integer validarDia() {

		Boolean diaValido;
		Integer diaElegido;

		do {
			diaElegido = ingresarEntero("Día: ");
			diaValido = diaElegido < 32 && diaElegido > 0;

			if (!diaValido) {
				mostrarMensaje("Día invalido, intentelo nuevamente");
			}
		} while (!diaValido);

		return diaElegido;
	}

	private static Integer validarMes() {

		Boolean mesValido;
		Integer mesElegido;

		do {
			mesElegido = ingresarEntero("Mes: ");
			mesValido = mesElegido < 13 && mesElegido > 0;

			if (!mesValido) {
				mostrarMensaje("Mes invalido, intentelo nuevamente");
			}
		} while (!mesValido);

		return mesElegido;
	}

	private static boolean validarHoraDeInicio(LocalDateTime horaDeInicio) {

		Boolean esValida = false;
		LocalDateTime fechaYHoraActual = LocalDateTime.now();
		LocalTime horaQueAbrimos = LocalTime.of(8, 0);
		LocalTime horaQueCerramos = LocalTime.of(23, 0);

		if (horaDeInicio.isAfter(fechaYHoraActual)) {
			if (horaDeInicio.toLocalTime().isAfter(horaQueAbrimos)
					&& horaDeInicio.toLocalTime().isBefore(horaQueCerramos)) {
				esValida = true;
			}
		}
		return esValida;
	}

	private static void agregarItemsAdicionales(GestorDeReserva gestor) {
		mostrarMensaje("\n--- Agregar Items Adicionales ---");

		Integer idReserva = ingresarEntero("Ingrese el ID de la reserva: ");
		ReservaBase reserva = gestor.obtenerReservaPorId(idReserva);

		if (reserva == null) {
			mostrarMensaje("No se encontró una reserva con ese ID.");
			return;
		}

		mostrarMensaje("1. Pelota de Fútbol ($5000)");
		mostrarMensaje("2. Raquetas de Tenis ($7000 x capacidad)");
		mostrarMensaje("3. Descuento Estudiante (10%)");

		Integer opcion = ingresarEntero("Seleccione el item: ");

		ItemAdicional item = null;
		String nombreItem = "";

		switch (opcion) {
		case 1:
			item = new PelotaDeFutbol();
			nombreItem = "Pelota de Fútbol";
			break;
		case 2:
			item = new RaquetaDeTenis();
			nombreItem = "Raquetas de Tenis";
			break;
		case 3:
			item = new DescuentoEstudiante();
			nombreItem = "Descuento Estudiante";
			break;
		default:
			mostrarMensaje("Opción inválida.");
			return;
		}

		Boolean seAgrego = reserva.agregarItemAdicional(item);

		if (seAgrego) {
			mostrarMensaje("Se agregó " + nombreItem + " a la reserva.");
			mostrarMensaje("Total de items: " + reserva.getCantidadItems());
		} else {
			mostrarMensaje("No se pudo agregar el item. No es compatible con la cancha reservada.");
		}
	}

	private static void cancelarReserva(GestorDeReserva gestor) {
		mostrarMensaje("\n--- Cancelar Reserva ---");

		Integer idReserva = ingresarEntero("Ingrese el ID de la reserva a cancelar: ");

		ReservaBase reserva = gestor.obtenerReservaPorId(idReserva);

		if (reserva == null) {
			mostrarMensaje("No se encontró una reserva con ese ID.");
			return;
		}

		mostrarMensaje("Reserva encontrada:");
		mostrarMensaje("Cliente: " + reserva.getClienteTitular().getNombre());
		mostrarMensaje("Hora: " + reserva.getHoraInicio());

		String confirmacion = ingresarString("¿Confirma la cancelación? (S/N): ");

		if (confirmacion.equalsIgnoreCase("S")) {
			Boolean seCancelo = gestor.cancelarReservaPorId(idReserva);

			if (seCancelo) {
				mostrarMensaje("Reserva cancelada exitosamente.");
			} else {
				mostrarMensaje("No se pudo cancelar la reserva.");
			}
		} else {
			mostrarMensaje("Cancelación abortada.");
		}
	}

	public static Menu ingresarOpcionDelMenu() {
		System.out.println(Menu.getMenu());
		int opcion = 0;

		do {
			opcion = ingresarEntero("Ingrese la opción: ");
			if (opcion < 1 || opcion > Menu.values().length) {
				mostrarMensaje("Opción inválida. Intente nuevamente.");
			}
		} while (opcion < 1 || opcion > Menu.values().length);

		return Menu.values()[opcion - 1];
	}

	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}

	public static Integer ingresarEntero(String mensaje) {
		mostrarMensaje(mensaje);
		while (!teclado.hasNextInt()) {
			mostrarMensaje("Por favor ingrese un número válido.");
			teclado.next();
		}
		Integer numero = teclado.nextInt();
		teclado.nextLine();
		return numero;
	}

	public static Double ingresarDouble(String mensaje) {
		mostrarMensaje(mensaje);
		while (!teclado.hasNextDouble()) {
			mostrarMensaje("Por favor ingrese un número válido.");
			teclado.next();
		}
		Double numero = teclado.nextDouble();
		teclado.nextLine();
		return numero;
	}

	public static String ingresarString(String mensaje) {
		mostrarMensaje(mensaje);
		return teclado.nextLine();
	}
}
