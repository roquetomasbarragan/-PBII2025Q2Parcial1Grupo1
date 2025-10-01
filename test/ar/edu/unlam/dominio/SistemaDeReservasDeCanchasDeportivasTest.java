package ar.edu.unlam.dominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;

public class SistemaDeReservasDeCanchasDeportivasTest {

	@Test
	public void dadoQueExisteUnGestorDeReservasDeCanchasSePuedeCrearUnaCanchaExitosamenteElMetodoDevuelveTrue() {

		GestorDeReserva gestor = new GestorDeReserva();

		Integer cantMaxPersonas = 10;
		Double precioBasePorHora = 20000.00;

		Integer idCancha = 1;
		Cancha canchaDeFutbol = new CanchaDeFutbol5(precioBasePorHora, idCancha);

		Boolean seAgrego = gestor.agregarCancha(canchaDeFutbol);

		assertTrue(seAgrego);
	}

	@Test
	public void dadoQueExisteUnGestorDeReservasYUnaCanchaElClientePuedeReservarlaElMetodoDevuelveTrue() {
		GestorDeReserva gestor = new GestorDeReserva();

		Integer cantMaxPersonas = 10;
		Double precioBasePorHora = 20000.00;

		Cancha cancha = new CanchaDeFutbol5(precioBasePorHora,1);
		gestor.agregarCancha(cancha);
		
		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);
		LocalDateTime horaFinal = LocalDateTime.of(2025, 10, 01, 21, 00);
		
		String nombre = "Juan";
		Integer dni = 123;
		Cliente clienteTitular = new Cliente(nombre, dni);
		Integer id = 1;
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio, horaFinal, id);
		
		Boolean seAgregoReserva = gestor.agregarReserva(reserva);
		
		assertTrue(seAgregoReserva);
	}
	
	@Test 
	public void dadoQueExisteUnaCanchaReservadaNoSePuedeReservarLaMismaEnElMismoHorarioElMetodoDevuelveFalse() {
		
		
		GestorDeReserva gestor = new GestorDeReserva();

		Integer cantMaxPersonas = 10;
		Double precioBasePorHora = 20000.00;

		Cancha cancha = new CanchaDeFutbol5(precioBasePorHora, 1);
		gestor.agregarCancha(cancha);
		
		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);
		LocalDateTime horaFinal = LocalDateTime.of(2025, 10, 01, 21, 00);
		
		String nombre = "Juan";
		Integer dni = 123;
		Cliente clienteTitular = new Cliente(nombre, dni);
		Integer id = 1;
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio, horaFinal, id);
		gestor.agregarReserva(reserva);
		
		
		Cliente clienteTitular2 = new Cliente("Pedro", 235);
		LocalDateTime horaInicio2 = LocalDateTime.of(2025, 10, 01, 20, 00);
		LocalDateTime horaFinal2 = LocalDateTime.of(2025, 10, 01, 21, 00);
		ReservaBase reserva2 = new ReservaBase(clienteTitular2, cancha, horaInicio2, horaFinal2, 2);
		
		Boolean seAgregoReserva2 = gestor.agregarReserva(reserva2);
		assertFalse(seAgregoReserva2);
	
	}
	
	
}
