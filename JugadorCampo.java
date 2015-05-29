import java.util.Random;
/**
 * clase de porteros
 * 
 * @author (marco ibañez antolin) 
 * @version (1-27/5/2015)
 */
public class JugadorCampo extends Jugador
{
    private int pase;
    private int regate;
    private int remate;
    private static int MIN_ESTAT=0;
    private static int MAX_STAT=10;
   

    /**
     * Constructor for objects of class Portero
     */
    public JugadorCampo(String nombre)
    {
        super(nombre);
        Random rn=new Random();
        pase=rn.nextInt((MAX_STAT + 1 )- MIN_ESTAT )+ MIN_ESTAT;
        regate=rn.nextInt((MAX_STAT + 1) - MIN_ESTAT ) + MIN_ESTAT;
        remate=rn.nextInt((MAX_STAT + 1) - MIN_ESTAT ) + MIN_ESTAT;
    }
    
    /**
     * devuelve la pase
     * @return int pase
     */
    public int getPase()
    {
        return pase;
    }
    
    public void setPase(int pase) {
        this.pase = pase;
    }
    
    /**
     * devuelve la regate
     * @return int regate
     */
    public int getRegate()
    {
        return regate;
    }
    
    public void setRegate(int regate) {
        this.regate = regate;
    }
    
    /**
     * devuelve la remate
     * @return int remate
     */
    public int getRemate()
    {
        return remate;
    }
    
    public void setRemate(int remate) {
        this.remate = remate;
    }
    
    /**
     * devuelve la valoracion de cada jugador
     * @return int valoracion del jugador
     */
    public int valoracion()
    {
        return (regate+remate+pase+super.getForma() )/4;
    }
    
    /**
     * datos del portero
     * @return string datos del portero
     */
    public String toString()
    {
        return super.toString()+ "\t"+"  Pase: "+ pase+ "\t"+ "  Regate : " +regate + "\t" +
                " Remate:  "+ "\t"+ "Valoracion: " + valoracion();
    }
}
