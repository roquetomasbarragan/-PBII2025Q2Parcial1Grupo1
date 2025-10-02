package ar.edu.unlam.dominio;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class ReservaBase{

	private Cliente clienteTitular;
	private Cancha cancha;
	private LocalDateTime horaInicio;
	private LocalDateTime horaFinal;
	private Integer idReserva;

	public ReservaBase(Cliente clienteTitular, Cancha cancha, LocalDateTime horaInicio) {
		this.clienteTitular = clienteTitular;
		this.cancha = cancha;
		this.horaInicio = horaInicio;
		this.horaFinal = horaInicio.plusHours(1);
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(idReserva);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservaBase other = (ReservaBase) obj;
		return Objects.equals(idReserva, other.idReserva);
	}



	public Cliente getClienteTitular() {
		return clienteTitular;
	}

	public void setClienteTitular(Cliente clienteTitular) {
		this.clienteTitular = clienteTitular;
	}

	public Cancha getCancha() {
		return cancha;
	}


	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}

	
	public LocalDateTime getHoraFinal() {
		return horaFinal;
	}

	
	public Integer getIdReserva() {
		return idReserva;
	}


	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}



	public Boolean verificarSiEsNocturna(ReservaBase reserva) {
		Boolean esNocturna = false;
		LocalTime horaDeInicioDeReserva = reserva.getHoraInicio().toLocalTime();
		if(horaDeInicioDeReserva.isAfter(LocalTime.of(20, 0))){
			esNocturna = true;
		}
		return esNocturna;
	}






	
	
	
	
	

}
