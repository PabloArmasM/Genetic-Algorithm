package algoritmogenetico;

public class Imprime {
    
    public static void imprime(){
        int tamCarretera = Carretera.getTamano();
        for (int i = 0; i < tamCarretera; i++) {
            for (int j = 0; j < tamCarretera; j++) {
                if(Carretera.getcelda(i, j) == null){
                    System.out.print("  .   ");
                }if(Carretera.getcelda(i, j) != null && Carretera.getcelda(i, j).isEstado())
                    System.out.print("  +   ");
                if(Carretera.getcelda(i, j) != null && !Carretera.getcelda(i, j).isEstado())
                    System.out.print("  -   ");
            }
            System.out.println("");
        }
    }
}
