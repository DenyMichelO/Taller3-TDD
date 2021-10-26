package bo.edu.ucb.Taller3.TDD;

public class Elevador {

    private final int LIMITE = 1;
    private final Character[] piso = {'0', '0', '0',};

    public String controlarElevador(int pisoActualElevador, int pisoActualPersona, int limitePersonas, int pisoDestino, String estadoPuerta) throws Exception {
        capacidad(limitePersonas);
        verificarFueraDeRangoDePisos(pisoDestino);
        verificarComienzoDia(pisoActualElevador,estadoPuerta);
        crearPersona(pisoActualPersona);
        return callElevador(pisoActualPersona,pisoDestino);


    }

    private void crearPersona(int pisoActualPersona) {
        for(int i = 1; i<= piso.length; i++){
            if(i==pisoActualPersona){
                piso[i-1] = '1';
            }
        }
    }
    private String callElevador(int pisoActualPersona,int pisoDestino){
        if(pisoActualPersona==pisoDestino){
            return "No se puede ir al destino";
        }
        return "Se puede ir al destino";

    }

    private void verificarFueraDeRangoDePisos(int destino) throws Exception {
        if (destino>3) {
            throw new Exception(" esta fuera del rango de pisos");
        }
    }
    private void capacidad(int destino) throws Exception {
        if (destino>=2) {
            throw new Exception(" esta fuera del rango de personas permitido");
        }
    }
    private void verificarComienzoDia(int pisoElevador, String estadoPuerta) throws Exception {
        if (pisoElevador!=1 && estadoPuerta.equals("Abierto")) {
            throw new Exception(" esta fuera del rango de personas permitido");
        }
    }
}



