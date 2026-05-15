import co.edu.uniquindio.co.poo.model.Camion;
import co.edu.uniquindio.co.poo.model.Carro;
import co.edu.uniquindio.co.poo.model.Moto;
import co.edu.uniquindio.co.poo.model.TipoCarro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehiculoTest {

    @Test
    public void calcularPeajeVehiculosTest() {

        // CARRO ELECTRICO
        Carro carro = new Carro(
                "ABC123",
                0,
                "Mazda",
                TipoCarro.ELECTRICO
        );

        double resultadoCarro = carro.calcularPeaje();

        assertEquals(8000, resultadoCarro);

        // MOTO MAYOR A 200CC
        Moto moto = new Moto(
                "XYZ999",
                0,
                250
        );

        double resultadoMoto = moto.calcularPeaje();

        assertEquals(7000, resultadoMoto);

        // CAMION CON CARGA MAYOR A 10
        Camion camion = new Camion(
                "TRK777",
                0,
                4,
                15
        );

        double resultadoCamion = camion.calcularPeaje();

        assertEquals(30800, resultadoCamion);
    }
}
