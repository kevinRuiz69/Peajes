package co.edu.uniquindio.co.poo.model;

import java.time.LocalDate;
import java.time.LocalTime;

public record RegistroPeaje(double valorCobrado, LocalDate fechaCobro, LocalTime horaCobro, Estacion estacion, Recaudador recaudador, Vehiculo vehiculo) {
}
