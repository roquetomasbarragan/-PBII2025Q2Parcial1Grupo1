package ar.edu.unlam.dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReservaBase implements Tarifable{

	private Cliente clienteTitular;
	private Cancha cancha;
	private LocalDateTime horaInicio;
	private LocalDateTime horaFinal;
	private Integer idReserva;
	private List<ItemAdicional> items;

	public ReservaBase(Cliente clienteTitular, Cancha cancha, LocalDateTime horaInicio) {
		this.clienteTitular = clienteTitular;
		this.cancha = cancha;
		this.horaInicio = horaInicio;
		this.horaFinal = horaInicio.plusHours(1);
		this.items = new ArrayList<>();
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

	public void setCancha(Cancha cancha) {
		this.cancha = cancha;
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

	public void setIdReserva(Integer id) {
		this.idReserva = id;
	}
	
	public Boolean estaActiva(LocalDateTime momento) {
		return !momento.isBefore(this.horaInicio) && !momento.isAfter(this.horaFinal);
	}


	public Boolean agregarItemAdicional(ItemAdicional item) {

		if (item.esCompatibleConLaCancha(this.cancha)) {
			return this.items.add(item);
		}
		return false;
	}

	public Integer getCantidadItems() {
		
		return this.items.size();
	}
	
	public List<ItemAdicional> getItems() {
		return items;
	}

	
	@Override
	public Double calcularPrecioFinal() {
		Double precioFinal = 0.0;
		for (ItemAdicional item : this.items) {
			precioFinal += item.calcularCosto(this.cancha);
		}
		precioFinal += this.cancha.getPrecioBasePorHora();
		return precioFinal;
	}
	


}
