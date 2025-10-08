package ar.edu.unlam.interfaz;

public enum Menu {
	
AGREGAR_CANCHA("1. Agregar cancha."), AGREGAR_RESERVA("\n2. Agregar reserva."),AGREGAR_ITEMS_ADICIONALES("\n3. Agregar Items Adicionales"), 
VER_RESERVAS_REALIZADAS("\n4. Ver todas las reservas realizadas."), CANCELAR_CANCHA("\n5. Cancelar cancha."), MOSTRAR_RESERVAS("\n6. Ver canchas RESERVADAS en un horario especifico"), 
MOSTRAR_DISPONIBLES("\n7. Ver canchas DISPONIBLES en un horario especifico"), SALIR("\n8. Salir.");


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
