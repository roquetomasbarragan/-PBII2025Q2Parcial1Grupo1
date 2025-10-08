package ar.edu.unlam.interfaz;

public enum Menu {
	
AGREGAR_CANCHA("1. Agregar cancha."), AGREGAR_RESERVA("\n2. Agregar reserva."),AGREGAR_ITEMS_ADICIONALES("\n3. Agregar Items Adicionales"), 
CERRAR_RESERVA_Y_OBTENER_COSTO("\n4. Cerrar reserva y obtener el costo final a pagar."), VER_RESERVAS_REALIZADAS("\n5. Ver todas las reservas realizadas."), 
CANCELAR_RESERVA("\n6. Cancelar reserva."), MOSTRAR_RESERVAS("\n7. Ver canchas RESERVADAS en un horario especifico"), 
MOSTRAR_DISPONIBLES("\n8. Ver canchas DISPONIBLES en un horario especifico"), SALIR("\n9. Salir.");


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
