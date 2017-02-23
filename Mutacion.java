package algoritmogenetico;

import java.util.ArrayList;

public class Mutacion {
    
    public static ArrayList mutacion(ArrayList codificacion, double valorMutacion){
        ArrayList <Integer> muta = new ArrayList <>();
        int indice;
        for (int i = 0; i < codificacion.size(); i++) {
            if(Math.random() <= valorMutacion){
                muta = (ArrayList<Integer>) codificacion.get(i);
                indice = (int)(Math.random()*muta.size());
                if(muta.get(indice) == 0){
                    muta.remove(indice);
                    muta.add(indice, 1);
                    codificacion.remove(i);
                    codificacion.add(i, muta);
                }else{
                    muta.remove(indice);
                    muta.add(indice, 0);
                    codificacion.remove(i);
                    codificacion.add(i, muta);
                }
            } 
        }
        return codificacion;
    }   
    
}
