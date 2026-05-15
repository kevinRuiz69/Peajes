package co.edu.uniquindio.co.poo.model;


import java.time.LocalDate;
import java.util.ArrayList;

public class PeajesQuindio {

    //ATRIBUTOS

    private String codigo;

    //RELACIONES

    private ArrayList<Vehiculo> ListaVehiculos;
    private ArrayList<iCobrador> ListaCobradores;
    private ArrayList<Recaudador> listaRecaudores;
    private ArrayList<Conductor> ListaConductores;

    //CONSTRUCTOR


    public PeajesQuindio(String codigo) {
        this.codigo = codigo;
        this.ListaCobradores = new ArrayList<>();
        this.listaRecaudores = new ArrayList<>();
        this.ListaVehiculos = new ArrayList<>();
        this.ListaConductores = new ArrayList<>();
    }

    //SETTERS Y GETTERS


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return ListaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        ListaVehiculos = listaVehiculos;
    }

    public ArrayList<iCobrador> getListaCobradores() {
        return ListaCobradores;
    }

    public void setListaCobradores(ArrayList<iCobrador> listaCobradores) {
        ListaCobradores = listaCobradores;
    }

    public ArrayList<Recaudador> getListaRecaudores() {
        return listaRecaudores;
    }

    public void setListaRecaudores(ArrayList<Recaudador> listaRecaudores) {
        this.listaRecaudores = listaRecaudores;
    }

    public ArrayList<Conductor> getListaConductores() {
        return ListaConductores;
    }

    public void setListaConductores(ArrayList<Conductor> listaConductores) {
        ListaConductores = listaConductores;
    }

    //METODO TOSTRING


    @Override
    public String toString() {
        return "PeajesQuindio{" +
                "codigo='" + codigo + '\'' +
                ", ListaVehiculos=" + ListaVehiculos +
                ", ListaCobradores=" + ListaCobradores +
                ", ListaRecaudores=" + listaRecaudores +
                ", ListaConductores=" + ListaConductores +
                '}';
    }


    //CRUD DE COBRADOR

    public String agregarCobrador(iCobrador cobrador) {

        String resultado = "";

        if (ListaCobradores.contains(cobrador)) {

            resultado = "Ya existe el cobrador";

        } else {

            ListaCobradores.add(cobrador);

            resultado = "El cobrador fue registrado exitosamente";
        }

        return resultado;
    }

    //CRUD DE RECAUDOR

    public String agregarRecaudor(String nombre, String apellidos, String documento, LocalDate fechaNacimiento, double sueldoMensual, PeajesQuindio peajesQuindio) {

        String resultado = "";

        Recaudador recaudadorEncontrado = buscarRecaudor(documento);

        if (recaudadorEncontrado != null) {
            resultado = "Ya existe este recaudor";

        } else {

            Recaudador recaudador = new Recaudador(nombre, apellidos, documento, fechaNacimiento, sueldoMensual, null);
            resultado = "El recaudor ha sido registrado exitosamente";
        }
        return resultado;
    }

    public Recaudador buscarRecaudor(String documento) {

        for (Recaudador recaudador : listaRecaudores) {
            if (recaudador.getDocumento().equals(documento)) {
                return recaudador;
            }
        }
        return null;
    }

    public String actualizarRecaudor(String nombre, String apellidos, String documento, LocalDate fechaNacimiento, double sueldoMensual, PeajesQuindio peajesQuindio) {

        String resultado = "";

        Recaudador recaudadorEncontrado = buscarRecaudor(documento);

        if (recaudadorEncontrado == null) {
            resultado = "No existe el recaudor al que quieres actualizar";
        } else {

            recaudadorEncontrado.setNombre(nombre);
            recaudadorEncontrado.setApellidos(apellidos);
            recaudadorEncontrado.setDocumento(documento);

            resultado = "El recaudor fue actualizado exitosamente";
        }
        return resultado;
    }

    public String eliminarRecaudor(String documento) {

        String resultado = "";

        Recaudador recaudadorEncontrado = buscarRecaudor(documento);

        if (recaudadorEncontrado != null) {
            getListaRecaudores().remove(recaudadorEncontrado);
            resultado = "Recaudor eliminado";
        } else {

            resultado = "El recaudor que desea eliminar no existe";
        }

        return resultado;
    }

    //CRUD DE CONDUCTOR (SOLO CREATE Y UPDATE AL SER RECORD)

    public String agregarConductor(String nombre, String apellidos, LocalDate fechaNacimiento, String documento, PeajesQuindio peajesQuindio, ArrayList<Vehiculo> ListaVehiculos) {

        String resultado = "";

        Conductor conductorEncontrado = buscarConductor(nombre);

        if (conductorEncontrado != null) {

            resultado = "El conductor que desea registrar ya existe";
        } else {

            Conductor conductor = new Conductor(nombre, apellidos, fechaNacimiento, documento, null, ListaVehiculos);
            resultado = "El conductor fue registrado exitosamente";
        }
        return resultado;
    }

    public Conductor buscarConductor(String nombre) {

        for (Conductor conductor : ListaConductores) {
            if (conductor.nombre().equals(nombre)) {
                return conductor;
            }
        }
        return null;
    }

    //CRUD DE VEHICULO

    public String agregarVehiculo(Vehiculo vehiculo) {

        String resultado = "";

        Vehiculo vehiculoEncontrado =
                buscarVehiculo(vehiculo.getPlaca());

        if (vehiculoEncontrado != null) {

            resultado = "El vehículo ya existe";

        } else {

            ListaVehiculos.add(vehiculo);

            resultado = "Vehículo registrado correctamente";
        }

        return resultado;
    }

    public Vehiculo buscarVehiculo(String placa) {

        for (Vehiculo vehiculo : ListaVehiculos){

            if (vehiculo.getPlaca().equals(placa)){
                return vehiculo;
            }
        }
        return null;
    }

    public String actualizarVehiculo (String placa, int numeroPeajes, PeajesQuindio peajesQuindio, Conductor conductor){

        String resultado= "";

        Vehiculo vehiculoEncontrado = buscarVehiculo(placa);

        if (vehiculoEncontrado == null) {
            resultado = "No existe el recaudor al que quieres actualizar";
        } else {

            vehiculoEncontrado.setPlaca(placa);
            vehiculoEncontrado.setNumeroPeajes(numeroPeajes);
            vehiculoEncontrado.setConductor(conductor);

            resultado = "El recaudor fue actualizado exitosamente";
        }
        return resultado;
    }

    public String eliminarVehiculo(String placa) {

        String resultado = "";

        Vehiculo vehiculoEncontrado = buscarVehiculo(placa);

        if (vehiculoEncontrado != null) {
            getListaVehiculos().remove(vehiculoEncontrado);
            resultado = "Vehiculo eliminado";
        } else {

            resultado = "El Vehiculo que desea eliminar no existe";
        }

        return resultado;
    }

    public ArrayList<Camion> obtenerCamionesFiltrados() {

        ArrayList<Camion> camionesFiltrados = new ArrayList<>();

        for (Vehiculo vehiculo : ListaVehiculos) {

            if (vehiculo instanceof Camion) {

                Camion camion = (Camion) vehiculo;

                if (camion.getCarga() > 10 &&
                        camion.getNumeroPeajes() > 5) {

                    camionesFiltrados.add(camion);
                }
            }
        }

        return camionesFiltrados;
    }
}



