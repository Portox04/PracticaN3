/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaN3;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author porto
 */
public class VentanaBorrarEmpleados extends JFrame {

    private JTextField txtCedula;
    private Planilla planilla;

    public VentanaBorrarEmpleados(JFrame owner, Planilla planilla) {
        super("Eliminar Empleados");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtCedula = new JTextField(15);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Cedula del Empleado que desea elimiar"), gbc);
        gbc.gridx = 1;
        add(txtCedula, gbc);

        JPanel buttonPanel = new JPanel();
        JButton btnBorrar = new JButton("Borrar");
        JButton btnCancelar = new JButton("Cancelar");

        btnBorrar.addActionListener(e -> {
            try {
                String cedula = txtCedula.getText();

                if (!planilla.buscarEmpleado(cedula)) {
                    throw new Exception("Empleado no encontrado con cédula: " + cedula);
                }

                planilla.eliminarEmpleado(cedula);
                JOptionPane.showMessageDialog(this, "Empleado eliminado correctamente.");

                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancelar.addActionListener(e -> {
            dispose();
        });
        buttonPanel.add(btnCancelar);
        buttonPanel.add(btnBorrar);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc);
        pack();

        setLocationRelativeTo(owner);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
