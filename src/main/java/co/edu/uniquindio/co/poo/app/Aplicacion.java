package co.edu.uniquindio.co.poo.app;


import co.edu.uniquindio.co.poo.model.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Aplicacion {
    static void main() {
        PeajesQuindio sistema = new PeajesQuindio("123");

        Estacion estacion = new Estacion(
                "Peaje Armenia",
                "Quindio"
        );

        Recaudador recaudador = new Recaudador(
                "Carlos",
                "Ramirez",
                "123",
                LocalDate.of(1990, 5, 10),
                2500000, null
        );

        int opcion;

        do {

            String menu = """
                    
                    ===== PEAJES QUINDIO =====
                    
                    1. Agregar carro
                    2. Agregar moto
                    3. Agregar camion
                    4. Cobrar peaje
                    5. Mostrar camiones filtrados
                    0. Salir
                    """;

            opcion = Integer.parseInt(
                    JOptionPane.showInputDialog(menu)
            );

            switch (opcion) {

                case 1 -> {

                    String placa = JOptionPane.showInputDialog(
                            "Ingrese la placa:"
                    );

                    String modelo = JOptionPane.showInputDialog(
                            "Ingrese el modelo:"
                    );

                    int tipo = Integer.parseInt(
                            JOptionPane.showInputDialog("""
                                    
                                    Tipo de carro:
                                    1. ELECTRICO
                                    2. SERVICIO_PUBLICO
                                    """)
                    );

                    TipoCarro tipoCarro;

                    if (tipo == 1) {
                        tipoCarro = TipoCarro.ELECTRICO;
                    } else {
                        tipoCarro = TipoCarro.SERVICIO_PUBLICO;
                    }

                    Carro carro = new Carro(
                            placa,
                            0, modelo,
                            tipoCarro
                    );

                    JOptionPane.showMessageDialog(
                            null,
                            sistema.agregarVehiculo(carro)
                    );
                }

                case 2 -> {

                    String placa = JOptionPane.showInputDialog(
                            "Ingrese la placa:"
                    );

                    double cilindraje = Double.parseDouble(
                            JOptionPane.showInputDialog(
                                    "Ingrese el cilindraje:"
                            )
                    );

                    Moto moto = new Moto(
                            placa,
                            0,
                            cilindraje
                    );

                    JOptionPane.showMessageDialog(
                            null,
                            sistema.agregarVehiculo(moto)
                    );
                }

                case 3 -> {

                    String placa = JOptionPane.showInputDialog(
                            "Ingrese la placa:"
                    );

                    double ejes = Double.parseDouble(
                            JOptionPane.showInputDialog(
                                    "Ingrese cantidad de ejes:"
                            )
                    );

                    double carga = Double.parseDouble(
                            JOptionPane.showInputDialog(
                                    "Ingrese carga en toneladas:"
                            )
                    );

                    Camion camion = new Camion(
                            placa,
                            0,
                            ejes,
                            carga
                    );

                    JOptionPane.showMessageDialog(
                            null,
                            sistema.agregarVehiculo(camion)
                    );
                }

                case 4 -> {

                    String placa = JOptionPane.showInputDialog(
                            "Ingrese la placa:"
                    );

                    Vehiculo vehiculo =
                            sistema.buscarVehiculo(placa);

                    if (vehiculo != null) {

                        RegistroPeaje registro =
                                estacion.cobrarPeaje(vehiculo);

                        JOptionPane.showMessageDialog(
                                null,
                                "Peaje cobrado correctamente\n" +
                                        "Valor: $" +
                                        registro.valorCobrado()
                        );

                    } else {

                        JOptionPane.showMessageDialog(
                                null,
                                "Vehiculo no encontrado"
                        );
                    }
                }

                case 5 -> {

                    ArrayList<Camion> lista =
                            sistema.obtenerCamionesFiltrados();

                    String mensaje = "CAMIONES FILTRADOS\n\n";

                    for (Camion camion : lista) {

                        mensaje +=
                                "Placa: " +
                                        camion.getPlaca() +
                                        "\nCarga: " +
                                        camion.getCarga() +
                                        "\nPeajes pagados: " +
                                        camion.getNumeroPeajes() +
                                        "\n\n";
                    }

                    JOptionPane.showMessageDialog(
                            null,
                            mensaje
                    );
                }

                case 0 -> JOptionPane.showMessageDialog(
                        null,
                        "Saliendo..."
                );

                default -> JOptionPane.showMessageDialog(
                        null,
                        "Opcion invalida"
                );
            }

        } while (opcion != 0);
    }
}

