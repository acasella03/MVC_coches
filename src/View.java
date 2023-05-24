public class View {
    /**
     * Constructor crear ventana
     */
    public static void View() {
        InterfazGrafica.crearVentana();
    }

    /**
     * Muestra la velocidad de un coche
     *
     * @param matricula del coche
     * @param v         velocidad a mostrar
     * @return true cuando es correcto
     */
    public static boolean muestraVelocidad(String matricula, Integer v) {
        String mensaje = "Coche " + matricula + " velocidad: " + v + "km/h";
        System.out.println(mensaje);
        Dialogo.main(mensaje);
        return true;
    }

    /**
     * Muestra un coche encontrado
     *
     * @param matricula del coche encontrado
     * @param modelo    del coche encontrado
     * @param v         velocidad del coche encontrado
     * @return el coche encontrado
     */
    public static boolean muestraCoche(String matricula, String modelo, Integer v) {
        String mensaje = "Coche " + matricula + " Modelo " + modelo + " velocidad: " + v + "km/h";
        System.out.println(mensaje);
        Dialogo.main(mensaje);
        return true;
    }
}
