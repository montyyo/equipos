import java.util.Random;
import java.util.ArrayList;
/**
 * Write a description of class Team here.
 * 
 * @author marco ibañez antolin
 * @version 1-27/5/2015
 */
public class Equipo
{
    private String nombre;
    private int numJugadores;
    private ArrayList<Jugador> componentes;
    private ArrayList<Jugador> suplentes;
    private int valorDorsal=1;
    String nombres[] = {"Ramon", "Pedro", "Juan", "Mario", "Marcos", "Miguel", "Luis", "Carlos", 
            "Jose Ramon", "Federico", "Alberto", "Roberto", "Ruben", "Guillermo", "Hector", 
            "Mario", "Felipe", "Manuel", "Tomas", "Agustin", "Jose Manuel", "Juan Jesus", 
            "Pepe", "Ricardo", "Fernando", "Antonio", "Jose Alberto", "Jose Luis", "David", 
            "Emilio", "Cesar", "German", "Raul", "Pablo"};

    /**
     * Constructor de equipos
     */
    public Equipo(String nombre,int jugadores)
    {
        this.nombre=nombre;
        numJugadores=jugadores;
        componentes = new ArrayList<>();
        suplentes=new ArrayList<>();
        Random  rn = new Random();
        //creacion del primer jugador portero
        componentes.add(new Portero(nombres[rn.nextInt(33)]));
        componentes.get(0).setDorsal(valorDorsal);
        valorDorsal++;
        //creacion de los jugadores 
        for(int a = 1; a < jugadores - 1;a++)
        {
            componentes.add(new JugadorCampo(nombres[rn.nextInt(33)]));
            componentes.get(a).setDorsal(valorDorsal);
            valorDorsal++;
        }

        if (rn.nextInt(1) == 0) {  //  Si sale 0 hay crack, si no no.            
            JugadorCampo crack = new JugadorCampo(nombres[rn.nextInt(nombres.length - 1)]);
            crack.setFormaFisica(10);
            crack.setPase(10);
            crack.setRegate(10);
            crack.setRemate(10);            
        }        

        //seleccion suplentes
        int nuemroSuplentes=jugadores-11;
        for(int i=0;i<nuemroSuplentes;i++)
        {
            suplentes.add(componentes.remove(rn.nextInt(componentes.size()-1)));

        }
        //eleccion del capitan
        int capitan = rn.nextInt(10);
        int dorsalc=componentes.get(capitan).getDorsal();
        String nomb=componentes.get(capitan).getNombre();
        componentes.set(capitan,new Capitan(nomb));
        componentes.get(capitan).setDorsal(dorsalc);
    }

    public String getNombre()
    {
        return nombre;
    }
    
    public void listaTitulares()
    {
        for(Jugador titular:componentes)
        {
            System.out.println(titular.toString());
        }
    }

    public void listaSuplentes()
    {
        for(Jugador titular:suplentes)
        {
            System.out.println(titular.toString());
        }
    }

    public float mediaValoracion()
    {
        int valEquipo=0;
        for(Jugador titular:componentes)
        {
            valEquipo+= titular.valoracion();
        }
        return valEquipo/11;
    }

    public void entrenarEquipo() {
        Jugador jugador = null;
        for (int i = 0; i < componentes.size(); i++) {
            jugador = componentes.get(i);
            if (jugador instanceof Capitan) {
                ((Capitan)jugador).entrenar();
            } else if (jugador instanceof JugadorCampo) {                
                ((JugadorCampo)jugador).entrenar();            
            } else {
                ((Portero)jugador).entrenar();
            }
        }
    }
}
