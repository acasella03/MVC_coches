public class View {
    public View() {
        InterfazGrafica.crearVentana();
    }
    boolean muestraVelocidad(String matricula, Integer v) {
        String mensaje = "Coche " + matricula + " velocidad: " + v + "km/h";
        System.out.println(mensaje);
        //Dialog.mostrarMensaje(mensaje);
        return true;
    }
}
