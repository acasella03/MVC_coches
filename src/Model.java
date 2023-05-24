import java.util.ArrayList;

public class Model {
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un coche y lo mete en el parking
     *
     * @param modelo    del coche
     * @param matricula identificador unico
     * @return el coche creado
     */
    public static Coche crearCoche(String modelo, String matricula) {
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca coche segun matricula
     *
     * @param matricula a buscar
     * @return coche o null si no existe
     */
    public static Coche getCoche(String matricula) {
        Coche aux = null;
        // recorre el array buscando por matricula
        for (Coche e : parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    /**
     * @param matricula
     * @param v         nueva velocidad
     * @return velocidad modificada
     */
    public static Integer cambiarVelocidad(String matricula, Integer v) {
        // busca el coche
        getCoche(matricula).velocidad = v;
        // retorna la nueva velocidad
        return getCoche(matricula).velocidad;
    }

    /**
     * Aumenta la velocidad de un coche
     *
     * @param matricula del coche
     * @param v         velocidad para acelerar
     * @return velocidad aumentada
     */
    public static Integer subirVelocidad(String matricula, Integer v) {
        getCoche(matricula).velocidad = v + getCoche(matricula).velocidad;
        return getCoche(matricula).velocidad;
    }

    /**
     * Disminuye la velocidad de un coche
     *
     * @param matricula del coche
     * @param v         velocidad para disminuir
     * @return velocidad disminuida
     */
    public static Integer bajarVelocidad(String matricula, Integer v) {
        getCoche(matricula).velocidad = getCoche(matricula).velocidad - v;
        return getCoche(matricula).velocidad;
    }


    /**
     * Devuelve la velocidad segun la matricula
     *
     * @param matricula
     * @return
     */
    public static Integer getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
}
