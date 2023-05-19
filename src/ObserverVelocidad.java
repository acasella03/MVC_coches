
import java.util.Observable;
import java.util.Observer;

public class ObserverVelocidad implements Observer {
    /**
     * Se llama cada vez que exista un cambio
     * El observable cuando hace el notifyObservers
     * 'dispara' todos los update de los Observers
     * @param o     objeto observable(Model).
     * @param arg   argumento pasado por {@code notifyObservers}
     *                 method.
     */
    @Override
    public void update(Observable o, Object arg) {
        // el argumento es tipo Object, porque es general
        Coche auxCoche= (Coche) arg;
        System.out.println("Se ha cambiado la velocidad: "+auxCoche.velocidad.toString());
        // comunicación a la vista que muestre la velocidad
        View.muestraVelocidad(auxCoche.matricula, auxCoche.velocidad);
    }
}
