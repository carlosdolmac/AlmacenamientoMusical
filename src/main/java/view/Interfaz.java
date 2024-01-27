/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import controller.LoginController;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * La clase 'Interfaz' representa el marco principal de la aplicación.
 * Controla la visualización de diferentes paneles y el inicio de sesión.
 *
 * Autor: Carlos de los Dolores Macías
 */
public class Interfaz extends javax.swing.JFrame {
    private static Interfaz instancia;

    public Interfaz() {
        initComponents();
        setLocationRelativeTo(null); // Establece la ubicación de la ventana en el centro de la pantalla
        LoginController loginController = new LoginController(this);
        loginController.mostrarLogin(); // Muestra el panel de inicio de sesión al iniciar la aplicación
    }
    
    // Método para obtener la instancia única de la clase Interfaz
    public static Interfaz getInstance() {
        if (instancia == null) {
            instancia = new Interfaz();
        }
        return instancia;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ponerPaneles = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout ponerPanelesLayout = new javax.swing.GroupLayout(ponerPaneles);
        ponerPaneles.setLayout(ponerPanelesLayout);
        ponerPanelesLayout.setHorizontalGroup(
            ponerPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        ponerPanelesLayout.setVerticalGroup(
            ponerPanelesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ponerPaneles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ponerPaneles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatLightFlatIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ponerPaneles;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Método para mostrar los paneles.
     * @param p este argumento es el panel que se quiera mostrar
     */
    public void mostrarPanel(JPanel p) {
        ponerPaneles.removeAll(); // Elimina todos los componentes hijos del panel para que no haya nada al mostrar el panel que se quiere
        ponerPaneles.setLayout(new BorderLayout()); // Establece el BorderLayout para que el panel se expanda

        ponerPaneles.add(p, BorderLayout.CENTER); // Agrega el panel al centro para que se ajuste al tamaño del contenedor

        ponerPaneles.revalidate(); // Obliga al panel a recalcular su diseño
        ponerPaneles.repaint(); // Solicita al panel que repinte sus componentes
    }
    
    /**
     * Método para mostrar el panel de dashboard después del inicio de sesión.
     * @param idUsuario El ID del usuario que ha iniciado sesión.
     */
    public void mostrarDashboard(int idUsuario) {
        Principal dashboard = new Principal(idUsuario);
        mostrarPanel(dashboard);
    }
}
