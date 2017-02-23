package algoritmogenetico;

class Tiempo {

    private static int tiempo;

    static void reset() {
        tiempo = 0;
    }

    public Tiempo() {
        tiempo = 0;
    }

    public static int getTiempo() {
        return tiempo;
    }
    
    public static void aumentarTiempo(){
        tiempo++;
    }
    
    public static int tiempoSemaforo(){
        return ((tiempo-(tiempo%10))/10);
    }
}
