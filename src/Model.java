import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable {
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
     * @return chche o null si no existe
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
     * Cambia la velocidad, por lo tanto
     * tendrá que avisar al controlador que ha cambiado
     *
     * @param matricula del coche
     * @param v         nueva velocidad
     * @return velocidad modificada
     */
    public void cambiarVelocidad(String matricula, Integer v) {
        // busca el coche
        getCoche(matricula).velocidad = v;
        // apuntamos el cambio
        setChanged();
        // notificación a todos los observadores
        notifyObservers(getCoche(matricula));
    }

    /**
     * Aumenta la velocidad de un coche
     *
     * @param matricula del coche
     * @param v         velocidad para acelerar
     * @return velocidad aumentada
     */
    public void subirVelocidad(String matricula, Integer v) {
        getCoche(matricula).velocidad = v + getCoche(matricula).velocidad;
        setChanged();
        notifyObservers(getCoche(matricula));
    }

    /**
     * Disminuye la velocidad de un coche
     *
     * @param matricula del coche
     * @param v         velocidad para disminuir
     * @return velocidad disminuida
     */
    public void bajarVelocidad(String matricula, Integer v) {
        getCoche(matricula).velocidad = getCoche(matricula).velocidad - v;
        setChanged();
        notifyObservers(getCoche(matricula));
    }


    /**
     * Devuelve la velocidad segun la matricula
     *
     * @param matricula del coche
     * @return velocidad del coche
     */
    public static Integer getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
}
