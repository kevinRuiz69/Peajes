import co.edu.uniquindio.co.poo.model.Camion;
import co.edu.uniquindio.co.poo.model.Carro;
import co.edu.uniquindio.co.poo.model.Moto;
import co.edu.uniquindio.co.poo.model.TipoCarro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehiculoTest {

    @Test
    public void calcularPeajeCarroElectricoTest() {
        Carro carro = new Carro(
                "ABC123",
                0,
                null,
                null,
                null,
                null,
                null,
                "Mazda",
                TipoCarro.ELECTRICO
        );

        double resultado = carro.calcularPeaje();

        assertEquals(8000, resultado, 0.01);
    }

    @Test
    public void calcularPeajeMotoMayorA200CcTest() {
        Moto moto = new Moto(
                "XYZ999",
                0,
                null,
                null,
                null,
                null,
                null,
                250
        );

        double resultado = moto.calcularPeaje();

        assertEquals(7000, resultado, 0.01);
    }

    @Test
    public void calcularPeajeCamionConCargaMayorA10Test() {
        Camion camion = new Camion(
                "TRK777",
                0,
                null,
                null,
                null,
                null,
                null,
                15,
                4
        );

        double resultado = camion.calcularPeaje();

        assertEquals(30800, resultado, 0.01);
    }
}
