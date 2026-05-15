import co.edu.uniquindio.co.poo.model.Camion;
import co.edu.uniquindio.co.poo.model.PeajesQuindio;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PeajesQuindioTest {

    @Test
    public void obtenerCamionesFiltradosTest() {

        PeajesQuindio sistema = new PeajesQuindio("123");

        Camion camion1 = new Camion(
                "AAA111",
                6,
                4,
                15
        );

        Camion camion2 = new Camion(
                "BBB222",
                7,
                2,
                8
        );

        Camion camion3 = new Camion(
                "CCC333",
                3,
                5,
                20
        );

        sistema.agregarVehiculo(camion1);
        sistema.agregarVehiculo(camion2);
        sistema.agregarVehiculo(camion3);

        ArrayList<Camion> resultado =
                sistema.obtenerCamionesFiltrados();

        assertEquals(1, resultado.size());

        assertEquals("AAA111",
                resultado.get(0).getPlaca());
    }
}
