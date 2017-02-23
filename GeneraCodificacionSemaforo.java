package algoritmogenetico;

import java.util.ArrayList;

public class GeneraCodificacionSemaforo {
    
    public static ArrayList generaCodificacionSemaforo(){
        ArrayList <Integer> colores = new ArrayList<>();
        int color;
        for (int i = 0; i < 12; i++) {
            color = (int) (Math.random()*2);
            if(color == 1 || color == 0)
                colores.add(color);
            else
                i--;
        }
        return colores;
    }
}
