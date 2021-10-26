package bo.edu.ucb.Taller3.TDD;

import org.junit.jupiter.api.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ElevadorTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void capacidad() throws Exception{

        //Preparacion de la prueba
        Elevador asc = new Elevador();

        //logica de la prueba
        asc.controlarElevador(1,1,1,3,"Abierto");
        exception.expect(Exception.class);
        asc.controlarElevador(1,1,2,3,"Abierto");
        asc.controlarElevador(1,1,3,3,"Abierto");


    }


    @Test
    public void destinoDistintoAPisoActual() throws Exception{

        //Preparacion de la prueba
        Elevador asc = new Elevador();

        //logica de la prueba
        String prueba1 = asc.controlarElevador(1,1,1,3,"Abierto");
        String prueba2 = asc.controlarElevador(1,1,1,2,"Abierto");
        String prueba3 = asc.controlarElevador(1,1,1,1,"Abierto");

        //Verificacion o Assert
        assertEquals("Se puede ir al destino", prueba1);
        assertEquals("Se puede ir al destino", prueba2);
        assertEquals("No se puede ir al destino", prueba3);

    }

    @Test
    public void verificarFueraDeRangoDePiso() throws Exception{

        //Preparacion de la prueba
        Elevador asc = new Elevador();

        //logica de la prueba
        exception.expect(Exception.class);
        asc.controlarElevador(1,1,1,5,"Abierto");

    }
    @Test
    public void verificarEmpiezoDia() throws Exception{

        //Preparacion de la prueba
        Elevador asc = new Elevador();

        //logica de la prueba
        asc.controlarElevador(1,1,1,3,"Cerrado");
        exception.expect(Exception.class);
        asc.controlarElevador(2,1,5,3,"Abierto");
        asc.controlarElevador(3,1,2,3,"Abierto");
    }


}
