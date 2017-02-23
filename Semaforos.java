package algoritmogenetico;

import java.util.ArrayList;

public class Semaforos {
    
    private static ArrayList <Integer> semaforo1;
    private static ArrayList <Integer> semaforo2;
    private static ArrayList <Integer> semaforo3;
    private static ArrayList <Integer> semaforo4;
    
    private static ArrayList <ArrayList<Integer>> poblacionSemaforo1;
    private static ArrayList <ArrayList<Integer>> poblacionSemaforo2;
    private static ArrayList <ArrayList<Integer>> poblacionSemaforo3;
    private static ArrayList <ArrayList<Integer>> poblacionSemaforo4;

    public static void setSemaforo1(ArrayList<Integer> semaforo1) {
        Semaforos.semaforo1 = semaforo1;
    }

    public static void setSemaforo2(ArrayList<Integer> semaforo2) {
        Semaforos.semaforo2 = semaforo2;
    }

    public static void setSemaforo3(ArrayList<Integer> semaforo3) {
        Semaforos.semaforo3 = semaforo3;
    }

    public static void setSemaforo4(ArrayList<Integer> semaforo4) {
        Semaforos.semaforo4 = semaforo4;
    }
    
    public static int estadoSemaforo(CeldaSemaforo celdaSemaforo){
        int semaforo = celdaSemaforo.getSelectorSemaforo();
        int direccion = celdaSemaforo.getDireccion();
        if(semaforo == 1){
            if(direccion == 0){
                return semaforo1.get(Tiempo.tiempoSemaforo());
            }else{
                return Math.abs(semaforo1.get(Tiempo.tiempoSemaforo())-1);
            }
        }if(semaforo == 2){
            if(direccion == 0){
                return semaforo2.get(Tiempo.tiempoSemaforo());
            }else{
                return Math.abs(semaforo2.get(Tiempo.tiempoSemaforo())-1);
            }
        }if(semaforo == 3){
            if(direccion == 0){
                return semaforo3.get(Tiempo.tiempoSemaforo());
            }else{
                return Math.abs(semaforo3.get(Tiempo.tiempoSemaforo())-1);
            }
        }if(semaforo == 4){
            if(direccion == 0){
                return semaforo4.get(Tiempo.tiempoSemaforo());
            }else{
                return Math.abs(semaforo4.get(Tiempo.tiempoSemaforo())-1);
            }
        }else
            return -1;
    }
    
    public static  ArrayList getPoblacion(int semaforoPoblacion){    
        if(semaforoPoblacion == 1)
            return poblacionSemaforo1;
        if(semaforoPoblacion == 2)
            return poblacionSemaforo2;
        if(semaforoPoblacion == 3)
            return poblacionSemaforo3;
        if(semaforoPoblacion == 4)
            return poblacionSemaforo4;
        else
            return null;
    }
    
     
    public static  void setPoblacion(int semaforoPoblacion, ArrayList poblacionSemaforo){    
        if(semaforoPoblacion == 1)
            poblacionSemaforo1 = poblacionSemaforo;
        if(semaforoPoblacion == 2)
            poblacionSemaforo2 = poblacionSemaforo;
        if(semaforoPoblacion == 3)
            poblacionSemaforo3 = poblacionSemaforo;
        if(semaforoPoblacion == 4)
            poblacionSemaforo4 = poblacionSemaforo;
    }
    
}
