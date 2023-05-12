public class Controller {
    static Model miModelo = new Model();

    public static void main(String[] args) {
        View.View();

        ObserverVelocidad observarVelocidad = new ObserverVelocidad();
        miModelo.addObserver(observarVelocidad);
    }

    public static void bCrearCoche(String modelo, String matricula) {
        Coche aux = Model.crearCoche(modelo, matricula);
        if (aux != null) View.muestraVelocidad(aux.matricula, aux.velocidad);
    }

    public static void bAumentarVelocidad(String matricula, Integer v) {
        miModelo.subirVelocidad(matricula, v);
    }

    public static void bReducirVelocidad(String matricula, Integer v) {
        miModelo.bajarVelocidad(matricula, v);
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