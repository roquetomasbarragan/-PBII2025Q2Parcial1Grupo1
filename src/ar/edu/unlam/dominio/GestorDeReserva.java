package ar.edu.unlam.dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

public class GestorDeReserva {

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

	public Double finalizarReserva(Integer IdDeReserva) {
		ReservaBase reservaAFinalizar = obtenerReservaPorId(IdDeReserva);
		return reservaAFinalizar.calcularPrecioFinal();
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

	public Boolean cancelarReserva(ReservaBase reserva) {
		return this.reservas.remove(reserva);
	}
	public Boolean cancelarReservaPorId(Integer idReserva) {
		ReservaBase reservaACancelar = obtenerReservaPorId(idReserva);
		return cancelarReserva(reservaACancelar);
	}

	public Cancha obtenerCanchaPorId(Integer idCancha) {
		Cancha canchaEncontrada = null;
		for (Cancha cancha : this.canchas) {
			if (cancha.getIdCancha().equals(idCancha)) {
				canchaEncontrada = cancha;
			}
		}
		return canchaEncontrada;
	}

	public HashSet<Cancha> getCanchas() {
		return canchas;
	}

	public HashSet<Cancha> obtenerCanchasReservadas(LocalDateTime horaDeInicio) {
		HashSet<Cancha> hashSetTemporalDeCanchasReservadas = new HashSet<>();

			for (ReservaBase reserva : reservas) {
				if (reserva.estaActiva(horaDeInicio)) {
					hashSetTemporalDeCanchasReservadas.add(reserva.getCancha());
				}
			}
		
		return hashSetTemporalDeCanchasReservadas;
	}
	
	public HashSet<Cancha> obtenerCanchasDisponibles(LocalDateTime horaDeInicio) {
		HashSet<Cancha> hashSetTemporalDeCanchasDisponibles = new HashSet<>();
		ArrayList<Integer> IdDeCanchasReservadas = obtenerCanchasIdDeCanchasReservadas(horaDeInicio);
		
		for (Cancha cancha : this.canchas) {
			 if (!IdDeCanchasReservadas.contains(cancha.getIdCancha())) {
				 hashSetTemporalDeCanchasDisponibles.add(cancha);
		        }
		}
		
		return hashSetTemporalDeCanchasDisponibles;
	}
	
	public ArrayList<Integer> obtenerCanchasIdDeCanchasReservadas(LocalDateTime horaDeInicio) {
		ArrayList<Integer> IdDeCanchasReservadas = new ArrayList<>();
		
		for (Cancha cancha : obtenerCanchasReservadas(horaDeInicio)) {
			IdDeCanchasReservadas.add(cancha.getIdCancha());
		}
		
		return IdDeCanchasReservadas;
	}
	
	
}
