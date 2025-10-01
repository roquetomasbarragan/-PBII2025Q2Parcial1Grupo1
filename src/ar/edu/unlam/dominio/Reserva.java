package ar.edu.unlam.dominio;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reserva {

	private Cliente clienteTitular;
	private Cancha cancha;
	private LocalDateTime horaInicio;
	private LocalDateTime horaFinal;
	private Integer id;

	public Reserva(Cliente clienteTitular, Cancha cancha, LocalDateTime horaInicio, LocalDateTime horaFinal, Integer id) {
		this.clienteTitular = clienteTitular;
		this.cancha = cancha;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.id = id;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(id, other.id);
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

	public void setCancha(Cancha cancha) {
		this.cancha = cancha;
	}

	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalDateTime getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(LocalDateTime horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Integer getId() {
		return id;
	}

	
	
	
	
	

}
