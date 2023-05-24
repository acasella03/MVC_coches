/**
 * Clase que se encarga de conectar la View con el Modelo
 */
public class Controller {
    /**
     * Llama a la View
     *
     * @param args
     */
    public static void main(String[] args) {
        View.View();
    }

    /**
     * Funcionalidad del botón Crear coche
     *
     * @param modelo    del coche a crear
     * @param matricula del coche a crear
     */
    public static void bCrearCoche(String modelo, String matricula) {
        Coche aux = Model.crearCoche(modelo, matricula);
        if (aux != null) View.muestraVelocidad(aux.matricula, aux.velocidad);
    }

    /**
     * Funcionalidad del botón +
     *
     * @param matricula del coche a aumentar la velocidad
     * @param v         velocidad deseada
     * @return muestra la velocidad
     */
    public static Integer bAumentarVelocidad(String matricula, Integer v) {
        Integer aux = Model.subirVelocidad(matricula, v);
        if (aux != null) View.muestraVelocidad(matricula, aux);
        return aux;
    }

    /**
     * Funcionalidad del botón -
     *
     * @param matricula del coche a reducir la velocidad
     * @param v         velocidad deseada
     * @return muestra la velocidad
     */
    public static Integer bReducirVelocidad(String matricula, Integer v) {
        Integer aux = Model.bajarVelocidad(matricula, v);
        if (aux != null) View.muestraVelocidad(matricula, aux);
        return aux;
    }

    /**
     * Funcionalidad del botón BUSCAR
     * @param matricula del coche a buscar
     * @return datos completos del coche
     */
    public static Coche bBuscarCoche(String matricula) {
        Coche aux = Model.getCoche(matricula);
        if (aux != null) View.muestraCoche(aux.matricula, aux.modelo, aux.velocidad);
        return aux;
    }

        /*
        // Crear tres coches
        miModelo.crearCoche("LaFerrari", "SBC 1234");
        miModelo.crearCoche("Alpine", "HYU 4567");
        miModelo.crearCoche("Aston Martin", "FGH 3333");

        Coche ferrari = miModelo.getCoche("SBC 1234");
        // modifica la velocidad
        miModelo.cambiarVelocidad("SBC 1234", 30);
        // subir la velocidad
        miModelo.subirVelocidad("SBC 1234",20);
        // bajar la velocidad
        miModelo.bajarVelocidad("SBC 1234",10);

        // recoje la velocidad y la muestra (tarea de la View)
        boolean hecho = miVista.muestraVelocidad("SBC 1234", miModelo.getVelocidad("SBC 1234"));

        System.out.println(hecho);
    }*/


}