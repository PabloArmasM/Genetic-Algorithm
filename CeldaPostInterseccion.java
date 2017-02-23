package algoritmogenetico;

public class CeldaPostInterseccion extends Celda {

    public CeldaPostInterseccion(int i, int j, int direccion) {
        super(i, j, direccion);
    }

    @Override
    public Celda estadoFuturo() {
        boolean estadoFuturo = estado;

        if(Carretera.getAnterior(posicion, direccion).getDireccion()==this.direccion &&
                ((!estado && Carretera.getEstadoAnterior(posicion, direccion)) ||
                (estado && Carretera.getEstadoSiguiente(posicion, direccion)) /*||
                (estado && Carretera.getEstadoAnterior(posicion, direccion) && !Carretera.getEstadoSiguiente(posicion, direccion))*/)){
            estadoFuturo = true;
        } else {
            estadoFuturo = false;
        }

        CeldaPostInterseccion celda = new CeldaPostInterseccion(posicion[0], posicion[1], direccion);
        celda.setEstado(estadoFuturo);
        return celda;
    }

}
