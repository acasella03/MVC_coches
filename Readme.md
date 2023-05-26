# Arquitectura MVC con Observer

Aplicación que trabaja con objetos coches, modifica la velocidad y la muestra.

Los cambios de la velocidad que se hagan en el model serán observados por el Controller.

Para notificar a los observadores se hacen dos pasos:
1. Se actualiza el estado de 'algo a cambiado' con `setChange()`
2. Se notifica a los observadores `notifyObservers(valor)`

De esta manera se dispara en todos los observadores el método `update()`

---
## Diagrama de clases:

```mermaid
classDiagram
    class Observable{
        +setChange()
        +notifyObserver(valor)
    }
    class Coche {
        String: matricula
        String: modelo
        Integer: velocidad
    }
      class Controller{
          +main()
      }
      class View {+muestraVelocidad(String, Integer)
                  +muestraVelocidad2(String, Integer)
       }
      class Model {
          ArrayList~Coche~: parking
          +crearCoche(String, String, String)
          +getCoche(String)
          +cambiarVelocidad(String, Integer)
          +subirVelocidad(String, Integer)
          +bajarVelocidad(String, Integer)
          +getVelocidad(String)
      }
      class InterfazGrafica {
          +mostrarVentana()
      }
      class Dialogo {
          +mostrarMensaje()
      }
      class ObserverVelocidad {
      +update()
      }
      class ObsExceso {
      +update()
      }
    Controller "1" *-- "1" ObserverVelocidad : association
    Controller "1" *-- "1" ObsExceso : association
    Controller "1" *-- "1" Model : association
    Controller "1" *-- "1" View : association
    Model "1" *-- "1..n" Coche : association
    View "1" *-- "1..1" InterfazGrafica : association
    View "1" *-- "1..1" Dialogo : association
    Observable<|--Model
      
```

---

## Diagrama de Secuencia
### Evento en el View
El observer está para controlar el cambio de velocidad
```mermaid
sequenceDiagram
    actor usuario
    participant View
    participant Controller
    participant ObserverVelocidad
    participant ObsExceso
    participant Model
    
    usuario-->>View: clik! Crear coche
    activate View
    View-->>Controller: El usuario quiere crear un coche
    activate Controller
    Controller->>Model: Puedes crear un coche?
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller-->>View: Coche creado
    deactivate Controller
    View-->>usuario: Tu coche se ha creado!
    deactivate View
    
    usuario-->>View: clik! Para aumentar velocidad
    activate View
    View-->>Controller: El usuario quiere aumentar la velocidad
    activate Controller
    Controller->>Model: Aumenta la velocidad
    activate Model
    Model-->>ObserverVelocidad: Notificación de cambio de velocidad
    activate ObserverVelocidad
    Model-->>ObsExceso: Notificación de cambio de velocidad
    deactivate Model
    activate ObsExceso
    ObserverVelocidad-->>+View: Muestra la velocidad
    deactivate ObserverVelocidad
    ObsExceso-->>+View: Muestra Velocidad con exceso
    deactivate ObsExceso
    deactivate Controller
    View-->>usuario: Tu coche ha aumentado su velocidad!
    deactivate View
    
    usuario-->>View: clik! Para reducir velocidad
    activate View
    View-->>Controller: El usuario quiere reducir la velocidad
    activate Controller
    Controller->>Model: Reduce la velocidad
    activate Model
    Model-->>ObserverVelocidad: Notificación de cambio de velocidad
    deactivate Model
    activate ObserverVelocidad
    ObserverVelocidad-->>+View: Muestra la velocidad
    deactivate ObserverVelocidad
    deactivate Controller
    View-->>usuario: Tu coche ha reducido su velocidad!
    deactivate View
```

El mismo diagrama con los nombres de los métodos
```mermaid
sequenceDiagram
    actor usuario
    
        participant InterfazGrafica
        participant Dialogo
        participant View
    
    participant Controller
    participant ObserverVelocidad
    participant ObsExceso
    participant Model
    
    usuario-->>InterfazGrafica: clik! Crear coche
    InterfazGrafica-->Controller: crearCoche(modelo,matricula)
    activate Controller
    Controller->>Model: crearCoche(modelo, matricula)
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller-->>+View: muestraVelocidad(matricula, velocidad)
    deactivate Controller
    View-->>-Dialogo: muestraVelocidad(matricula, velocidad)
    usuario-->>InterfazGrafica: clik! Para aumentar velocidad
    InterfazGrafica-->>Controller: subirVelocidad(matricula,velocidad)
    activate Controller
    Controller->>Model: subirVelocidad(matricula,velocidad)
    activate Model
    Model-->>ObserverVelocidad: update()
    deactivate Model
    activate ObserverVelocidad
    ObserverVelocidad-->>+View: muestraVelocidad(matricula, velocidad)
    deactivate ObserverVelocidad
    deactivate Controller
    View-->>-Dialogo: muestraVelocidad(matricula, velocidad)
    
    usuario-->>InterfazGrafica: clik! Para reducir velocidad
    InterfazGrafica-->>Controller: bajarVelocidad(matricula,velocidad)
    activate Controller
    Controller->>Model: bajarVelocidad(matricula,velocidad)
    activate Model
    Model-->>ObserverVelocidad: update()
    deactivate Model
    activate ObserverVelocidad
    ObserverVelocidad-->>+View: muestraVelocidad(matricula, velocidad)
    deactivate ObserverVelocidad
    deactivate Controller
    View-->>-Dialogo: muestraVelocidad(matricula, velocidad)
```