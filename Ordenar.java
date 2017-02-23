package algoritmogenetico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Ordenar {

    public static void ordenar(ArrayList<ArrayList<Integer>> pobSemaforo, ArrayList<Double> fitness) {
        ArrayList<Double> fitnessCopia = (ArrayList<Double>) fitness.clone();
        int salto, i;
        double aux;
        ArrayList<Integer> arrayAux = new ArrayList<>();
        boolean cambios;
        for (salto = fitnessCopia.size() / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) { // Mientras se intercambie algún elemento
                cambios = false;
                for (i = salto; i < fitnessCopia.size(); i++) // se da una pasada
                {
                    if (fitnessCopia.get(i-salto) < fitnessCopia.get(i)) { // y si están desordenados
                        aux = fitnessCopia.get(i); // se reordenan
                        arrayAux = pobSemaforo.get(i);
                        fitnessCopia.remove(i);
                        pobSemaforo.remove(i);
                        fitnessCopia.add(i, fitnessCopia.get(i-salto));
                        pobSemaforo.add(i, pobSemaforo.get(i-salto));
                        fitnessCopia.remove(i-salto);
                        pobSemaforo.remove(i-salto);
                        fitnessCopia.add(i-salto, aux);
                        pobSemaforo.add(i-salto,arrayAux);
                        cambios = true; // y se marca como cambio.
                    }
                }
            }
        }
    }

}
