package ar.edu.unlam.dominio;

import java.util.Objects;

public abstract class Cancha {

	private Double precioBasePorHora;
	private Integer idCancha;
	protected String tipoDeCancha;

	public Cancha( Double precioBasePorHora) {
		this.precioBasePorHora = precioBasePorHora;
	}
	
	public abstract Integer getCapacidadMax();

	public Double getPrecioBasePorHora() {
		return precioBasePorHora;
	}

	public void setIdCancha(Integer idCancha) {
		this.idCancha = idCancha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCancha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cancha other = (Cancha) obj;
		return Objects.equals(idCancha, other.idCancha);
	}

	public Integer getIdCancha() {
		return idCancha;
	}

	public String getTipoDeCancha() {
		return tipoDeCancha;
	}

	@Override
	public String toString() {
		return this.tipoDeCancha + " por $" + this.precioBasePorHora + "/hora.  ID: " + idCancha;
	}
	
}
