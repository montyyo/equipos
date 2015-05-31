import java.util.ArrayList;
import java.util.Collections;
/**
 * Write a description of class Liga here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Liga
{
    private ArrayList<Encuentro> encuentros;
    private ArrayList<Equipo> equipos;
    private int jornadas;
    /**
     * Constructor for objects of class Liga
     */
    public Liga(int numEquipos)
    {
        jornadas = numEquipos - 1;
        equipos = new ArrayList<>();
        encuentros = new ArrayList<>();
        ArrayList<Encuentro> encuentrosTemp = new ArrayList<>();
        int encuentrosJugados = 0;
        int partidos = 0;
        for (int i = 0; i < numEquipos; i++) {  //  Crea los equipos y los entrena.
            equipos.add(new Equipo("Equipo" + i, 15));
            equipos.get(0).entrenarEquipo();
        }
        ArrayList<Equipo> equiposTemp = (ArrayList) equipos.clone();    //  Clona los equipos en un array temporal.
        while (encuentrosJugados < jornadas) {  //  Mientras que no se hayan jugado el número de partidos especificado se sigue ejecutando.
            Collections.shuffle(equiposTemp);
            while (equiposTemp.size() >= 2) {   //  Comprueba que haya suficientes equipos para hacer un partido.
                encuentrosTemp.add(new Encuentro(equiposTemp.remove(0), equiposTemp.remove(0)));    //  Añade un encuentro entre los dos primeros equipos del array temporal de equipos al array temporal de encuentros.
            } 
            partidos = encuentrosTemp.size();
            for (int i = 0; i < partidos; i++) {    //  Mientras no se hayan jugado todos los partidos del array temporal de encuentros sigue.
                encuentrosTemp.get(0).jugarPartido();   //  se juega el partido.
                if (encuentrosTemp.get(0).hanEmpatado()) {  //  Si han empatado.
                    equiposTemp.add(encuentrosTemp.get(0).getEquipo1());    //  Añade al equipo1 al array temporal de equipos.
                    equiposTemp.add(encuentrosTemp.get(0).getEquipo2());    //  Añade al equipo2 al array temporal de equipos.
                } else {    //  No han empatado
                    equiposTemp.add(encuentrosTemp.get(0).getGanador());    //  Añade al ganador al array temporal de equipos
                }
                encuentros.add(encuentrosTemp.remove(0));   //  Elimina el encuentro del array temporal de encuentros y lo añade al definitivo.
                encuentrosJugados++;
            }
        }
    }
    
    public void mostrarEquipos() {
        String equipos = "Equipos que juegan la liga:\n";
        for (Equipo equipo : this.equipos) {
            equipos += equipo.getNombre() + " ";
        }
        System.out.println(equipos);
    }
    
    public void mostrarEncuentros() {
        for (Encuentro encuentro : encuentros) {
            encuentro.mostrarAlineaciones();
            System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////");
            encuentro.showMarcador();
            System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////");
        }
    }
}
