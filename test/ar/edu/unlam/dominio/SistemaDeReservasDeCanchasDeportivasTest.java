package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;

public class SistemaDeReservasDeCanchasDeportivasTest {

	@Test
	public void dadoQueExisteUnGestorDeReservasDeCanchasSePuedeCrearUnaCanchaExitosamenteElMetodoDevuelveTrue() {

		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha canchaDeFutbol = new CanchaDeFutbol5(precioBasePorHora);

		Boolean seAgrego = gestor.agregarCancha(canchaDeFutbol);

		assertTrue(seAgrego);
	}

	@Test
	public void dadoQueExisteUnGestorDeReservasDeCanchasYUnaCanchaElClientePuedeReservarlaElMetodoDevuelveTrue() {
		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha cancha = new CanchaDeFutbol5(precioBasePorHora);
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

		Cancha cancha = new CanchaDeFutbol5(precioBasePorHora);
		gestor.agregarCancha(cancha);
		
		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);
		
		String nombre = "Juan";
		Integer dni = 123;
		Cliente clienteTitular = new Cliente(nombre, dni);
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio);
		gestor.agregarReserva(reserva);
		
		
		Cliente clienteTitular2 = new Cliente("Pedro", 235);
		LocalDateTime horaInicio2 = LocalDateTime.of(2025, 10, 01, 20, 00);
		ReservaBase reserva2 = new ReservaBase(clienteTitular2, cancha, horaInicio2);
		
		Boolean seAgregoReserva2 = gestor.agregarReserva(reserva2);
		assertFalse(seAgregoReserva2);
	
	}
	
	public void dadoQueExisteUnaCanchaReservadaElClientePuedeCancelarSuReserva() {
		
		
		GestorDeReserva gestor = new GestorDeReserva();
		
		Double precioBasePorHora = 20000.00;
		
		Cancha cancha = new CanchaDeFutbol5(precioBasePorHora);
		gestor.agregarCancha(cancha);
		
		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);
		
		String nombre = "Juan";
		Integer dni = 123;
		Cliente clienteTitular = new Cliente(nombre, dni);
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio);
		gestor.agregarReserva(reserva);
		
		Boolean seCanceloLaReserva = gestor.cancelarReserva(reserva);
		assertTrue(seCanceloLaReserva);
		
	}
	
	
	
	@Test 
	public void dadoQueExisteUnaCanchaDeFutbol5YUnaReservaSePuedeAgregarUnaPelotaDeFutbolSiLaCanchaAReservarEsDeFutbol() {
		
		
		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha cancha = new CanchaDeFutbol5(precioBasePorHora);
		gestor.agregarCancha(cancha);
		
		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);
		
		String nombre = "Juan";
		Integer dni = 123;
		Cliente clienteTitular = new Cliente(nombre, dni);
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio);
		gestor.agregarReserva(reserva);
		
		
		ItemAdicional pelotaDeFutbol = new PelotaDeFutbol();
		
		
		Boolean seAgregoElItem = reserva.agregarItemAdicional(pelotaDeFutbol);
		Integer cantidadEsperada = 1;
		Integer cantidadObtenida = reserva.getCantidadItems();
		assertTrue(seAgregoElItem);
		assertEquals(cantidadEsperada, cantidadObtenida);
		
	}
	
	@Test 
	public void dadoQueExisteUnaCanchaDeTenisYUnaReservaNOSePuedeAgregarUnaPelotaDeFutbolSiLaCanchaAReservarNoEsDeFutbol() {
		
		
		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha cancha = new CanchaDeTenis(precioBasePorHora);
		gestor.agregarCancha(cancha);
		
		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);
		
		String nombre = "Juan";
		Integer dni = 123;
		Cliente clienteTitular = new Cliente(nombre, dni);
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio);
		gestor.agregarReserva(reserva);
		
		
		ItemAdicional pelotaDeFutbol = new PelotaDeFutbol();
		
		
		Boolean seAgregoElItem = reserva.agregarItemAdicional(pelotaDeFutbol);
		Integer cantidadEsperada = 0;
		Integer cantidadObtenida = reserva.getCantidadItems();
		
		assertFalse(seAgregoElItem);
		assertEquals(cantidadEsperada, cantidadObtenida);
		
	}
	
	@Test 
	public void dadoQueExisteUnaCanchaDeTenisYUnaReservaElClientePuedeAgregarRaquetasDeTenis() {
		
		
		GestorDeReserva gestor = new GestorDeReserva();
		
		Double precioBasePorHora = 20000.00;
		
		Cancha cancha = new CanchaDeTenis(precioBasePorHora);
		gestor.agregarCancha(cancha);
		
		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);
		
		String nombre = "Juan";
		Integer dni = 123;
		Cliente clienteTitular = new Cliente(nombre, dni);
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio);
		gestor.agregarReserva(reserva);
		
		
		ItemAdicional raquetaDeTenis = new RaquetaDeTenis();
		
		Boolean seAgregoElItem = reserva.agregarItemAdicional(raquetaDeTenis);
		
		assertTrue(seAgregoElItem);
	}
	
	@Test 
	public void dadoQueExisteUnaCanchaDeTenisYUnaReservaElClientePuedeAgregarRaquetasDeTenisQueSeSumaEnElPrecioFinal() {
		
		
		GestorDeReserva gestor = new GestorDeReserva();
		
		Double precioBasePorHora = 20000.00;
		
		Cancha cancha = new CanchaDeTenis(precioBasePorHora);
		gestor.agregarCancha(cancha);
		
		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);
		
		String nombre = "Juan";
		Integer dni = 123;
		Cliente clienteTitular = new Cliente(nombre, dni);
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio);
		gestor.agregarReserva(reserva);
		
		
		ItemAdicional raquetaDeTenis = new RaquetaDeTenis();
		
		reserva.agregarItemAdicional(raquetaDeTenis);
		
		Double precioFinalEsperado = 48000.00;
		Double precioFinalObtenido = reserva.calcularPrecioFinal();
		
		assertEquals(precioFinalEsperado, precioFinalObtenido);
	}
	
	@Test 
	public void dadoQueExisteUnaCanchaYMuchasReservasPuedoIdentificarUnaReservaSoloConSuiID() {
		
		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha cancha = new CanchaDeFutbol5(precioBasePorHora);
		gestor.agregarCancha(cancha);
		
		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);
		
		Cliente clienteTitular = new Cliente("Juan", 123);
		ReservaBase reservaDeJuan = new ReservaBase(clienteTitular, cancha, horaInicio);
		gestor.agregarReserva(reservaDeJuan);
		
		
		Cliente clienteTitular2 = new Cliente("Pedro", 235);
		LocalDateTime horaInicio2 = LocalDateTime.of(2025, 10, 01, 23, 00);
		ReservaBase reservaDePedro = new ReservaBase(clienteTitular2, cancha, horaInicio2);
		
		gestor.agregarReserva(reservaDePedro);
		
		//Quiero obtener la reserva de Pedro
		Integer IdDeReserva = reservaDePedro.getIdReserva();
		
		ReservaBase reservaEsperada = reservaDePedro;
		ReservaBase reservaEncontrada = gestor.obtenerReservaPorId(IdDeReserva);
		
		assertEquals(reservaEsperada, reservaEncontrada);
		
	}
	
	@Test
	public void dadoQueExisteUnaReservaDeCanchasElClientePuedeCancelarlaSabiendoSuIdDeReserva() {
		GestorDeReserva gestor = new GestorDeReserva();
		
		Double precioBasePorHora = 20000.00;
		
		Cancha cancha = new CanchaDeFutbol5(precioBasePorHora);
		gestor.agregarCancha(cancha);
		
		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);
		
		Cliente clienteTitular = new Cliente("Juan", 123);
		ReservaBase reservaDeJuan = new ReservaBase(clienteTitular, cancha, horaInicio);
		gestor.agregarReserva(reservaDeJuan);
		
		gestor.agregarReserva(reservaDeJuan);
		
		Cliente clienteTitular2 = new Cliente("Pedro", 235);
		LocalDateTime horaInicio2 = LocalDateTime.of(2025, 10, 01, 23, 00);
		ReservaBase reservaDePedro = new ReservaBase(clienteTitular2, cancha, horaInicio2);
		
		gestor.agregarReserva(reservaDePedro);
		
		
		//Juan desea cancelar su reserva
		Integer idReserva = reservaDeJuan.getIdReserva();
		
		Boolean seCanceloReserva = gestor.cancelarReservaPorId(idReserva);
		
		assertTrue(seCanceloReserva);
		
	}
	
	@Test 
	public void dadoQuePuedoIdentificarUnaReservaConItemsSoloConSuiIdPuedoFinalizarlaYObtenerElImporteTotalAPagar() {
		
		GestorDeReserva gestor = new GestorDeReserva();
		
		Double precioBasePorHora = 20000.00;
		
		Cancha cancha = new CanchaDeFutbol5(precioBasePorHora);
		gestor.agregarCancha(cancha);
		
		Cliente clienteTitular = new Cliente("Pedro", 235);
		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio);
		
		gestor.agregarReserva(reserva);
		
		ItemAdicional pelota = new PelotaDeFutbol();
		reserva.agregarItemAdicional(pelota);
		
		Integer IdDeReserva = reserva.getIdReserva();
		
		Double valorObtenido = gestor.finalizarReserva(IdDeReserva);
		Double valorEsperado = 25000D;
		
		assertEquals(valorEsperado, valorObtenido);
		
		
	}
	

	
	
	
	
	
}
