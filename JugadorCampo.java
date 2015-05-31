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
        if (pase >= MAX_STAT) {
            this.pase = MAX_STAT;
        } else {
            this.pase = pase;
        }      
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
        if (regate >= MAX_STAT) {
            this.regate = MAX_STAT;
        } else {
            this.regate = regate;
        }      
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
        if (remate >= MAX_STAT) {
            this.remate = MAX_STAT;
        } else {
            this.remate = remate;
        }      
    }    

    /**
     * devuelve la valoracion de cada jugador
     * @return int valoracion del jugador
     */
    public int valoracion()
    {
        return (regate+remate+pase+super.getForma() )/4;
    }

    public void entrenar() {
        super.entrenar();
        Random rnd = new Random();        
        setPase((rnd.nextInt((MAX_STAT + 1 ) - MIN_ESTAT) + MIN_ESTAT) + pase);
        setRegate((rnd.nextInt((MAX_STAT + 1 ) - MIN_ESTAT) + MIN_ESTAT) + regate);
        setRemate((rnd.nextInt((MAX_STAT + 1 ) - MIN_ESTAT) + MIN_ESTAT) + remate);
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
