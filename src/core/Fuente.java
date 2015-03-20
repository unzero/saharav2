package core;

import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 * @author unzero
 */
public class Fuente {
    
    private Font ttfBase;
    private int size;
    
    public Fuente(String path,int size){
        this.size = size;
        try{
             InputStream myStream = new BufferedInputStream(new FileInputStream(path));
             ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
        }catch(Exception e){
        	e.printStackTrace();
            core.Common.errorMessage();
        }
    }
    
    public Font getFont(){
        if(ttfBase != null){
            return ttfBase.deriveFont(Font.TRUETYPE_FONT,size);
        }
        Common.debugMessage();
        return null;
    }
    
}
