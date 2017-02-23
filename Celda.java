package algoritmogenetico;

public class Celda {
    final int [] posicion;
    int direccion;
    boolean estado;

    public Celda(int i, int j, int direccion) {
        this.posicion = new int[2];
        this.posicion[0] = i;
        this.posicion[1] = j;
        this.direccion = direccion;
        this.estado = false;
    }

    public int[] getPosicion() {
        return posicion;
    }

    public int getDireccion() {
        return direccion;
    }

    public boolean isEstado() {
        return estado;
    }
    
    public Celda estadoFuturo(){
       boolean estadoFuturo;
       if((!estado && Carretera.getEstadoAnterior(posicion, direccion))||(estado && Carretera.getEstadoSiguiente(posicion, direccion)))
           estadoFuturo = true;
       else
           estadoFuturo = false;
       
       Celda auxiliar = new Celda(posicion[0], posicion[1], direccion);
       auxiliar.setEstado(estadoFuturo);
       return auxiliar;
    }

    public int getCodificacionSemaforo() {
        return -1;
    }

    Celda getSiguienteInterseccion() {
        return null;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }
}
