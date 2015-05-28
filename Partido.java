
/**
 * Write a description of class Partido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Partido
{
    private Equipo equipo1;
    private Equipo equipo2;

    /**
     * Constructor for objects of class Partido
     */
    public Partido(Equipo uno,Equipo dos)
    {
       equipo1=uno;
       equipo2=dos;
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
         
         
         System.out.println( equipo2.getNombre());
        System.out.println("Titulares:");
         equipo2.listaTitulares();
        
         System.out.println("***********************************Media de valoracion del Equipo titular= "+  equipo2.mediaValoracion()+ "***********************************");
         System.out.println("Reservas:");
          equipo2.listaSuplentes();
    }
    
}
