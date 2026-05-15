package co.edu.uniquindio.co.poo.model;

public interface iCobrador {

    public RegistroPeaje cobrarPeaje(Vehiculo vehiculo);

    public void registrarCobro(RegistroPeaje registro);
}
