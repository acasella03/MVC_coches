import java.util.Observable;
import java.util.Observer;

public class ObsExceso implements Observer {

    /**
     * Se llama cada vez que exista un cambio
     * El observable cuando hace el notifyObservers
     * 'dispara' todos los update de los Observers
     *
     * @param o   the observable object.
     * @param arg an argument passed to the {@code notifyObservers}
     *            method.
     */
    @Override
    public void update(Observable o, Object arg) {
        // el argumento es tipo Object, porque es general
        //hay que castear el Objeto a tipo Coche
        Coche auxCoche = (Coche) arg;
        if(auxCoche.velocidad > 120){
            View.mostrarVelocidad2(auxCoche.matricula, auxCoche.velocidad);
        }

    }
}