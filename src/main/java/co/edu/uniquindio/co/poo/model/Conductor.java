package co.edu.uniquindio.co.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;

public record Conductor  (String nombre, String apellidos, LocalDate fechaNacimiento, String documento, PeajesQuindio peajesQuindio, ArrayList <Vehiculo> ListaVehiculos) {
}
