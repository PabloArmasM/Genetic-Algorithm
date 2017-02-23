package algoritmogenetico;

import java.util.ArrayList;

public class Criba {
    
    public static ArrayList criba(ArrayList codificacion, int criba){
        ArrayList <ArrayList> codificacionCriba = new ArrayList <>();
        codificacionCriba.addAll(codificacion.subList(0, criba));
        return codificacionCriba;
    }

    public static ArrayList<ArrayList<Integer>> Torneo(ArrayList<ArrayList<Integer>> pobSemaforo, int poblacion) {
        int indice1;
        int indice2; 
        ArrayList<ArrayList<Integer>> ganadores = new ArrayList<>();
        while(ganadores.size() != poblacion ){
            indice1 = (int) (Math.random()*pobSemaforo.size());
            indice2 = (int) (Math.random()*pobSemaforo.size()); 
            if(indice1 > indice2){
                ganadores.add(pobSemaforo.get(indice2));
            }else{
                ganadores.add(pobSemaforo.get(indice1));
            }
        }
        return ganadores;
    }
}
