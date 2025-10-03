package ar.edu.unlam.dominio;

import java.time.LocalDateTime;
import java.util.HashSet;

public class GestorDeReserva implements Tarifable {

	private HashSet<Cancha> canchas;
	private HashSet<ReservaBase> reservas;
	private static Integer proximoIdCancha = 1;
	private static Integer proximoIdReserva = 1;

	public GestorDeReserva() {
		this.canchas = new HashSet<>();
		this.reservas = new HashSet<>();
	}

	public Boolean agregarCancha(Cancha cancha) {
		cancha.setIdCancha(proximoIdCancha);
		proximoIdCancha++;
		return this.canchas.add(cancha);
	}

	public Boolean agregarReserva(ReservaBase nuevaReserva) {
		if (!hayHorarioSuperpuesto(nuevaReserva)) {
			nuevaReserva.setIdReserva(proximoIdReserva);
			proximoIdReserva++;
			return reservas.add(nuevaReserva);
		}
		return false;
	}

	private Boolean hayHorarioSuperpuesto(ReservaBase nuevaReserva) {
		for (ReservaBase reservaExistente : this.reservas) {
			if (reservaExistente.getCancha().equals(nuevaReserva.getCancha())) {
				if (yaSeReservoLaCanchaEnEseRangoHorario(reservaExistente, nuevaReserva)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean yaSeReservoLaCanchaEnEseRangoHorario(ReservaBase reservaExistente, ReservaBase nuevaReserva) {

		LocalDateTime inicioReservaExistente = reservaExistente.getHoraInicio();
		LocalDateTime finalReservaExistente = reservaExistente.getHoraFinal();

		LocalDateTime inicioNuevaReserva = nuevaReserva.getHoraInicio();
		LocalDateTime finalNuevaReserva = nuevaReserva.getHoraFinal();

		Boolean reservaExistenteEmpiezaCuandoTerminaNuevaReserva = inicioReservaExistente.isBefore(finalNuevaReserva);
		Boolean reservaExistenteTerminaCuandoEmpiezaNuevaReserva = finalReservaExistente.isAfter(inicioNuevaReserva);

		return reservaExistenteEmpiezaCuandoTerminaNuevaReserva && reservaExistenteTerminaCuandoEmpiezaNuevaReserva;
	}

	@Override
	public Double calcularPrecioFinal(ReservaBase reserva) {
		Double precioFinal = 0.0;
		for (ItemAdicional item : reserva.getItems()) {
			precioFinal += item.calcularCosto();
		}
		precioFinal += reserva.getCancha().getPrecioBasePorHora();
		return precioFinal;
	}

	public Double finalizarReserva(Integer IdDeReserva) {
		ReservaBase reservaAFinalizar = obtenerReservaPorId(IdDeReserva);
		return calcularPrecioFinal(reservaAFinalizar);
	}

	public ReservaBase obtenerReservaPorId(Integer idABuscar) {
		ReservaBase reservaEncontrada = null;
		for (ReservaBase reserva : this.reservas) {
			if (reserva.getIdReserva().equals(idABuscar)) {
				reservaEncontrada = reserva;
			}
		}
		return reservaEncontrada;
	}

}
