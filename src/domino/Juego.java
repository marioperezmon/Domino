
package domino;


public class Juego {
    private Jugador[] jugadores;
    private int numJugadores;
    private Mesa mesa = new Mesa();
    private static  Ficha coger = new Ficha(-1, -1);
 
    public void juego(){
        pedirJugadores();
        while(!ciclo()){
            ciclo();
            
        }
        
        
        
    }
    

    public void pedirJugadores(){
        do{
            System.out.print("¿Cuántos Jugadores sois?(De 2 a 4) ");
            numJugadores = Metodos.leerNum();
        }while(numJugadores > 4 || numJugadores < 2);
        
        jugadores = new Jugador[numJugadores];
        for (int i = 0; i < numJugadores; i++) {
            System.out.print("Introduce el nombre del "+ (i+1) +"º jugador/a. ");
            Jugador aux  = new Jugador(Metodos.leerString());
            for (int j = 0; j < 7; j++) {
                aux.cogerFichaMonton(mesa.getMonton().cogerFicha());
            }
            jugadores[i]=aux;
        }
        jugadores[0].setSerMano(true);
    }
    

    public void insertarPrimera(){
        Ficha aux;
        int pos;
            System.out.println("Elige la ficha que quieres colocar: ");
            System.out.println(jugadores[0].toString());
            do{
                pos = Metodos.leerNum();
            }while(pos<1 || pos>jugadores[0].getNumFichas());
            aux = jugadores[0].elegirFicha(pos);
            mesa.insertarPrimero(aux);
            jugadores[0].quitarFicha(aux);
            
    }
 
    public boolean ciclo(){
        for (int i = 0; i < numJugadores; i++) {
            int fichasMesa = mesa.getNumFichas();
            int fichasJugador = jugadores[i].getNumFichas();
            Ficha aux = null;
            int pos;
            boolean pasar = false;
            
            if(mesa.getNumFichas()==0){
                insertarPrimera();
            }else{
                System.out.println(mesa.toString());
                do{
                    if(jugadores[i].getNumFichas()>fichasJugador){
                        System.out.println("Elige la ficha que quieres colocar: (Pulsa 0 para pasar)");
                        do{
                            pos = Metodos.leerNum();
                        }while(pos<0 || pos>jugadores[i].getNumFichas());
                        if(pos != 0){
                            System.out.println(jugadores[i].toString());
                            aux = jugadores[i].elegirFicha(pos);
                            mesa.insertarficha(aux);
                            if(fichasMesa!=mesa.getNumFichas()){
                            jugadores[i].quitarFicha(aux);
                                if(cerrar()==true){
                                    System.err.println("MESA CERRADA");
                                    puntos();
                                    return true;
                                }
                            }
                        }else{
                            pasar = true;
                        }
                        
                        
                    }
                    else{
                    System.out.println(jugadores[i].toString());
                    System.out.println("Elige la ficha que quieres colocar: (Pulsa 0 si no tienes para colocar)");
                    do{
                        pos = Metodos.leerNum();
                    }while(pos<0 || pos>jugadores[i].getNumFichas());
                    if(pos == 0){
                        if(mesa.getMonton().getNumFichas()!=0){
                        jugadores[i].cogerFichaMonton(mesa.getMonton().cogerFicha());
                        System.out.println(jugadores[i].toString());
                        }else{
                            System.err.println("Se acabaron las fichas del montón.");
                            pasar = true;
                        }
                    }else{
                        aux = jugadores[i].elegirFicha(pos);
                        mesa.insertarficha(aux);
                    }
                    if(fichasMesa!=mesa.getNumFichas()){
                        jugadores[i].quitarFicha(aux);
                        if(cerrar()==true){
                            System.err.println("MESA CERRADA");
                            puntos();
                            return true;
                        }
                        
                    }
                    }
                    System.out.println("");
                }while(mesa.getNumFichas()== fichasMesa && jugadores[i].getNumFichas()<=fichasJugador+1 && pasar == false );
                if(jugadores[i].getNumFichas()==0){
                    System.err.println("Ha ganado "+jugadores[i].getNombre()+ ".");
                    return true;
                }
                }
            }

        
        return false;
    }
    
    public boolean cerrar(){
        if(mesa.getFinal() == mesa.getPrincipio()){
            return mesa.getNumVeces(mesa.getFinal())==7;
        
        }else{
        return false;
        }   
    }
    
    
    public void puntos() {
        int puntosGanador = 20;
        Jugador jugadorGanador = new Jugador("");
        for (int i = 0; i < numJugadores; i++) {
            System.out.println("Puntos de "+jugadores[i].getNombre()+": " +jugadores[i].getPuntos());
            if(puntosGanador > jugadores[i].getPuntos()){
                puntosGanador=jugadores[i].getPuntos();
                jugadorGanador = jugadores[i];
            }
            
        }for (int i = 0; i < numJugadores; i++) {
            if(jugadorGanador.getPuntos()==jugadores[i].getPuntos() && !jugadorGanador.equals(jugadores[i])){
                System.out.println("Empate entre "+jugadorGanador.getNombre()+" y "+jugadores[i].getNombre());
                if(jugadorGanador.getSerMano()){
                    System.err.println("Ganó el jugador "+jugadorGanador.getNombre()+" por ser Mano.");
                }else if (jugadores[i].getSerMano()){
                    System.err.println("Ganó el jugador "+jugadores[i].getNombre()+" por ser Mano.");
                }
            }
        }
        System.out.println("Gana el Jugador: "+jugadorGanador.getNombre());
    }
}
