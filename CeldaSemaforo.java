package algoritmogenetico;

import java.util.ArrayList;

public class CeldaSemaforo extends Celda{
    
    private int selectorSemaforo;

    public CeldaSemaforo(int i, int j, int direccion, int selectorSemaforo) {
        super(i, j, direccion);
        this.selectorSemaforo = selectorSemaforo;
    }

    /*public boolean estadoFuturo() {//colorSemaforo 0 -> verde, colorSemaforo 1 -> rojo
        if(!estado || (Semaforos.estadoSemaforo(selectorSemaforo, direccion) == 0 && !Carretera.getEstadoSiguiente(posicion, direccion))){
            if(Carretera.getEstadoAnterior(posicion, direccion))
                return true;
            else
                return false;
        }else
            return estado;
    }*/
    
    public Celda estadoFuturo(){
        boolean estadoFuturo = estado;
        if(Semaforos.estadoSemaforo(this) == 1 || (Semaforos.estadoSemaforo(this)==0 && Carretera.getEstadoSiguiente(posicion, direccion))){
            if(!estado)
                estadoFuturo = Carretera.getEstadoAnterior(posicion, direccion);
        }if(Semaforos.estadoSemaforo(this)==0 && !Carretera.getEstadoSiguiente(posicion, direccion)){
            if(!estado)
                estadoFuturo = Carretera.getEstadoAnterior(posicion, direccion);
            else
                estadoFuturo = false;
        }
        CeldaSemaforo celda = new CeldaSemaforo(posicion[0], posicion[1], direccion, selectorSemaforo);
        celda.setEstado(estadoFuturo);
        return celda;
    }

    public int getSelectorSemaforo() {
        return selectorSemaforo;
    }
    
    
}
