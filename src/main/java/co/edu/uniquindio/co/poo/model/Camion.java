package co.edu.uniquindio.co.poo.model;

public class Camion extends Vehiculo{

    // ATRIBUTOS

    private double carga;
    private double ejes;

    //CONSTRUCTOR


    public Camion(String placa, int numeroPeajes, PeajesQuindio peajesQuindio, Carro carro, Moto moto, Camion camion, Conductor conductor, double carga, double ejes) {
        super(placa, numeroPeajes, peajesQuindio, carro, moto, camion, conductor);
        this.carga = carga;
        this.ejes = ejes;
    }

    //SETTERS Y GETTERS


    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    public double getEjes() {
        return ejes;
    }

    public void setEjes(double ejes) {
        this.ejes = ejes;
    }

    //METODO TOSTRING


    @Override
    public String toString() {
        return "Camion{" +
                "carga=" + carga +
                ", ejes=" + ejes +
                ", placa='" + placa + '\'' +
                ", numeroPeajes=" + numeroPeajes +
                '}';
    }

    @Override
    public double calcularPeaje() {
        double total = ejes * 7000;

        if (carga > 10) {

            total += total * 0.10;
        }

        return total;
    }
}

