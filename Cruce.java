package algoritmogenetico;

import java.util.ArrayList;

public class Cruce {
    
    public static ArrayList<ArrayList<Integer>> cruce(ArrayList<ArrayList<Integer>> codificacion, int elite, int metodoSeleccion, ArrayList<Double> fitness) {
        if(metodoSeleccion == 1)
            return seleccionAleatoria(codificacion, elite);
        else
            return seleccionProporcional(codificacion, elite, fitness);
    }
    
    
    private static ArrayList seleccionProporcional(ArrayList codificacion, int elite, ArrayList<Double> fitness) {
        ArrayList <ArrayList> cruzados = new ArrayList <>();
        ArrayList <Integer> madre = new ArrayList <> ();
        ArrayList <Integer> padre = new ArrayList <>();
        ArrayList <ArrayList> hijos = new ArrayList <>();
        ArrayList <Integer> hijo1 = new ArrayList <>();
        ArrayList <Integer> hijo2 = new ArrayList <>();
        
        ArrayList <ArrayList> pobPropocional = new ArrayList<>();
        generaArrayPropocional(codificacion, pobPropocional, fitness);
        
        return seleccionAleatoria(pobPropocional, elite);
    }
    
    
    
    private static ArrayList seleccionAleatoria(ArrayList codificacion, int elite){
        ArrayList <ArrayList> cruzados = new ArrayList <>();
        ArrayList <Integer> madre = new ArrayList <> ();
        ArrayList <Integer> padre = new ArrayList <>();
        ArrayList <ArrayList> hijos = new ArrayList <>();
        ArrayList <Integer> hijo1 = new ArrayList <>();
        ArrayList <Integer> hijo2 = new ArrayList <>();
        
        
        cruzados.addAll(codificacion.subList(0, elite));
        while(cruzados.size() < Poblacion.getPoblacion()){
           int indicemadre = (int) (Math.random()*codificacion.size());
           int indicepadre = (int) (Math.random()*codificacion.size());
           while(indicemadre == indicepadre){
               indicepadre = (int) (Math.random()*codificacion.size());
           }
           madre = (ArrayList<Integer>) codificacion.get(indicemadre);
           padre = (ArrayList<Integer>) codificacion.get(indicepadre);
           hijos = Cruce.twoPointCrossover(madre, padre);
           cruzados.addAll(hijos);
        }
        return cruzados;
    }

    private static ArrayList twoPointCrossover(ArrayList<Integer> madre, ArrayList<Integer> padre) {
        ArrayList<ArrayList> hijos = new ArrayList<>();
        ArrayList<Integer>hijo1 = new ArrayList<>();
        ArrayList<Integer>hijo2 = new ArrayList<>();
        
        int indiceMinimo = (int) (Math.random()*madre.size()+1);
        int indiceMaximo = (int) (indiceMinimo+(Math.random()*(madre.size()-indiceMinimo)));
        if(indiceMinimo == 0){
           hijo1.addAll(madre.subList(0, (madre.size()/2)));
           hijo1.addAll(padre.subList((madre.size()/2), madre.size()));
           hijo2.addAll(padre.subList(0, (padre.size()/2)));
           hijo2.addAll(madre.subList((padre.size()/2), padre.size()));
        }if((indiceMaximo == madre.size()) || (indiceMinimo == indiceMaximo)){
           hijo1.addAll(madre.subList(0, madre.size()/2));
           hijo1.addAll(padre.subList(madre.size()/2, madre.size()));
           hijo2.addAll(padre.subList(0, madre.size()/2));
           hijo2.addAll(madre.subList(madre.size()/2, padre.size()));
        }else{
            hijo1.addAll(madre.subList(0, indiceMinimo));
            hijo1.addAll(padre.subList(indiceMinimo, indiceMaximo));
            hijo1.addAll(madre.subList(indiceMaximo, madre.size()));
            hijo2.addAll(padre.subList(0, indiceMinimo));
            hijo2.addAll(madre.subList(indiceMinimo, indiceMaximo));
            hijo2.addAll(padre.subList(indiceMaximo, padre.size()));
        }
        hijos.add(hijo1);
        hijos.add(hijo2);
        return hijos;
    }

    private static void generaArrayPropocional(ArrayList<ArrayList> codificacion, ArrayList<ArrayList> pobProporcional, ArrayList<Double> fitness) {
        double sumFitness = 0.0;
        for (Double fitnes : fitness) {
               sumFitness += fitnes;
        }
        for (int i = 0; i < codificacion.size(); i++) {
            for (int j = 0; j < ((fitness.get(i)*1000)/sumFitness); j++) {
                pobProporcional.add((ArrayList) codificacion.get(i));
            }
        }
    }

    

    
}
