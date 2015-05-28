import java.util.Random;
/**
 * Write a description of class Jugador here.
 * 
 * @author (marco ibañez antolin) 
 * @version (1-27/5/2015)
 */
public abstract class Jugador
{
    private String nombre;
    private int edad;
    private int formaFisica;
    private int dorsal;
    private boolean titular;
    private static int MIN_EDAD=18;
    private static int MAX_EDAD=40;
    private static int MIN_FORMA=0;
    private static int MAX_FORMA=10;

    /**
     * constructor clase constructor
     * @param nombre nombre del jugador
     */
    public Jugador(String nombre)
    {
        Random rn=new Random();
        this.nombre=nombre;
        edad=rn.nextInt((MAX_EDAD+1)-MIN_EDAD)+MIN_EDAD;
        formaFisica=rn.nextInt((MAX_FORMA+1)-MIN_FORMA)+MIN_FORMA;
        dorsal=0;
        if(rn.nextInt(1) == 1)
            titular=true;
        else
            titular=false;
    }
    
    /**
     * deuelve el nombre del jugador
     * @return nombre del jugador
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * devuelve la edad del jugador
     * @return int edad del jugador 
     */
    public int getEdad()
    {
        return edad;
    }
    
    /**
     * devuelve la forma fisica del jugador
     * @return int forma fisica del jugador
     */ 
    public int getForma()
    {
        return formaFisica;
    }
    
    /**
     * devuelve el dorsal del jugador
     * @return int numero del dorsal
     */
    public int getDorsal()
    {
        return dorsal;
    }
    
    public void setDorsal(int i)
    {
        dorsal=i;
    }
    
    /**
     * devuelve si el jugador es titular
     * @return boolean titular
     */
    public boolean getTitular()
    {
        return titular;
    }
    
    /**
     * valoracion del jugador
     */
    public abstract int valoracion();
    
    /**
     * devuelve los datos del jugador
     * @return string datos jugador
     */
    public String toString()
    {
        return "Dorsal " + dorsal+".  " + nombre +
               " ("+ edad +" anos)      "+ "Forma: "+formaFisica;
    }
    

    
}
