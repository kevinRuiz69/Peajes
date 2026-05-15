package co.edu.uniquindio.co.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Recaudador implements iCobrador{

    //ATRIBUTOS

    private String nombre;
    private String apellidos;
    private String documento;
    private LocalDate fechaNacimiento;
    private double sueldoMensual;

    //RELACIONES

    private PeajesQuindio peajesQuindio;
    private ArrayList <RegistroPeaje> ListaRegistrosPeajes;

    //CONSTRUCTOR

    public Recaudador(String nombre, String apellidos, String documento, LocalDate fechaNacimiento, double sueldoMensual, PeajesQuindio peajesQuindio) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldoMensual = sueldoMensual;
        this.peajesQuindio = peajesQuindio;
        this.ListaRegistrosPeajes = new ArrayList<>();
    }


    //SETTERS Y GETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    public PeajesQuindio getPeajesQuindio() {
        return peajesQuindio;
    }

    public void setPeajesQuindio(PeajesQuindio peajesQuindio) {
        this.peajesQuindio = peajesQuindio;
    }

    public ArrayList<RegistroPeaje> getListaRegistrosPeajes() {
        return ListaRegistrosPeajes;
    }

    public void setListaRegistrosPeajes(ArrayList<RegistroPeaje> listaRegistrosPeajes) {
        ListaRegistrosPeajes = listaRegistrosPeajes;
    }


    //METODO TOSTRING


    @Override
    public String toString() {
        return "Recaudor{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", documento='" + documento + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", sueldoMensual=" + sueldoMensual +
                ", peajesQuindio=" + peajesQuindio +
                ", ListaRegistrosPeajes=" + ListaRegistrosPeajes +
                '}';
    }

    @Override
    public RegistroPeaje cobrarPeaje(Vehiculo vehiculo) {
        RegistroPeaje registro =
                vehiculo.realizarPagoPeaje(this);

        registrarCobro(registro);

        return registro;
    }

    @Override
    public void registrarCobro(RegistroPeaje registro) {
        ListaRegistrosPeajes.add(registro);
    }
}
