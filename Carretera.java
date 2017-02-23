package algoritmogenetico;

class Carretera {
    
    private static Celda [][] carretera;


    public Carretera(Celda[][] carretera) {
        this.carretera = carretera;
    }

    public static Celda getAnterior (int [] pos, int direccion){
        int posAnterior [] = new int [2];
        posAnterior[0] = pos[0];
        posAnterior[1] = pos[1];
        posAnterior[direccion]--;
        return carretera[posAnterior[0]][posAnterior[1]];
    }
    
    public static Celda getSiguiente (int [] pos, int direccion){
        int posAnterior [] = new int [2];
        posAnterior[0] = pos[0];
        posAnterior[1] = pos[1];
        posAnterior[direccion]++;
        return carretera[posAnterior[0]][posAnterior[1]];
    }
    
    public static boolean getEstadoAnterior (int [] pos, int direccion){
        int posAnterior [] = new int [2];
        posAnterior[0] = pos[0];
        posAnterior[1] = pos[1];
        posAnterior[direccion]--;
        return carretera[posAnterior[0]][posAnterior[1]].isEstado();
    }
    
    public static boolean getEstadoSiguiente (int [] pos, int direccion){
        int posAnterior [] = new int [2];
        posAnterior[0] = pos[0];
        posAnterior[1] = pos[1];
        posAnterior[direccion]++;
        return carretera[posAnterior[0]][posAnterior[1]].isEstado();
    }
    
    public static void actualizaEstados(){
        Celda [][] estadoFuturo = Carretera.iniciliazar();
        for (int i = 0; i < 14; i++) {
            estadoFuturo[i][4] = carretera[i][4].estadoFuturo();
            estadoFuturo[i][9] = carretera[i][9].estadoFuturo();
            estadoFuturo[4][i] = carretera[4][i].estadoFuturo();
            estadoFuturo[9][i] = carretera[9][i].estadoFuturo();
        }
        carretera = estadoFuturo;
    }

    public static Celda[][] getCarretera() {
        return carretera;
    }
    
    public static Celda getcelda(int i, int j){
        return carretera[i][j];
    }
    public static int getTamano() {
        return carretera.length;
    }

    public static void setCarretera(Celda[][] carretera) {
        Carretera.carretera = carretera;
    }
    
    public static Celda[][] iniciliazar(){
        Celda [][] conjuntoCeldas = new Celda[14][14];
        for (int i = 0; i < 14; i++) {
            conjuntoCeldas[i][4]= new Celda(i,4, 0);
            conjuntoCeldas[i][9] = new Celda(i,9, 0);
            conjuntoCeldas[4][i] = new Celda(4,i, 1);
            conjuntoCeldas[9][i] = new Celda(9,i, 1);
        }
        
        conjuntoCeldas[0][4] = new CeldaEntrada(0,4,0);
        conjuntoCeldas[0][9] = new CeldaEntrada(0,9,0);
        conjuntoCeldas[4][0] = new CeldaEntrada(4,0,1);
        conjuntoCeldas[9][0] = new CeldaEntrada(9,0,1);
        
        //Celdas de salida

        conjuntoCeldas[13][4] = new CeldaSalida(13,4,0);
        conjuntoCeldas[13][9] = new CeldaSalida(13,9,0);
        conjuntoCeldas[4][13] = new CeldaSalida(4,13,1);
        conjuntoCeldas[9][13] = new CeldaSalida(9,13,1);
        
        //intersecciones
        conjuntoCeldas[4][4] = new CeldaInterseccion(4,4,-1);
        conjuntoCeldas[4][9] = new CeldaInterseccion(4,9,-1);
        conjuntoCeldas[9][4] = new CeldaInterseccion(9,4,-1);
        conjuntoCeldas[9][9] = new CeldaInterseccion(9,9,-1);
        
        
        //Semaforos
        conjuntoCeldas[3][4] = new CeldaSemaforo(3,4,0,1);
        conjuntoCeldas[4][3] = new CeldaSemaforo(4,3,1,1);
        conjuntoCeldas[3][9] = new CeldaSemaforo(3,9,0,2);
        conjuntoCeldas[4][8] = new CeldaSemaforo(4,8,1,2);
        conjuntoCeldas[8][4] = new CeldaSemaforo(8,4,0,3);
        conjuntoCeldas[9][3] = new CeldaSemaforo(9,3,1,3);
        conjuntoCeldas[8][9] = new CeldaSemaforo(8,9,0,4);
        conjuntoCeldas[9][8] = new CeldaSemaforo(9,8,1,4);
        
        //Post-Intersecciones
        conjuntoCeldas[5][4] = new CeldaPostInterseccion(5,4,0);
        conjuntoCeldas[10][4] = new CeldaPostInterseccion(10,4,0);
        conjuntoCeldas[5][9] = new CeldaPostInterseccion(5,9,0);
        conjuntoCeldas[10][9] = new CeldaPostInterseccion(10,9,0);
        conjuntoCeldas[4][5] = new CeldaPostInterseccion(4,5,1);
        conjuntoCeldas[9][5] = new CeldaPostInterseccion(9,5,1);
        conjuntoCeldas[4][10] = new CeldaPostInterseccion(4,10,1);
        conjuntoCeldas[9][10] = new CeldaPostInterseccion(9,10,1);
        
        //Carretera.setCarretera(conjuntoCeldas);
        return conjuntoCeldas; 
    }
}
