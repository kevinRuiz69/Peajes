package co.edu.uniquindio.co.poo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Vehiculo {

    // ATRIBUTOS

    protected String placa;
    protected int numeroPeajes;

    //RELACIONES

    private PeajesQuindio peajesQuindio;
    private Carro carro;
    private Moto moto;
    private Camion camion;
    private Conductor conductor;
    private ArrayList <RegistroPeaje> ListaRegistrosPeaje;

    //CONSTRUCTOR


    public Vehiculo(String placa, int numeroPeajes, PeajesQuindio peajesQuindio, Carro carro, Moto moto, Camion camion, Conductor conductor) {
        this.placa = placa;
        this.numeroPeajes = numeroPeajes;
        this.peajesQuindio = peajesQuindio;
        this.carro = carro;
        this.moto = moto;
        this.camion = camion;
        this.conductor = conductor;
        this.ListaRegistrosPeaje = new ArrayList<>();
    }

    public Vehiculo() {

    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getNumeroPeajes() {
        return numeroPeajes;
    }

    public void setNumeroPeajes(int numeroPeajes) {
        this.numeroPeajes = numeroPeajes;
    }

    public PeajesQuindio getPeajesQuindio() {
        return peajesQuindio;
    }

    public void setPeajesQuindio(PeajesQuindio peajesQuindio) {
        this.peajesQuindio = peajesQuindio;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public ArrayList<RegistroPeaje> getListaRegistrosPeaje() {
        return ListaRegistrosPeaje;
    }

    public void setListaRegistrosPeaje(ArrayList<RegistroPeaje> listaRegistrosPeaje) {
        ListaRegistrosPeaje = listaRegistrosPeaje;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", numeroPeajes=" + numeroPeajes +
                ", peajesQuindio=" + peajesQuindio +
                ", carro=" + carro +
                ", moto=" + moto +
                ", camion=" + camion +
                ", conductor=" + conductor +
                ", ListaRegistrosPeaje=" + ListaRegistrosPeaje +
                '}';
    }

    //METODO ABSTRACTO

    public abstract double calcularPeaje();

    //METODO DE PAGAR PEAJE

    public RegistroPeaje realizarPagoPeaje(iCobrador cobrador) {

        double valor = calcularPeaje();

        numeroPeajes++;

        Estacion estacion = null;
        Recaudador recaudador = null;

        if (cobrador instanceof Estacion) {

            estacion = (Estacion) cobrador;

        } else if (cobrador instanceof Recaudador) {

            recaudador = (Recaudador) cobrador;
        }

        RegistroPeaje registro = new RegistroPeaje(
                valor,
                LocalDate.now(),
                LocalTime.now(),
                estacion,
                recaudador,
                this
        );

        return registro;
    }
}

