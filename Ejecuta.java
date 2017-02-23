package algoritmogenetico;

import java.util.ArrayList;

public class Ejecuta {

    public static void ejecuta() {
        ArrayList<ArrayList<Integer>> pobSemaforo1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> pobSemaforo2 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> pobSemaforo3 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> pobSemaforo4 = new ArrayList<>();
        
        ArrayList<Double> fitness = new ArrayList<>();

        ArrayList<Double> mejorFitness = new ArrayList<>();
        
        for (int i = 0; i < 100; i++) {
            pobSemaforo1.add(GeneraCodificacionSemaforo.generaCodificacionSemaforo());
            pobSemaforo2.add(GeneraCodificacionSemaforo.generaCodificacionSemaforo());
            pobSemaforo3.add(GeneraCodificacionSemaforo.generaCodificacionSemaforo());
            pobSemaforo4.add(GeneraCodificacionSemaforo.generaCodificacionSemaforo());
        }

        Semaforos.setPoblacion(1, pobSemaforo1);
        Semaforos.setPoblacion(2, pobSemaforo2);
        Semaforos.setPoblacion(3, pobSemaforo3);
        Semaforos.setPoblacion(4, pobSemaforo4);
      
        for (int k = 0; k < 100; k++) {

            for (int i = 0; i < pobSemaforo1.size(); i++) {
                Semaforos.setSemaforo1(pobSemaforo1.get(i));
                Semaforos.setSemaforo2(pobSemaforo2.get(i));
                Semaforos.setSemaforo3(pobSemaforo4.get(i));
                Semaforos.setSemaforo4(pobSemaforo4.get(i));
                for (int j = 0; j < 120; j++) {
                    Carretera.actualizaEstados();
                    Tiempo.aumentarTiempo();
                }
                Carretera.setCarretera(Carretera.iniciliazar());
                fitness.add(Fitness.resultadoFitness());
                CeldaEntrada.reset();
                CeldaSalida.reset();
                Tiempo.reset();
            }
            Ordenar.ordenar(pobSemaforo1, fitness);
            Ordenar.ordenar(pobSemaforo2, fitness);
            Ordenar.ordenar(pobSemaforo3, fitness);
            Ordenar.ordenar(pobSemaforo4, fitness);
            
            OrdenaFitness.ordenar(fitness);
            
            mejorFitness.add(fitness.get(0));
            
            if(100 - (int)k*1.16 > 60){
                pobSemaforo1 = Criba.Torneo(pobSemaforo1, 100 - (int) ((int)k*1.16));
                pobSemaforo2 = Criba.Torneo(pobSemaforo2, 100 - (int) ((int)k*1.16));
                pobSemaforo3 = Criba.Torneo(pobSemaforo3, 100 - (int) ((int)k*1.16));
                pobSemaforo4 = Criba.Torneo(pobSemaforo4, 100 - (int) ((int)k*1.16));
                pobSemaforo1 = Cruce.cruce(pobSemaforo1, 2, 1, fitness);
                pobSemaforo2 = Cruce.cruce(pobSemaforo2, 2, 1, fitness);
                pobSemaforo3 = Cruce.cruce(pobSemaforo3, 2, 1, fitness);
                pobSemaforo4 = Cruce.cruce(pobSemaforo4, 2, 1, fitness);
            }else{
                pobSemaforo1 = Criba.criba(pobSemaforo1, 60);
                pobSemaforo2 = Criba.criba(pobSemaforo2, 60);
                pobSemaforo3 = Criba.criba(pobSemaforo3, 60);
                pobSemaforo4 = Criba.criba(pobSemaforo4, 60);
                pobSemaforo1 = Cruce.cruce(pobSemaforo1, 2, 2, fitness);
                pobSemaforo2 = Cruce.cruce(pobSemaforo2, 2, 2, fitness);
                pobSemaforo3 = Cruce.cruce(pobSemaforo3, 2, 2, fitness);
                pobSemaforo4 = Cruce.cruce(pobSemaforo4, 2, 2, fitness);
            }
            
            if(1.0-((double)k*0.014) > 0.0){
                pobSemaforo1 = Mutacion.mutacion(pobSemaforo1, 1.0-((double)k*0.014));
                pobSemaforo2 = Mutacion.mutacion(pobSemaforo1, 1.0-((double)k*0.014));
                pobSemaforo3 = Mutacion.mutacion(pobSemaforo1, 1.0-((double)k*0.014));
                pobSemaforo4 = Mutacion.mutacion(pobSemaforo1, 1.0-((double)k*0.014));
            }
            
            
            double sumaFitns = 0.0;
            
            for (Double fitnes : fitness) {
                sumaFitns += fitnes;
            }
            
            System.out.println(fitness.get(0) +  "    ---     " + sumaFitns);
            fitness = new ArrayList<>();
        }
        
        
        Semaforos.setSemaforo1(pobSemaforo1.get(0));
        Semaforos.setSemaforo2(pobSemaforo2.get(0));
        Semaforos.setSemaforo3(pobSemaforo4.get(0));
        Semaforos.setSemaforo4(pobSemaforo4.get(0));
        
        for (int i = 0; i < 120; i++) {
            Imprime.imprime();
            System.out.println("----------------Iteracion: " + i + "-----------------------");
            Carretera.actualizaEstados();
            Tiempo.aumentarTiempo();
        }
        
        System.out.println(CeldaEntrada.getCantidadEntrada());
        System.out.println(CeldaSalida.getCochesFuera());
        
        Grafica grafica = new Grafica(mejorFitness);
        grafica.execute();
    }
}
