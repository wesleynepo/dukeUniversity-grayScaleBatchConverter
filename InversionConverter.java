import edu.duke.*;
import java.io.*;
/**
 * Escreva a descrição da classe GrayScaleConverter aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class InversionConverter {
    
    public ImageResource makeInversion(ImageResource inImage) {
    
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        for (Pixel pixel: outImage.pixels()){
            Pixel inPixel = inImage.getPixel( pixel.getX(), pixel.getY());
                   
            pixel.setRed(255 - inPixel.getRed());
            pixel.setBlue(255 - inPixel.getBlue());
            pixel.setGreen(255 - inPixel.getGreen());
            
        }
        
        return outImage;
    }
    
    public void testInversion() {
        ImageResource ir = new ImageResource();         
        ImageResource gray = makeInversion(ir);     
        gray.draw();      
    }
    
    public void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();
        
        for (File f: dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = makeInversion(inImage); 
            saveImage(gray, "inverted-" + inImage.getFileName() );
        }
        
    }
    
    public void saveImage(ImageResource outImage, String fileName ) {        
           outImage.setFileName(fileName);
           outImage.save();              
    }
}
