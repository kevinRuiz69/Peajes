import co.edu.uniquindio.co.poo.model.Camion;
import co.edu.uniquindio.co.poo.model.PeajesQuindio;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PeajesQuindioTest {

    @Test
    public void obtenerCamionesFiltradosTest() {
        PeajesQuindio sistema = new PeajesQuindio("123");

        Camion camionValido = new Camion(
                "AAA111",
                6,
                null,
                null,
                null,
                null,
                null,
                15,
                4
        );

        Camion camionConCargaMenor = new Camion(
                "BBB222",
                7,
                null,
                null,
                null,
                null,
                null,
                8,
                2
        );

        Camion camionConPocosPeajes = new Camion(
                "CCC333",
                3,
                null,
                null,
                null,
                null,
                null,
                20,
                5
        );

        sistema.agregarVehiculo(camionValido);
        sistema.agregarVehiculo(camionConCargaMenor);
        sistema.agregarVehiculo(camionConPocosPeajes);

        ArrayList<Camion> resultado = sistema.obtenerCamionesFiltrados();

        assertEquals(1, resultado.size());
        assertTrue(resultado.contains(camionValido));
        assertFalse(resultado.contains(camionConCargaMenor));
        assertFalse(resultado.contains(camionConPocosPeajes));
        assertEquals("AAA111", resultado.get(0).getPlaca());
    }
}
