package algoritmogenetico;

import java.util.ArrayList;

public class OrdenaFitness {

    public static void ordenar(ArrayList<Double> fitness) {
        int salto, i;
        double aux;
        ArrayList<Integer> arrayAux = new ArrayList<>();
        boolean cambios;
        for (salto = fitness.size() / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) { // Mientras se intercambie algún elemento
                cambios = false;
                for (i = salto; i < fitness.size(); i++) // se da una pasada
                {
                    if (fitness.get(i - salto) < fitness.get(i)) { // y si están desordenados
                        aux = fitness.get(i); // se reordenan
                        fitness.remove(i);
                        fitness.add(i, fitness.get(i - salto));
                        fitness.remove(i - salto);
                        fitness.add(i - salto, aux);
                        cambios = true; // y se marca como cambio.
                    }
                }
            }
        }
    }
}
