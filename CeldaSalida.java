package algoritmogenetico;

public class CeldaSalida extends Celda{
    
    public static double cochesFuera;

    public CeldaSalida(int i, int j, int direccion) {
        super(i, j, direccion);
    }

    public static double getCochesFuera() {
        return cochesFuera;
    }

    @Override
    public Celda estadoFuturo() {
        boolean estadoFuturo;
        if(this.isEstado())
            aumentaCantidad();
        estadoFuturo = Carretera.getEstadoAnterior(posicion, direccion);
        CeldaSalida celda = new CeldaSalida(posicion[0], posicion[1], direccion);
        celda.setEstado(estadoFuturo);
        return celda;
    }

    private static void aumentaCantidad() {
        cochesFuera++;
    }
    
    public static void reset(){
        cochesFuera = 0;
    }
    

}
