/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaN3;

/**
 *
 * @author porto
 */
import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Planilla implements calcularAguinaldo {

    private final ArrayList<Empleados> empleadosEnPlanilla = new ArrayList<>();

    public void agregarEmpleado(Empleados empleado) {
        empleadosEnPlanilla.add(empleado);
        System.out.println("Empleado agregado a la planilla: " + empleado.getCedula());

    }

    public void mostrarEmpleados() {
        for (Empleados emp : empleadosEnPlanilla) {
            emp.mostrarEmpleado();
            System.out.println("------------------");
        }
    }

    public void eliminarEmpleado(String cedula) {
        empleadosEnPlanilla.removeIf(v -> v.getCedula().equals(cedula));
    }

    public ArrayList<Empleados> getEmpleados() {
        return empleadosEnPlanilla;
    }

    public boolean buscarEmpleado(String cedula) {
        for (Empleados emp : empleadosEnPlanilla) {
            if (String.valueOf(emp.getCedula()).equals(cedula)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double calculoDeAguinaldo(String cedula) {
        for (Empleados emp : empleadosEnPlanilla) {
            if (String.valueOf(emp.getCedula()).equals(cedula)) {
                LocalDate ingreso = emp.getFecheDeIngreso();
                LocalDate hoy = LocalDate.now();

                long mesesTrabajados = ChronoUnit.MONTHS.between(ingreso, hoy);

                //Por si a trabajado mas de 12 meses
                if (mesesTrabajados > 12) {
                    mesesTrabajados = 12;
                }

                double aguinaldo = (emp.getSalario() * mesesTrabajados) / 12;
                return aguinaldo;
            }
        }
        return 0;
    }

    public void guardarEnArchivo(String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(empleadosEnPlanilla);
            System.out.println("Empleados serializados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarDesdeArchivo(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            ArrayList<Empleados> cargados = (ArrayList<Empleados>) ois.readObject();
            empleadosEnPlanilla.clear();
            empleadosEnPlanilla.addAll(cargados);
            System.out.println("Empleados deserializados correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
