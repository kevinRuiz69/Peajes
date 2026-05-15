package co.edu.uniquindio.co.poo.model;


public class Moto extends Vehiculo {

    //ATRIBUTOS

    private double cilindraje;

    //CONSTRUCTOR


    public Moto(String placa, int numeroPeajes, PeajesQuindio peajesQuindio, Carro carro, Moto moto, Camion camion, Conductor conductor, double cilindraje) {
        super(placa, numeroPeajes, peajesQuindio, carro, moto, camion, conductor);
        this.cilindraje = cilindraje;
    }

    //SETTERS AND GETTERS


    public double getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(double cilindraje) {
        this.cilindraje = cilindraje;
    }

    //METODO TOSTRING


    @Override
    public String toString() {
        return "Moto{" +
                "cilindraje=" + cilindraje +
                ", placa='" + placa + '\'' +
                ", numeroPeajes=" + numeroPeajes +
                '}';
    }

    @Override
    public double calcularPeaje() {
        double total = 5000;

        if (cilindraje > 200) {

            total += 2000;
        }

        return total;
    }
}
