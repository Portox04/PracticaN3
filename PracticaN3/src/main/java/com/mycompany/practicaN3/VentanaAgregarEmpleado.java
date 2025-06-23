/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaN3;

import java.awt.GridBagLayout;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author porto
 */
public class VentanaAgregarEmpleado extends JFrame {

    private JTextField txtNombre;
    private JTextField txtCedula;
    private JTextField txtSalario;
    private JTextField txtDepartamento;
    private JTextField txtPuesto;
    private JTextField txtFechaIngreso;

    private Planilla planilla;

    public VentanaAgregarEmpleado(JFrame owner, Planilla planilla) {

        super("Agregar Planilla");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtNombre = new JTextField(20);
        txtCedula = new JTextField(20);
        txtSalario = new JTextField(20);
        txtDepartamento = new JTextField(20);
        txtPuesto = new JTextField(20);
        txtFechaIngreso = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nombre: "), gbc);
        gbc.gridx = 1;
        add(txtNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Cedula: "), gbc);
        gbc.gridx = 1;
        add(txtCedula, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Salario: "), gbc);
        gbc.gridx = 1;
        add(txtSalario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Departamento: "), gbc);
        gbc.gridx = 1;
        add(txtDepartamento, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Puesto: "), gbc);
        gbc.gridx = 1;
        add(txtPuesto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Fecha de Ingreso: "), gbc);
        gbc.gridx = 1;
        add(txtFechaIngreso, gbc);

        JPanel buttonPanel = new JPanel();
        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");

        btnGuardar.addActionListener(e -> {
            try {

                String nombre = txtNombre.getText();
                double salario = Double.parseDouble(txtSalario.getText());
                String cedula = txtCedula.getText();
                String departamento = txtDepartamento.getText();
                String puesto = txtPuesto.getText();
                String fechaTexto = txtFechaIngreso.getText();

                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate fechaIngreso;

                try {
                    fechaIngreso = LocalDate.parse(fechaTexto, formato);
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Usa dd/MM/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Empleados nuevo = new Empleados(nombre, cedula, puesto, departamento, salario, fechaIngreso);
                planilla.agregarEmpleado(nuevo);

                dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor digitar numeros en los campos que lo requieren", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancelar.addActionListener(e -> {
            dispose();
        });
        buttonPanel.add(btnCancelar);
        buttonPanel.add(btnGuardar);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc);
        pack();

        setLocationRelativeTo(owner);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}


