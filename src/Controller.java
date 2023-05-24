public class Controller {
    public static void main(String[] args) {
        View.View();
            }

    public static void bCrearCoche(String modelo, String matricula) {
        Coche aux = Model.crearCoche(modelo, matricula);
        if (aux != null) View.muestraVelocidad(aux.matricula, aux.velocidad);
    }

    public static Integer bAumentarVelocidad(String matricula, Integer v){
        Integer aux= Model.subirVelocidad(matricula, v);
        if (aux != null) View.muestraVelocidad(matricula, aux);
        return aux;
    }

    public static Integer bReducirVelocidad(String matricula, Integer v){
        Integer aux= Model.bajarVelocidad(matricula,v);
        if (aux != null) View.muestraVelocidad(matricula, aux);
        return aux;
    }
    public static Coche bBuscar (String matricula){
        Coche aux= Model.getCoche(matricula);
        if (aux != null) View.muestraVelocidad(aux.matricula,aux.velocidad);
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