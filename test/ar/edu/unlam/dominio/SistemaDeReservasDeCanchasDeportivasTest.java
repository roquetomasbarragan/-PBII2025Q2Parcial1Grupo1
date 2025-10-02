package ar.edu.unlam.dominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;

public class SistemaDeReservasDeCanchasDeportivasTest {

	@Test
	public void dadoQueExisteUnGestorDeReservasDeCanchasSePuedeCrearUnaCanchaDeFutbolDeTenisYDePaddleExitosamente() {

		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;
		Cancha canchaDeFutbol = new CanchaDeFutbol5 (precioBasePorHora);
		Boolean seAgregoFutbol = gestor.agregarCancha(canchaDeFutbol);
		
		
		Double precioBasePorHora2 = 27000.0;
		Cancha canchaDeTenis = new CanchaDeTenis(precioBasePorHora2);
		Boolean seAgregoTenis = gestor.agregarCancha(canchaDeTenis);

		Double precioBasePorHora3 = 23000.0;
		Cancha canchaDePaddle = new CanchaDePaddle(precioBasePorHora3);
		Boolean seAgregoPaddle = gestor.agregarCancha(canchaDePaddle);

		assertTrue(seAgregoFutbol);
		assertTrue(seAgregoTenis);
		assertTrue(seAgregoPaddle);
	}

		

	@Test
	public void dadoQueExisteUnGestorDeReservasYUnaCanchaElClientePuedeReservarlaElMetodoDevuelveTrue() {
		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha cancha = new CanchaDeFutbol5 (precioBasePorHora);
		gestor.agregarCancha(cancha);
		
		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);
		
		String nombre = "Juan";
		Integer dni = 123;
		Cliente clienteTitular = new Cliente(nombre, dni);
		
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio);
		
		Boolean seAgregoReserva = gestor.agregarReserva(reserva);
		
		assertTrue(seAgregoReserva);
	}
	
	@Test 
	public void dadoQueExisteUnaCanchaReservadaNoSePuedeReservarLaMismaEnElMismoHorarioElMetodoDevuelveFalse() {
		
		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha cancha = new CanchaDeFutbol5 (precioBasePorHora);
		gestor.agregarCancha(cancha);  
		
		
		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);
		Cliente clienteTitular = new Cliente("Juan", 123);
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio);
		
		gestor.agregarReserva(reserva);
		
		
		LocalDateTime horaInicio2 = LocalDateTime.of(2025, 10, 01, 20, 00);
		Cliente clienteTitular2 = new Cliente("Pedro", 235);
		ReservaBase reserva2 = new ReservaBase(clienteTitular2, cancha, horaInicio2);
		
		Boolean seAgregoReserva2 = gestor.agregarReserva(reserva2);
		
		
		assertFalse(seAgregoReserva2);
	
	}
	
	@Test 
	public void dadoQueExisteUnaReservaPuedoVerificarSiEsNocturnaSiSuHorarioDeInicioEsPosteriorALas20() {
		
		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha cancha = new CanchaDeFutbol5 (precioBasePorHora);
		gestor.agregarCancha(cancha);  
		
		
		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 30);
		Cliente clienteTitular = new Cliente("Juan", 123);
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio);
		
		gestor.agregarReserva(reserva);
		
		Boolean esNocturna = reserva.verificarSiEsNocturna(reserva);
		
		assertTrue(esNocturna);
		
	}
	
	
}
