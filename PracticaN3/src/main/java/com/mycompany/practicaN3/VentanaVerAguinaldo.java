/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaN3;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author porto
 */
public class VentanaVerAguinaldo extends JFrame {

    private JTextField txtCedula;
    private Planilla planilla;

    public VentanaVerAguinaldo(JFrame owner, Planilla planilla) {
        super("Ver Aguinaldo");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtCedula = new JTextField(15);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Cedula del Empleado que desea ver el aguinaldo"), gbc);
        gbc.gridx = 1;
        add(txtCedula, gbc);

        JPanel buttonPanel = new JPanel();
        JButton btnBuscar = new JButton("Buscar");
        JButton btnCancelar = new JButton("Cancelar");

        btnBuscar.addActionListener(e -> {
            try {
                String cedula = txtCedula.getText();
                double aguinaldo = planilla.calculoDeAguinaldo(cedula);
                if (aguinaldo > 0) {
                    JOptionPane.showMessageDialog(this,"El aguinaldo del empleado con cédula " + cedula + " es: ₡" + String.format("%.2f", aguinaldo),"Aguinaldo Calculado",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this,"No se encontró ningún empleado con esa cédula.","Empleado no encontrado",JOptionPane.WARNING_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,"Por favor ingrese un número de cédula válido.","Error en el ingreso",JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancelar.addActionListener(e -> {
            dispose();
        });
        buttonPanel.add(btnCancelar);
        buttonPanel.add(btnBuscar);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc);
        pack();

        setLocationRelativeTo(owner);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

}
