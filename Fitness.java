package algoritmogenetico;

public class Fitness {

    public static double resultadoFitness(){
        return (CeldaSalida.getCochesFuera()/CeldaEntrada.getCantidadEntrada());
    }
}
