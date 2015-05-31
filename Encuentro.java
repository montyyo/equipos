import java.util.Random;
/**
 * Write a description of class Partido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Encuentro
{
    private Equipo equipo1;
    private Equipo equipo2;
    private Equipo ganador;
    private Equipo perdedor;
    private boolean empate;
    private int golesMarcadosEquipo1;
    private int golesMarcadosEquipo2;
    private String marcador;
    /**
     * Constructor for objects of class Partido
     */
    public Encuentro(Equipo uno,Equipo dos)
    {
        equipo1=uno;
        equipo2=dos;
        ganador = null;
        perdedor = null;
        empate = false;
        golesMarcadosEquipo1 = 0;
        golesMarcadosEquipo2 = 0;
        marcador = equipo1.getNombre() + " vs " + equipo2.getNombre() + ": 0 - 0";
    }
    
    public Equipo getEquipo1() {
        return equipo1;
    }
    
    public Equipo getEquipo2() {
        return equipo1;
    }
    
    public boolean hanEmpatado() {
        return empate;
    }
    
    public Equipo getGanador() {
        return equipo1;
    }
    
    public Equipo getPerdedor() {
        return equipo2;
    }
    
    public int getGolesMarcadosEquipo1() {
        return golesMarcadosEquipo1;
    }

    public void setGolesMarcadosEquipo1(int goles) {
        golesMarcadosEquipo1 = goles;
    }

    public int getGolesMarcadosEquipo2() {
        return golesMarcadosEquipo2;
    }

    public void setGolesMarcadosEquipo2(int goles) {
        golesMarcadosEquipo2 = goles;
    }

    public void showMarcador() {
        System.out.println(marcador);
    }

    /**
     * mostrar alineaciones
     */
    public void mostrarAlineaciones()
    {
        System.out.println(equipo1.getNombre());
        System.out.println("Titulares:");
        equipo1.listaTitulares();

        System.out.println("***********************************Media de valoracion del Equipo titular= "+ equipo1.mediaValoracion()+ "***********************************");
        System.out.println("Reservas:");
        equipo1.listaSuplentes();

        System.out.println("");
        System.out.println("");
        System.out.println( equipo2.getNombre());
        System.out.println("Titulares:");
        equipo2.listaTitulares();

        System.out.println("***********************************Media de valoracion del Equipo titular= "+  equipo2.mediaValoracion()+ "***********************************");
        System.out.println("Reservas:");
        equipo2.listaSuplentes();
    }

    public void jugarPartido() {
        float puntosEquipo1 = equipo1.mediaValoracion();
        float puntosEquipo2 = equipo2.mediaValoracion();
        int total = (int)(puntosEquipo1 + puntosEquipo2);
        Random rnd = new Random();
        int resultado = rnd.nextInt(total) + 1;
        if (puntosEquipo1 > puntosEquipo2) {
            if (resultado > puntosEquipo1) {
                ganador = equipo2;
                perdedor = equipo1;
            } else {
                ganador = equipo1;
                perdedor = equipo2;
            }
        } else if (puntosEquipo2 > puntosEquipo1) {
            if (resultado > puntosEquipo2) {
                ganador = equipo1;
                perdedor = equipo2;
            } else {
                ganador = equipo2;
                perdedor = equipo1;
            }
        } else {
            empate = true;
        }

        if (ganador == equipo1) {
            golesMarcadosEquipo1 = rnd.nextInt(4) + 1;
            golesMarcadosEquipo2 = rnd.nextInt(golesMarcadosEquipo1);
        } else if (ganador == equipo2) {
            golesMarcadosEquipo2 = rnd.nextInt(4) + 1;
            golesMarcadosEquipo1 = rnd.nextInt(golesMarcadosEquipo2);
        } else {
            golesMarcadosEquipo1 = rnd.nextInt(4) + 1;
            golesMarcadosEquipo2 = golesMarcadosEquipo1;
        }
        marcador = equipo1.getNombre() + " vs " + equipo2.getNombre() + ": " + golesMarcadosEquipo1 + " - " + golesMarcadosEquipo2;
    }
}
