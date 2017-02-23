package algoritmogenetico;

import java.util.ArrayList;

public class AlgoritmoGenetico {

    public static void main(String[] args) {
        
        Carretera.setCarretera(Carretera.iniciliazar());
        CeldaEntrada.reset();
        CeldaSalida.reset();
        
        ArrayList <Integer> semaforo = new ArrayList <>();

        Semaforos.setSemaforo1(semaforo);
        Semaforos.setSemaforo2(semaforo);
        Semaforos.setSemaforo3(semaforo);
        Semaforos.setSemaforo4(semaforo);
        
        Ejecuta.ejecuta();
        
    }
}