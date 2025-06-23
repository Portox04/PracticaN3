/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaN3;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author porto
 */
public class Empleados implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String cedula;
    private String puesto;
    private String departamento;
    private double salario;
    private LocalDate fecheDeIngreso;

    public Empleados(String nombre, String cedula, String puesto, String departamento, double salario, LocalDate fecheDeIngreso) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.puesto = puesto;
        this.departamento = departamento;
        this.salario = salario;
        this.fecheDeIngreso = fecheDeIngreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getFecheDeIngreso() {
        return fecheDeIngreso;
    }

    public void setFecheDeIngreso(LocalDate fecheDeIngreso) {
        this.fecheDeIngreso = fecheDeIngreso;
    }

    public void mostrarEmpleado() {
        System.out.println("Empleado");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Cedula: " + getCedula());
        System.out.println("Puesto: " + getPuesto());
        System.out.println("Departamento" + getDepartamento());
        System.out.println("Salario: " + getSalario());
    }


}
