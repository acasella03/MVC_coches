import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazGrafica {
    private static JFrame app;
    private JPanel panel;
    private JButton bCrearCoche;
    private JTextField modelo;
    private JTextField matricula;
    private JButton aumentarVelocidad;
    private JButton bajarVelocidad;
    private JButton bBuscarCoche;

    /**
     * Constructor del entorno gráfico para el usuario
     */
    public InterfazGrafica() {
        bCrearCoche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.bCrearCoche(modelo.getText(), matricula.getText());
            }
        });
        aumentarVelocidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.bAumentarVelocidad(matricula.getText(), 10);
            }
        });
        bajarVelocidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.bReducirVelocidad(matricula.getText(), 10);
            }
        });
        bBuscarCoche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { Controller.bBuscarCoche(matricula.getText());
            }
        });
    }

    /**
     * Inicializa la IU del usuario
     */
    public static void crearVentana(){
        app = new JFrame("App MVC");
        app.setContentPane(new InterfazGrafica().panel);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.pack();
        app.setVisible(true);
    }
}


