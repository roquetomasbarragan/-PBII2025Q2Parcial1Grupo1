package ar.edu.unlam.interfaz;

public enum Menu {
AGREGAR_CANCHA("1. Agregar cancha."), AGREGAR_RESERVA("\n2.Agregar reserva."),AGREGAR_ITEMS_ADICIONALES("\n3.Agregar Items Adicionales"), RESERVAR_CANCHA("\n4.Reservar cancha."), CANCELAR_CANCHA("\n5.Cancelar cancha."), SALIR("\n6.Salir.");


	private String descripcion;

	Menu(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}


	public static String getMenu() {
		String menu = "";
		Menu [] menuPrincipal = Menu.values();
		
		for (Menu menuTemp : menuPrincipal) {
			menu += menuTemp.getDescripcion();
		}
		
		return menu;
	}
	

}
