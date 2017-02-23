package algoritmogenetico;

public class CeldaInterseccion extends Celda {

    public CeldaInterseccion(int i, int j, int direccion) {
        super(i, j, direccion);
    }
    
    @Override
    public Celda estadoFuturo() {
        boolean estadoFuturo = estado;
        int direccionFutura = direccion;
        Celda colorSemaforoFila = Carretera.getAnterior(posicion, 0);
        Celda colorSemaforoColumna = Carretera.getAnterior(posicion,1);
        Celda semaforoVerde;
        if(Semaforos.estadoSemaforo((CeldaSemaforo) colorSemaforoFila) == 0){
            semaforoVerde = colorSemaforoFila;
        }else
            semaforoVerde = colorSemaforoColumna; 
        if(estado){
            if(!Carretera.getEstadoSiguiente(posicion, direccion))
                estadoFuturo = false;
            else
                estadoFuturo = estado;
        }else{
            estadoFuturo = semaforoVerde.isEstado();
            direccionFutura = semaforoVerde.getDireccion();
        }
          
        CeldaInterseccion celda = new CeldaInterseccion(posicion[0], posicion[1], direccionFutura);
        celda.setEstado(estadoFuturo);
        return celda;
    }    

    public Celda getSiguienteInterseccion(){
        return Carretera.getSiguiente(posicion, direccion);
    }
}

