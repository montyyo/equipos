import java.util.Random;
/**
 * clase de porteros
 * 
 * @author (marco ibañez antolin) 
 * @version (1-27/5/2015)
 */
public class Portero extends Jugador
{
    private int agilidad;
    private int fortalezaMental;

    private static int MIN_ESTAT=0;
    private static int MAX_STAT=10;
   

    /**
     * Constructor for objects of class Portero
     */
    public Portero(String nombre)
    {
        super(nombre);
        Random rn=new Random();
        agilidad=rn.nextInt((MAX_STAT + 1 )- MIN_ESTAT )+ MIN_ESTAT;
        fortalezaMental=rn.nextInt((MAX_STAT + 1) - MIN_ESTAT ) + MIN_ESTAT;
        
    }
    
    /**
     * devuelve la agilidad
     * @return int agilidad
     */
    public int getAgilidad()
    {
        return agilidad;
    }
    
    /**
     * devuelve la fortalezaMental
     * @return int fortalezaMental
     */
    public int fortalezaMental()
    {
        return fortalezaMental;
    }
    
    /**
     * devuelve la valoracion de cada jugador
     * @return int valoracion del jugador
     */
    public int valoracion()
    {
        return (agilidad + fortalezaMental+super.getForma() )/3;
    }
    
    /**
     * datos del portero
     * @return string datos del portero
     */
    public String toString()
    {
        return super.toString()+ "\t"+  "  Agil: "+ agilidad+  "\t" + "Formental: " +fortalezaMental + 
                "\t"+ "\t"+ "\t"+  "Valoracion: " + valoracion()+ "\t";
    }
}
