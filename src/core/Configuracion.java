
package core;
import java.awt.Font;

/**
 * 
 * Sahara - Programa para el aprendizaje de la lengua japonesa
 * @author Ciro Iván Garcia López - Universidad Nacional de Colombia
 *
 */
public class Configuracion {
    
    private String fileName = "data.dat";
    private Fuente fuente;
    private static Configuracion instance;
    
    private Configuracion(){
        try{
            //LinkedList<String> rawData = new FileReader("./resources/config.dat").getContent();
            //fileName = rawData.get(0);
            fuente = new Fuente("./bin/resources/MicroHei.ttc",80);
        }catch(Exception ex){
        }
    }
    
    public String getFileName(){
        return fileName;
    }
    
    public Font getFont(){
    	return fuente.getFont();
    }
    
    public static Configuracion getInstance(){
    	if(instance == null){
    		instance = new Configuracion();
    	}
    	return instance;
    }
}
