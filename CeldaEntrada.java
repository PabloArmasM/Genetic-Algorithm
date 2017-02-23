package algoritmogenetico;

public class CeldaEntrada extends Celda{
    
    private static double cantidadEntrada;
    private int cola;
    
    
    public CeldaEntrada(int i, int j, int direccion) {
        super(i, j, direccion);
    }

    public static double getCantidadEntrada() {
        return cantidadEntrada;
    }


    public int getCola() {
        return cola;
    }

    
    
    public void aumentarEntrada(){
        cantidadEntrada++;
    }

    public Celda estadoFuturo() {
        boolean estadoFuturo = estado;
        if(Tiempo.getTiempo()%5==0){
            this.cola++;
            aumentarEntrada();
        }
        if(this.isEstado()){
            if(!Carretera.getEstadoSiguiente(this.getPosicion(),this.getDireccion())){
                if(cola > 0){
                    cola--;
                    estadoFuturo = true;
                }if(cola == 0)
                    estadoFuturo = false;
            }else
                estadoFuturo = estado;
        }else{
            if(cola > 0){
                cola--;
                estadoFuturo = true;
            }else
                estadoFuturo = estado;
        }
        CeldaEntrada celdaFutura = new CeldaEntrada(posicion[0], posicion[1], direccion);
        celdaFutura.setEstado(estadoFuturo);
        return celdaFutura;
    } 
    
    public static void reset(){
        cantidadEntrada = 0;
    }

}
