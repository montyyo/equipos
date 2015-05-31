import java.util.Random;
/**
 * Write a description of class Capitan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Capitan extends JugadorCampo
{
    private String nombre;
    private int liderazgo;
    private static int MIN_ESTAT=0;
    private static int MAX_STAT=5;
    /**
     * Constructor de la clase capitan
     */
    public Capitan(String nombre)
    {
        super(nombre);
        Random rn=new Random();
        liderazgo=rn.nextInt((MAX_STAT + 1 )- MIN_ESTAT )+ MIN_ESTAT;
    }

    public int getLiderazgo() {
        return liderazgo;
    }

    public void setLiderazgo(int liderazgo) {
        if (liderazgo >= MAX_STAT) {
            this.liderazgo = MAX_STAT;
        } else {
            this.liderazgo = liderazgo;
        }      
    }

    public int valoracion()
    {
        return super.valoracion() + liderazgo;
    }

    public void entrenar() {
        super.entrenar();
        Random rnd = new Random();        
        setLiderazgo((rnd.nextInt((MAX_STAT + 1 ) - MIN_ESTAT) + MIN_ESTAT) + liderazgo);
    }

    public String toString()
    {
        return super.toString() + "  Liderazgo : " + liderazgo + " (cap)";
    }
}
