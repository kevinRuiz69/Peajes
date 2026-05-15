package co.edu.uniquindio.co.poo.model;

public class Carro extends Vehiculo {

    //ATRIBUTOS

    private String modelo;
    private TipoCarro tipoCarro;

    //CONSTRUCTOR

    public Carro(String placa, int numeroPeajes, PeajesQuindio peajesQuindio, Carro carro, Moto moto, Camion camion, Conductor conductor, String modelo, TipoCarro tipoCarro) {
        super(placa, numeroPeajes, peajesQuindio, carro, moto, camion, conductor);
        this.modelo = modelo;
        this.tipoCarro = tipoCarro;
    }

    public Carro(String placa, int numeroPeajes, String modelo, TipoCarro tipoCarro) {
        this(placa, numeroPeajes, null, null, null, null, null, modelo, tipoCarro);
    }

    //SETTTERS Y GETTERS

    public TipoCarro getTipoCarro() {
        return tipoCarro;
    }

    public void setTipoCarro(TipoCarro tipoCarro) {
        this.tipoCarro = tipoCarro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    //METODO TOSTRING

    @Override
    public String toString() {
        return "Carro{" +
                "modelo='" + modelo + '\'' +
                ", tipoCarro=" + tipoCarro +
                ", placa='" + placa + '\'' +
                ", numeroPeajes=" + numeroPeajes +
                '}';
    }

    @Override
    public double calcularPeaje() {
        double total = 10000;

        if (tipoCarro == TipoCarro.ELECTRICO) {
            total = total - (total * 0.20);
        } else if (tipoCarro == TipoCarro.SERVICIO_PUBLICO) {
            total = total + (total * 0.15);
        }

        return total;
    }
}
