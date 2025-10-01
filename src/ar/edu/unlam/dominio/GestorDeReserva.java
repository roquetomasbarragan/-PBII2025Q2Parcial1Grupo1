package ar.edu.unlam.dominio;

import java.time.LocalDateTime;
import java.util.HashSet;

public class GestorDeReserva {

	private HashSet<Cancha> canchas;
	private HashSet<ReservaBase> reservas;

	public GestorDeReserva() {
		this.canchas = new HashSet<>();
		this.reservas = new HashSet<>();
	}

	public Boolean agregarCancha(Cancha cancha) {

		return this.canchas.add(cancha);
	}

	public Boolean agregarReserva(ReservaBase nuevaReserva) {
		if (hayHorarioSuperpuesto(nuevaReserva)) {
			return false;
		}
		return reservas.add(nuevaReserva);
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

}
