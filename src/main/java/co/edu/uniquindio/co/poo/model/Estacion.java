package co.edu.uniquindio.co.poo.model;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Estacion implements iCobrador{

    //ATRIBUTOS

    private String nombre;
    private String departamentoUbi;
    private double valoNumerico;
    private double totalPeajes;

    //RELACIONES

    private ArrayList <RegistroPeaje> ListaRegistrosPeaje;

    //CONSTRUCTOR


    public Estacion(String nombre, String departamentoUbi, double valoNumerico, double totalPeajes) {
        this.nombre = nombre;
        this.departamentoUbi = departamentoUbi;
        this.valoNumerico = valoNumerico;
        this.totalPeajes = totalPeajes;
        this.ListaRegistrosPeaje = new ArrayList<>();
    }

    public Estacion(String peajeArmenia, String quindio) {
    }

    //SETTERS AND GETTERS


    public double getTotalPeajes() {
        return totalPeajes;
    }

    public void setTotalPeajes(double totalPeaje) {
        this.totalPeajes = totalPeaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamentoUbi() {
        return departamentoUbi;
    }

    public void setDepartamentoUbi(String departamentoUbi) {
        this.departamentoUbi = departamentoUbi;
    }

    public double getValoNumerico() {
        return valoNumerico;
    }

    public void setValoNumerico(double valoNumerico) {
        this.valoNumerico = valoNumerico;
    }

    public ArrayList<RegistroPeaje> getListaRegistrosPeaje() {
        return ListaRegistrosPeaje;
    }

    public void setListaRegistrosPeaje(ArrayList<RegistroPeaje> listaRegistrosPeaje) {
        ListaRegistrosPeaje = listaRegistrosPeaje;
    }

    //METODO TOSTRING

    @Override
    public String toString() {
        return "Estacion{" +
                "nombre='" + nombre + '\'' +
                ", departamentoUbi='" + departamentoUbi + '\'' +
                ", valoNumerico=" + valoNumerico +
                ", totalPeajes=" + totalPeajes +
                ", ListaRegistrosPeaje=" + ListaRegistrosPeaje +
                '}';
    }


    //CRUD DE REGISTRO PEAJE (SOLO CREATE Y UPDATE AL SER UN RECORD)

    public String agregarRegistroPeaje(double valorCobrado, LocalDate fechaCobro, LocalTime horaCobro, Estacion estacion, Recaudador recaudador, Vehiculo vehiculo) {

        String resultado = "";

        RegistroPeaje registroEncontrado = buscarRegistroPeaje(fechaCobro);

        if (registroEncontrado != null) {

            resultado = "El registro de peaje que desea registrar ya existe";
        } else {

            RegistroPeaje registroPeaje1 = new RegistroPeaje (valorCobrado, fechaCobro, horaCobro, null, null, null);
            resultado = "El registro de peaje fue registrado exitosamente";
        }
        return resultado;
    }

    public RegistroPeaje buscarRegistroPeaje(LocalDate fechaCobro) {

        for (RegistroPeaje registro : ListaRegistrosPeaje) {
            if (registro.fechaCobro().equals(fechaCobro)) {
                return registro;
            }
        }
        return null;
    }

    //METODO DE CALCULAR PEAJE VEHICULO

    public double calcularPeajeVehiculo(Vehiculo vehiculo) {

        return vehiculo.calcularPeaje();
    }

    //METODO PARA EL TOTAL DE PEAJES

    public void registrarTotalPeajes(double valorCobrado) {

        totalPeajes += valorCobrado;
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
        ListaRegistrosPeaje.add(registro);

        registrarTotalPeajes(registro.valorCobrado());
    }
}

