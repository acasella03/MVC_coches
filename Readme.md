# Arquitectura MVC

Aplicación que trabaja con objetos coches, modifica la velocidad y la muestra

---
## Diagrama de clases:

```mermaid
classDiagram
    class Coche {
        String: matricula
        String: modelo
        Integer: velocidad
    }
      class Controller{
          +main()
      }
      class View {+muestraVelocidad(String, Integer)
                  +muestraCoche(String, String, Integer)
      }
      class Model {
          ArrayList~Coche~: parking
          +crearCoche(String, String, String)
          +getCoche(String)
          +cambiarVelocidad(String, Integer)
          +subirVelocidad(String, Integer)
          +bajarVelocidad(String, Integer)
          +getVelocidad(String)
          +getModelo(String)
      }
      class InterfazGrafica {
          +mostrarVentana()
      }
      class Dialogo {
          +mostrarMensaje()
      }
    Controller "1" *-- "1" Model : association
    Controller "1" *-- "1" View : association
    Model "1" *-- "1..n" Coche : association
    View "1" *-- "1..1" InterfazGrafica : association
    View "1" *-- "1..1" Dialogo : association
      
```

---

## Diagrama de Secuencia
### Evento en el View

Cuando ocurre un evento en la vista, el `controller`se tiene que enterar.<br>
Tener en cuenta que en el MVC estricto, la vista no se comunica con el modelo.

En el listener del botón llamamos al `controler`


```mermaid
sequenceDiagram
    actor usuario
    participant View
    participant Controller
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
    Model-->>Controller: Aumento de velocidad
    deactivate Model
    Controller-->>View: Velocidad aumentada
    deactivate Controller
    View-->>usuario: Tu coche ha aumentado su velocidad!
    deactivate View
    
    usuario-->>View: clik! Para reducir velocidad
    activate View
    View-->>Controller: El usuario quiere reducir la velocidad
    activate Controller
    Controller->>Model: Reduce la velocidad
    activate Model
    Model-->>Controller: Reducción de velocidad
    deactivate Model
    Controller-->>View: Velocidad reducida
    deactivate Controller
    View-->>usuario: Tu coche ha reducido su velocidad!
    deactivate View
    
    usuario-->>View: Introduce matrícula! clik en BUSCAR!
    activate View
    View-->>Controller: El usuario quiere buscar un coche
    activate Controller
    Controller->>Model: Busca coche
    activate Model
    Model-->>Controller: Coche encontrado
    deactivate Model
    Controller-->>View: Coche encontrado
    deactivate Controller
    View-->>usuario: Los datos de tu coche!
    deactivate View
```

El mismo diagrama con los nombres de los métodos y ahora la parte de la Arquitectura de la vista son tres clases

```mermaid
sequenceDiagram
    actor usuario
    
        participant InterfazGrafica
        participant Dialogo
        participant View
    
    participant Controller
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
    InterfazGrafica-->Controller: subirVelocidad(matricula, velocidad)
    activate Controller
    Controller->>Model: subirVelocidad(matricula, velocidad)
    activate Model
    Model-->>Controller: Velocidad aumentada
    deactivate Model
    Controller-->>+View: muestraVelocidad(matricula, velocidad)
    deactivate Controller
    View-->>-Dialogo: muestraVelocidad(matricula, velocidad)
    
    usuario-->>InterfazGrafica: clik! Para reducir velocidad
    InterfazGrafica-->Controller: bajarVelocidad(matricula, velocidad)
    activate Controller
    Controller->>Model: bajarVelocidad(matricula, velocidad)
    activate Model
    Model-->>Controller: Velocidad reducida
    deactivate Model
    Controller-->>+View: muestraVelocidad(matricula, velocidad)
    deactivate Controller
    View-->>-Dialogo: muestraVelocidad(matricula, velocidad)
    
    usuario-->>InterfazGrafica: Introduce matrícula! clik en BUSCAR!
    InterfazGrafica-->Controller: buscarCoche(matricula)
    activate Controller
    Controller->>Model: getCoche(matricula)
    activate Model
    Model-->>Controller: Coche encontrado
    deactivate Model
    Controller-->>+View: muestraCoche(matricula, modelo, velocidad)
    deactivate Controller
    View-->>-Dialogo: muestraCoche(matricula, modelo, velocidad)
```