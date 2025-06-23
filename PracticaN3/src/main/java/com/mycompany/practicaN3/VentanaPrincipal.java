/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaN3;

/**
 *
 * @author porto
 */
import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private final Planilla planilla;
    private final JTextArea logArea;
    private static String ARCHIVO_DATOS = "empleados.dat";

    public VentanaPrincipal() {
        super("Informacion empleados");

        planilla = new Planilla();
        logArea = new JTextArea(10, 40);
        logArea.setEditable(false);

        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        JButton btnAgregarEmpleado = new JButton("Agregar Empleado");
        JButton btnBorrarEmpleado = new JButton("Borrar Empleado");
        JButton btnMostrarEmpleado = new JButton("Mostrar Empleado");
        JButton btnCalcularAguinaldo = new JButton("Calcular Aguinaldo");
        
        JPanel archivePanel = new JPanel();
        JButton btnCargarArchivo = new JButton("Cargar Archivo");
        JButton btnGuardarArchivo = new JButton("Guardar Archivo");
        
        archivePanel.add(btnCargarArchivo);
        archivePanel.add(btnGuardarArchivo);

        controlPanel.add(btnAgregarEmpleado);
        controlPanel.add(btnBorrarEmpleado);
        controlPanel.add(btnMostrarEmpleado);
        controlPanel.add(btnCalcularAguinaldo);

        JScrollPane scrollPane = new JScrollPane(logArea);

        add(controlPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(archivePanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);

        btnAgregarEmpleado.addActionListener(e -> agregarEmpleado());
        btnMostrarEmpleado.addActionListener(e -> mostrarEmpleado());
        btnBorrarEmpleado.addActionListener(e -> borrarEmpleado());
        btnCalcularAguinaldo.addActionListener(e -> verAguinaldo());
        btnCargarArchivo.addActionListener(e -> cargarEmpleados());
        btnGuardarArchivo.addActionListener(e -> guardarEmpleados());
    }

    private void agregarEmpleado() {
        VentanaAgregarEmpleado vAddEmp = new VentanaAgregarEmpleado(this, planilla);
        vAddEmp.setVisible(true);
        logArea.append("\n==Empleado agragado==\n");
    }

    private void borrarEmpleado() {
        VentanaBorrarEmpleados vAddEmp = new VentanaBorrarEmpleados(this, planilla);
        vAddEmp.setVisible(true);
        logArea.append("\n==Empleado eliminado==\n");
    }

    private void mostrarEmpleado() {
        logArea.append("\n==Empleados en planilla==\n");
        for (Empleados empleado : planilla.getEmpleados()) {
            logArea.append(empleado.getNombre() + " - " + empleado.getPuesto() + " - " + empleado.getDepartamento());
        }
        logArea.append("=========================\n\n");
    }

    private void verAguinaldo() {
        VentanaVerAguinaldo vAddEmp = new VentanaVerAguinaldo(this, planilla);
        vAddEmp.setVisible(true);
    }

    private void cargarEmpleados() {
        planilla.cargarDesdeArchivo("empleados.dat");
        JOptionPane.showMessageDialog(this, "Empleados cargados desde archivo.");
    }

    private void guardarEmpleados() {
        planilla.guardarEnArchivo(ARCHIVO_DATOS);
        JOptionPane.showMessageDialog(this, "Empleados guardados en archivo.");
    }

}
