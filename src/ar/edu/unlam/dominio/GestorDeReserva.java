package ar.edu.unlam.dominio;

import java.time.LocalDateTime;
import java.util.HashSet;

public class GestorDeReserva {

	private HashSet<Cancha> canchas;
	private HashSet<ReservaBase> reservas;
	private static Integer proximoIdCancha = 0;
	private static Integer proximoIdReserva = 0;
	

	public GestorDeReserva() {
		this.canchas = new HashSet<>();
		this.reservas = new HashSet<>();
	}

	public Boolean agregarCancha(Cancha cancha) {
		cancha.setIdCancha(proximoIdCancha);
		proximoIdCancha ++;
		return this.canchas.add(cancha);
	}

	public Boolean agregarReserva(ReservaBase nuevaReserva) {
		if (!hayHorarioSuperpuesto(nuevaReserva)) {
			nuevaReserva.setIdReserva(proximoIdReserva);
			proximoIdReserva ++;
			return reservas.add(nuevaReserva);
		}
		return false; 
	}

	private Boolean hayHorarioSuperpuesto(ReservaBase nuevaReserva) {
		for (ReservaBase reservaExistente : this.reservas) {
			if (reservaExistente.getCancha().getIdCancha().equals(nuevaReserva.getCancha().getIdCancha())) {
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
